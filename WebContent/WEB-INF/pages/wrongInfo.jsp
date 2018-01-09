<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>没有找到用户</title>
<link href="${pageContext.request.contextPath }/cssConfig/login.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath }/jsConfig/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$("img").click(function(){
			window.location.href="${pageContext.request.contextPath }/userHandler/turnIndex?userAccount=${user.userAccount}"
		})
	})
</script>
</head>
<body>
	<div class="login">
		<font color="orange" size="6">用户信息填写有误,更新失败！</font></p>
		<img src="${pageContext.request.contextPath }/imgs/err.jpg" height="200px">
	</div>
</body>
</html>