$(function() {
	$("div[name=addDept]").hide();
	$("div[name=addPosition]").hide();
	$("div[name=addPositionToDept]").hide();
	$("div[name=deptInfo]").hide();
	$("div[name=poDeReUp]").hide();
	
	$("img[name=back]").click(function() {
		window.location.href="http://localhost:8080/FinalProject/index.jsp";
	})
	
	$("img[name=addDept]").click(function() {
		$("div[name=addPositionToDept]").hide();
		$("div[name=poDeReUp]").hide();
		$("div[name=deptInfo]").hide();
		$("div[name=addDept]").show();
	})
	
	$("img[name=addPosition]").click(function() {
		$("div[name=addDept]").hide();
		$("div[name=poDeReUp]").hide();
		$("div[name=deptInfo]").hide();
		$("div[name=addPositionToDept]").show();
	})
	
	$("img[name=deptInfo]").click(function() {
		$("div[name=addDept]").hide();
		$("div[name=poDeReUp]").hide();
		$("div[name=addPositionToDept]").hide();
		$("div[name=deptInfo]").show();
	})
	
	$("img[name=poDeReUp]").click(function() {
		$("div[name=addDept]").hide();
		$("div[name=addPositionToDept]").hide();
		$("div[name=deptInfo]").hide();
		$("div[name=poDeReUp]").show();
	})
	
	$(":text[name=addDept]").blur(function() {
		var info = "确认添加部门？";
		var deptName = $(this).val();
		if(deptName==""||deptName==null){
			alert("部门名字不能为空")
		}else{
			if(confirm(info)==true){
				$("div[name=addPosition]").show();
			}
		}
	})
	
	$(":submit[name=confirmSubmit]").click(function(){
		var info = "确认创建部门？";
		if(confirm(info)==true){
			$("form[name=addDeptForm]").attr("onsubmit","return true")
		}
	})
	
	$(":submit[name=addPosiSubmit]").click(function() {
		var p1 = $(":text[name=positionName_1]").val();
		var p2 = $(":text[name=positionName_2]").val();
		var p3 = $(":text[name=positionName_3]").val();
		var p4 = $(":text[name=positionName_4]").val();
		var p5 = $(":text[name=positionName_5]").val();
		var p6 = $(":text[name=positionName_6]").val();
		if(p1==""&&p2==""&&p3==""&&p4==""&&p5==""&&p6==""){
			alert("请填写职位名字");
			$("form[name=posiAdd]").attr("onsubmit","return false");
		}else{
			alert("提交成功")
			$("form[name=posiAdd]").attr("onsubmit","return true");
		}
	})
	
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
	
	$("select[name=deptInf]").change(function(){
		var dInfo = $(this).val();
		if(dInfo!=0){
			$.ajax({
				url:"http://localhost:8080/FinalProject/departmentHandler/ajaxQueryPositionByDeptId",
				type:"post",
				data:{dInfo:dInfo},
				dataType:"json",
				success:function(data){
					$("select[name=posiInf]").empty();
					$("select[name=posiInf]").append("<option>-请选择-</option>")
					$.each(data,function(idx,item){
						$("select[name=posiInf]").append("<option name='"+item.poName+"'>"+item.poName+"</option>")
					})
				}
			})
		}
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
	
	$("select[name=posiInf]").change(function(){
		$("button[name=delPosi]").unbind("click");
		$("button[name=updatePosi]").unbind("click");
		
		var pInfo = $(this).val();
		if(pInfo!="-请选择-"){
			$.ajax({
				url:"http://localhost:8080/FinalProject/departmentHandler/ajaxQueryEmp",
				type:"post",
				data:{pInfo:pInfo},
				dataType:"json",
				success:function(data){
					
					$("button[name=delPosi]").click(function() {
						if(data!=0){
							alert("该职位下有员工无法进行删除")
						}else{
							var poName = $("select[name=posiInf]").val();
							$.ajax({
								url:"http://localhost:8080/FinalProject/departmentHandler/ajaxDelPosi",
								type:"post",
								data:{poName:poName},
								success:function(data){
									alert("删除成功")
									$("option[name="+pInfo+"]").remove();
								}
							})
						}
					})
					
					$("button[name=updatePosi]").click(function() {
						var updatePosiName = $(":text[name=updatePosiNamee]").val();
						var pInfo = $("select[name=posiInf]").val();
						if(updatePosiName==""||updatePosiName==null){
							alert("修改值不能为空")
						}else{
							$.ajax({
								url:"http://localhost:8080/FinalProject/departmentHandler/ajaxUpdatePosi",
								type:"post",
								data:{updatePosiName:updatePosiName,oldName:pInfo},
								success:function(data){
									alert("修改成功")
									$("option[name="+pInfo+"]").text(updatePosiName);
									$("option[name="+pInfo+"]").attr("name",updatePosiName)
								}
							})
						}
					})
				}
			})
		}else{
			alert("请选择职位")
		}
	})
	
	$("button[name=delDept]").click(function() {
		var deptId = $("select[name=deptInf]").val();
		$.ajax({
			url:"http://localhost:8080/FinalProject/departmentHandler/ajaxDelDept",
			type:"post",
			data:{deptId:deptId},
			success:function(data){
				if(data==0){
					alert("删除成功");
					$("option[name="+deptId+"]").remove();
				}else{
					alert("部门还有"+data+"个员工,无法删除")
				}
			}
		})
	})
	
	$("button[name=updateDept]").click(function() {
		var deptId = $("select[name=deptInf]").val();
		var deptNewName = $(":input[name=updateDeptName]").val();
		if(deptNewName==""||deptNewName==null){
			alert("修改值不能为空")
		}else{
			$.ajax({
				url:"http://localhost:8080/FinalProject/departmentHandler/ajaxUpdateDept",
				type:"post",
				data:{deptId:deptId,deptNewName:deptNewName},
				success:function(data){
					alert("修改成功")
					$("option[name="+deptId+"]").text(deptNewName);
				}
			})
		}
	})
	
	
	
	
	
	
})