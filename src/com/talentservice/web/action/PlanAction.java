package com.talentservice.web.action;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.Evaluate;
import com.talentservice.domain.Plan;
import com.talentservice.domain.Planfile;
import com.talentservice.domain.Project;
import com.talentservice.domain.Projectlog;
import com.talentservice.domain.Score;
import com.talentservice.service.WorkflowManager;
import com.talentservice.utils.DataUtils;
import com.talentservice.utils.DateUtils;
import com.talentservice.utils.UploadUtils;

@Controller("planAction")
@Scope("prototype")
public class PlanAction extends BaseAction {
	
	private static final long serialVersionUID = -5545722953566775365L;

	private Plan plan = new Plan() ;
	
	@Resource(name="workflowManager")
	private WorkflowManager workflowManager ;
	
	// 任务ID
	private String taskId ;
	// executionId ==> 流程实例 id
	private String executionId ;
	// 评价内容
	private String content ;
	// 类型: bidder ==> 承接方, issuer ==> 发布方
	private String type ;
	// 是否是制定新计划
	private String newPlan ;
	// 评分
	private Score score ;
	// 完成计划上传附件
	private File file ;
	private String name ;
	/**
	 * 制定计划视图
	 * 	* 正常流程
	 * 	* 从完成计划返回，制定新计划
	 * 		* 完成  完成计划 任务
	 * 		* 修改项目状态
	 * 		
	 * @return
	 */
	public String makePlanUI() {
		Map<String, String> data = new HashMap<String, String>() ;
		data.put("pid", plan.getPid().toString()) ;	// plan 的 id 也叫 pid（项目ID）
		data.put("executionId", executionId) ;
		
		List<Plan> planList = (List<Plan>) this.baseService.getListById(Plan.class, "project_id", plan.getPid()) ;
		
		if(!"".equals(newPlan) && newPlan != null){
			// 完成任务
			this.workflowManager.completeTaskByTaskId(taskId, DataUtils.TO_MAKEPLAN) ;
			// 修改项目状态
			Project p = (Project) this.baseService.getById(Project.class, plan.getPid()) ;
			p.setStatus(DataUtils.PROJECT_UNDERWAY) ;
			this.baseService.update(p);
			
			// 根据 executionId 获取  taskId
			data.put("taskId", this.workflowManager.getTaskByExecutionId(executionId).getId()) ;
			
			// 为至少第二次制定新计划
			ActionContext.getContext().put("newPlan", newPlan) ;
			
		}else{
			data.put("taskId", taskId) ;
		}
		
		ActionContext.getContext().put("data", data) ;
		ActionContext.getContext().put("planList", planList) ;
		return "makePlanUI" ;
	}
	
	/**
	 * 计划提交表单视图
	 * 	* 保存计划表单数据 ==> 存入 plan 表
	 * 	* makePlan 任务节点任务完成
	 * 	* 项目状态改为 ==> 确认计划
	 * 
	 * @return
	 */
	public String makePlan(){
		Project p = (Project) this.baseService.getById(Project.class, plan.getPid());
		
		System.out.println("pid: "+plan.getPid());
		
		// 保存plan数据  
		plan.setUploadtime(DateUtils.formatDateTime(new Date())) ;
		plan.setState("制定完成") ;
		plan.setProject(p) ;
		plan.setPid(null) ;
		this.baseService.save(plan) ;
		
		// 完成makePlan任务节点
		this.workflowManager.completeTaskByTaskId(taskId) ;
		
		// 更新project状态
		p.setStatus(DataUtils.PROJECT_CONFIRMPLAN) ;
		this.baseService.update(p) ;
		
		return "planAddSuccess" ;
	}
	
	/**
	 * 确认计划视图
	 * @return
	 */
	public String confirmPlanUI() {
		//Plan p = (Plan) this.baseService.getEntityByHql("from Plan where project_id = '"+plan.getPid()+"'") ;
		
		// 最新计划
		List<Plan> planList = (List<Plan>) this.baseService.getListById(Plan.class, "project_id", plan.getPid()) ;
		
		ActionContext.getContext().put("type", "confirmPlan") ;
		ActionContext.getContext().put("data", planList.get(planList.size()-1)) ;
		ActionContext.getContext().put("taskId", taskId) ;
		
		return "confirmPlanUI" ;
	}
	
