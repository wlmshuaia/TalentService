<%@page import="org.drools.lang.DRLParser.data_type_return"%>
<%@ page language="java" import="java.util.*, com.talentservice.domain.Topic" pageEncoding="UTF-8"%>
<%@ include file="/admin/common/common.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>话题详情</title>
   	
   	<style>
		#zuo{ position:relative;}
		#zuobian{ min-height:150px; width:860px; margin:0 auto;}
		#zuobian div{ width:750px; margin:0 auto; }
		#dibu div{ width:216px; height:108px; background:#dce1e7; float:left; margin-left:2px;}
		
		#youxia{ width:240px; margin-top:7px;}
		#youxia div{ width:240px; height:265px; background:#FFF; margin-top:13px; border-radius:4px 4px 0 0; border-right:1px #dbdbdb solid; border-bottom:1px #dbdbdb solid;border-top:3px #ff6900 solid; box-shadow:1px 1px #b0b0b1;}
		#youxia div div{ width:220px; margin:0 auto; height:42px; border-bottom:2px #e5e5e5 solid; border-top:none; color:#3e6372; box-shadow:none; border-right:none; font-size:22px; text-indent:4px; line-height:2em;}
		
		#ping li{ list-style:none;}
	</style>
   	
   	<script type="text/javascript">

		function zan(cid) {
			$.post('/TalentService/circle/wcircleAction_zan.action', {cid: cid}, function(result){
				var data = eval("(" + result + ")");//json为接收的后台返回的数据；
				var value = data.value ;
				$('#'+cid).html(value);
			});
		}
		
		function topicZan(tid) {
			$.post('/TalentService/circle/wcircleAction_topicZan.action', {tid: tid}, function(result){
				var data = eval("(" + result + ")");//json为接收的后台返回的数据；
				var value = data.value ;
				alert('已赞') ;
				$('#topicZan').html(value);
			});
		}

   	</script>
   	
  </head>
  
  <body>
  	<%@ include file="/front/frame/header.jsp" %>
  	
  	<div id="main" style="background-color:#efeff5; padding-bottom:20px; margin:0 auto; border-top:#6b6b6b solid;">
    	<div id="weizhi" style="width:1120px; height:30px; margin:0 auto; border:2px dashed #999; font-size:20px; border-radius:5px; margin-top:5px;">
        	<span style="font-size:20px; margin-left:5px;">当前位置</span>
        	>>首页>><s:a action="wcircleAction_dataList.action">圈子列表</s:a>>>
            <s:a action="wcircleAction_getInfo.action?cid=%{#data.circle.cid}">圈子详情</s:a>>>
            <a>话题详情</a>
        </div>
        <div style="width:1120px; margin:0 auto; min-height:950px; margin-top:10px;">
        	<div style="width:870px; float:left; margin-left:0px; min-height:955px;border-radius:4px 4px 0 0; background:#FFF; border-right:1px #dbdbdb solid; border-bottom:1px #dbdbdb solid;border-top:5px #ff6900 solid; box-shadow:1px 1px #b0b0b1; " id="zuo">
            	<div id="zuobian">
                    <div style="height:50px; font-size:26px; text-align:center; margin-top:70px; line-height:2em;">
                       	<s:property value="#data.title" />
                    </div>
                    
                    <div style="height:30px; margin-top:20px; color:#909090; font-size:20px; text-align:center;">
                        	作者：<s:property value="#data.user.username" />&nbsp;|&nbsp;
                        	<s:property value="#data.foundtime" />&nbsp;|&nbsp;
                        	评论(<s:property value="#dataList.size()" />)&nbsp;|&nbsp;
                        	赞(<span id="topicZan"><s:property value="#data.zannumber" /></span>)&nbsp;|&nbsp;
                        	收藏(0)&nbsp;|&nbsp;
                        	浏览(123)
                    </div>
                    
                    <div style="margin-top:50px; min-height: 130px; width:750px; word-break:break-all; line-height:2em; letter-spacing:0.1em; text-indent:2em;">
                    	<s:property value="#data.content" />
                    </div>
                </div>
                <div id="dibu" style=" position:absolute; bottom:0px; height:108px; width:870px; ">
                	<div id="shangyiye" style="margin-left:0px;"><img src="<%=request.getContextPath()%>/images/dibu1.gif" /></div>
                    <div><img src="<%=request.getContextPath()%>/images/dibu2.gif" /></div>
                    <div><a onclick="topicZan(<s:property value="#data.tid" />)"><img src="<%=request.getContextPath()%>/images/dibu3.gif" /></a></div>
                	<div id="xiayiye"><img src="<%=request.getContextPath()%>/images/dibu4.gif" /></div>
                </div>
            </div>
            <div style="width:240px; float:left; margin-left:6px;">
                <div id="youxia" style="margin-top:0px;">
                	<div style="margin-top:0px; height:395px;">
                    	<div>
                        	推荐:
                        </div>
                    </div>
                    <div>
                    	<div>
                        	话题标签:
                        </div>
                    </div>
                    <div>
                    	<div>
                        	相关圈子:
                        </div>
                    </div>
                </div>
            </div>
        </div>
		<div style="width:1120px; min-height:1000px; margin:0 auto; margin-top:20px;border-radius:4px 4px 0 0; background:#FFF; border-right:1px #dbdbdb solid; border-bottom:1px #dbdbdb solid;border-top:5px #ff6900 solid; box-shadow:1px 1px #b0b0b1;">
    		<s:form action="wcircleAction_addComment.action">
    			<div style="width:1056px; height:240px; margin:0 auto;margin-top:50px;">
	            	<s:hidden name="tid" value="%{#data.tid}"></s:hidden>
	            	<s:textarea name="content" style="background:#eff5f5; width:100%; height:133px; border:none; font-size:18px;" id="kuang" ></s:textarea>
	            	<input type="submit" value="评论" id="tijiao" style="width:107px; height:53px; float:right; margin-top:20px; border:none; background:#3598db; border-radius:3px; color:#FFF; font-size:18px;"/>
	            </div>
    		</s:form>
            <div style=" width:1030px; height: auto; margin:0 auto; margin-top:20px;" id="ping">
            	<s:if test="#dataList.size() == 0">
            		暂无评论
            	</s:if>
            	<s:else>
            		<s:iterator value="dataList">
	            		<li style="width:1030px; height:105px; ">
		                	<div style="background:url(<%=request.getContextPath()%>/images/touxiang.gif); width:90px; height:105px; float:left"></div>
		                    <div style="float:left; width:820px; hanging-punctuation:105px; margin-left:20px;">
		                    	<div style="height:40px;color:#233c52; font-size:20px; line-height:2em"><s:property value="user.username" /></div>
		                    	<div style="height:30px;"><s:property value="content" /></div>
		                        <div style="height:33px; font-size:16px;">
		                        	<a onclick="zan(<s:property value="cid" />)">赞(<span id="<s:property value="cid" />"><s:property value="zannumber" /></span>)</a>
		                        	<s:property value="commenttime" />
		                        </div>
		                    </div>
		                </li>
            		</s:iterator>
            	</s:else>
            	<div class="page">
					<%
						int start = Integer.parseInt(ActionContext.getContext().get("start").toString()) ;
						int end = Integer.parseInt(ActionContext.getContext().get("end").toString()) ;
						int pageNum = Integer.parseInt(ActionContext.getContext().get("page").toString()) ;
						Topic t = (Topic) ActionContext.getContext().get("data") ;
						
						if(pageNum > 1){
							out.print("<span><a href='circle/wcircleAction_topicInfo?tid="+t.getTid()+"&start="+(pageNum-1)+"'>上一页</a></span>") ;
						}
					%>
					<ul>
						<%
							for(int i = start; i <= end; i ++){
								if(i == pageNum){
									out.print("<li class='choose'><b>"+i+"</b></li>") ;
								}else{
									out.print("<li><a href='circle/wcircleAction_topicInfo?tid="+t.getTid()+"&start="+i+"'>"+i+"</a></li>") ;
								}
							}
							
						%>
					</ul>
					<%
						if(pageNum < end){
							out.print("<span><a href='circle/wcircleAction_topicInfo?tid="+t.getTid()+"&start="+(pageNum+1)+"'>下一页</a></span>") ;
						}
					%>
				</div>
            </div>
        </div>
    </div>
  	
  	<%--<s:iterator value="data">
  		<ul>
  			<li>话题标题：<s:property value="title" /></li>
  			<li>内容：<s:property value="content" /></li>
  			<li>发布时间：<s:property value="foundtime" /></li>
  			<li>发布人：<s:property value="user.username" /></li>
  		</ul>
  	</s:iterator>
  	
  	评论列表：
  	<s:iterator value="dataList">
  		<ul>
  			<li>评论人：<s:property value="user.username" /></li>
  			<li>评论内容：<s:property value="content" /></li>
  			<li>评论时间：<s:property value="commenttime" /></li>
  			<li><a onclick="zan(${cid})">赞(<span id="${cid}"><s:property value="zannumber" /></span>)</a></li>
  			<li><s:a action="wcircleAction_addCommentUI.action?tid=%{data.tid}&cid=%{cid}">评论</s:a></li>
  		</ul>
  	</s:iterator>
  	
  	<s:form action="wcircleAction_addComment.action">
  		<s:hidden name="tid" value="%{tid}"></s:hidden>
  		<s:textarea name="content" rows="10" cols="70"></s:textarea>
  		<s:submit label="发布评论"></s:submit>
  	</s:form>
	--%><%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>
