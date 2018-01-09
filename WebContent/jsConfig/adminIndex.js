$(function() {
	$("div[name=addDept]").hide();
	$("div[name=addPosition]").hide();
	$("div[name=addPositionToDept]").hide();
	$("div[name=deptInfo]").hide();
	
	$("img[name=back]").click(function() {
		window.location.href="http://localhost:8080/FinalProject/index.jsp";
	})
	
	$("img[name=addDept]").click(function() {
		$("div[name=addPositionToDept]").hide();
		$("div[name=deptInfo]").hide();
		$("div[name=addDept]").show();
	})
	
	$("img[name=addPosition]").click(function() {
		$("div[name=addDept]").hide();
		$("div[name=deptInfo]").hide();
		$("div[name=addPositionToDept]").show();
	})
	
	$("img[name=deptInfo]").click(function() {
		$("div[name=addDept]").hide();
		$("div[name=addPositionToDept]").hide();
		$("div[name=deptInfo]").show();
	})
	
	$(":text[name=addDept]").blur(function() {
		var info = "确认添加部门？";
		if(confirm(info)==true){
			$("div[name=addPosition]").show();
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
	
	$("select[name=posiInfo]").change(function(){
		var pInfo = $(this).val();
		if(pInfo!="-请选择-"){
			$.ajax({
				url:"http://localhost:8080/FinalProject/departmentHandler/ajaxQueryEmp",
				type:"post",
				data:{pInfo:pInfo},
				dataType:"json",
				success:function(data){
					$("tr[name=addEmp]").remove();
					$.each(data,function(idx,item){
						$("tr[name=title]").after("<tr name='addEmp'><td><font>"+item.empId+"</font></td><td><font>"+item.empName+"</font></td><td><font>"+item.empAccount+"</font></td><td><font>"+item.empSalary+"</font></td></tr>")
					})
				}
			})
		}
	})
	
	
	
	
	
	
	
	
	
	
	
	
})