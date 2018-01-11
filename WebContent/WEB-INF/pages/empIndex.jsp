<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/cssConfig/empIndex.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath }/jsConfig/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsConfig/empIndex.js"></script>
</head>
<body>
	<div class="left">
		<font color="orange">亲爱的贪玩集团员工${emp.empName}[${emp.empStatus}]，今天又是朝气蓬勃的一天！</font><br>
			
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/button.png" name=""><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/button.png" name=""><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/button.png" name=""><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/button.png" name=""><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/tuichu.png" name="back"><br/>
	</div>
	<div class="right">
		<img src="${pageContext.request.contextPath }/imgs/shangban.png" name="sad" style="right:0;top:200px;width: 100px;height: 100px;position: absolute;">
		<font size="5" style="position: absolute;right:40px;top:300px">上班</font>
		<img src="${pageContext.request.contextPath }/imgs/shangban.png" name="happy" style="right:0;top:400px;width: 100px;height: 100px;position: absolute;">
		<font size="5" style="position: absolute;right:40px;top:500px">下班</font>
		<input type="hidden" value="${emp.empId }" name="empId">
		
		<div class="info" name="">
		
		</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	</div>
</body>
</html>