	/**
	 * 确认计划
	 * 	* 完成确认计划任务节点
	 * 	* 修改项目状态
	 * 	* 增加项目日志
	 * @return
	 */
	public String confirmPlan(){
		Project p = (Project) this.baseService.getById(Project.class, plan.getPid());
		
		// 完成确认计划任务
		this.workflowManager.completeTaskByTaskId(taskId, DataUtils.TO_COMPLETEPLAN) ;
		
		// 更新项目状态
		p.setStatus(DataUtils.PROJECT_COMPLETEPLAN) ;	// 确认计划之后进入完成计划阶段
		this.baseService.update(p) ;
		
		// 增加项目日志
		Projectlog pl = new Projectlog() ;
		pl.setHandle(DataUtils.PROJECT_CONFIRMPLAN);
		pl.setHandle(DateUtils.formatDateTime(new Date()));
		pl.setProject(p);
		
		return "bidderProjectList" ;
	}
	
	/**
	 * 完成计划视图
	 * 	
	 * @return
	 */
	public String completePlanUI() {
		// 最新计划
		List<Plan> planList = (List<Plan>) this.baseService.getListById(Plan.class, "project_id", plan.getPid()) ;
		
		ActionContext.getContext().put("type", "completePlan") ;
		ActionContext.getContext().put("data", planList.get(planList.size()-1)) ;
		ActionContext.getContext().put("taskId", taskId) ;
		
		return "completePlanUI" ;
	}
	
	/**
	 * 完成计划
	 * 	* 完成完成计划任务
	 * 	* 更新项目状态
	 * 
	 * @return
	 */
	public String completePlan() {
		Project p = (Project) this.baseService.getById(Project.class, plan.getPid());
		Plan pl = (Plan) this.baseService.getEntityByHql("from Plan where project_id = '"+plan.getPid()+"'") ;
		
		// 完成完成计划任务
		this.workflowManager.completeTaskByTaskId(taskId, DataUtils.TO_CONFIRMPRODUCT) ;
		
		// 上传附件
		if(file != null){
			String url = UploadUtils.saveUploadFile(file);
			Planfile pf = new Planfile() ;
			pf.setName(name);
			pf.setUrl(url);
			pf.setPlan(pl);
			this.baseService.save(pf) ;
		}
		
		// 更新项目状态
		p.setStatus(DataUtils.PROJECT_COMPLETEPRODUCT) ;
		this.baseService.update(p) ;
		
		// 增加项目日志
		
		return "issuerProjectList" ;
	}
	
	/**
	 * 确认产品视图
	 * 
	 * @return
	 */
	public String confirmProductUI(){
		// 最新计划
		List<Plan> planList = (List<Plan>) this.baseService.getListById(Plan.class, "project_id", plan.getPid()) ;
		
		ActionContext.getContext().put("type", "confirmProduct") ;
		ActionContext.getContext().put("data", planList.get(planList.size()-1)) ;
		ActionContext.getContext().put("taskId", taskId) ;
		
		return "confirmProductUI" ;
	}
	
	/**
	 * 确认作品
	 * 	* 完成确认作品任务，自动流转到 payAndComment 任务
	 * 	* 
	 * @return
	 */
	public String confirmProduct() {
		System.out.println("confirmProduct...");
		
		Project p = (Project) this.baseService.getById(Project.class, plan.getPid());
		
		// 完成确认作品任务
		this.workflowManager.completeTaskByTaskId(taskId, DataUtils.TO_PAYANDCOMMENT) ;
		
		// 更新项目状态
		p.setStatus(DataUtils.PROJECT_PAYANDCOMMENT) ;
		this.baseService.update(p) ;
		
		return "issuerProjectList" ;
	}
	
	/**
	 * 付款评价视图
	 * 
	 * @return
	 */
	public String payAndCommentUI() {
		ActionContext.getContext().put("pid", plan.getPid()) ;
		ActionContext.getContext().put("taskId", taskId) ;
		
		return "payAndCommentUI" ;
	}
	
	/**
	 * 付款评论
	 * 	* 当点击项目结束按钮才不再制定计划，否则流转到 makePlan 任务节点
	 * 
	 * @return
	 */
	public String payAndComment() {
		// 付款逻辑...
		
		
		// 评论逻辑
		Project p = (Project) this.baseService.getById(Project.class, plan.getPid());
		Evaluate evaluate = new Evaluate() ;
		evaluate.setContent(content) ;
		evaluate.setEvaluatetime(DateUtils.formatDateTime(new Date())) ;
		evaluate.setProject(p) ;
		evaluate.setUserByFromuserId(p.getUserByFounderId()) ;
		evaluate.setUserByTouserId(p.getUserByUndertakerId()) ;
		this.baseService.save(evaluate) ;
		
		// 修改项目状态
		p.setStatus(DataUtils.PROJECT_PLANCOMPLETE) ;
		this.baseService.update(p) ;
		
		// 完成流程
		this.workflowManager.completeTaskByTaskId(taskId) ;
		
		// 流转到制定计划按钮
		// this.workflowManager.completeTaskByTaskId(taskId, DataUtils.TO_MAKEPLAN) ;
		// this.workflowManager.completeTaskByTaskId(taskId, DataUtils.TO_FORK) ;
		
		return "issuerProjectList" ;
	}
	
