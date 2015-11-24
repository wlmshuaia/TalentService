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
    
    <title><s:property value="#data.title" /></title>
    <link href="<%=request.getContextPath()%>/CSS/head.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
	   	table input{ border:#b2d4dd thin solid; border-radius:4px; font-family:"微软雅黑";}
		#d1{ color:#3d6473}
		#d1 div{ float:left; margin-left:20px; }
		#d1 div span{ margin-left:5px;}
		#d1 div input{ margin-left:10px;  width:30px; height:18px; color:#b2d4dd; border-radius:4px;}
		#d2 div{ margin-top:5px; width:100%; height:30px; display:none;}
		#d2{ color:#3d6473}
		#d2 div span{ display:inline-block; font-size:16px; width:40px; text-align:left;; float:left;}
		#d2 div input{ margin-left:20px; width:50%; height:20px; float:left; border:#b2d4dd thin solid; border-radius:4px;}
		#d3{ color:#3d6473}
		#d3 div{ width:100%; margin-top:10px; height:30px;}
		#d3 div span{ display:inline-block; width:100px; float:left; text-align:left;}
		#d3 div select{ font-weight:bold; width:40px; margin-left:50px; float:left; border:#b2d4dd thin solid; border-radius:4px;}
		#d3 div option{}
		
		#zuoshang{ height:70px; width:844px; border-bottom:2px #e5e5e5 solid; margin:0 auto;}
		#zuoshang div{ float:left; margin-top:20px;}
		#zuoshang div li{ float:left; list-style:none; width:65px; margin-left:23px; height:30px; color:#3e6373; font-size:21px;    }
		#zuoxia{ width:826px; margin:0 auto; }
		
		#zuoxia div{ width:800px; margin:0 auto;}
		#xinxi{ margin-top:10px; height:150px;}
		#xinxi li{ width:360px; height:30px; float:left; list-style:none;border-bottom:1px #CCC dashed; margin-left:20px; margin-top:18px;}
		#xinxi li div{ float:left; width:325px; line-height:2em; text-indent:1em;}
		
		#youxia{ width:240px; margin-top:7px;}
		#youxia div{ width:240px; height:265px; background:#FFF; margin-top:13px; border-radius:4px 4px 0 0; border-right:1px #dbdbdb solid; border-bottom:1px #dbdbdb solid;border-top:3px #ff6900 solid; box-shadow:1px 1px #b0b0b1;}
		#youxia div div{ width:220px; margin:0 auto; height:42px; border-bottom:2px #e5e5e5 solid; border-top:none; color:#3e6372; box-shadow:none; border-right:none; font-size:22px; text-indent:4px; line-height:2em;}
		
    </style>
    
	<script language="javascript" src="<%=request.getContextPath()%>/js/click.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/time.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/jingbiao.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/check.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/all.js"></script>
    <script type="text/javascript">
    	var isBid ;	// 是否显示竞标表单
    	$(function(){
    		$('#bid').click(function(){
    			if(isBid == true){
    				isBid = false ;
        			$('#bidDiv').css('display', 'none') ;
    			}else{
    				isBid = true ;
        			$('#bidDiv').css('display', 'block') ;
    			}
    		});
    		
    		$("#bidBtn").click(function(){
    			
    			$.ajax({
    				type: 'post',
    				url: 'project/wbidAction_bid.action',
    				data: $('#bidForm').serialize(),
    				datatype: 'json',
    				success: function(result){
				    	var data = eval('(' + result + ')');  // change the JSON string to javascript object    
				        alert(data.message) ;
				    	$('#jingbiaofangan').css('display', 'none');
				    	location.reload();
    				},
    				error: function() {
    					var data = eval('(' + result + ')');  // change the JSON string to javascript object    
				        alert(data.message) ;
    				}
    			}) ;
    			
    			isBid = false ;
    			$('#bidDiv').css('display', 'none') ;
    			
    		}) ;
    	}); 
    </script>
    
  </head>
  
  <body>
  	<div id="timestamp" style="display: none;"><s:property value="#timestamp" /></div>
  
  	<div id="jingbiaofangan" style="z-index:10; position:fixed; background:#dedadc; width:100%; height:100%; display:none; opacity:0.95;">
            <div style="margin:0 auto; width:960px; margin-top:20px; background:#FFF; height:640px;">
            	<div style="font-size:36px; border-bottom:#63818c solid thin; color:#ff6a03; height:52px; text-align:center; margin-top:20px;">竞标方案
                	<div id="guanbi" style=" float:right; width:36px; height:36px; background:url(<%=request.getContextPath()%>/images/guanbi.gif);"></div>
                </div>
                <s:form action="project/wbidAction_bid.action" id="bidForm">
	                <s:hidden name="pid" value="%{pid}"></s:hidden>
	                <table cellspacing="20px;" width="550px" style="float:left;">
	                    <tr>
	                        <th width="100px" valign="middle" bgcolor="#3e6373" style="border-radius:4px; color:#FFF">
	                       	 竞标费用
	                        </th>
	                        <th valign="top"align="left" style="text-indent:20px; line-height:2em;">
	                            <input type="text" name="bidmoney" style=" width:30%; font-size:17px; float:left; height:25px;"/>
	                            	元
	                        </th>
	                    </tr>
	                    <tr>
	                        <th valign="middle"  bgcolor="#3e6373" style="border-radius:4px; color:#FFF">
	                      	  项目周期
	                        </th>
	                        <th align="left" valign="top" style="text-indent:20px; line-height:2em;">
	                            <input name="bidcycle" type="text" style=" width:30%; float:left; margin-left:0px; height:25px; border:#b2d4dd thin solid; border-radius:4px;"/>
	                         	天  
	                        </th>
	                    </tr>
	                    <tr>
	                        <th valign="top">
	                            <span style="border-radius:4px; color:#FFF; background-color:#3e6373; display:inline-block; font-size:16px; height:30px; line-height:2em; width:100%">联系方式</span>
	                        </th>
	                        <th>
	                            <div id="d1" style="margin-top:5px; width:100%; height:30px;">
	                                <div style="margin-left:0px;""><input type="checkbox" style="margin-left:0px;" /><span>固话</span></div>
	                                <div><input type="checkbox" /><span>邮箱</span></div>
	                                <div><input type="checkbox" /><span>QQ</span></div>
	                            </div>
	                            <div id="d2" style="margin-top:5px; width:100%;">
	                                <div><span>固话</span><input type="text" name="phone" /></div>
	                                <div><span>邮箱</span><input type="text" name="mail" /></div>
	                                <div><span>QQ</span><input type="text" name="qq" /></div>
	                            </div>
	                        </th>
	                    </tr>                                       
	                     <tr>
	                        <th valign="top">
	                        	<span style="border-radius:4px; color:#FFF; background-color:#3e6373; display:inline-block; font-size:16px; height:30px; line-height:2em; width:100%">竞标方案</span>
	                        </th>
	                        <th>
	                            <textarea name="plan" style=" font-size:20px; width:99%; height:200px;"></textarea>
	                        </th>
	                    </tr>
	                    <tr>
	                        <th></th>
	                        <th>
	                            <input id="bidBtn" style="width:150px; height:30px; float:left; margin-left:0px; font-size:18px; color:#FFF; border:1px solid #ff6900; border-radius:4px; text-align:center;  text-indent:5px; background:#ff6900;"   type="button"  value="提交竞标方案"/>
	                            <input style="width:140px; height:30px; float:left; margin-left:30px; font-size:18px; border:1px solid #ff6900; background:#ff6900; border-radius:4px; color:#FFF;" type="submit"  value="取消"/>
	                        </th>
	                    </tr>
	                </table>
                </s:form>
                <div style="border:1px #000000 solid; float:left; width:406px; height:520px; margin-top:10px"></div>
            
            </div>
	</div>

	<%@ include file="/front/frame/header.jsp" %>
	<div id="main" style="background-color:#efeff5; padding-bottom: 30px;height:auto;  width:100%; margin:0 auto; margin-bottom: 50px;border-top:#6b6b6b solid;">
    	<div id="weizhi" style="width:1120px; height:30px; margin:0 auto; border:2px dashed #999; font-size:18px; border-radius:5px; margin-top:5px;">
        	<span style="font-size:18px; margin-left:5px;">当前位置</span>
        	>>首页>>
            <a>项目详情</a>
        </div>
        <div style="width:1120px; margin:0 auto; margin-top:10px; min-height:1500px;">
        	<div style="width:870px; float:left; margin-left:0px;min-height:1500px; border-right:1px #9b9b9b solid; border-bottom:2px #9b9b9b solid; background:#FFF; border-top:3px #ff6900 solid; border-radius:5px 5px 0 0 ;">
                <div style="width:100%; height:100%; border-right:1px #dbdbdb solid;">
                   <div id="zuoxia">
                    	<div style="color:#58afdc; height:50px; line-height: 45px; font-size:22px;"><s:property value="#data.title" /></div>
                    	<div style="height:30px; font-size:16px; margin-top:10px;">
                        	最新动态：
                            <span style=" color:#58afdc; display:inline-block; width:190px;"><s:property value="#projectlogList[#projectlogList.size()-1].handletime" /></span>
                        	<span style=" color:#58afdc; display:inline-block;"><s:property value="#projectlogList[#projectlogList.size()-1].handle" /></span>
                        </div>
                        
                        <div style="height:80px;">
                        	<s:if test="#data.status == '竞标中'">
                        		<img src="<%=request.getContextPath()%>/images/xiangmujindu_1.gif"/>
                        	</s:if>
                        	<s:elseif test="#data.status != '审核中' && #data.status != '竞标中'  && #data.status != '已完成' ">
                        		<img src="<%=request.getContextPath()%>/images/xiangmujindu_4.gif"/>
                        	</s:elseif>
                        	<s:elseif test="#data.status == '双方互评">
                        		<img src="<%=request.getContextPath()%>/images/xiangmujindu_2.gif"/>
                        	</s:elseif>
                        	<s:elseif test="#data.status == '已完成">
                        		<img src="<%=request.getContextPath()%>/images/xiangmujindu_3.gif"/>
                        	</s:elseif>
                        </div>
                    	<div id="xinxi">
                        	<li>
                            	<div style="width:30px; height:30px; background:url(<%=request.getContextPath()%>/images/xinxi_1.gif);"></div>
                                <div>发布时间：<span><s:property value="#data.foundtime" /></span></div>
                            </li>
                            
                           	<li>
                            	<div style="width:30px; height:30px; background:url(<%=request.getContextPath()%>/images/xinxi_2.gif);"></div>
                                <div>项目预算：<span>
                                		<s:if test="#data.budget == 1">
	                                		免费练手
	                                	</s:if>
	                                	<s:elseif test="#data.budget == 2">
	                                		小于￥1000
	                                	</s:elseif>
	                                	<s:elseif test="#data.budget == 3">
	                                		￥1000-￥3000
	                                	</s:elseif>
	                                	<s:elseif test="#data.budget == 4">
	                                		￥3000-￥5000
	                                	</s:elseif>
                                </span></div>
                            </li>
                            <li>
                            	<div style="width:30px; height:30px; background:url(<%=request.getContextPath()%>/images/xinxi_3.gif);"></div>
                                <div>开发周期：<span>
                                		<s:if test="#data.projectend == 1">
	                                		详谈
	                                	</s:if>
	                                	<s:elseif test="#data.projectend == 2">
	                                		1-5天
	                                	</s:elseif>
	                                	<s:elseif test="#data.projectend == 3">
	                                		5-10天
	                                	</s:elseif>
	                                	<s:elseif test="#data.projectend == 4">
	                                		10-20天
	                                	</s:elseif>
	                                	<s:elseif test="#data.projectend == 5">
	                                		20-30天
	                                	</s:elseif>
	                                	<s:elseif test="#data.projectend == 6">
	                                		30天以上
	                                	</s:elseif>
                                </span></div>
                            </li>
                           	<li>
                            	<div style="width:30px; height:30px; background:url(<%=request.getContextPath()%>/images/xinxi_4.gif);"></div>
                                <div>项目分类：<span><s:property value="#data.category.catename" /></span></div>
                            </li>
                            <li>
                            	<div style="width:30px; height:30px; background:url(<%=request.getContextPath()%>/images/xinxi_5.gif);"></div>
                                <div>已有竞标：<span>6</span></div>
                            </li>
                        	<li>
                            	<div style="width:30px; height:30px; background:url(<%=request.getContextPath()%>/images/xinxi_6.gif);"></div>
                                <div>竞标要求：<span>
                                	<img src="<%=request.getContextPath()%>/images/phone.jpg" />
                               		<img src="<%=request.getContextPath()%>/images/realName.jpg" />
                               		<img src="<%=request.getContextPath()%>/images/invoice.jpg" />
                                </span></div>
                            </li>
                        </div>
                        
                        <div style="height:150px;background:#b2d4dd; margin-top:30px; border-radius: 4px;">
                        	<div style="width:108px; height:108px; float:left; margin-left:20px; margin-top:20px;">
                        		<img style="width:108px; height:108px;" src="<%=request.getContextPath()%>/images/self.png" />
                        	</div>
                            <div style="float:left; height:108px; width:300px; margin-top:20px; margin-left:20px;">
                            	<div style="color:#547885; font-size:18px;"><s:property value="#data.userByFounderId.username" /></div>
                                <div style="color:#95a1a2; margin-top:10px; font-size:16px; ">身份：职业人</div>
                                <div style="color:#95a1a2; margin-top:5px; font-size:16px;">来自：杭州</div>
                            
                            </div>
                            <div style=" float:left; width:300px; margin-top:50px;">
                            	<s:if test="#data.userByUndertakerId == null">
                            		<img src="<%=request.getContextPath()%>/images/jingbiaohouchakan.gif" />
                            	</s:if>
                            	<s:else>
                            		<span style="color:#95a1a2;">手机：<s:property value="#data.phone" /></span>
                            	</s:else>
                            </div>
                        </div>
                        
                        <div style="margin-top:30px; font-size:18px; color:#8b9fa7">
                        	 <b>项目状态：</b> <s:property value="#data.status" /><br>
                        </div>
                        
                    	<div style="margin-top:30px; font-size:18px; color:#8b9fa7">
                        	<b>项目描述：</b><br />
                        	<div style="width:100%; font-size:16px; line-height: 25px; min-height:400px; padding-top: 15px; text-indent: 20px; line-height: ; border:1px #b2d4dd solid; border-radius:4px; margin-top:10px;">
                        		<s:property value="#data.description" escape="false" />
	                        		<s:if test="#files.size() > 0">
	                        		 <div style="margin-top: 50px;">
			                        	附件：<ul style="list-style-type: none; padding: 0; margin: 0; ">
												<s:iterator value="#files">
													<li><s:a action="wprojectAction_download.action?fid=%{fid}"><s:property value="filename" /></s:a></li>
												</s:iterator>
											</ul>
			                        </div>
	                       	 	</s:if>
                        	</div>
                        </div>
                        
                        <div style="margin-top:20px;">
                        	<div style="font-size:18px; border-bottom:1px #d9d9d9 solid; width:100%;">项目日志：</div>
                            <s:iterator value="projectlogList">
						  		<li style="list-style:none; margin-top:5px; font-size:16px; color:#b2b2b1; height:35px; width:700px; margin:0 auto; margin-top:5px; border-bottom:1px #d9d9d9 dashed;"><s:property value="handletime" /><span style=" margin-left:30px; color:#000;"><s:property value="handle" /></span></li>
						  	</s:iterator>
                        </div>
                    </div>
            	</div>
            	
            </div>
            
            <div style="width:240px; float:left; margin-left:6px;">
            	<div style="width:238px; height:80px; border:1px #ff6900 solid; border-radius:4px; background:#fce5d5; text-indent:10px; line-height:2em; color:#ff6900;">
                	本项目已预付款：
                	<br />
               		<center>
                    <span style="font-size:28px; margin:0 auto;">1000.00</span>
                	<sub>元</sub>
                	</center>
            	</div>
                
                <s:if test="#data.status == '竞标中'">
                	<div id="jingbiao" style="width:238px; margin-top:5px; height:90px; border:1px #ff6900 solid; border-radius:4px; background:#ff6900; font-size:40px; text-align:center; letter-spacing:10px;cursor: pointer; line-height:2em; color:#FFF;">
	                	竞&nbsp;标
	                </div>
	                <div style="width:238px; margin-top:5px; height:80px; border:1px #ff6900 solid; border-radius:4px; background:#fce5d5; text-indent:10px; line-height:2em; color:#ff6900;">
	               		 距离竞标结束还有：
	                	<br />
	               		<center>
							 <span style="font-size:20px; margin:0 auto;" id="daojishi">xx天xx小时xx分xx秒</span>
	                	</center>
	            	</div>           
                </s:if>
                <s:elseif test="#data.status == '已完成'">
                	<div style="width:238px; margin-top:5px; height:110px; border:1px #ff6900 solid; border-radius:4px; background:#ff6900; font-size:40px; text-align:center; letter-spacing:10px;cursor: pointer; line-height:2em; color:#FFF;">
	                	已完成
	                </div>
                </s:elseif>
                <s:elseif test="#data.status == '双方互评'">
                	<div style="width:238px; margin-top:5px; height:110px; border:1px #ff6900 solid; border-radius:4px; background:#ff6900; font-size:40px; text-align:center; letter-spacing:10px;cursor: pointer; line-height:2em; color:#FFF;">
	                	双方互评
	                </div>
                </s:elseif>
                <s:else>
                	<div style="width:238px; margin-top:5px; height:110px; border:1px #ff6900 solid; border-radius:4px; background:#ff6900; font-size:40px; text-align:center; letter-spacing:10px;cursor: pointer; line-height:2em; color:#FFF;">
	                	进行中
	                </div>
                </s:else>
                
            	     
                <div id="youxia">
                    <div>
                    	<div>
                        	项目竞标方案:
                        	<ul style="list-style-type: none; padding: 0; margin: 0;">
					  			<s:iterator value="bidList">
					  				<li><s:a action=""><s:property value="user.username" /></s:a>&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="bidtime" /></li>
					  			</s:iterator>
					  		</ul>
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
    
   <%--
 	<div>
 		<s:iterator value="data">
	  		 <ul>
				标题：<s:property value="title" /><br />
				所属分类：<s:property value="category.catename" /><br />
				描述：<s:property value="description" /><br />
				
				附件列表：
					<ul>
						<s:iterator value="files">
							<li><s:a action="wprojectAction_download.action?fid=%{fid}"><s:property value="filename" /></s:a></li>
						</s:iterator>
					</ul>
				预算：<s:property value="budget" /><br />
				手机：<s:property value="phone" /><br />
				邮箱：<s:property value="mail" /><br />
				
				竞标结束：<s:property value="biddingend" /><br />
				项目结束：<s:property value="projectend" /><br />
				
				发布人：<s:property value="userByFounderId.username" /><br />
				
				状态：<s:property value="status" />
			</ul>
	  	</s:iterator>
 	</div>
  	
  	
  	<div style="margin-left:100px;">
  		<h2>竞标方案：</h2>
  		<ul>
  			<s:iterator value="bidList">
  				<li><s:property value="user.username" />&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="bidtime" /></li>
  			</s:iterator>
  		</ul>
  	</div>
  	
  	<div style="clear:both;">
	  	<h2>项目日志</h2>
	  	<ul>
		  	<s:iterator value="projectlogList">
		  		<li><s:property value="handletime" />|&nbsp;&nbsp;<s:property value="handle" /></li>
		  	</s:iterator>
	  	</ul>
  	</div>
  	
  	<br />
  	<input type="button" value="竞标" id="bid" />
  	<div id="bidDiv" style="margin-left:100px;display:none;">
	  	<s:form action="" id="bidForm">
	  		<s:hidden name="pid" value="%{pid}"></s:hidden>
	  		<ul>
	  			<li>竞标费用：<s:textfield name="bidmoney"></s:textfield></li>
	  			<li>项目周期：<s:textfield name="bidcycle"></s:textfield></li>
	  			<li>联系方式：手机：<s:textfield name="phone"></s:textfield>邮箱：<s:textfield name="mail"></s:textfield></li>
	  			<li>竞标方案：<s:textarea name="plan" rows="10" cols="70"></s:textarea></li>
	  			<li><input type="button" value="竞标" id="bidBtn" /></li>
	  		</ul>
	  	</s:form>
  	</div>
  	--%>
  	
  	<%@ include file="/front/frame/bottom.jsp" %>
  </body>
</html>
