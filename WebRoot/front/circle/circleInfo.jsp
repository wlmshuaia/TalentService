<%@ page language="java" import="java.util.*, com.talentservice.domain.Circle" pageEncoding="UTF-8"%>
<%@ include file="/admin/common/common.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><s:property value="#data.circlename" /></title>
    
    <script language="javascript" src="<%=request.getContextPath()%>/js/click.js"></script>
    <script language="javascript" src="<%=request.getContextPath()%>/js/fahuati.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/all9.js"></script>
    
    <style type="text/css">
		#zuoshang{ height:70px; width:844px; border-bottom:4px #e5e5e5 solid; margin:0 auto;}
		#zuoshang div{ float:left; margin-top:20px;}
		#zuoshang div li{ float:left; list-style:none; width:90px; margin-left:23px; height:46px; text-align:center; font-weight:bolder; color:#3e6373; font-size:21px;    }
		#zuoshang div li a{ display:inline-block;width:90px; height:50px; border-bottom:4px #e5e5e5 solid; }
		#zuoshang div li a:link{ text-decoration:none;}
		#zuoshang div li a:hover{ border-bottom:4px #ff6900 solid; color:#ff6900; cursor:pointer;}
		#zuoxia{ width:826px; margin:0 auto;}
		
		#zuoxia div{ width:826px; height:143px; background:#FFF;}
		#zuoxia div div{ float:left; margin-top:15px; margin-left:20px; height:113px;}
		#zuoxia div div div{ width:650px; margin-top:10px; height:30px; font-size:20px;color:#cacaca;}
		
		#zuoxiaxia{ width:826px; margin:0 auto; margin-top:10px;}
		#zuoxiaxia div{ line-height:2em; text-indent:1em; width:826px; margin-top:10px; border-bottom:1px #e0e0e0 solid; border-right:1px #e0e0e0 solid; box-shadow:1px 1px #afafaf; background:#fff; font-size:24px; border-left:3px #ff6900 solid; border-radius:4px 0 0 4px; color:#3f6371;}
		
		#quanzichengyuan{ height:300px;}
		#quanzichengyuan div{ width:300px; height:60px; float:left;  margin-left:40px; border:none; box-shadow:none;}
		#quanzichengyuan div div{ height:60px; float:left; margin-left:10px; font-size:9px; margin-top:0px;}
		#quanzichengyuan div div span{ margin-left:20px;}
		#quanzichengyuan a{ display:inline-block; margin-top:180px; color:#ff6900; margin-left:20px; text-decoration:underline;}
		#quanzichengyuan a:link{}
		#quanzichengyuan a:hover{ cursor:pointer;}
		
		#quanzihuati{ min-height:300px;}
		#quanzihuati div{ border:none; box-shadow:none; color:#137eb4; font-size:18px; width:780px; margin-left:15px;}
		#quanzihuati div span{ float:right; color:#99999b; width: auto; margin-right:20px;}
		
		#quanzihuati div a:hover{ text-decoration:underline; cursor:pointer;}
		
		#youxia{ width:240px; margin-top:7px;}
		#youxia div{ width:240px; height:265px; background:#FFF; margin-top:13px; border-radius:4px 4px 0 0; border-right:1px #dbdbdb solid; border-bottom:1px #dbdbdb solid;border-top:3px #ff6900 solid; box-shadow:1px 1px #b0b0b1;}
		#youxia div div{ width:220px; margin:0 auto; height:42px; border-bottom:2px #e5e5e5 solid; border-top:none; color:#3e6372; box-shadow:none; border-right:none; font-size:22px; text-indent:4px; line-height:2em;}

    </style>
    
  </head>
  
  <body>
	<%@ include file="/front/frame/header.jsp" %>
    <div id="main" style="background-color:#efeff5; margin:0 auto; border-top:#6b6b6b solid; padding-bottom:0px;">
    	<div id="weizhi" style="width:1120px; height:30px; margin:0 auto; border:2px dashed #999; font-size:20px; border-radius:5px; margin-top:5px;">
        	<span style="font-size:20px; margin-left:5px;">当前位置</span>
        	>>首页>><s:a action="wcircleAction_dataList.action">圈子列表</s:a>>>
            <a>圈子详情</a>
            
        </div>
        
        <div style="width:1120px; margin:0 auto; margin-top:10px; min-height:1500px;">
        	<div style="width:870px; float:left; margin-left:0px;">
            	<div id="zuoxia">
                	<div>
	                    <div style=" width:110px; background:#30F;"></div>
	                    
	                   	<div style=" width:550px;">
			               <div style="margin-top:0px;color:#1374b9"><s:property value="#data.circlename" /></div>
			               <div><s:property value="#data.user.username" /></div>
			               <div>分类 成员 话题</div>
			           </div>
	                    <div id="fahuati" style=" height:40px; color:#FFF; background:#ff6900; margin-left:20px; margin-top:90px; line-height:2em; width:90px; text-align:center; border:1px #ff6900 solid; border-radius:3px; font-size:18px; cursor:pointer;">发话题</div>
                 	</div>
                </div>
                
                <div id="zuoxiaxia">
                	<div>
                    	圈子简介<br />
                    	<span style="color:#cacaca; margin-left:50px;"><s:property value="#data.description" /></span>
                    </div>
                    
                    <div id="quanzichengyuan">
                    	圈子成员<br />
                    	<div>
                        	<div style="width:65px; background:#F00;"></div>
                        	<div style="width:200px;">
                            	wlm<br />
                                <span>男</span>
                            </div>
                        </div>
                                                                                  
                        <a>更多</a>
                    </div>
                     
                    
					<div id="quanzihuati">
                    	圈子话题
                    	<s:if test="#dataList.size() == 0">
                    		<div>
	                        	暂无
	                        </div>
                    	</s:if>
						<s:else>
							<s:iterator value="dataList">
		                    	<div>
		                        	<a><s:a action="circle/wcircleAction_topicInfo.action?tid=%{tid}"><s:property value="title" /></s:a></a>
		                            <span><s:property value="foundtime" /></span>
		                            <span><a><s:property value="user.username" /></a></span>
		                            <span>赞(<s:property value="zannumber" />)</span>
		                        </div>
							</s:iterator>
							
							<div class="page">
								<%
									int start = Integer.parseInt(ActionContext.getContext().get("start").toString()) ;
									int end = Integer.parseInt(ActionContext.getContext().get("end").toString()) ;
									int pageNum = Integer.parseInt(ActionContext.getContext().get("page").toString()) ;
									Circle c = (Circle) ActionContext.getContext().get("data") ;
									
									if(pageNum > 1){
										out.print("<span><a href='circle/wcircleAction_getInfo?cid="+c.getCid()+"&start="+(pageNum-1)+"'>上一页</a></span>") ;
									}
								%>
								<ul>
									<%
										for(int i = start; i <= end; i ++){
											if(i == pageNum){
												out.print("<li class='choose'><b>"+i+"</b></li>") ;
											}else{
												out.print("<li><a href='circle/wcircleAction_getInfo?cid="+c.getCid()+"&start="+i+"'>"+i+"</a></li>") ;
											}
										}
									%>
								</ul>
								<%
									if(pageNum < end){
										out.print("<span><a href='circle/wcircleAction_getInfo?cid="+c.getCid()+"&start="+(pageNum+1)+"'>下一页</a></span>") ;
									}
								%>
			                    
			            	</div>
							
						</s:else>
                    </div>
                	
                    <div>
                    	发表话题
                    	<s:form action="wcircleAction_addTopic.action">
                    		<s:hidden name="cid" value="%{#data.cid}"></s:hidden>
                    		<div style="margin:0 auto; border:none; box-shadow:none; width:780px; padding-bottom:90px;">
	                    		<s:textfield name="topic.title" style=" font-size:20px; text-indent:2px; display:block; margin:0 auto; width:780px; height:44px;border:1px #e5f1f4 solid;"  ></s:textfield>
	                    		<s:textarea name="topic.content" style="width:780px; font-size:24px; height:300px;border:1px #e5f1f4 solid; border-radius:4px; margin-top:15px; "></s:textarea>
	                            <input type="submit" value="发表" style="width:96px; height:40px; margin-top:30px; border:none; background:#ff6900; font-size:20px; cursor:pointer; color:#FFF; font-family:'微软雅黑';" />
	                    	</div>
                    	</s:form>
                    </div>
                </div>
            </div>
            
            <div style="width:240px; float:left; margin-left:6px;">
                <div id="youxia" style="margin-top:0px;">
                	<div style="margin-top:0px;">
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
