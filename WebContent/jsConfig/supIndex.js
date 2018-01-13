$(function() {
	var empId = $(":hidden[name=empId]").val();
	var deptId = $(":hidden[name=deptId]").val();
	
	$("div[name=releaseTrain]").hide();
	$("div[name=suggest]").hide();
	$("div[name=addReword]").hide();
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
		$("div[name=releaseTrain]").hide();
		$("div[name=suggest]").hide();
		$("div[name=interview]").hide();
		$("div[name=readResumes]").hide();
		$("div[name=addReword]").hide();
		$("div[name=deptInfo]").hide();
		$("div[name=createRecruitment]").show();
	})
	
	$("img[name=readResumes]").click(function() {
		$("div[name=releaseTrain]").hide();
		$("div[name=suggest]").hide();
		$("div[name=interview]").hide();
		$("div[name=addReword]").hide();
		$("div[name=createRecruitment]").hide();
		$("div[name=deptInfo]").hide();
		$("div[name=readResumes]").show();
	})
	
	$("img[name=interview]").click(function() {
		$("div[name=releaseTrain]").hide();
		$("div[name=suggest]").hide();
		$("div[name=createRecruitment]").hide();
		$("div[name=deptInfo]").hide();
		$("div[name=addReword]").hide();
		$("div[name=readResumes]").hide();
		$("div[name=interview]").show();
	})
	
	$("img[name=deptInfo]").click(function() {
		$("div[name=releaseTrain]").hide();
		$("div[name=suggest]").hide();
		$("div[name=createRecruitment]").hide();
		$("div[name=readResumes]").hide();
		$("div[name=addReword]").hide();
		$("div[name=interview]").hide();
		$("div[name=deptInfo]").show();
	})
	
	$("img[name=addReword]").click(function() {
		$("div[name=releaseTrain]").hide();
		$("div[name=suggest]").hide();
		$("div[name=createRecruitment]").hide();
		$("div[name=readResumes]").hide();
		$("div[name=interview]").hide();
		$("div[name=deptInfo]").hide();
		$("div[name=addReword]").show();
	})
	
	$("img[name=suggest]").click(function() {
		$("div[name=releaseTrain]").hide();
		$("div[name=createRecruitment]").hide();
		$("div[name=readResumes]").hide();
		$("div[name=interview]").hide();
		$("div[name=deptInfo]").hide();
		$("div[name=addReword]").hide();
		$("div[name=suggest]").show();
	})
	
	$("img[name=releaseTrain]").click(function() {
		$("div[name=createRecruitment]").hide();
		$("div[name=readResumes]").hide();
		$("div[name=interview]").hide();
		$("div[name=deptInfo]").hide();
		$("div[name=addReword]").hide();
		$("div[name=suggest]").hide();
		$("div[name=releaseTrain]").show();
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
										$("div[name=deptInfo]").append("<div name='inf'><table border='2 solid' cellpadding='5' cellspacing='0' align='center' style='margin-top: 30px;width:100%'><tr><td colspan='6'><font size='5'>个人信息（上月 单位：天）</font></td></tr><tr name='empInfomation'><td><font>迟到</font></td><td><font>早退</font></td><td><font>旷工</font></td><td><font>绩效奖金</font></td><td><font>罚金</font></td><td><font>共计薪资</font></td></tr><tr><td><font>"+data.lateCount+"</font></td><td><font>"+data.beforeCount+"</font></td><td><font>"+data.disAttend+"</font></td><td><font>"+data.plusMoney+"</font></td><td><font>"+data.lessMoney+"</font></td><td><font>"+data.count+"</font></td></tr><tr><td  colspan='6'><button name='return'>返回</button></td></tr></table></div>")
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
	
	var flagRewMoney = false;
	var flagEmpId = false;
	
	$(":text[name=rewMoney]").blur(function() {
		var rewMoney = $(this).val();
		var regx = /^[0-9]+$/;
		if(!regx.test(rewMoney)){
			alert("请填写正确的金额")
			flagRewMoney = false;
		}else{
			flagRewMoney = true;
		}
	})
	
	$(":text[name=empId]").blur(function() {
		var empId = $(this).val();
		var regx = /^[0-9]+$/;
		if(!regx.test(empId)){
			alert("员工ID不合法")
			flagEmpId = false;
		}else{
			flagEmpId = true;
		}
	})
	
	$("button[name=commitRew]").click(function() {
		if(flagRewMoney&&flagEmpId){
			var rewType = $("select[name=rewType]").val();
			var rewMoney = $(":text[name=rewMoney]").val();
			var empId = $(":text[name=empId]").val();
			var rewReason = $(":text[name=rewReason]").val();
			$.ajax({
				url:"http://localhost:8080/FinalProject/employeeHandler/ajaxAddReward",
				type:"post",
				data:{rewMoney:rewMoney,empId:empId,rewReason:rewReason,rewType:rewType},
				success:function(data){
					alert("操作成功")
				}
			})
		}else{
			alert("请核对信息后再提交")
		}
	})
	
	$("img[name=releaseSalary]").click(function() {
		$.ajax({
			url:"http://localhost:8080/FinalProject/employeeHandler/ajaxReleaseSalary",
			type:"post",
			data:{deptId:deptId},
			success:function(data){
				if(data==0){
					alert("请于每月一号结算工资")
				}else{
					alert("发放成功")
				}
			}
		})
	})
	
	
	$("button[name=addTrain]").click(function() {
		var deptId = $(this).val();
		var tInfo = $(":text[name=tInfo]").val();
		var tStartTime = $("input[name=tStartTime]").val();
		var tEndTime = $("input[name=tEndTime]").val();
		
		$.ajax({
			url:"http://localhost:8080/FinalProject/employeeHandler/ajaxAddTrain",
			type:"post",
			data:{deptId:deptId,tInfo:tInfo,tStartTime:tStartTime,tEndTime:tEndTime},
			success:function(data){
				alert("发布成功")
			}
		})
	})
	
	$("button[name=trainUpdate]").click(function() {
		var tId = $(this).val();
		var tStartTime = $("input[name=tStartTimeNew"+tId+"]").val();
		var tEndTime = $("input[name=tEndTimeNew"+tId+"]").val();
		if(tStartTime==""){
			tStartTime = $("input[name=tStartTimeOld"+tId+"]").val();
		}
		if(tEndTime==""){
			tEndTime = $("input[name=tEndTimeOld"+tId+"]").val();
		}
		var tInfo = $(":text[name=tInfoNew"+tId+"]").val();
		$.ajax({
			url:"http://localhost:8080/FinalProject/employeeHandler/ajaxUpdateTrain",
			type:"post",
			data:{tId:tId,tInfo:tInfo,tStartTime:tStartTime,tEndTime:tEndTime},
			success:function(data){
				alert("修改成功")
			}
		})
	})

	$("button[name=trainRemove]").click(function() {
		var tId = $(this).val();
		$.ajax({
			url:"http://localhost:8080/FinalProject/employeeHandler/ajaxDelTrain",
			type:"post",
			data:{tId:tId},
			success:function(data){
				alert("删除成功")
			}
		})
	})
	
	
	
	
	
	
	
	
	
	
	
	
	
})