<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>贪玩有限公司人才招聘注册页面</title>
<link href="${pageContext.request.contextPath }/cssConfig/login.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath }/jsConfig/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsConfig/confirmInfo.js"></script>
</head>
<body>
		<div class="login">
			<font color="white" size="7">注册</font></p>
			<form action="${pageContext.request.contextPath }/userHandler/regist" method="post" onsubmit="return false">
				<font color="white" size="5">用户账户</font><input type="text" name="name"></p>
				<font color="white" size="5">用户密码</font><input type="text" name="password"></p>
				<font color="white" size="5">确认密码</font><input type="text" name="confirmPassword"></p>
				<font color="orange" name="info">账户：6-20位字母或数字<br/>密码：6-20位字母或数字或特殊字符</font></p>
				<input type="submit" value="提交" name="regist"></p>
			</form>
		</div>
	
	
	
</body>
</html>