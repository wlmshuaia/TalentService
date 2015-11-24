package com.talentservice.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

import org.hibernate.Session;
import org.jbpm.api.task.Task;
import org.junit.Test;

import aj.org.objectweb.asm.Label;

import com.talentservice.domain.Category;
import com.talentservice.domain.File;
import com.talentservice.domain.Plan;
import com.talentservice.domain.Project;
import com.talentservice.domain.Projectlog;
import com.talentservice.domain.User;
import com.talentservice.service.base.BaseService;
import com.talentservice.utils.DataUtils;
import com.talentservice.utils.DateUtils;
import com.talentservice.utils.UploadUtils;

public class ProjectListTest extends BaseSpring {
	
	@Test
	public void testPlan() {
		String pid = "75" ;
		Plan p = (Plan) this.baseService.getEntityByHql("from Plan where project_id = '"+Long.parseLong(pid)+"'") ;
		System.out.println("planmoney: "+p.getPlanmoney());
	}
	
	@Test 
	public void testGetFile() {
		String pid = "76" ;
		List<com.talentservice.domain.File> files = (List<com.talentservice.domain.File>)this.baseService.getListById(com.talentservice.domain.File.class, "project_id", Long.parseLong(pid)) ;
		for(com.talentservice.domain.File f : files){
			System.out.println(f.getFilename());
		}
	}
	
	@Test
	public void testProjectList() {
		int sqlStart = 0 ;
		this.baseService.getByPage(Project.class, " and status = '竞标中' ", sqlStart, DataUtils.DATA_NUM) ;
		this.baseService.queryByHql("from Label where ") ;
	}
	
	@Test
	public void testBidChoose() {
		List<Task> taskList = this.processEngine.getTaskService().createTaskQuery().assignee("wlm").list();
		
		for(Task task : taskList){
			System.out.print(task.getId()+" ");
		}
		System.out.println();
		
		List<Task> taskList2 = this.processEngine.getTaskService().findPersonalTasks("wlm") ;
		
		for(Task task : taskList2){
			System.out.print(task.getId()+" ");
		}
		System.out.println();
	}
	
	@Test
	public void testUpdateP() {
		Project p = (Project) this.baseService.getById(Project.class, Long.parseLong("2")) ;
		p.setStatus("竞标中");
		this.baseService.update(p) ;
	}
	
	@Test
	public void testGetListByPage() {
		List<Project> projectList = (List<Project>) this.baseService.getByPage(Project.class, " and founder_id = '1'", 0, DataUtils.DATA_NUM);
		for(Project p : projectList){
			System.out.println(p.getTitle());
		}
	}
	
	@Test
	public void testSavePLog(){
		Project p = (Project) this.baseService.getById(Project.class, Long.parseLong("2")) ;
		Projectlog projectlog = new Projectlog() ;
		projectlog.setProject(p) ;
		projectlog.setHandle(DataUtils.PROJECT_APPROVE_TRUE) ;
		projectlog.setHandletime(DateUtils.formatDateTime(new Date())) ;
		this.baseService.save(projectlog) ;
	}
	
	@Test
	public void testApproveUnpass() {
		//this.processEngine.getExecutionService().endProcessInstance("project.970001", "ended") ;
		//this.processEngine.getExecutionService().endProcessInstance("project.1010001", "ended");
		
		//Execution execution = this.processEngine.getExecutionService().findExecutionById("project.960001");
		this.processEngine.getTaskService().completeTask("1010006", "to end1");
	}
	
	@Test
	public void testList() {
		List<User> userList = new ArrayList<User>() ;
		
		/*User user1 = new User((long)1, "wlm", "1") ;
		User user2 = new User((long)2, "test", "2") ;
		User user3 = new User((long)3, "t", "3") ;
		userList.add(user1) ;
		userList.add(user2) ;
		userList.add(user3) ;
		*/
		JSONArray userData = JSONArray.fromObject(userList) ;
		System.out.println("userData: "+userData.toString());
	}
	
	@Test
	public void testProjectDataList() {
		BaseService baseService = (BaseService) context.getBean("baseService") ;
		
		List<Project> ps = (List<Project>) baseService.getAll(Project.class) ;
		
		for(Project p : ps){
			System.out.println(p.getTitle()+", "+p.getDescription());
		}
	}
	
	@Test
	public void testProjectBiddingPageList() {
		List<Project> pList = (List<Project>) baseService.getByPage(Project.class, " and status = '竞标中' ", 0, 10) ;
		
		for(Project p : pList){
			System.out.println("title: "+p.getTitle());
		}
	}
	
	@Test
	public void testProjectLog(){
		
		Project p = (Project) this.baseService.getById(Project.class, Long.parseLong("18")) ;
		System.out.println("title: "+p.getTitle());
		Date foundertime = new Date() ;
		
		Projectlog pl = new Projectlog() ;
		pl.setHandle("项目提交") ;
		pl.setHandletime(DateUtils.formatDateTime(foundertime)) ;
		pl.setProject(p) ;
		
		this.baseService.save(pl) ;
		
	}
	
	@Test
	public void testQueryByHql() {
		BaseService baseService = (BaseService) context.getBean("baseService") ;
		
		String budget = "1" ;
		List<Project> ps = (List<Project>) baseService.queryByHql("from Project where budget = "+Long.parseLong(budget)) ;
		
		for(Project p : ps){
			System.out.println(p.getTitle());
		}
	}
	
	@Test
	public void testFileupload() {
		BaseService baseService = (BaseService) context.getBean("baseService") ;

		
		
		Project project = new Project() ;
		Category category = new Category() ;
		category.setCid((long)2) ;
		
		project.setTitle("测试而已") ;
		project.setCategory(category) ;
		
		Project p = (Project) baseService.save(project) ;
		
		File f = new File() ;
		f.setUrl("test") ;
		f.setFilename("测试测试测试") ;
		f.setProject(p) ;
		
		baseService.save(f);
	}
	
	@Test
	public void testProjectService() {
		/*Session session = sf.openSession() ;
		
		session.beginTransaction() ;
		
		List<Project> projects = session.createQuery("from Project").list() ;
		*/
		/*ProjectService projectService = (ProjectService) context.getBean("projectService") ;
		List<Project> projects = (List<Project>) projectService.getAllProjects() ;
		
		Project p = projects.get(0) ;
		System.out.println("projectData: "+p.getApprovetime()+","+p.getApprovetime());*/
		/*
		session.getTransaction().commit() ;
		session.close();*/
	}
	
	@Test
	public void testDelete() {
		String pid = "19" ;
		Project project = (Project) this.baseService.getById(Project.class, Long.parseLong(pid)) ;
		
		File file = (File) this.baseService.getEntityByHql("from File where project_id = "+Long.parseLong(pid)) ;
		UploadUtils.deleteFile(file.getUrl()) ;
		this.baseService.delete(file) ;
	}
	
	@Test
	public void testSave() {
		Session session = sf.openSession() ;
		
		session.beginTransaction() ;
		
		Project project = new Project() ;
		
		project.setTitle("测试2") ;
		Category category = new Category() ;
		category.setCid((long)3) ;
		project.setCategory(category) ;
		project.setDescription("测试测试测试") ;
		
		session.save(project) ;
		session.getTransaction().commit() ;
		session.close();
	}
	
}
