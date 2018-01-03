<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>贪玩有限公司人才招聘登陆页面</title>
<link href="${pageContext.request.contextPath }/cssConfig/login.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath }/jsConfig/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$(":submit[name=login]").click(function() {
			$("form").attr("action","${pageContext.request.contextPath }/userHandler/login");
		})
		
		$(":submit[name=regist]").click(function() {
			$("form").attr("action","${pageContext.request.contextPath }/userHandler/turnRegistPage");
		})
	})
</script>
</head>
<body>
	<div class="login">
		<font color="white" size="7">欢迎登陆</font></p>
		<form action="#" method="post">
			<font color="white" size="5">用户账户</font><input type="text" name="name"></p>
			<font color="white" size="5">用户密码</font><input type="text" name="password"><br/></p>
			<input type="submit" value="登陆" name="login"></p>
			<input type="submit" value="注册" name="regist"></p>
		</form>
	</div>


</body>
</html>