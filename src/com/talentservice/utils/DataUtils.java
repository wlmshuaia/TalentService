package com.talentservice.utils;

/**
 * 数据
 * @author Administrator
 *
 */
public class DataUtils {
	/**
	 * 单个页面数据条数
	 */
	public static int DATA_NUM = 8 ;
	
	// 是否审批通过
	public static String APPROVE_TRUE = "通过" ;
	public static String APPROVE_FALSE = "不通过" ;
	
	// 项目日志有关信息
	public static String PROJECT_SUBMIT = "项目提交" ;
	public static String PROJECT_APPROVE = "审核中" ;
	public static String PROJECT_BIDDING = "竞标中" ;
	public static String PROJECT_UNDERWAY = "进行中" ;
	public static String PROJECT_CONFIRMPLAN = "确认计划" ;
	public static String PROJECT_COMPLETEPLAN = "完成计划" ;
	public static String PROJECT_COMPLETEPRODUCT = "确认作品" ;
	public static String PROJECT_PAYANDCOMMENT = "付款评价" ;
	public static String PROJECT_PLANCOMPLETE = "计划已完成" ;
	public static String PROJECT_MUTUALEVALUATION = "双方互评" ;
	public static String PROJECT_ISSUEREVALUATION = "发布方评价已完成" ;
	public static String PROJECT_BIDDEREVALUATION = "承接方评价已完成" ;
	public static String PROJECT_COMPLETE = "已完成" ;
	public static String PROJECT_CLOSE = "已关闭" ;	// 超出竞标期等原因导致的项目关闭
	
	public static String PROJECT_UNPASS = "审核未通过" ;
	public static String PROJECT_CHOOSE = "项目发布方选择了承接方" ;
	
	public static String PROJECT_ISSUERCOMMENT = "发包方完成了评价" ;
	public static String PROJECT_BIDDERCOMMENT = "接包方完成了评价" ;
	
	public static String PROJECT_APPROVE_TRUE = "项目审批通过" ;
	public static String PROJECT_APPROVE_FALSE = "项目审批不通过" ;
	
	
	// 流程各节点信息
	public static String TO_END = "to end1" ;
	public static String TO_BIDDING = "to bidding" ;
	public static String TO_MAKEPLAN = "to makePlan" ;
	public static String TO_COMPLETEPLAN = "to completePlan" ;
	public static String TO_CONFIRMPLAN = "to confirmPlan" ;
	public static String TO_CONFIRMPRODUCT = "to confirmProduct" ;
	public static String TO_PAYANDCOMMENT = "to payAndComment" ;
	public static String TO_ISSUERCOMMENT = "to issuerComment" ;
	public static String TO_BIDDERCOMMENT = "to bidderComment" ;
	public static String TO_JOIN = "to join1" ;
	public static String TO_FORK = "to fork1" ;
	
}
