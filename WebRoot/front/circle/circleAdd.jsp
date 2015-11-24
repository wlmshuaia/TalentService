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
    
    <script language="javascript" src="<%=request.getContextPath()%>/js/click.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/chuangjianquanzi.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/all8.js"></script>
    
    <title>创建圈子</title>
    
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
		
		#quanzihuati{ height:1350px;}
		#quanzihuati div{ border:none; box-shadow:none; color:#137eb4; font-size:18px; width:780px; margin-left:30px;}
		#quanzihuati div span{ float:right; color:#99999b; width:40px; margin-right:20px;}
		
		#quanzihuati div a:hover{ text-decoration:underline; cursor:pointer;}
		
		#youxia{ width:240px; margin-top:7px;}
		#youxia div{ width:240px; height:265px; background:#FFF; margin-top:13px; border-radius:4px 4px 0 0; border-right:1px #dbdbdb solid; border-bottom:1px #dbdbdb solid;border-top:3px #ff6900 solid; box-shadow:1px 1px #b0b0b1;}
		#youxia div div{ width:220px; margin:0 auto; height:42px; border-bottom:2px #e5e5e5 solid; border-top:none; color:#3e6372; box-shadow:none; border-right:none; font-size:22px; text-indent:4px; line-height:2em;}
		
		table{ font-size:20px;}
		table input{ height:45px; border:#b2d4dd thin solid; border-radius:4px; font-family:"微软雅黑";}
		tr{ height:45px;}
    
    </style>
    
  </head>
  
  <body>
  <%@ include file="/front/frame/header.jsp" %>
  <div id="main" style="background-color:#efeff5; margin:0 auto; border-top:#6b6b6b solid; padding-bottom:0px;">
    	<div id="weizhi" style="width:1120px; height:30px; margin:0 auto; border:2px dashed #999; font-size:20px; border-radius:5px; margin-top:5px;">
        	<span style="font-size:20px; margin-left:5px;">当前位置</span>
        	>>首页>>
            <a>圈子创建</a>
        </div>
        
        <div style="width:1120px; margin:0 auto; margin-top:10px; min-height:800px;">
        	<div style="width:870px; float:left; margin-left:0px; border-radius:4px 4px 0 0; border-right:1px #dbdbdb solid; border-bottom:1px #dbdbdb solid;border-top:3px #ff6900 solid; box-shadow:1px 1px #b0b0b1; padding-bottom:20px; background:#FFF;">
				<div style="font-size:36px; width:842px; color:#627f8a; height:80px; border-bottom:2px #eeeeee solid; margin:0 auto; margin-top:50px; text-indent:1em;">
                	圈子
                </div>
                <s:form action="wcircleAction_circleAdd.action">
                	<table cellspacing="20px;" width="786px;" style="margin:0 auto;">
	                    <tr>
	                        <th valign="middle" width="110px;" bgcolor="#3e6373" style="border-radius:4px; color:#FFF">
	                      	   圈子名称
	                        </th>
	                        <th>
	                        	<s:textfield name="circlename" style=" width:80%; font-size:17px; float:left;"></s:textfield>
	                        </th>
	                    </tr>
	                    <tr>
	                        <th valign="middle"  bgcolor="#3e6373" style="border-radius:4px; color:#FFF">
	                        	圈子分类
	                        </th>
	                        <th>
	                        	<s:select list="cateList" name="category_id" listKey="cid" listValue="catename" style=" width:40%; height:35px; float:left; margin-left:0px; border:#b2d4dd thin solid; border-radius:4px;"></s:select>
	                        </th>
	                    </tr>
	                    <tr>
	                        <th valign="top" >
	                        	<span style="border-radius:4px; color:#FFF; background-color:#3e6373; display:inline-block; font-size:20px; height:45px; line-height:2em; width:100%">圈子简介</span>
	                        </th>
	                        <th>
	                        	<s:textarea name="description" style=" font-size:20px; width:99%; height:200px;"></s:textarea>
	                        </th>
	                    </tr>
	                    <tr>
	                        <th valign="top">
	                        	 <span style="border-radius:4px; color:#FFF; background-color:#3e6373; display:inline-block; font-size:20px; height:45px; line-height:2em; width:100%;">邀请成员</span>   
	                        </th>
	                        <th>
	                            <div id="d3">
	                                <div id="genduo" style=" margin-top:0px; width:74px; height:25px; text-align:1em; cursor:pointer; font-size:16px; background:#ff6900; color:#FFF;">+&nbsp;添加</div>
	                                <div style="display:none;" id="zhankai">
	                        			
	                                </div>
	                            </div>
	                        </th>
	                    </tr>
	                    <tr>
                    		<th>
                        	</th>
                        	<th>
                            	<input type="submit" value="创建圈子" style=" font-family:微软雅黑; cursor:pointer; float:left; font-size:22px; width:116px; height:46px; background:#ff6900; color:#FFF; border:none; border-radius:4px;" />
                        	</th>
                    
                    	</tr>
                    
	                </table>
                </s:form>
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
