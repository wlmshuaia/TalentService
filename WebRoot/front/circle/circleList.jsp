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
    
    <title>圈子列表</title>
    
    <script language="javascript" src="<%=request.getContextPath()%>/js/click.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/all2.js"></script>
    
    <style type="text/css">
		#zuoshang{ height:70px; width:844px; border-bottom:4px #e5e5e5 solid; margin:0 auto;}
		#zuoshang div{ float:left; margin-top:20px;}
		#zuoshang div li{ float:left; list-style:none; width:90px; margin-left:23px; height:46px; text-align:center; font-weight:500; color:#3e6373; font-size:20px;    }
		#zuoshang div li a{ display:inline-block;width:90px; height:50px; border-bottom:4px #e5e5e5 solid; }
		#zuoshang div li a:link{ text-decoration:none;}
		#zuoshang div li a:hover{ border-bottom:4px #ff6900 solid; color:#ff6900; cursor:pointer;}
		.circle-type { color: #316372;}
		.circle-type a{ color: #316372;}
		
		#zuoxia{ width:826px; margin:0 auto; border-top: 1px dashed #efeef4;}
		#zuoxia a {color: #0d97da;}
		#zuoxia div{ color: #8e8e8e; width:826px; height:143px; margin-top:22px; background:#FFF;}
		#zuoxia div div{ float:left; margin-left:20px; height:113px;}
		#zuoxia div div div{ width:650px; margin-top:10px; height:30px; font-size:20px;color:#cacaca;}
		
		#youxia{ width:240px; margin-top:7px;}
		#youxia div{ width:240px; height:265px; background:#FFF; margin-top:13px; border-radius:4px 4px 0 0; border-right:1px #dbdbdb solid; border-bottom:1px #dbdbdb solid;border-top:3px #ff6900 solid; box-shadow:1px 1px #b0b0b1;}
		#youxia div div{ width:220px; margin:0 auto; height:42px; border-bottom:2px #e5e5e5 solid; border-top:none; color:#3e6372; box-shadow:none; border-right:none; font-size:22px; text-indent:4px; line-height:2em;}
    </style>
    
  </head>
  
  <body>
	<%@ include file="/front/frame/header.jsp" %>
    
    <div id="main" style="background-color:#efeff5; padding-bottom: 20px; height: auto; overflow: hidden; margin:0 auto; border-top:#6b6b6b solid;">
    	<div id="weizhi" style="width:1120px; height:30px; margin:0 auto; font-size:20px; border-radius:5px; margin-top:5px;">
        	<span style="margin-left:5px;">当前位置</span>
        	>><a>首页</a>>>
            <s:a action="circle/wcircleAction_dataList.action">圈子列表</s:a>
        </div>
        
        <div style="width:1120px; margin:5px auto; padding-bottom: 20px; hight: auto; overflow: hidden; border-radius:8px;">
        	<div style="width:870px; float:left; margin-left:0px; min-height:1000px; overflow: hidden; border-right:2px #9b9b9b solid; border-bottom:2px #9b9b9b solid; background:#FFF; border-top:3px #ff6900 solid; border-radius:5px 5px 0 0 ;">
                <div style="width:100%; height: auto; overflow: hidden; border-right:1px #dbdbdb solid; border-bottom:1px #dbdbdb solid;">
            		<div style=" font-size:36px; height: 80px; margin: 20px 0 0 20px; color:#5d7b86;">
                    	圈子
		                <div style="font-family:微软雅黑; cursor:pointer; margin:20px 50px 0 0; text-align: center; line-height: 40px; float:right; font-size:22px; width:116px; height:46px; background:#ff6900; border-radius:4px;">
		                	<s:a action="wcircleAction_circleAddUI.action" style="color: white;">创建圈子</s:a>
		                </div>
                    </div>
                    <div id="zuoshang">
                        <div class="circle-type">
                        	<li><a>热门</a></li>
                            <li><a>最新</a></li>
                            <li><a>分类</a></li>
                            <li><a>我的圈子</a></li>
                        </div>
                        <div style="width:204px; height:44px; margin-top:13px; margin-left:150px; border:1px #b2d4dd solid; border-radius:4px;">
                        	<input type="text" name="sousuoquanzi" id="sousuoquanzi" style="width:150px; background:url(<%=request.getContextPath()%>/images/sousuoquanzi.gif); margin-left:10px; height:30px; margin-top:5px; font-size:21px; border:none; float:left;" />
                            <div style="background-image:url(<%=request.getContextPath()%>/images/sousuo.gif); margin-top:9px; width:36px; height:30px; float:left;"></div>
                        </div>
                    </div>
                   
	                <s:iterator value="dataList">
	                	<div id="zuoxia">
	                    	<div>
	                        	<div style=" width:110px; background:#30F; border-radius: 8px;"></div>
	                            <div style=" width:550px;">
	                            	<div style="margin-top:0px;color:#1374b9"><s:a action="circle/wcircleAction_getInfo.action?cid=%{cid}"><s:property value="circlename" /></s:a></div>
	                                <div>圈主：<s:a><s:property value="user.username" /></s:a>&nbsp;&nbsp;&nbsp;&nbsp;创建时间：<s:property value="foundtime" /></div>
	                                <div>分类:<span style=" text-indent:8px; display:inline-block; width:150px;"><s:property value="category.catename" /></span>
	                                 	成员:<span style=" text-indent:8px;display:inline-block; width:120px;">2323</span>
	                                	话题:<span style=" text-indent:8px;display:inline-block; width:40px;"><s:property value="topics.size()" /></span>
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
								out.print("<span><a href='circle/wcircleAction_dataList?start="+(pageNum-1)+"'>上一页</a></span>") ;
							}else{
								out.print("<span>上一页</span>") ;
							}
						%>
						<ul>
							<%
								for(int i = start; i <= end; i ++){
									if(i == pageNum){
										out.print("<li class='choose'><b>"+i+"</b></li>") ;
									}else{
										out.print("<li><a href='circle/wcircleAction_dataList?start="+i+"'>"+i+"</a></li>") ;
									}
								}
							%>
						</ul>
						<%
							if(pageNum < end){
								out.print("<span><a href='circle/wcircleAction_dataList?start="+(pageNum+1)+"'>下一页</a></span>") ;
							}else{
								out.print("<span>下一页</span>") ;
							}
						%>
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