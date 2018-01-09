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
<script type="text/javascript" src="${pageContext.request.contextPath }/jsConfig/supIndex.js"></script>
</head>
<body>
	<div class="left">
		<font color="orange">亲爱的主管${sup.supName}，今天又是朝气蓬勃的一天！</font><br>
		<c:forEach items="${rec}" var="r">
			<c:if test="${r.resumes.size()!=0 }">
				<font>您有未办面试请求!</font><br>
			</c:if>
		</c:forEach>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/createRecruitment.png" name="createRecruitment"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/button.png" name="readResumes"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/button.png" name=""><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/button.png" name=""><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/button.png" name="back"><br/>
	</div>
	<div class="right">
		<!-- 发布招聘信息 -->
		<div class="info" name="createRecruitment">
			<form action="${pageContext.request.contextPath }/recruitmentHandler/createRecru?supId=${sup.supId}&supDeptId=${sup.supDeptId}" method="post" onsubmit="return false" name="createRecruitment">
				<font size="5">请选择要招聘的职位</font>
				<select name="recPosition">
					<c:forEach items="${pList }" var="posi">
						<option>${posi.poName }</option>
					</c:forEach>
				</select></p>
				<input type="hidden" value="${sup.supDeptId }" name="recDeptId">
				<font size="5">工作地点</font>
				<select name="recWorkPlace">
					<option>徐汇区纸张路3898号</option>
					<option>浦东新区张江高科陡壁路1231号</option>
					<option>宝山区聚丰园路88号</option>
				</select></p>
				<font size="5">薪水待遇</font>
				<input type="text" name="recSalary">
				<font size="5">岗位要求</font>
				<input type="text" name="recWorkDescribe"></p>
				<input type="submit" name="recConfirm">
			</form>
		</div>
		<!-- 查看面试信息 -->
		<div class="info" name="readResumes" style="margin-top: 20px;width: 68%;margin-left: 10%">
			<table border="2px solid" cellpadding="5" cellspacing="0">
				<tr><td colspan="11"><font size="5">招聘信息</font></td></tr>
				<tr>
					<td colspan="2"><font size="3">职位</font></td>
					<td colspan="3"><font size="3">工作地点</font></td>
					<td colspan="3"><font size="3">薪水待遇</font></td>
					<td colspan="3"><font size="3">发布时间</font></td>
				</tr>
				<c:forEach items="${rec}" var="r">
					<tr>
						<td colspan="2"><font>${r.recPosition }</font></td>
						<td colspan="3"><font>${r.recWorkPlace }</font></td>
						<td colspan="3"><font>${r.recSalary }</font></td>
						<td colspan="3"><font><f:formatDate value="${r.recReleaseTime }" pattern="yyyy-MM-dd"/></font></td>
					</tr>
				</c:forEach>
				<tr><td colspan="11"><font size="5">投递者个人简历</font></td></tr>
				<tr>
					<td><font size="3">真实姓名</font></td>
					<td><font size="3">性别</font></td>
					<td><font size="3">年龄</font></td>
					<td><font size="3">学历</font></td>
					<td><font size="3">联系方式</font></td>
					<td><font size="3">政治面貌</font></td>
					<td><font size="3">期望薪资</font></td>
					<td><font size="3">兴趣爱好</font></td>
					<td><font size="3">工作经验</font></td>
					<td><font size="3">面试职位</font></td>
					<td><font size="3">是否面试</font></td>
				</tr>
				<c:forEach items="${rec}" var="r">
					<c:forEach items="${r.resumes}" var="res">
						<tr>
							<td><font size="3">${res.realName}</font></td>
							<td><font size="3">${res.gender}</font></td>
							<td><font size="3">${res.age}</font></td>
							<td><font size="3">${res.education}</font></td>
							<td><font size="3">${res.contactInfo}</font></td>
							<td><font size="3">${res.politicalStatus}</font></td>
							<td><font size="3">${res.expectedSalary}</font></td>
							<td><font size="3">${res.hobby}</font></td>
							<td><font size="3">${res.jobExperience}</font></td>
							<td><font size="3">${res.position}</font></td>
							<td><font size="3"><button>是</button><button>否</button></font></td>
						</tr>
					</c:forEach>
				</c:forEach>
			</table>
		
		</div>
	
	
	
	
	
	
	
	
	</div>
</body>
</html>