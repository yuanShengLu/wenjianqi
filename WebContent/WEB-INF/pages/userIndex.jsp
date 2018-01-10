<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<!-- 导航 -->
	<div class="left">
		<c:if test="${user.resume.realName==null}">
			<font size="3" color="orange">欢迎用户${user.userAccount },您还没完善简历信息</font><br/>
		</c:if>
		<c:if test="${user.resume.realName!=null}">
			<font size="3" color="orange">欢迎用户${user.resume.realName },人才市场济济赶紧投递您的简历吧</font><br/>
		</c:if>
		<c:if test="${iList.size()!=0}">
			<font size="3" color="orange">您有新的面试邀约，请查看！</font>
		</c:if>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/check.png" name="check"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/send.png" name="send"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/report.png" name="report"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/cp.png" name="cp"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/back.png" name="back"><br/>
	</div>
	
	<div class="right" name="info">
	
		<!-- 修改密码 -->
		<div style="width:30%;text-align: center;margin-top: 20%;margin-left: 25%" name="cp">
			<form action="${pageContext.request.contextPath }/userHandler/updatePassword?userId=${user.userId}" method="post">
				<font size="6" color="grey">用户账号</font><input readonly="readonly" value="${user.userAccount }" name="userAccount"></p>
				<font size="6" color="grey">原密码</font><input type="text" name="userPassword"></p>
				<font size="6" color="grey">新密码</font><input type="text" name="newPassword"></p>
				<input type="submit"><br/>
			</form>
		</div>
		
		<!-- 个人简历 -->
		<div style="width:50%;text-align: center;margin-top: 10%;margin-left: 10%" name="check">
			<form action="${pageContext.request.contextPath }/userHandler/updateResume?resumeId=${user.resume.resumeId }" method="post" id="resume" >
			<table border="2" cellpadding="5" cellspacing="0">
				<tr>
					<td colspan="4"><b><font size="6" color="orange">个人简历</font></b></td>
				</tr>
				<tr>
					<td><font size="2" color="orange">真实姓名</font></td>
					<td><input type="text" value="${user.resume.realName }" name="realName"></td>
					<td><font size="2" color="orange">性别</font></td>
					<td>
						<select name="gender" style="width: 50%">
							<option value="男" <c:if test="${user.resume.gender=='男' }">selected="selected"</c:if>>男</option>
							<option value="女" <c:if test="${user.resume.gender=='女' }">selected="selected"</c:if>>女</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><font size="2" color="orange">年龄</font></td>
					<td><input type="text" value="${user.resume.age }" name="age"></td>
					<td><font size="2" color="orange">学历</font></td>
					<td>
						<select name="education" style="width: 50%">
							<option value="本科" <c:if test="${user.resume.education=='本科' }">selected="selected"</c:if>>本科</option>
							<option value="专科" <c:if test="${user.resume.education=='专科' }">selected="selected"</c:if>>专科</option>
							<option value="硕士" <c:if test="${user.resume.education=='硕士' }">selected="selected"</c:if>>硕士</option>
							<option value="博士" <c:if test="${user.resume.education=='博士' }">selected="selected"</c:if>>博士</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><font size="2" color="orange">联系方式</font></td>
					<td><input type="text" value="${user.resume.contactInfo }" name="contactInfo"></td>
					<td><font size="2" color="orange">e-mail</font></td>
					<td><input type="text" value="${user.resume.eMail }" name="eMail"></td>
				</tr>
				<tr>
					<td><font size="2" color="orange">应聘职位</font></td>
					<td>
						<select name="department">
							<c:forEach items="${dList}" var="dept">
								<option value="${dept.deptName}" <c:if test="${dept.deptName==user.resume.department}">selected="selected"</c:if>>${dept.deptName}</option>
							</c:forEach>
						</select>
						<select name="position" value="${user.resume.position }">
							<option>${user.resume.position }</option>
						</select>
					</td>
					<td><font size="2" color="orange">政治面貌</font></td>
					<td>
						<select name="politicalStatus">
							<option value="党员" <c:if test="${user.resume.politicalStatus=='党员' }">selected="selected"</c:if>>党员</option>
							<option value="团员" <c:if test="${user.resume.politicalStatus=='团员' }">selected="selected"</c:if>>团员</option>
							<option value="群众" <c:if test="${user.resume.politicalStatus=='群众' }">selected="selected"</c:if>>群众</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><font size="2" color="orange">期望薪资</font></td>
					<td>
						<select name="expectedSalary">
							<option value="5000-6000" <c:if test="${user.resume.expectedSalary=='5000-6000' }">selected="selected"</c:if>>5000-6000</option>
							<option value="7000-9000" <c:if test="${user.resume.expectedSalary=='7000-9000' }">selected="selected"</c:if>>7000-9000</option>
							<option value="1W-1.5W" <c:if test="${user.resume.expectedSalary=='1W-1.5W' }">selected="selected"</c:if>>1W-1.5W</option>
						</select>
					</td>
					<td><font size="2" color="orange">兴趣爱好</font></td>
					<td><input type="text" value="${user.resume.hobby }" name="hobby"></td>
				</tr>
				<tr>
					<td><font size="2" color="orange">工作经验</font></td>
					<td colspan="3"><input type="text" value="${user.resume.jobExperience }" name="jobExperience"></td>
				</tr>
				<tr>
					<td colspan="4"><input type="hidden" name="userAccount" value="${user.userAccount }"><img src="${pageContext.request.contextPath }/imgs/update.png" width="60px" height="40px" name="update"></td>
				</tr>
			</table>
			</form>
		</div>
		
		<!-- 投递简历 -->
		<input type="hidden" value="${isTurnPage }" name="isTurnPage">
		<div style="width:70%;text-align: center;margin-top: 5%;margin-left: 5%" name="send">
			<table border="2px solid orange" cellpadding="8" cellspacing="0" align="center">
				<tr><td colspan="7"><font size="5" color="orange">招聘信息</font></td></tr>
				<tr>
					<td><font size="3" color="orange">招聘职位</font></td>
					<td><font size="3" color="orange">所属部门</font></td>
					<td><font size="3" color="orange">工作地点</font></td>
					<td><font size="3" color="orange">薪资待遇</font></td>
					<td><font size="3" color="orange">发布时间</font></td>
					<td><font size="3" color="orange">岗位需求</font></td>
					<td><font size="3" color="orange">投递简历</font></td>
				</tr>
				<c:forEach items="${page.list }" var="rec">
					<tr>
						<td><font size="3" color="orange">${rec.recPosition }</font></td>
						<td><font size="3" color="orange">${rec.recDept }</font></td>
						<td><font size="3" color="orange">${rec.recWorkPlace }</font></td>
						<td><font size="3" color="orange">${rec.recSalary }</font></td>
						<td><font size="3" color="orange"><f:formatDate value="${rec.recReleaseTime }" pattern="yyyy-MM-dd"/></font></td>
						<td><button name="workDesc" value="${rec.recWorkDescribe }">岗位需求</button></td>
						<td><a name="send" href="${pageContext.request.contextPath }/recruitmentHandler/addRec?resumeId=${user.resume.resumeId}&recId=${rec.recId}&userAccount=${user.userAccount }"><font size="3" color="orange">投递简历</font></a></td>
					</tr>
				</c:forEach>
				<tr><td colspan="7"><font size="3" color="orange">当前页数${page.pageNo }/${page.totalPageNumber }&nbsp;&nbsp;</font><a href="${pageContext.request.contextPath }/userHandler/turnIndex?pageNo=1&userAccount=${user.userAccount }&isTurnPage=true"><font size="3" color="orange">首页</font></a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/userHandler/turnIndex?pageNo=${page.pageNo-1}&userAccount=${user.userAccount }&isTurnPage=true"><font size="3" color="orange">上一页</font></a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/userHandler/turnIndex?pageNo=${page.pageNo+1}&userAccount=${user.userAccount }&isTurnPage=true"><font size="3" color="orange">下一页</font></a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/userHandler/turnIndex?pageNo=${page.totalPageNumber}&userAccount=${user.userAccount }&isTurnPage=true"><font size="3" color="orange">末页</font></a></td></tr>
				<tr><td colspan="7"><font size="5" color="orange">INFO</font></td></tr>
				<tr><td colspan="7"><font size="5" color="orange" name="workDesc"></font></td></tr>
			</table>
		
		</div>
		
		<!-- 反馈信息 -->
		<div name="report" style="width:70%;text-align: center;margin-top: 10%;margin-left: 15%;">
			<table border="2px" cellpadding="6" cellspacing="0">
				<tr>
					<td colspan="7"><font size="5" color="orange">面试邀约</font></td>
				</tr>
				<tr>
					<td>
						<font size="3" color="orange">面试职位</font>
					</td>
					<td>
						<font size="3" color="orange">部门</font>
					</td>
					<td>
						<font size="3" color="orange">工作地点</font>
					</td>
					<td>
						<font size="3" color="orange">薪资范围</font>
					</td>
					<td>
						<font size="3" color="orange">招聘信息发布时间</font>
					</td>
					<td>
						<font size="3" color="orange">岗位需求</font>
					</td>
					<td>
						<font size="3" color="orange">面试时间</font>
					</td>
				</tr>
				<c:if test="${iList.size()!=0 }">
					<c:forEach items="${iList }" var="inter">
						<tr>
							<td>
								<font size="3" color="orange">${inter.recruitment.recPosition }</font>
							</td>
							<td>
								<font size="3" color="orange">${inter.recruitment.recDept }</font>
							</td>
							<td>
								<font size="3" color="orange">${inter.recruitment.recWorkPlace }</font>
							</td>
							<td>
								<font size="3" color="orange">${inter.recruitment.recSalary }</font>
							</td>
							<td>
								<font size="3" color="orange"><f:formatDate value="${inter.recruitment.recReleaseTime }" pattern="yyyy-MM-dd"/></font>
							</td>
							<td>
								<font size="3" color="orange">${inter.recruitment.recWorkDescribe }</font>
							</td>
							<td>
								<font size="3" color="orange"><f:formatDate value="${inter.interTime}" pattern="yyyy-MM-dd"/></font>
							</td>
						</tr>
						<tr>
							<td colspan="7"><font size="3" color="orange">接受面试</font></td>
						</tr>
						<tr>
							<td colspan="7"><button name="attendInter" value="1">按时参加面试</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button name="attendInter" value="0">拒绝面试</button><input type="hidden" value="${user.userId}" name="isAttendUserId"></td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			<c:if test="${iList.size()==0 }">
				<font size="5" color="orange">您暂时没有面试邀约！</font>
			</c:if>
		</div>
		
		
		
		
		
		
		
		
		
		
		
	</div>
</body>
</html>