$(function() {
	$("div[name=createRecruitment]").hide();
	$("div[name=readResumes]").hide();
	$("tr[name=interviewDate]").hide();
	$("tr[name=salary]").hide();
	$("button[name=hire]").hide();
	$("div[name=interview]").hide();
	
	
	$("img[name=back]").click(function() {
		window.location.href="http://localhost:8080/FinalProject/index.jsp";
	})
	
	$("img[name=createRecruitment]").click(function() {
		$("div[name=interview]").hide();
		$("div[name=readResumes]").hide();
		$("div[name=createRecruitment]").show();
	})
	
	$("img[name=readResumes]").click(function() {
		$("div[name=interview]").hide();
		$("div[name=createRecruitment]").hide();
		$("div[name=readResumes]").show();
	})
	
	$("img[name=interview]").click(function() {
		$("div[name=createRecruitment]").hide();
		$("div[name=readResumes]").hide();
		$("div[name=interview]").show();
	})
	
	$(":submit[name=recConfirm]").click(function() {
		var info = "确认发布招聘信息？";
		if(confirm(info)==true){
			alert("发布成功！")
			$("form[name=createRecruitment]").attr("onsubmit","return true");
		}else{
			$("form[name=createRecruitment]").attr("onsubmit","return false");
		}
	})
	
	$("button[name=yes]").click(function() {
		$("tr[name=interviewDate]").show();
		var info = $(this).val();
		$("button[name=ok]").val(info);
		var id = $(this).parent().parent().parent().attr("id");
		$("tr[name=interviewDate]").attr("class",id);
	})
	
	$("button[name=ok]").click(function() {
		var supId = $(":hidden[name=supId]").val();
		var interviewDate = $("input[name=interviewDate]").val();
		var resumeId = $(this).val().split("_")[0];
		var recId = $(this).val().split("_")[1];
		$.ajax({
			url:"http://localhost:8080/FinalProject/recruitmentHandler/ajaxConfirmRec",
			type:"post",
			data:{resumeId:resumeId,recId:recId,interviewDate:interviewDate,supId:supId},
			success:function(data){
				if(data==1){
					var id = $("tr[name=interviewDate]").attr("class");
					$("#"+id).remove();
				}else{
					alert("您选的时间有误")
				}
			}
		})
	})
	
	$("button[name=no]").click(function() {
		var resumeId = $(this).val().split("_")[0];
		var recId = $(this).val().split("_")[1];
		var yes = $("button[name=yes]");
		$.ajax({
			url:"http://localhost:8080/FinalProject/recruitmentHandler/ajaxDenyRec",
			type:"post",
			data:{resumeId:resumeId,recId:recId},
			success:function(data){
				yes.parent().parent().parent().remove();
			}
		})
	})
	
	$("button[name=addEmp]").click(function() {
		var salaryInfo = $(this).parent().parent().next().show();
	})
	
	$(":text[name=salary]").blur(function() {
		var salary = $(this).val();
		var regx = /^([1-9]\d{0,9}|0)([.]?|(\.\d{1,2})?)$/;
		if(!regx.test(salary)){
			$(this).next().hide();
			alert("输入不合法，请仔细查看填写工资");
		}else{
			$(this).next().show();
		}
	})
	
	$("button[name=hire]").click(function() {
		var empSalary = $(this).prev().val();
		var info = $(this).val();
		var userId = info.split("_")[0];
		var interId = info.split("_")[1];
		var empResumeId = info.split("_")[2];
		var empSupId = info.split("_")[3];
		var deptName = info.split("_")[4];
		var posiName = info.split("_")[5];
		var rem = $("tr."+interId);
		$.ajax({
			url:"http://localhost:8080/FinalProject/employeeHandler/ajaxAddEmp",
			type:"post",
			data:{empSalary:empSalary,userId:userId,interId:interId,empResumeId:empResumeId,empSupId:empSupId,deptName:deptName,posiName:posiName},
			success:function(data){
				alert("成功雇佣员工")
				rem.remove();
			}
		})
	})
	
	
	
	
	
	
	
	
	
	
	
	
	
})