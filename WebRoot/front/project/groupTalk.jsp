<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.talentservice.utils.*, com.talentservice.domain.User" %>
<%@ include file="/admin/common/common.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>团队交流</title>

	<!-- Set render engine for 360 browser -->
	<meta name="renderer" content="webkit">
	
	<!-- No Baidu Siteapp-->
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	
	<link rel="alternate icon" href="<%=request.getContextPath()%>/assets/i/favicon.ico">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/amazeui.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/app.css">
	
	<!-- umeditor css -->
	<link href="<%=request.getContextPath()%>/umeditor/themes/default/css/umeditor.css" rel="stylesheet">
	
	<style>
	.title {
		text-align: center;
	}
	
	.chat-content { width: 960px; height: auto; margin: 0 auto;}
	
	.chat-content-container {
		float: left;
		width: 700px;
		height: 29rem;
		overflow-y: scroll;
		border: 1px solid silver;
	}
	
	.user-list { width: 200px; height: 350px; border: silver 1px solid; float: right; overflow-y: scroll;}
	.user-online {width: 100%; height: 35px; line-height: 35px; display: block; padding-left: 15px; background: #3e6372; color: white; font-size: 18px;}
	</style>
	</head>
	<body>
	<!-- title start -->
	<div class="title">
		<div class="am-g am-g-fixed">
			<div class="am-u-sm-12">
				<h1 class="am-text-primary"><s:property value="%{#group.groupname}" /></h1>
			</div>
		</div>
	</div>
	<!-- title end -->

	<!-- chat content start -->
	<div class="chat-content">
		<div class="chat-content-container">
			<div class="am-u-sm-12">
				<ul id="message-list" class="am-comments-list am-comments-list-flip">
					<s:if test="#chatList.size() != 0">
						<s:iterator value="chatList">
							<s:if test="#user.uid == user.uid">
								<li class="am-comment am-comment-flip">
							</s:if>
							<s:else>
								<li class="am-comment am-comment">
							</s:else>
								<a href="javascript:void(0)" >
									<s:if test="#user.uid == user.uid">
										<img src="<%=request.getContextPath()%>/images/self.png" alt="" class="am-comment-avatar" width="48" height="48"/>
									</s:if>
									<s:else>
										<img src="<%=request.getContextPath()%>/images/others.png" alt="" class="am-comment-avatar" width="48" height="48"/>
									</s:else>
								</a>
								<div class="am-comment-main">
									<header class="am-comment-hd">
										<div class="am-comment-meta">
											<a href="javascript:void(0)" class="am-comment-author"><s:property value="user.username" /></a> 
											<time><s:property value="sendtime" /></time>
										</div>
									</header>
									<div class="am-comment-bd">
										<s:property value="content" escape="false" />
									</div>
								</div>
							</li>
					</s:iterator>
				</s:if>
				</ul>
			</div>
		</div>
		<div class="user-list">
			<span class="user-online">在线成员</span>
			<ul id="user-list"></ul>
		</div>
	</div>
	
	<!-- chat content end -->

	<!-- message input start -->
	<div class="message-input am-margin-top">
		<div class="am-g am-g-fixed">
			<div class="am-u-sm-12">
				<form class="am-form">
					<div class="am-form-group">
						<script type="text/plain" id="myEditor" style="width: 100%;height: 8rem;"></script>
					</div>
				</form>
			</div>
		</div>
		<div class="am-g am-g-fixed am-margin-top">
			<div class="am-u-sm-6">
				<button id="send" type="button" class="am-btn am-btn-primary">
					<i class="am-icon-send"></i> Send
				</button>
			</div>
		</div>
	</div>
	<!-- message input end -->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="<%=request.getContextPath()%>/assets/js/jquery.min.js"></script>
	<!--<![endif]-->
	<!--[if lte IE 8 ]>
	<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
	<![endif]-->
	
	<!-- umeditor js -->
	<script charset="utf-8" src="<%=request.getContextPath()%>/umeditor/umeditor.config.js"></script>
	<script charset="utf-8" src="<%=request.getContextPath()%>/umeditor/umeditor.min.js"></script>
	<script src="<%=request.getContextPath()%>/umeditor/lang/zh-cn/zh-cn.js"></script>
	
	<script>
		var uid = '<s:property value="%{#user.uid}" />';
		var group = '<s:property value="%{#group.gid}" />';

		$(function() {
			// 初始化消息输入框
			var um = UM.getEditor('myEditor');
			// 滚动到最底端
			$(".chat-content-container").scrollTop($(".chat-content-container")[0].scrollHeight);
			// 新建WebSocket对象，最后的/WebSocket跟服务器端的@ServerEndpoint("/websocket")对应
			var socket = new WebSocket('ws://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/websocket/'+group+'/'+uid);
			// 处理服务器端发送的数据
			socket.onmessage = function(event) {
				addMessage(event.data);
			};
			socket.onopen = function() {
			    log("open");
			    socket.send("send message");
			}
			socket.onclose = function(e) {
			    log("closed");
			}
			socket.onerror = function(e) {
			    log("error");
			}
			// 点击Send按钮时的操作
			$('#send').on('click', function() {
				var nickname = '<s:property value="%{#user.username}" />' ;
				if (!um.hasContents()) {	// 判断消息输入框是否为空
					// 消息输入框获取焦点
					um.focus();
					// 添加抖动效果
					$('.edui-container').addClass('am-animation-shake');
					setTimeout("$('.edui-container').removeClass('am-animation-shake')", 1000);
				} else {
					// 发送消息
					socket.send(JSON.stringify({
						content : um.getContent(),
						nickname : nickname,
						groupid : group,
						obj : uid
					}));
					// 清空消息输入框
					um.setContent('');
					// 消息输入框获取焦点
					um.focus();
				}
			});
			
			// 把消息添加到聊天内容中
			function addMessage(message) {
				message = JSON.parse(message);
				if(message.type == 'message'){
					var messageItem = '<li class="am-comment '
							+ (message.isSelf ? 'am-comment-flip' : 'am-comment')
							+ '">'
							+ '<a href="javascript:void(0)" ><img src="<%=request.getContextPath()%>/assets/images/'
							+ (message.isSelf ? 'self.png' : 'others.jpg')
							+ '" alt="" class="am-comment-avatar" width="48" height="48"/></a>'
							+ '<div class="am-comment-main"><header class="am-comment-hd"><div class="am-comment-meta">'
							+ '<a href="javascript:void(0)" class="am-comment-author">'
							+ message.nickname + '</a> <time>' + message.date
							+ '</time></div></header>'
							+ '<div class="am-comment-bd">' + message.content
							+ '</div></div></li>';
					$(messageItem).appendTo('#message-list');
					// 把滚动条滚动到底部
					$(".chat-content-container").scrollTop($(".chat-content-container")[0].scrollHeight);
				}else{
					var messageItem = '' ;
					for(var i = 0; i < message.userList.length; i ++){
						messageItem += '<li class="user-style">'+message.userList[i].username+'</li>';
					}
					$('#user-list').html(messageItem);
					$(".user-list").scrollTop($(".user-list")[0].scrollHeight);
				}
			}
		});
	</script>
</body>
</html>