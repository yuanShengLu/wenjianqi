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
		<font color="orange">亲爱的贪玩集团员工${emp.empName}[${emp.empStatus}]，今天又是朝气蓬勃的一天！
			<c:if test="${trainList.size()!=0}">
				<font>您有${trainList.size()}个培训正在执行!</font>
			</c:if>
		</font><br>
			
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/gerenxinxi.png" name="empInfo"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/jiangcheng.png" name="reword"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/peixun.png" name="train"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/xinzi.png" name="salary"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/deptInfo.png" name="deptInfo"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/tuichu.png" name="back"><br/>
	</div>
	<div class="right">
		<img src="${pageContext.request.contextPath }/imgs/shangban.png" name="sad" style="right:0;top:200px;width: 100px;height: 100px;position: absolute;">
		<font size="5" style="position: absolute;right:40px;top:300px">上班</font>
		<img src="${pageContext.request.contextPath }/imgs/shangban.png" name="happy" style="right:0;top:400px;width: 100px;height: 100px;position: absolute;">
		<font size="5" style="position: absolute;right:40px;top:500px">下班</font>
		<input type="hidden" value="${emp.empId }" name="empId">
		
		<!-- 查看个人信息 -->
		<div class="info" name="empInfo">
			<table border="2" cellpadding="5" cellspacing="0">
				<tr>
					<td colspan="4"><b><font size="6" color="orange">个人信息</font></b></td>
				</tr>
				<tr>
					<td><font size="2" color="orange">真实姓名</font></td>
					<td><input type="text" value="${resume.realName }" name="realName"></td>
					<td><font size="2" color="orange">性别</font></td>
					<td>
						<select name="gender" style="width: 50%">
							<option value="男" <c:if test="${resume.gender=='男' }">selected="selected"</c:if>>男</option>
							<option value="女" <c:if test="${resume.gender=='女' }">selected="selected"</c:if>>女</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><font size="2" color="orange">年龄</font></td>
					<td><input type="text" value="${resume.age }" name="age"></td>
					<td><font size="2" color="orange">学历</font></td>
					<td>
						<select name="education" style="width: 50%">
							<option value="本科" <c:if test="${resume.education=='本科' }">selected="selected"</c:if>>本科</option>
							<option value="专科" <c:if test="${resume.education=='专科' }">selected="selected"</c:if>>专科</option>
							<option value="硕士" <c:if test="${resume.education=='硕士' }">selected="selected"</c:if>>硕士</option>
							<option value="博士" <c:if test="${resume.education=='博士' }">selected="selected"</c:if>>博士</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><font size="2" color="orange">联系方式</font></td>
					<td><input type="text" value="${resume.contactInfo }" name="contactInfo"></td>
					<td><font size="2" color="orange">e-mail</font></td>
					<td><input type="text" value="${resume.eMail }" name="eMail"></td>
				</tr>
				<tr>
					<td><font size="2" color="orange">所属部门职位</font></td>
					<td>
						<font>部门：${dept.deptName }</font><br/>
						<font>职位：${posi.poName }</font>
					</td>
					<td><font size="2" color="orange">政治面貌</font></td>
					<td>
						<select name="politicalStatus">
							<option value="党员" <c:if test="${resume.politicalStatus=='党员' }">selected="selected"</c:if>>党员</option>
							<option value="团员" <c:if test="${resume.politicalStatus=='团员' }">selected="selected"</c:if>>团员</option>
							<option value="群众" <c:if test="${resume.politicalStatus=='群众' }">selected="selected"</c:if>>群众</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><font size="2" color="orange">兴趣爱好</font></td>
					<td colspan="3"><input type="text" value="${resume.hobby }" name="hobby"></td>
				</tr>
				<tr>
					<td colspan="4"><input type="hidden" name="resumeId" value="${resume.resumeId }"><img src="${pageContext.request.contextPath }/imgs/update.png" width="60px" height="40px" name="update"></td>
				</tr>
			</table>
		</div>
		
		<!-- 查看奖惩信息 -->
		<div class="info" name="reword">
			<table border="2" cellpadding="5" cellspacing="0" width="100%">
				<tr><td colspan="2"><font size="5">奖金记录(上月)</font></td></tr>
				<tr>
					<td><font>金额</font></td>
					<td><font>原因</font></td>
				</tr>
				<c:forEach items="${rListPlus }" var="r">
					<tr>
						<td><font>${r.rewMoney}</font></td>
						<td><font>${r.rewReason}</font></td>
					</tr>
				</c:forEach>
				<tr><td colspan="2"><font size="5">罚金记录</font></td></tr>
				<tr>
					<td><font>金额</font></td>
					<td><font>原因</font></td>
				</tr>
				<c:forEach items="${rListLess }" var="r">
					<tr>
						<td><font>${r.rewMoney}</font></td>
						<td><font>${r.rewReason}</font></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	
		<!-- 查看薪资及打卡记录-->
		<div class="info" name="salary">
			<table border="2" cellpadding="5" cellspacing="0" width="100%">
				<tr><td colspan="6"><font size="5">薪资记录(上月)</font></td></tr>
				<tr>
					<td><font>迟到天数</font></td>
					<td><font>早退天数</font></td>
					<td><font>旷工天数</font></td>
					<td><font>奖金金额</font></td>
					<td><font>罚金金额</font></td>
					<td><font>总工资</font></td>
				</tr>
				<tr>
					<td><font>${salary.lateCount }</font></td>
					<td><font>${salary.beforeCount }</font></td>
					<td><font>${salary.disAttend }</font></td>
					<td><font>${salary.plusMoney }</font></td>
					<td><font>${salary.lessMoney }</font></td>
					<td><font>${salary.count }</font></td>
				</tr>
				<tr><td colspan="6"><font size="5">不良出勤记录(上月)</font></td></tr>
				<tr>
					<td colspan="2"><font>状态</font></td>
					<td colspan="4"><font>时间</font></td>
				</tr>
				<c:forEach items="${aListAfter }" var="a">
					<tr>
						<td colspan="2"><font>迟到</font></td>
						<td colspan="4"><font><f:formatDate value="${a.attTime }" pattern="yyyy-MM-dd HH:mm:SS"/></font></td>
					</tr>
				</c:forEach>
				<c:forEach items="${aListBefore }" var="b">
					<tr>
						<td colspan="2"><font>早退</font></td>
						<td colspan="4"><font><f:formatDate value="$${b.attTime }" pattern="yyyy-MM-dd HH:mm:SS"/></font></td>
					</tr>
				</c:forEach>
				<tr><td colspan="6"><font size="5">薪资异议</font></td></tr>
				<tr><td colspan="6"><input type="text" name="suggest"><button name="sendToSup">发送至主管</button></td></tr>
				<input type="hidden" name="supId" value="${emp.empSupId }">
			</table>
		</div>
	
		<!-- 查看培训 -->
		<div class="info" name="train">
			<table border="2" cellpadding="5" cellspacing="0" width="100%">
				<tr><td colspan="6"><font size="5">培训信息</font></td></tr>
				<tr>
					<td><font>开始时间</font></td>
					<td><font>结束时间</font></td>
					<td><font>培训内容</font></td>
				</tr>
				<c:forEach items="${trainList }" var="t">
					<tr>
						<td><font><f:formatDate value="${t.tStartTime }" pattern="yyyy-MM-dd"/></font></td>
						<td><font><f:formatDate value="${t.tEndTime }" pattern="yyyy-MM-dd"/></font></td>
						<td><font>${t.tInfo }</font></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	
		
		<div class="info" name="deptInfo">
			<div name="all">
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
			
			<table border="2 solid" cellpadding="5" cellspacing="0" align="center" style="margin-top: 30px;width:100%">
				<tr><td colspan="4"><b><font>员工信息</font></b></td></tr>
				<tr name="title">
					<td><font>ID</font></td>
					<td><font>姓名</font></td>
					<td><font>账号</font></td>
					<td><font>入职时间</font></td>
				</tr>
			</table>
			</div>
		</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	</div>
</body>
</html>