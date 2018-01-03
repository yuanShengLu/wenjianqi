<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>贪玩有限公司人才招聘主页</title>
<link href="${pageContext.request.contextPath }/cssConfig/index.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath }/jsConfig/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsConfig/userIndex.js"></script>
</head>
<body>
	<div class="left">
		<c:if test="${user.resume.realName==null}">
			<font size="3" color="orange">欢迎用户${user.userAccount },您还没完善简历信息</font><br/>
		</c:if>
		<c:if test="${user.resume.realName!=null}">
			<font size="3" color="orange">欢迎用户${user.resume.realName },人才市场济济赶紧投递您的简历吧</font><br/>
		</c:if>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/check.png" name="check"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/send.png" name="send"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/report.png" name="report"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/cp.png" name="cp"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/back.png" name="back"><br/>
	</div>
	
	<div class="right" name="info">
		<div style="width:30%;text-align: center;margin-top: 20%;margin-left: 25%" name="cp">
			<form action="#" method="post">
				<font size="6" color="grey">用户账号</font><input readonly="readonly" value="${user.userAccount }"></p>
				<font size="6" color="grey">原密码</font><input type="text" name="oldPassword"></p>
				<font size="6" color="grey">新密码</font><input type="text" name="newPassword"></p>
				<input type="submit"><br/>
			</form>
		</div>
		
		<div style="width:50%;text-align: center;margin-top: 10%;margin-left: 10%" name="check">
			<table border="2" cellpadding="5" cellspacing="0">
				<tr>
					<td colspan="4"><b><font size="6" color="orange">个人简历</font></b></td>
				</tr>
				<tr>
					<td><font size="2" color="orange">真实姓名</font></td>
					<td><input type="text" value="${user.resume.realName }" name="realName"></td>
					<td><font size="2" color="orange">性别</font></td>
					<td>
						<select name="gender" value="${user.resume.gender }" style="width: 50%">
							<option>-请选择-</option>
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><font size="2" color="orange">年龄</font></td>
					<td><input type="text" value="${user.resume.age }"></td>
					<td><font size="2" color="orange">学历</font></td>
					<td><input type="text" value="${user.resume.gender }"></td>
				</tr>
				<tr>
					<td><font size="2" color="orange">联系方式</font></td>
					<td><input type="text" value="${user.resume.realName }"></td>
					<td><font size="2" color="orange">e-mail</font></td>
					<td><input type="text" value="${user.resume.gender }"></td>
				</tr>
				<tr>
					<td><font size="2" color="orange">应聘职位</font></td>
					<td><input type="text" value="${user.resume.realName }"></td>
					<td><font size="2" color="orange">政治面貌</font></td>
					<td><input type="text" value="${user.resume.gender }"></td>
				</tr>
				<tr>
					<td><font size="2" color="orange">期望薪资</font></td>
					<td><input type="text" value="${user.resume.realName }"></td>
					<td><font size="2" color="orange">兴趣爱好</font></td>
					<td><input type="text" value="${user.resume.gender }"></td>
				</tr>
				<tr>
					<td><font size="2" color="orange">工作经验</font></td>
					<td colspan="3"><input type="text" value="${user.resume.realName }"></td>
				</tr>
			</table>
		</div>
		
	</div>
</body>
</html>