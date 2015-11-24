<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.lang.Integer"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/admin/common/common.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>项目列表</title>
    
    <script language="javascript" src="<%=request.getContextPath()%>/js/click.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/xuanze.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/all5.js"></script>
	
    <style type="text/css">
    	
    	#shaixuan{ float:left;}
		#shaixuan div{ float:left; width:250px; height:160px; margin-left:20px;}
		#shaixuan div div{ margin:0; margin-top:10px; }
		#shaixuan div div li{ padding: 0 5px; width: auto; line-height: 25px; height:27px; background-color:#FFF; border:1px solid #FFF; text-align:center; color:#ff6900; border-radius:4px; list-style:none; float:left; margin-left:10px; margin-top:10px;}
		#shaixuan div select{ width:100%; height:30px; margin-top:15px; background-color:#FFF; border:1px solid #FFF; border-radius:4px;}
		#yixuan{ float:left; margin-top:10px; width:840px;}
		#yixuan li{padding: 0 5px; width: auto; line-height: 25px;height:27px; margin-left:20px; background-color:#FFF; border:1px solid #FFF; border-radius:4px; float:left; list-style:none; color:#ff6900; text-align:center;}
		#zuoshang{ height:70px; width:844px; border-bottom:2px #e5e5e5 solid; margin:0 auto;}
		#zuoshang div{ float:left; margin-top:20px;}
		#zuoshang div li{ float:left; list-style:none; width:65px; margin-left:23px; height:30px; color:#3e6373; font-size:21px;    }
		#zuoshang div li a:hover{ color:#ff6900;}
		#zuoxia{ width:826px; margin:0 auto;}
		
		#zuoxia div{ color: #8e8e8e;}
		#zuoxia a {color: #0d97da;}
		#biaoqian li{ width:70px; height:30px; list-style:none; float:left; margin-left:30px; font-size:18px; background:#e7fafe;color:#57b0dc; text-align:center; }
		#youxia{ width:240px; margin-top:7px;}
		#youxia div{ width:240px; height:265px; background:#FFF; margin-top:13px; border-radius:4px 4px 0 0; border-right:1px #dbdbdb solid; border-bottom:1px #dbdbdb solid;border-top:3px #ff6900 solid; box-shadow:1px 1px #b0b0b1;}
		#youxia div div{ width:220px; margin:0 auto; height:42px; border-bottom:2px #e5e5e5 solid; border-top:none; color:#3e6372; box-shadow:none; border-right:none; font-size:22px; text-indent:4px; line-height:2em;}
		
		.search{display:block;width:400px;height:50px;float:left;border:none;}
		.search .search_txt {float:left;width:150px; font-size: 16px; height:30px;border:#aaa 1px solid;color:#ccc;padding:3px 8px;
			border-radius:5px;transition:padding .25s; -o-transition:padding .25s;-moz-transition:padding .25s;-webkit-transition:padding .25s;}
		.search .search_txt:focus{border-color:red; padding-right:50px;}
		.search .search_btn {display:block;margin:0px 0 0 10px;float: left;width:50px;height:26px;line-height:26px;text-align:center;border:1px solid blue;border-radius:4px;cursor:pointer;}

    </style>
    
  </head>
  
  <body>
	<%@ include file="/front/frame/header.jsp" %>
	<div id="main" style="background-color:#efeff5; height:1760px; margin:0 auto;">
    	<div id="weizhi" style="width:1120px; height:30px; margin:0 auto; border-radius:5px; margin-top:5px;">
        	<span style="margin-left:5px;">当前位置</span>
        	>><a>首页</a>>>
            <a>项目列表</a>
        </div>
    	<div style=" width:1120px; margin:0 auto; margin-top:5px;background-color:#b2d4dd; border:2px #b2d4dd solid; border-radius:8px;">
			<div style=" height:160px; width:100%;">
				<div style="width:100px; height:150px; float:left; font-size:20px; font-weight:bolder; margin-left:15px; margin-top:15px;">筛选条件：</div>
                <div id="shaixuan">
                	<div>
                    	<s:select list="cateList" listKey="cid" listValue="catename" headerKey="-1" headerValue="热门分类"></s:select>
                        <div>
                        	<li>IT</li>
                        	<li>服装</li>
                            <li>高校</li>
                            <li>建筑</li>
                            <li>金融</li>
                        </div>
                    </div>
                    <div>
						<s:select list="labelList" listKey="lid" listValue="labelname" headerKey="-1" headerValue="热门标签"></s:select>
                         <div>
                        	<li>极客</li>
                        	<li>IT狂人</li>
                            <li>Java</li>
                            <li>学生</li>
                            <li>码农</li>
                        </div>
                    </div>
                    <div>
                    	<s:select list="sdList" listKey="id" listValue="content" headerKey="-1" headerValue="项目预算"></s:select>
                         <div>
                        	<li>免费练手</li>
                        	<li>小于￥1000</li>
                            <li>￥1000-￥3000</li>
                            <li>￥3000-￥5000</li>
                        </div>
                    </div>
                </div>
            
            </div>
            
           <div style="height:50px; margin-top:20px;">
            	
            	<div style="width:100px; height:150px; float:left; font-weight:bolder; font-size:20px; margin-left:15px; margin-top:10px; height:27px;">已经选择：</div>
           		<div id="yixuan">
                	
                </div>
            	<div id="qingkong" style="float:left; margin-left:30px; border:1px #ff6900 solid; text-align:center; font-size:18px; height:27px; width:60px; margin-top:10px; background-color:#ff6900; border-radius:3px; color:#FFF;">
                	清空
                </div>
            </div>
            
       	</div>
        
        <div style="width:1120px; margin:0 auto; margin-top:10px; height:1440px;">
        	<div style="width:870px; float:left; margin-left:0px;height:1435px; border-right:2px #9b9b9b solid; border-bottom:2px #9b9b9b solid; background:#FFF; border-top:3px #ff6900 solid; border-radius:5px 5px 0 0 ;">
                <div style="width:100%; height:100%; border-right:1px #dbdbdb solid; border-bottom:1px #dbdbdb solid;">
                    <div id="zuoshang">
                        <div style=" font-weight:bolder; font-size:20px; margin-left:5px;">更多条件：</div>
                        <div>
                        	<li><a>竞标中</a></li>
                            <li><a>已关闭</a></li>
                            <li><a>工作中</a></li>
                            <li><a>已完成</a></li>
                        </div>
                        <div style="width:204px; height:35px; margin-top:20px; margin-left:30px; border-radius:4px;">
                        	<s:form action="project/wprojectAction_getSearch.action">
	                        	<%-- <input type="text" style="width:150px; margin-left:10px; height:auto; margin-top:5px; font-size:21px; border:none; float:left;" />
	                            <div style="background-image:url(<%=request.getContextPath()%>/images/sousuo.gif); margin-top:9px; width:36px; height:30px; float:left;"></div> --%>
	                        	<%-- <s:textfield name="field" style="width:120px; margin-left:10px; height:auto;  font-size:21px;  float:left;"></s:textfield>
	                        	<s:submit value="搜索" style="margin-top: 5px;"></s:submit> --%>
	                        	
								<span class="search" id="search">
									<input type="text" name="field" class="search_txt"  />
									<input type="submit" class="search_btn" value="查找" />
								</span>
	                        	
	                        	
                        	</s:form>
                        </div>
                        <div style=" margin-left:20px; font-size:18px; color:#3e6373; margin-top:16px; line-height:2em;">
                        	相关项目
                            <span style=" font-size:24px; color:#ff6900;">
                            	<s:property value="#count" />
                            </span>
                            	个
                        </div>
                    </div>
                    
                    <s:iterator value="dataList">
	                    <div id="zuoxia">
	                    	<div style=" width:825px; height:138px; margin-top:22px;">
	                        	<div style="width:117px; height:138px; float:left;">
	                            	<div style="width:117px; height:114px; background:#0C6; border-radius:4px;"></div>
	                                <div style="width:117px; height:24px; background:#CCC; border-radius:4px;"></div>
	                            </div>
	                        	<div style="width:683px; height:138px; float:left; margin-left:20px;">
	                            	<div style="height: 35px; width: 100%; font-size: 20px; color: #57b0dc;">
	                            		<s:a action="wprojectAction_getInfo.action?pid=%{pid}">
	                            			<s:property value="title" escape="false" />
	                            		</s:a>
	                            	</div>
	                                <div style="height:28px; width:100%;">
	                                	发布日期：<span style=" display:inline-block;width:100px;"><s:property value="foundtime" /></span>
	                                	剩余：<span style=" display:inline-block;width:130px;">7天5小时23分</span>
	                                  	已有<span style=" display:inline-block;font-size:18px; text-align:center;color:#ff6900; width:25px;">
	                                  		<s:property value="bids.size()" />
	                                  	</span>人竞标
	                                </div>
	                                <div style="height:35px; width:100%; overflow: hidden;text-overflow: ellipsis;white-space: nowrap;course:hand; color: #b4b4b4;">
	                                	<s:property value="description" escape="false" />
	                                </div>
	                            	<div id="biaoqian" style="height:40px; width:100%; margin-left: 0;">
	                            		<s:if test="projectLabels.size() != 0">
	                            			<s:iterator value="projectLabels" status="s" >
		                            			<s:if test="#s.index == 0">
		                            				<li style="width: auto; height: auto; padding: 2px 6px 2px 6px; margin-left: 0px;"><s:property value="label.labelname" /></li>
		                            			</s:if>
		                            			<s:else>
		                            				<li style="width: auto; height: auto; padding: 2px 6px 2px 6px;"><s:property value="label.labelname" /></li>
		                            			</s:else>
		                            		</s:iterator>
	                            		</s:if>
	                            		<s:else>
	                            			<li style="margin-left: 0px;">标签</li>
	                            			<li>标签</li>
	                            			<li>标签</li>
	                            			<li>标签</li>
	                            		</s:else>
	                            		
	                                    <div style="width:65px; height:25px; float:right; margin-right:20px; background:url(<%=request.getContextPath()%>/images/shoucang.gif);"></div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
                    </s:iterator>
                    
                    <div class="page">
						<%
							int start = Integer.parseInt(ActionContext.getContext().get("start").toString()) ;
							int end = Integer.parseInt(ActionContext.getContext().get("end").toString()) ;
							int pageNum = Integer.parseInt(ActionContext.getContext().get("page").toString()) ;
							
							if(pageNum > 1){
								out.print("<span><a href='project/wprojectAction_dataList?start="+(pageNum-1)+"'>上一页</a></span>") ;
							}else{
								out.print("<span>上一页</span>") ;
							}
						%>
						<ul>
							<%
								for(int i = start; i <=
								end; i ++){
									if(i == pageNum){
										out.print("<li class='choose'><b>"+i+"</b></li>") ;
									}else{
										out.print("<li><a href='project/wprojectAction_dataList?start="+i+"'>"+i+"</a></li>") ;
									}
								}
								
							%>
						</ul>
						<%
							if(pageNum < end){
								out.print("<span><a href='project/wprojectAction_dataList?start="+(pageNum+1)+"'>下一页</a></span>") ;
							}else{
								out.print("<span>下一页</span>") ;
							}
						%>
					</div>
				    
            	</div>
            </div>
            
            <div style="width:240px; float:left; margin-left:6px;">
            	<div style="width:238px; height:74px; border:1px #ff6900 solid; border-radius:4px; background:#ff6900; font-size:30px; text-align:center; letter-spacing:10px; line-height:2em; color:#FFF;">
                	<s:a style="color: white;" action="project/wprojectAction_addUI.action">发布项目</s:a>
                </div>
                <div id="youxia">
                	<div>
                    	<div>
                        	相关圈子:
                        </div>
                    </div>
                    <div>
                    	<div>
                        	相关话题:
                        </div>
                    </div>
                    <div>
                    	<div>
                        	项目竞标方案:
                        </div>
                    </div>
                    <div>
                    	<div>
                        	其他:
                        </div>
                    </div>
                </div>
            </div>
        </div>
		
    
    </div>
	
	<%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>
