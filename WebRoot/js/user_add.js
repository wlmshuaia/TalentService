var user = {
	formValidate: function(){
		$('#registerSubmit').unbind("click");
		$('#registerSubmit').bind("click", function(){
			var password = $('input[name=password]').val();
			var passwordConfirm = $('input[name=passwordConfirm]').val();
			
			if(password == ""){
				user.infoTip("请输入密码") ;
			}else if(passwordConfirm == ""){
				user.infoTip("请输入确认密码") ;
			}else if(passwordConfirm != password){
				user.infoTip("两次密码输入不一致") ;
			}else {
				var username = $("input[name=username]").val() ;	// 防止刷新页面过后，不合法用户名停留在页面中
				if(username){		// 用户名判断1
					user.checkUser(username) ;
					if($("#usernameTip").text() == "该用户名已存在"){	
						user.infoTip("请输入正确的用户名") ;
					}else{
						if($("#usernameTip").text() == "该用户名可以使用"){// 用户名判断2
							if($("input[name=mail]").val() == ""){	// 邮箱判断
								user.infoTip("请输入邮箱") ;
							}else{
								$("#stuForm").submit() ;
							}
						}
					}
				}else{
					user.infoTip("请输入用户名") ;
				}
			}
		});
	},
	initEvent: function(){
		$('input[name=username]').unbind("blur");
		$('input[name=username]').bind("blur", function(){
			var username = $(this).val() ; 
			if(username == ""){
				user.notOk($('#usernameTip'), '请输入用户名') ;
			}else{
				user.checkUser(username) ;
			}
		});
	},
	checkUser: function(username) {
		$.post('register/wregisterJsonAction_checkUser.action', {username: username}, function(result){
			if(result == "该用户名已存在"){
				user.notOk($("#usernameTip"), result) ;
			}else{
				user.isOk($("#usernameTip"), result) ;
			}
		});
	},
	infoTip: function(text) {
		$.messager.show({
			title: '提示信息',
			msg: text
		});
	},
	isOk: function(obj, text){
		obj.text(text);
		obj.css("color", "green");
	},
	notOk: function(obj, text){
		obj.text(text);
		obj.css("color", "red");
	}
}
$(function(){
	user.formValidate() ;
	user.initEvent() ;
});