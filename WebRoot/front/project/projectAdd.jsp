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
    
    <title>项目发布</title>
    
	<script language="javascript" src="<%=request.getContextPath()%>/js/click.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/genduo.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/shangchuan.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/check.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/all3.js"></script>
  
    <style type="text/css">
    	body{ margin:0 auto;}
		table{ width:100%}
		table input{ border:#b2d4dd thin solid; border-radius:4px; font-family:"微软雅黑";}
		#d1{ color:#3d6473}
		#d1 div{ float:left; margin-left:20px; }
		#d1 div span{ margin-left:5px;}
		#d1 div input{ margin-left:10px;  width:18px; height:18px; color:#b2d4dd; border-radius:4px;}
		#d2 div{ margin-top:5px; width:100%; height:30px; display:none;}
		#d2{ color:#3d6473}
		#d2 div span{ display:inline-block; font-size:16px; width:40px; text-align:left;; float:left;}
		#d2 div input{ margin-left:20px; width:50%; height:20px; float:left; border:#b2d4dd thin solid; border-radius:4px;}
		#d3{ color:#3d6473}
		#d3 div{ width:100%; margin-top:10px; height:30px;}
		#d3 div span{ display:inline-block; width:100px; float:left; text-align:left;}
		#d3 div select{ font-weight:bold; width:40px; margin-left:50px; float:left; border:#b2d4dd thin solid; border-radius:4px;}
		#d3 div option{}
		
    </style>
  </head>
  
  <body>
  <%@ include file="/front/frame/header.jsp" %>
	<%--<s:form action="wprojectAction_add.action" method="post" enctype="multipart/form-data">
		标题：<s:textfield name="title" /><br />
		所属分类：<s:select list="cateList" name="category_id" listKey="cid" listValue="catename"></s:select><br />
		描述：<s:textarea name="description" cols="50" rows="10"></s:textarea><br />
		
		上传附件：<s:file name="upload" />
			<s:file name="upload" /><br />
		
		预算：<s:select list="budget" name="budget" listKey="id" listValue="content" /><br />
		手机：<s:textfield name="phone" /><br />
		邮箱：<s:textfield name="mail" /><br />
		
		竞标结束：<s:select list="biddingEnd" name="biddingend" listKey="id" listValue="content" /><br />
		项目结束：<s:select list="projectEnd" name="projectend" listKey="id" listValue="content" /><br />
		
		<s:submit title="发布" value="发布项目" />
		
		<s:a action="wprojectAction_add.action">测试</s:a>
	</s:form>
	
  --%>
  <div style=" background-color:#efeef4; border-top:#6b6b6b solid; padding-bottom:30px; ">
        <div id="main" style="width:1122px; margin:0 auto; background-color:#FFF; border-top:#ff6a03 solid; margin-top: 10px; border-radius:5px;">
      
            <div style="margin:0 auto; width:960px;">
            	<div style="font-size:36px; border-bottom:#63818c solid thin; color:#ff6a03; height:52px; margin-top:20px;">发布项目</div>
                <s:form action="wprojectAction_add.action" method="post" enctype="multipart/form-data">
                <table cellspacing="20px;">
                    <tr>
                        <th valign="middle" width="110px;" bgcolor="#3e6373" style="border-radius:4px; color:#FFF">
                        	项目标题
                        </th>
                        <th>
                            <input type="text" required name="title"   style=" width:80%; font-size:17px; float:left; height:30px;"/>
                        </th>
                    </tr>
                
                    <tr>
                        <th valign="middle"  bgcolor="#3e6373" style="border-radius:4px; color:#FFF">
                       	 项目类型
                        </th>
                        <th>
                            <s:select style=" width:20%; float:left; margin-left:0px; height:25px; border:#b2d4dd thin solid; border-radius:4px;" list="cateList" name="category_id" listKey="cid" listValue="catename"></s:select>
                        </th>
                    </tr>
                    
                    <tr>
                        <th valign="top">
                        	<span style="border-radius:4px; color:#FFF; background-color:#3e6373; display:inline-block; font-size:16px; height:30px; line-height:2em; width:100%">项目描述</span>
                        </th>
                        <th>
                            <textarea required name="description" id="myEditor" style=" font-size:20px; width:100%; height:200px;"></textarea>
                            <!-- <script type="text/plain" id="myEditor" style="width: 100%;height: 8rem;"></script> -->
                        </th>
                    </tr>
                    
                    <tr>
                    	<th valign="top">
                        	<span style="border-radius:4px; color:#FFF; background-color:#3e6373; display:inline-block; font-size:16px; height:30px; line-height:2em; width:100%">添加附件</span>
                        </th>
                    	<th align="left" style="color:#ff6900;">
                        	<div id="shangchuan" style="border:1px #ff6900 solid; width:70px">上传附件</div>
                            <div style="width:400px;">
                                <div id="shanchu" style="background:#FFF;">

                                </div>
                        	</div>
                        </th>
                    </tr>
                    <tr>
                        <th valign="middle"  bgcolor="#3e6373" style="border-radius:4px; color:#FFF">
                       	 	项目预算
                        </th>
                        <th>
                            <s:select style=" width:20%; float:left; margin-left:0px; height:25px; border:#b2d4dd thin solid; border-radius:4px;" list="budget" name="budget" listKey="id" listValue="content" /><br />
                        </th>
                    </tr>
                    <tr>
                        <th valign="top">
                            <span style="border-radius:4px; color:#FFF; background-color:#3e6373; display:inline-block; font-size:16px; height:30px; line-height:2em; width:100%">联系方式</span>
                        </th>
                        
                        <th>
                            <div style="width:100%; height:30px; color:#3d6473;">
                                <div style="float:left;">
                                    <input type="checkbox" value="手机" style="margin-left:0px;  width:18px; height:18px; color:#b2d4dd; border-radius:4px;"  checked="checked"; /><span style="margin-left:5px;">手机</span>
                                </div>
                                <div style="float:left; margin-left:10px; font-size:12px; width:70%;">
                                    <s:textfield name="phone"  style=" width:60%; float:left; margin-left:20px; height:20px;"></s:textfield>
                                    <span style="padding-left:20px; font-size:16px;">请留下联系方式</span>
                                </div>
                            </div>
                            
                            <div id="d1" style="margin-top:5px; width:100%; height:30px;">
                                <div style="margin-left:0px;""><input type="checkbox" style="margin-left:0px;" /><span>固话</span></div>
                                <div><input type="checkbox" /><span>邮箱</span></div>
                                <div><input type="checkbox" /><span>QQ</span></div>
                            </div>
                            
                            <div id="d2" style="margin-top:5px; width:100%;">
                                <div><span>固话</span><s:textfield name="telephone"></s:textfield></div>
                                <div><span>邮箱</span><s:textfield name="mail"></s:textfield></div>
                                <div><span>QQ</span><s:textfield name="qq"></s:textfield></div>
                            </div>
                        </th>
                    </tr>                                                   
                    
                    <tr>
                        <th valign="top">
                        	 <span style="border-radius:4px; color:#FFF; background-color:#3e6373; display:inline-block; font-size:16px; height:30px; line-height:2em; width:100%">更多需求</span>   
                        </th>
                        <th>
                            <div id="d3">
                                <div id="genduo" style="cursor: pointer; width: 69px; margin-top:0px; height:20px; margin-left:4px; background-image:url(<%=request.getContextPath()%>/images/zhankai.gif);"></div>
                                <div style="display:none;" id="zhankai">
                                <div style="margin-top:10px;">
                                    <span>竞标有效期</span>
                                    <s:select style="height:20px; width:50px;" list="biddingEnd" name="biddingend" listKey="id" listValue="content" />
                                </div>
                                <div>
                                    <span>项目完成期</span>
                                    <s:select style=" width:100px;height:20px;" list="projectEnd" name="projectend" listKey="id" listValue="content" />
                                </div>
                                <div>
                                    <span>隐私设置</span>
                                    <input style="float:left; margin-left:50px;  width:18px; height:18px;" type="checkbox" /><span style="float:left; margin-left:10px;">非公开项目</span>
                                    
                                </div>
                                <div id="open" style="width:100%;">
                                    <span>其他需求</span>
                                    <input style="float:left; margin-left:50px; width:18px; height:18px;" type="checkbox" /><span style="font-size:16px; width:120px; margin-left:5px;">接包方提供发票</span>
                                    <input style="float:left; margin-left:15px; width:18px; height:18px;" type="checkbox" /><span style="font-size:16px; width:120px; margin-left:5px;">接包方实名认证</span>
                                    <input style="float:left; margin-left:15px; width:18px; height:18px;" type="checkbox" /><span style="font-size:16px; width:120px; margin-left:5px;">接包方有案例 </span>
                                </div>
                                </div>
                            </div>
                        </th>
                    </tr>
                    <tr>
                        <th></th>
                        <th>
                            <input style="width:100px; height:30px; float:left; margin-left:0px; font-size:18px; color:#FFF; border:1px solid #ff6900; border-radius:4px; text-align:center; letter-spacing:1em; text-indent:15px; background:#ff6900;"   type="submit"  value="预览"/>
                            <input style="width:140px; height:30px; float:left; margin-left:30px; font-size:18px; border:1px solid #ff6900; background:#FFF; border-radius:4px; color:#ff6900;" type="submit"  value="提交项目"/>
                        </th>
                    </tr>
                </table>
            	</s:form>
            </div>
        
        </div>
	</div>
	<%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>
