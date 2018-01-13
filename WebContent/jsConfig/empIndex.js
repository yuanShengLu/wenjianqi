$(function() {
	var flagName = true;
	var flagAge = true;
	var flagContactInfo = true;
	var flagEmail = true;
	
	var empId = $(":hidden[name=empId]").val();
	
	$("div[name=deptInfo]").hide();
	$("div[name=train]").hide();
	$("div[name=empInfo]").hide();
	$("div[name=reword]").hide();
	$("div[name=salary]").hide();
	
	$("img[name=empInfo]").click(function() {
		$("div[name=deptInfo]").hide();
		$("div[name=train]").hide();
		$("div[name=salary]").hide();
		$("div[name=reword]").hide();
		$("div[name=empInfo]").show();
	})
	
	$("img[name=reword]").click(function() {
		$("div[name=deptInfo]").hide();
		$("div[name=train]").hide();
		$("div[name=salary]").hide();
		$("div[name=empInfo]").hide();
		$("div[name=reword]").show();
	})
	
	$("img[name=salary]").click(function() {
		$("div[name=deptInfo]").hide();
		$("div[name=train]").hide();
		$("div[name=empInfo]").hide();
		$("div[name=reword]").hide();
		$("div[name=salary]").show();
	})
	
	$("img[name=train]").click(function() {
		$("div[name=deptInfo]").hide();
		$("div[name=empInfo]").hide();
		$("div[name=reword]").hide();
		$("div[name=salary]").hide();
		$("div[name=train]").show();
	})
	
	$("img[name=deptInfo]").click(function() {
		$("div[name=empInfo]").hide();
		$("div[name=reword]").hide();
		$("div[name=salary]").hide();
		$("div[name=train]").hide();
		$("div[name=deptInfo]").show();
	})
	
	
	$("img[name=back]").click(function() {
		window.location.href="http://localhost:8080/FinalProject/index.jsp";
	})
	
	$("img[name=sad]").click(function() {
		$.ajax({
			url:"http://localhost:8080/FinalProject/employeeHandler/ajaxAttend",
			type:"post",
			data:{empId:empId},
			success:function(data){
				if(data==1){
					alert("正常上班")
				}
				if(data==2){
					alert("你迟到啦")
				}
				if(data==4){
					alert("加班开始")
				}
				if(data==0){
					alert("请勿重复打卡")
				}
			}
		})
	})
	
	$("img[name=happy]").click(function() {
		$.ajax({
			url:"http://localhost:8080/FinalProject/employeeHandler/ajaxLeave",
			type:"post",
			data:{empId:empId},
			success:function(data){
				if(data==1){
					alert("正常下班")
				}
				if(data==3){
					alert("早退")
				}
				if(data==5){
					alert("加班结束")
				}
				if(data==0){
					alert("请勿重复打卡")
				}
			}
		})
	})
	
	$("img[name=update]").click(function(){
		if(flagName&&flagAge&&flagContactInfo&&flagEmail){
			var realName = $(":text[name=realName]").val();
			var age = $(":text[name=age]").val();
			var contactInfo = $(":text[name=contactInfo]").val();
			var eMail = $(":text[name=eMail]").val();
			var gender = $("select[name=gender]").val();
			var education = $("select[name=education]").val();
			var politicalStatus = $("select[name=politicalStatus]").val();
			var hobby = $(":text[name=hobby]").val();
			var resumeId = $(":hidden[name=resumeId]").val();
			$.ajax({
				url:"http://localhost:8080/FinalProject/employeeHandler/ajaxUpdateResume",
				type:"post",
				data:{realName:realName,age:age,contactInfo:contactInfo,eMail:eMail,gender:gender,education:education,politicalStatus:politicalStatus,hobby:hobby,resumeId:resumeId},
				success:function(data){
					alert("修改成功")
				}
			})
		}else{
			alert("请完善信息！")
		}
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
	
	$("button[name=sendToSup]").click(function() {
		var suggestInfo = $(":text[name=suggest]").val();
		var supId = $(":hidden[name=supId]").val();
		$.ajax({
			url:"http://localhost:8080/FinalProject/employeeHandler/ajaxSendSuggest",
			type:"post",
			data:{suggestInfo:suggestInfo,empId:empId,supId:supId},
			success:function(data){
				alert("意见已反馈至主管")
			}
		})
	})
	
	function getzf(num){  
        if(parseInt(num) < 10){  
            num = '0'+num;  
        }  
        return num;  
    }  
	$("select[name=deptInfo]").change(function(){
		var dInfo = $(this).val();
		if(dInfo!=0){
			$.ajax({
				url:"http://localhost:8080/FinalProject/departmentHandler/ajaxQueryPositionByDeptId",
				type:"post",
				data:{dInfo:dInfo},
				dataType:"json",
				success:function(data){
					$("select[name=posiInfo]").empty();
					$("select[name=posiInfo]").append("<option>-请选择-</option>")
					$.each(data,function(idx,item){
						$("select[name=posiInfo]").append("<option>"+item.poName+"</option>")
					})
				}
			})
		}
	})
	
	$("select[name=posiInfo]").change(function(){
		var pInfo = $(this).val();
		if(pInfo!="-请选择-"){
			$.ajax({
				url:"http://localhost:8080/FinalProject/departmentHandler/ajaxQueryEmp",
				type:"post",
				data:{pInfo:pInfo},
				dataType:"json",
				success:function(data){
					if(data==0){
						$("tr[name=addEmp]").remove();
						alert("当前职位暂时没有员工")
					}else{
						$("tr[name=addEmp]").remove();
						$.each(data,function(idx,item){
							var oDate = new Date(item.empServingTime);
							var year = oDate.getFullYear(),
							oMonth = oDate.getMonth()+1,  
					        oDay = oDate.getDate(), 
					        oTime = year+'-'+getzf(oMonth) +'-'+ getzf(oDay);
							$("tr[name=title]").after("<tr name='addEmp'><td><font>"+item.empId+"</font></td><td><font>"+item.empName+"</font></td><td><font>"+item.empAccount+"</font></td><td><font>"+oTime+"</font></td></tr>")
						})
					}
				}
			})
		}
	})
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
})