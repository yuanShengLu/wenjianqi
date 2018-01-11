$(function() {
	var empId = $(":hidden[name=empId]").val();
	
	$("img[name=back]").click(function() {
		window.location.href="http://localhost:8080/FinalProject/index.jsp";
	})
	
	$("img[name=sad]").click(function() {
		$.ajax({
			url:"http://localhost:8080/FinalProject/employeeHandler/ajaxAttend",
			type:"post",
			data:{empId:empId},
			success:function(data){
				
			}
		})
	})
	
	$("img[name=happy]").click(function() {
		$.ajax({
			url:"http://localhost:8080/FinalProject/employeeHandler/ajaxLeave",
			type:"post",
			data:{empId:empId},
			success:function(data){
				
			}
		})
	})
	
	
	
	
	
	
	
	
})