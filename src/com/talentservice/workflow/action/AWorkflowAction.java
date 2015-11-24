package com.talentservice.workflow.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.Admin;
import com.talentservice.service.WorkflowManager;
import com.talentservice.utils.JsonUtils;
import com.talentservice.utils.OAUtils;

@Component("aworkflowAction")
@Scope("prototype")
public class AWorkflowAction extends BaseAction {

	private static final long serialVersionUID = 2664576446557446774L;
	
	@Resource(name="workflowManager")
	private WorkflowManager workflowManager ;
	
	// 流程部署文件 ==> 流程部署用
	private File deploy ;
	// 查看流程图  ==> 查看流程定义图片
	private InputStream inputStream ;
	// 流程实例ID ==> 流程定义删除用
	private String deploymentId ;
	
	
	/**
	 * 查看最新版本的流程定义列表
	 */
	public void list() {
		Collection<ProcessDefinition> pdList =  workflowManager.getLasterVersion() ;
		
		JSONArray jsonArray = new JSONArray();
        JSONObject jsonobj = new JSONObject();
        
        for(ProcessDefinition pd : pdList){
        	jsonobj.put("id", pd.getId());
        	jsonobj.put("deploymentId", pd.getDeploymentId());
        	jsonobj.put("key", pd.getKey()) ;
        	jsonobj.put("name", pd.getName());
        	jsonobj.put("version", pd.getVersion());
        	jsonArray.add(jsonobj) ;
        }
        writeToPage(pdList.size(), jsonArray);
	}
	
	/**
	 * 部署流程定义
	 */
	public void deploy() {
		System.out.println("deploy...");
		System.out.println("fileName: "+deploy.getName());
		try {
			this.workflowManager.deploy(deploy) ;
			String content = JsonUtils.getSuccessJson("流程定义部署成功！");
			writeJson(content);
		} catch (FileNotFoundException e) {
			String content = JsonUtils.getErrorJson("流程定义部署失败！");
			writeJson(content);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除流程定义
	 */
	public void delete() {
		try {
			// 转换成中文
			this.setIds(new String (this.getIds().getBytes("ISO8859-1"), "UTF-8")) ;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		this.workflowManager.deletePDKEY(ids) ;
		writeJson(JsonUtils.getSuccessJson("成功删除  "+ids.split(",").length+" 条流程定义！")) ;
		
	}
	
	/**
	 * 查看流程定义图片
	 * @return
	 */
	public String showImage() {
		this.inputStream = this.workflowManager.showImage(this.deploymentId) ;
		return SUCCESS ;
	}

	public String getDeploymentId() {
		return deploymentId;
	}

	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}

	public File getDeploy() {
		return deploy;
	}

	public void setDeploy(File deploy) {
		this.deploy = deploy;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public Object getModel() {
		return null;
	}

}
