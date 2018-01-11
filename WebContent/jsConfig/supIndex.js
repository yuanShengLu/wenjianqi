$(function() {
	$("div[name=createRecruitment]").hide();
	$("div[name=readResumes]").hide();
	$("tr[name=interviewDate]").hide();
	$("tr[name=salary]").hide();
	$("button[name=hire]").hide();
	$("div[name=interview]").hide();
	$("div[name=deptInfo]").hide();
	
	
	$("img[name=back]").click(function() {
		window.location.href="http://localhost:8080/FinalProject/index.jsp";
	})
	
	$("img[name=createRecruitment]").click(function() {
		$("div[name=interview]").hide();
		$("div[name=readResumes]").hide();
		$("div[name=deptInfo]").hide();
		$("div[name=createRecruitment]").show();
	})
	
	$("img[name=readResumes]").click(function() {
		$("div[name=interview]").hide();
		$("div[name=createRecruitment]").hide();
		$("div[name=deptInfo]").hide();
		$("div[name=readResumes]").show();
	})
	
	$("img[name=interview]").click(function() {
		$("div[name=createRecruitment]").hide();
		$("div[name=deptInfo]").hide();
		$("div[name=readResumes]").hide();
		$("div[name=interview]").show();
	})
	
	$("img[name=deptInfo]").click(function() {
		$("div[name=createRecruitment]").hide();
		$("div[name=readResumes]").hide();
		$("div[name=interview]").hide();
		$("div[name=deptInfo]").show();
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
	
	$("button[name=disAgree]").click(function() {
		var interId = $(this).val();
		var rem = $("tr."+interId);
		$.ajax({
			url:"http://localhost:8080/FinalProject/employeeHandler/ajaxDisAgree",
			type:"post",
			data:{interId:interId},
			success:function(data){
				alert("操作成功")
				rem.remove();
			}
		})
	})
	
	function getzf(num){  
        if(parseInt(num) < 10){  
            num = '0'+num;  
        }  
        return num;  
    }  
	
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
							$("tr[name=title]").after("<tr name='addEmp'><td><font>"+item.empId+"</font></td><td><font>"+item.empName+"</font></td><td><font>"+item.empAccount+"</font></td><td><font>"+item.empSalary+"</font></td><td><font>"+oTime+"</font></td><td><button name='chakan' value='"+item.empId+"'>查看</button></td></tr>")
							$("button[name=chakan]").click(function() {
								var empId = $(this).val();
								$("div[name=all]").hide();
								$.ajax({
									url:"http://localhost:8080/FinalProject/departmentHandler/ajaxQueryEmpInfo",
									type:"post",
									data:{empId:empId},
									dataType:"json",
									success:function(data){
										$("div[name=deptInfo]").append("<div name='inf'><table border='2 solid' cellpadding='5' cellspacing='0' align='center' style='margin-top: 30px;width:100%'><tr><td><font size='5'>个人信息</font></td></tr><tr name='empInfomation'><td><font>培训信息</font></td></tr><tr><td><button name='return'>返回</button></td></tr></table></div>")
										$("button[name=return]").click(function() {
											$("div[name=inf]").remove();
											$("div[name=all]").show();
										})
									}
								})
							})
						})
					}
				}
			})
		}
	})
	
	
	
	
	
	
	
	
	
	
})