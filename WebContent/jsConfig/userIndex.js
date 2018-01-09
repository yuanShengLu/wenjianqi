$(function() {
	var flagName = false;
	var flagAge = false;
	var flagContactInfo = false;
	var flagEmail = false;
	
	var isTurnPage = $(":hidden[name=isTurnPage]").val()
	if(isTurnPage==null||isTurnPage==""){
		$("div[name=send]").hide();
	}
	$("div[name=cp]").hide();
	$("div[name=check]").hide();
	
	$("img[name=cp]").click(function() {
		$("div[name=send]").hide();
		$("div[name=check]").hide();
		$("div[name=cp]").show();
	})
	
	$("img[name=check]").click(function() {
		$("div[name=cp]").hide();
		$("div[name=send]").hide();
		$("div[name=check]").show();
	})
	
	$("img[name=send]").click(function() {
		$("div[name=cp]").hide();
		$("div[name=check]").hide();
		$("div[name=send]").show();
	})
	
	$("img[name=back]").click(function() {
		window.location.href="http://localhost:8080/FinalProject/index.jsp";
	})
	
	
	
	$("img[name=update]").click(function(){
		if(flagName&&flagAge&&flagContactInfo&&flagEmail){
			$("#resume").submit();
		}else{
			alert("请完善信息！")
		}
	})
	
	
	$("select[name=department]").change(function() {
		var dept = $(this).val();
		$.ajax({
			url:"http://localhost:8080/FinalProject/departmentHandler/ajaxQueryPosition",
			data:{dept:dept},
			type:"post",
			dataType:"json",
			success:function(data){
				$("select[name=position]").empty();
				$.each(data,function(idx,item){
					$("select[name=position]").append("<option>"+item.poName+"</option>");
					if($("select[name=position]").val()==item.poName){
						$("option:first").attr("selected","selected")
					}
				})
			}
		})
	})
	
	
	$(":text[name=realName]").blur(function() {
		var regx = /^[\u4E00-\u9FA5A-Za-z]+$/;
		var realName = $(this).val();
		if(regx.test(realName)){
			flagName = true;
		}else{
			flagName = false;
			alert("名字只能输入中英文！")
		}
	})
	
	$(":text[name=age]").blur(function() {
		var regx = /^(1[6-9]|[2-9][0-9])$/;
		var age = $(this).val();
		if(regx.test(age)){
			flagAge = true;
		}else{
			flagAge = false;
			alert("请填写合适的年龄！")
		}
	})
	
	$(":text[name=contactInfo]").blur(function() {
		var regx = /^1[3|5|8][0-9]\d{4,8}$/;
		var contactInfo = $(this).val();
		if(regx.test(contactInfo)){
			flagContactInfo = true;
		}else{
			flagContactInfo = false;
			alert("请填写正确的联系方式！")
		}
	})
	
	$(":text[name=eMail]").blur(function() {
		var regx = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		var eMail = $(this).val();
		if(regx.test(eMail)){
			flagEmail = true;
		}else{
			flagEmail = false;
			alert("请填写正确邮箱！")
		}
	})
	
	$("button[name=workDesc]").click(function() {
		var workDescribe = $(this).val();
		$("font[name=workDesc]").text(workDescribe);
	})
	
	$("a[name=send]").click(function() {
		alert("投递成功")
	})
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
})