package com.talentservice.utils;

import java.util.ArrayList;
import java.util.List;

import com.talentservice.vo.SelectData;

public class SelectDataUtils {
	
	/**
	 * 用户类型
	 * @return
	 */
	public static List<SelectData> getUserTypeData(){
		List<SelectData> type = new ArrayList<SelectData>() ;
		type.add(new SelectData(0, "在校学生")) ;
		type.add(new SelectData(1, "在职员工")) ;
		type.add(new SelectData(2, "各大高校")) ;
		type.add(new SelectData(3, "社会企业")) ;
		return type ;
	}
	
	/**
	 * 预算种类
	 * @return
	 */
	public static List<SelectData> getBudgetData(){
		List<SelectData> budget = new ArrayList<SelectData>() ;
		budget.add(new SelectData(1, "免费练手")) ;
		budget.add(new SelectData(2, "小于 ￥1000")) ;
		budget.add(new SelectData(3, "￥1000-￥3000")) ;
		budget.add(new SelectData(4, "￥3000-￥5000")) ;
		return budget ;
	}
	
	/**
	 * 竞标结束日期
	 * @return
	 */
	public static List<SelectData> getBiddingEndData(){
		List<SelectData> biddingEnd = new ArrayList<SelectData>() ;
		for(int i = 3; i < 30; i ++){
			biddingEnd.add(new SelectData(i, i+"")) ;
		}
		return biddingEnd ;
	}
	
	/**
	 * 项目周期
	 * @return
	 */
	public static List<SelectData> getProjectEndData(){
		List<SelectData> projectEnd = new ArrayList<SelectData>() ;
		projectEnd.add(new SelectData(1, "详谈")) ;
		projectEnd.add(new SelectData(2, "1-5天")) ;
		projectEnd.add(new SelectData(3, "5-10天")) ;
		projectEnd.add(new SelectData(4, "10-20天")) ;
		projectEnd.add(new SelectData(5, "20-30天")) ;
		projectEnd.add(new SelectData(6, "30天以上")) ;
		return projectEnd ;
	}
	
}