	/**
	 * 计划完成视图
	 * @return
	 */
	public String planOverUI() {
		Plan p = (Plan) this.baseService.getEntityByHql("from Plan where project_id = '"+plan.getPid()+"'") ;
		
		System.out.println("planOverUI executionId: "+executionId);
		
		ActionContext.getContext().put("type", "planOver") ;
		ActionContext.getContext().put("data", p) ;
		ActionContext.getContext().put("taskId", taskId) ;
		ActionContext.getContext().put("executionId", executionId) ;
		
		return "planOverUI" ;
	}
	
	/**
	 * 计划完成操作处理
	 * 
	 * @return
	 */
	public String planOver() {
		System.out.println("planOver: "+plan.getPid());
		
		// 项目完工，跳转到双方互评阶段
		this.workflowManager.completeTaskByTaskId(taskId, DataUtils.TO_FORK) ;
		
		// 修改项目状态
		Project p = (Project) this.baseService.getById(Project.class, plan.getPid()) ;
		p.setStatus(DataUtils.PROJECT_MUTUALEVALUATION);
		this.baseService.update(p) ;
		
		return "issuerProjectList" ;
	}
	
	/**
	 * 发包方评价视图
	 * 
	 * @return
	 */
	public String commentUI() {
		ActionContext.getContext().put("pid", plan.getPid());
		ActionContext.getContext().put("type", type);
		ActionContext.getContext().put("taskId", taskId) ;
		ActionContext.getContext().put("executionId", executionId) ;
		return "commentUI" ;
	}
	
	/**
	 * 发包方评价
	 * 	* 保存评价数据
	 * 	* 完成发布方评价任务
	 * 	* 修改项目状态？
	 * 	* 增加项目日志
	 * 
	 * @return
	 */
	public String commentHandle() {
		Project p = (Project) this.baseService.getById(Project.class, plan.getPid()) ;
		
		// 保存评价数据
		score.setScoretime(DateUtils.formatDateTime(new Date())) ;
		score.setProject(p);
		score.setUserByFromuserId(p.getUserByFounderId());
		score.setUserByTouserId(p.getUserByUndertakerId());
		this.baseService.save(score) ;
		
		// 完成发布方评价任务
		this.workflowManager.completeTaskByTaskId(taskId) ;
		
		// 增加项目日志
		Projectlog pl = new Projectlog() ;
		
		// 修改项目状态
		if("issuer".equals(type)){
			if(DataUtils.PROJECT_BIDDERCOMMENT.equals(p.getStatus())){
				p.setStatus(DataUtils.PROJECT_COMPLETE);
			}else{
				p.setStatus(DataUtils.PROJECT_ISSUERCOMMENT);
			}
			pl.setHandle(DataUtils.PROJECT_ISSUERCOMMENT);
		}else{
			if(DataUtils.PROJECT_ISSUERCOMMENT.equals(p.getStatus())){
				p.setStatus(DataUtils.PROJECT_COMPLETE);
			}else{
				p.setStatus(DataUtils.PROJECT_BIDDERCOMMENT);
			}
			pl.setHandle(DataUtils.PROJECT_BIDDERCOMMENT);
		}
		this.baseService.update(p);
		
		pl.setHandle(DateUtils.formatDateTime(new Date())) ;
		pl.setProject(p) ;
		this.baseService.save(pl);
		
		/*if("issuer".equals(type)){
			System.out.println("issuerProjectList");
			return "issuerProjectList" ;
		}else{
			System.out.println("bidderProjectList");
			return "bidderProjectList" ;
		}*/
		return "bidderProjectList";
	}
	
	/**
	 * 获取计划列表
	 * 
	 * @return
	 */
	public String getPlans() {
		Project p = (Project) this.baseService.getById(Project.class, plan.getPid());
		List<Plan> planList = (List<Plan>) this.baseService.getListById(Plan.class, "project_id", plan.getPid()) ;
		List<Projectlog> projectlogList = (List<Projectlog>) this.baseService.getListById(Projectlog.class, "project_id", plan.getPid());
		
		ActionContext.getContext().put("data", p);
		ActionContext.getContext().put("dataList", planList);
		ActionContext.getContext().put("projectlogList", projectlogList);
		return "planList" ;
	}
	
	public String getNewPlan() {
		return newPlan;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public String getExecutionId() {
		return executionId;
	}

	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}

	public void setNewPlan(String newPlan) {
		this.newPlan = newPlan;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Object getModel() {
		return plan;
	}
}
