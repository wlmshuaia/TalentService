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
    
    <title>付款评论</title>
	<script language="javascript" src="<%=request.getContextPath()%>/js/click.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/pingjia.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/all12.js"></script>
	
	<style type="text/css">
		#xuesheng{width:100%; padding-bottom:20px; margin-top:30px;}
		#xuesheng li{ width:100%; margin-top:10px; height:40px; list-style:none;}
		#xuesheng li div{ float:left; width:40px; height:40px;background:url(<%=request.getContextPath()%>/images/yanshi.gif); background-size: cover; border-radius:40px;}
		#xuesheng li span{ display:block; height:30px; font-size:18px; margin-top:4px; margin-left:30px; float:left;}
		#pingfen{ width:810px; margin:0 auto;}
		#pingfen div{ width:100%;}
		#gezhongpingjia { font-size:20px; margin-top:20px;}
		#gezhongpingjia div{ width:33px; height:34px; display:inline-block; margin-left:50px; }
		#gezhongpingjia input{ display:inline-block; width:20px; height:20px;}
		#wanchengpingjia{ overflow:hidden; margin-top:10px; border:1px #000 solid;}
		#wanchengpingjia ul{ float:left; margin-left:10px; font-size:20px;}
		#wanchengpingjia ul li{ display:inline-block; width:22px; height:22px; cursor:pointer; background:url(<%=request.getContextPath()%>/images/star2.png); background-size:contain; margin-left:4px;}
		#hou{ overflow:hidden; margin-top:20px; }
		#hou input{ list-style:none; float:left; background:#fff; width:100px; height:30px; border:2px #ff6900 solid; color:#ff6900; font-size:20px; border-radius:4px;  margin-left:20px; text-align:center; cursor:pointer;}
		#hou input:hover{ background:#ff6900; color:#fff;}
	</style>

  </head>
  
  <body>
	<%@ include file="/front/frame/header.jsp" %>
	
	<div id="main" style="background-color:#efeff5; padding-bottom:20px; border-top:#6b6b6b solid;">
    	<div id="weizhi" style="width:960px; height:30px; margin:0 auto; font-size:20px; border-radius:5px; margin-top:5px;">
        	<span style="margin-left:5px;">当前位置</span>
        	>><a>首页</a>>>
            <a>项目评分</a>
            
        </div> 		
        <div style=" width:960px; margin:0 auto; margin-top:10px; padding-top:20px; padding-bottom:20px; background:#FFF; border-radius:5px 0 0 5px; border-right:1px #dbdbdb solid; border-bottom:1px #dbdbdb solid;border-left:3px #ff6900 solid; box-shadow:1px 1px #b0b0b1;">
            <div style=" width:870px; margin:0 auto;">
               <div style="font-size:20px;">项目评分：</div>
               <form action="project/wplanAction_commentHandle.action" method="post">
               		<s:hidden name="pid" value="%{#pid}"></s:hidden>
					<s:hidden name="taskId" value="%{#taskId}"></s:hidden>
					<s:hidden name="executionId" value="%{#executionId}"></s:hidden>
					<s:hidden name="type" value="%{#type}"></s:hidden>
					
					<div id="pingfen">
	               		<div style="font-size:16px; margin-top:10px;">您觉得承接方在本次合作中表现如何:</div>
	               		<div id="gezhongpingjia">
	                    	<div style="background:url(<%=request.getContextPath()%>/images/haoping.png); margin-left:0px;"></div>
	                        <input type="radio" name="score.overall" value="good" />好评
	                   		<div style="background:url(<%=request.getContextPath()%>/images/zhongping.png)"></div>
	                        <input type="radio" name="score.overall" value="soso" />中评
	                   		<div style="background:url(<%=request.getContextPath()%>/images/chaping.png)"></div>
	                        <input type="radio" name="score.overall" value="bad" />差评                    
	                    </div>
	                    
	                    <s:if test="type == 'issuer'">
	                    	<div id="wanchengpingjia">
		                    	<ul style="margin-left:0px;">
		                        	完成质量:<li></li><li></li><li></li><li></li><li></li>
		                        	<input type="hidden" name="score.quality" id="pj1"  />
		                        </ul>
		                        <ul>
		                        	完成速度:<li></li><li></li><li></li><li></li><li></li>
		                        	<input type="hidden" name="score.speed" id="pj2" />
		                        </ul>
		                        <ul>
		                        	配合态度:<li></li><li></li><li></li><li></li><li></li>
		                        	<input type="hidden" name="score.attitude" id="pj3" />
		                        </ul>
		                    </div>
						</s:if>
						<s:else>
							<div id="wanchengpingjia">
		                    	<ul style="margin-left:0px;">
		                        	价格合理:<li></li><li></li><li></li><li></li><li></li>
		                        	<input type="hidden" name="score.quality" id="pj1"  />
		                        </ul>
		                        <ul>
		                        	支付及时:<li></li><li></li><li></li><li></li><li></li>
		                        	<input type="hidden" name="score.speed" id="pj2" />
		                        </ul>
		                        <ul>
		                        	配合态度:<li></li><li></li><li></li><li></li><li></li>
		                        	<input type="hidden" name="score.attitude" id="pj3" />
		                        </ul>
		                    </div>
						</s:else>
	                    
	               		
	               		<div style="font-size:16px; margin-top:20px;">说说您对他的看法：</div>
	                    <div style="margin-top:10px;"><s:textarea name="score.content" style="width:100%; height:200px; font-size:20px;"></s:textarea></div>
	                    <div id="hou">
	                    	<input type="submit" value="确定" style="margin-left:0px;" />
	                        <input type="reset" value="以后再说" />
	                    </div>
	               </div>
               </form>
               
            
            </div>
        </div>
    </div>
	
	双方互评。
	<%-- <form action="project/wplanAction_commentHandle.action" method="post">
		<s:hidden name="pid" value="%{#pid}"></s:hidden>
		<s:hidden name="taskId" value="%{#taskId}"></s:hidden>
		<s:hidden name="executionId" value="%{#executionId}"></s:hidden>
		<s:hidden name="type" value="%{#type}"></s:hidden>
		<s:if test="type == 'issuer'">
			总评：<s:textfield name="score.overall"></s:textfield>
			完成质量：<s:textfield name="score.quality"></s:textfield>
			完成速度：<s:textfield name="score.speed"></s:textfield>
			配合态度：<s:textfield name="score.attitude"></s:textfield>
		</s:if>
		<s:else>
			总评：<s:textfield name="score.overall"></s:textfield>
			价格合理：<s:textfield name="score.quality"></s:textfield>
			支付及时：<s:textfield name="score.speed"></s:textfield>
			配合态度：<s:textfield name="score.attitude"></s:textfield>
		</s:else>
		<br>
		评价：<br><s:textarea name="score.content" rows="10" cols="100"></s:textarea><br/>
		<s:submit label="确认评价"></s:submit>
	</form> --%>
	
 	<%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>
