$(function(){
	var flagA = false;
	var flagB = false;
	var flagC = false;
	$(":text[name=name]").blur(function(){
		var data = "账户：6-20位字母或数字\n密码：6-20位字母或数字或特殊字符";
		$("font[name=info]").html(data.replace("\n", "<br>"));
		var name = $(this).val();
		var reg = /^[a-zA-Z0-9_@]{6,20}$/;
		if(!reg.test(name)){
			$("font[name=info]").text("用户名不合法");
			flagA = false;
		}else{
			$.ajax({
				url:"ajaxCheckUserAccount",
				type:"post",
				data:{name:name},
				success:function(data){
					if(data=="1"){
						$("font[name=info]").text("已存在该用户")
						flagA = false;
					}else{
						flagA = true;
					}
				}
			})
		}
	})
	
	$(":text[name=password]").blur(function(){
		var data = "账户：6-20位字母或数字\n密码：6-20位字母或数字或特殊字符";
		$("font[name=info]").html(data.replace("\n", "<br>"));
		var password = $(this).val();
		var reg = /^[a-zA-Z0-9`~!-@#$%^&*()_+|{}\[\];':"<>?,.\/\\]{6,20}$/;
		if(!reg.test(password)){
			$("font[name=info]").text("密码不合法")
			flagB = false;
		}else{
			flagB = true;
		}
	})
	
	$(":text[name=confirmPassword]").blur(function(){
		var data = "账户：6-20位字母或数字\n密码：6-20位字母或数字或特殊字符";
		$("font[name=info]").html(data.replace("\n", "<br>"));
		var password = $(":text[name=password]").val();
		var confirmPassword = $(this).val();
		if(!(password==confirmPassword)){
			if(confirmPassword==""){
				$("font[name=info]").text("请填写确认密码")
				flagC = false;
			}else{
				$("font[name=info]").text("密码不一致,请核对密码")
				flagC = false;
			}
		}else{
			flagC = true;
		}
	})
	
	$(":submit[name=regist]").click(function() {
		if(flagA&&flagB&&flagC){
			$("form").attr("onsubmit","return true");
		}
	})	
	
	
	
	
	
})