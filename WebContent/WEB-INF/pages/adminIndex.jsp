<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/cssConfig/empIndex.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath }/jsConfig/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsConfig/adminIndex.js"></script>
<title>Insert title here</title>
</head>
<body>
<!-- 导航 -->
	<div class="left">
		<font color="orange">亲爱的管理员${admin.adminAccount}，今天又是朝气蓬勃的一天！</font><br>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/addDept.png" name="addDept"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/addPosition.png" name="addPosition"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/deptInfo.png" name="deptInfo"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/button.png" name=""><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/button.png" name="back"><br/>
	</div>
	
	<div class="right">
	
		<!-- 添加部门 -->
		<div class="info" name="addDept">
			<form action="${pageContext.request.contextPath }/departmentHandler/addDept?adminAccount=${admin.adminAccount}" method="post" onsubmit="return false" name="addDeptForm">
				<font size="5">请输入部门名字</font><input type="text" name="addDept">
				<div name="addPosition">
					<font size="5">请输入职位名字</font><input type="text" name="addPosition_1" class="position">
					<input type="text" name="addPosition_2" class="position">
					<input type="text" name="addPosition_3" class="position">
					<input type="text" name="addPosition_4" class="position">
					<input type="text" name="addPosition_5" class="position">
					<input type="text" name="addPosition_6" class="position">
					<input type="text" name="addPosition_7" class="position">
					<input type="submit" class="position" name="confirmSubmit">
				</div>
			</form>
		</div>
		
		<!-- 新增职位 -->
		<div class="info" name="addPositionToDept">
			<font size="5">请选择要添加职位的部门</font>
			<form action="${pageContext.request.contextPath }/departmentHandler/addPosi?adminAccount=${admin.adminAccount}" method="post" onsubmit="return false" name="posiAdd">
				<select name="dept">
					<c:forEach items="${dList}" var="dept">
						<option value="${dept.deptId }">${dept.deptName }</option>
					</c:forEach>
				</select><br/>
				<font size="5">请填写要添加的职位名称</font><input type="text" name="positionName_1"></p>
				<input type="text" name="positionName_2"></p>
				<input type="text" name="positionName_3"></p>
				<input type="text" name="positionName_4"></p>
				<input type="text" name="positionName_5"></p>
				<input type="text" name="positionName_6"></p>
				<input type="submit" name="addPosiSubmit">
			</form>
		
		</div>
		
		<!-- 查看部门信息 -->
		<div class="info" name="deptInfo">
			<font size="5">部门</font>
			<select name="deptInfo">
				<option value="0">-请选择-</option>
				<c:forEach items="${dList}" var="dept">
						<option value="${dept.deptId }">${dept.deptName }</option>
				</c:forEach>
			</select>
			<font size="5">职位</font>
			<select name="posiInfo">
				<option>-请选择-</option>
			</select>
			
			<table border="2 solid" cellpadding="5" cellspacing="0" align="center" style="margin-top: 30px;width:90%">
				<tr><td colspan="4"><b><font>员工信息</font></b></td></tr>
				<tr name="title">
					<td><font>ID</font></td>
					<td><font>姓名</font></td>
					<td><font>账号</font></td>
					<td><font>基本工资</font></td>
				</tr>
			</table>
		</div>
		
		
		
		
		
		
		
		
	</div>
</body>
</html>