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
		<font color="orange">亲爱的${dept.deptName }主管${sup.supName}，今天又是朝气蓬勃的一天！</font><br>
		<c:forEach items="${rec}" var="r">
			<c:if test="${r.resumes.size()!=0 }">
				<font>您部门${r.recPosition }岗位有${r.resumes.size()}个未办面试请求!</font><br>
			</c:if>
		</c:forEach>
		<c:if test="${iList.size()!=0}">
			<font>您有${iList.size()}个面试需要参加审核！</font>
		</c:if>
		<c:if test="${sugList.size()!=0}">
			<font>您有${sugList.size()}条员工反馈未阅读！</font>
		</c:if>
			
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/createRecruitment.png" name="createRecruitment"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/checkintvinfo.png" name="readResumes"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/intvevent.png" name="interview"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/deptInfo.png" name="deptInfo"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/tianjiajiangcheng.png" name="addReword"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/gongzifafang.png" name="releaseSalary"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/fabupeixun.png" name="releaseTrain"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/button.png" name="suggest"><br/>
		<img class="navigation" src="${pageContext.request.contextPath }/imgs/tuichu.png" name="back"><br/>
	</div>
	<div class="right">
		<img src="${pageContext.request.contextPath }/imgs/shangban.png" name="sad" style="right:0;top:200px;width: 100px;height: 100px;position: absolute;">
		<font size="5" style="position: absolute;right:40px;top:300px">上班</font>
		<img src="${pageContext.request.contextPath }/imgs/shangban.png" name="happy" style="right:0;top:400px;width: 100px;height: 100px;position: absolute;">
		<font size="5" style="position: absolute;right:40px;top:500px">下班</font>
		<input type="hidden" name="empId" value="${empId }">
		<input type="hidden" name="deptId" value="${sup.supDeptId}">
		
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
						<tr id="${res.resumeId}">
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
							<td><font size="3"><button name="yes" value="${res.resumeId}_${r.recId}">是</button><button name="no" value="${res.resumeId}_${r.recId}">否</button></font></td>
						</tr>
					</c:forEach>
				</c:forEach>
				<tr name="interviewDate"><td colspan="11"><font size="3">请选择面试时间</font><input type="Date" name="interviewDate"><button name="ok">确认发送面试消息</button><input type="hidden" value="${sup.supId}" name=""></td></tr>
			</table>
		
		</div>
	
		<!-- 面试信息 -->
		<div class="info" name="interview" style="margin-top: 60px;width: 61%;margin-left: 10%">
			<table border="2" cellpadding="6" cellspacing="0" width="100%">
				<c:if test="${iList.size()!=0}">
					<c:forEach items="${iList}" var="i">
						<tr class="${i.interId}">
							<td colspan="6"><font size="5">应聘信息</font></td>
						</tr>
						<tr class="${i.interId}">
							<td><font>招聘职位</font></td>
							<td><font>所属部门</font></td>
							<td><font>工作地点</font></td>
							<td><font>薪资待遇</font></td>
							<td colspan="2"><font>发布时间</font></td>
						</tr>
						<tr class="${i.interId}">
							<td><font>${i.recruitment.recPosition }</font></td>
							<td><font>${i.recruitment.recDept }</font></td>
							<td><font>${i.recruitment.recWorkPlace }</font></td>
							<td><font>${i.recruitment.recSalary }</font></td>
							<td colspan="2"><font><f:formatDate value="${i.recruitment.recReleaseTime }" pattern="yyyy-MM-dd"/></font></td>
						</tr>
						<tr class="${i.interId}"><td colspan="6"><font>岗位需求</font></td></tr>
						<tr class="${i.interId}">
							<td colspan="6"><font>${i.recruitment.recWorkDescribe }</font></td>
						</tr>
						<tr class="${i.interId}"><td colspan="6"><font>------------------------------------------------------</font></td></tr>
						<tr class="${i.interId}"><td colspan="6"><font size="5">应聘者简历</font></td></tr>
						<tr class="${i.interId}">
							<td><font>真实姓名</font></td>
							<td><font>性别</font></td>
							<td><font>年龄</font></td>
							<td><font>学历</font></td>
							<td colspan="2"><font>联系方式</font></td>
						</tr>
						<tr class="${i.interId}">
							<td><font>${i.resume.realName}</font></td>
							<td><font>${i.resume.gender}</font></td>
							<td><font>${i.resume.age}</font></td>
							<td><font>${i.resume.education}</font></td>
							<td colspan="2"><font>${i.resume.contactInfo}</font></td>
						</tr>
						<tr class="${i.interId}">
							<td><font>政治面貌</font></td>
							<td><font>期望薪资</font></td>
							<td colspan="3"><font>兴趣爱好</font></td>
							<td><font>面试职位</font></td>
						</tr>
						<tr class="${i.interId}">
							<td><font>${i.resume.politicalStatus}</font></td>
							<td><font>${i.resume.expectedSalary}</font></td>
							<td colspan="3"><font>${i.resume.hobby}</font></td>
							<td><font>${i.resume.position}</font></td>
						</tr>
						<tr class="${i.interId}"><td colspan="6"><font>工作经验</font></td></tr>
						<tr class="${i.interId}"><td colspan="6"><font>${i.resume.jobExperience}</font></td></tr>
						<tr class="${i.interId}"><td colspan="6"><button style="width: 100px;height: 50px" name="addEmp">AGREE</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button name="disAgree" style="width: 100px;height: 50px" value="${i.interId}">PASS</button></td></tr>
						<tr name="salary" class="${i.interId}">
							<td colspan="3">
								<font>请谨慎填写商议后的员工薪资</font>
							</td>
							<td colspan="3">
								<input type="text" name="salary">
								<button name="hire" value="${i.userId }_${i.interId}_${i.resume.resumeId}_${sup.supId}_${i.recruitment.recDept}_${i.recruitment.recPosition}">确认薪资并雇佣员工</button>
							</td>
						</tr>
						<tr class="${i.interId}"><td colspan="6"><font>------------------------------------------------------</font></td></tr></p>
					</c:forEach>
				</c:if>
				<c:if test="${iList.size()==0}">
					<font size="6">您暂时没有面试需要参加！</font>
				</c:if>
			</table>
		</div>
	
		<!-- 查看部门信息 -->
		<div class="info" name="deptInfo">
			<div name="all">
			<font size="5">部门</font>
			<select name="deptInfo">
				<option>${dept.deptName }</option>
			</select>
			<font size="5">职位</font>
			<select name="posiInfo">
				<option>-请选择-</option>
				<c:forEach items="${pList}" var="p">
					<option>${p.poName }</option>
				</c:forEach>
			</select>
			
			<table border="2 solid" cellpadding="5" cellspacing="0" align="center" style="margin-top: 30px;width:100%">
				<tr><td colspan="6"><b><font>员工信息</font></b></td></tr>
				<tr name="title">
					<td><font>ID</font></td>
					<td><font>姓名</font></td>
					<td><font>账号</font></td>
					<td><font>基本工资</font></td>
					<td><font>入职时间</font></td>
					<td><font>详细信息</font></td>
				</tr>
			</table>
			</div>
		</div>
	
		<!-- 添加奖惩 -->
		<div class="info" name="addReword">
			<table border="2 solid" cellpadding="5" cellspacing="0" align="center" style="margin-top: 30px;width:100%">
				<tr><td><font size="5">添加奖惩</font></td></tr>
				<tr>
					<td>
						<font>请选择奖惩</font>
						<select name="rewType">
							<option value="1">奖励</option>
							<option value="0">惩罚</option>
						</select>
						<font>请填写员工ID</font>
						<input type="text" name="empId">
					</td>
				</tr>
				<tr>
					<td>
						<font>金额</font><input type="text" name="rewMoney">
					</td>
				</tr>
				<tr>
					<td>
						<font>奖惩原因</font><input type="text" name="rewReason">
					</td>
				</tr>
				<tr>
					<td>
						<button name="commitRew">确认添加</button>
					</td>
				</tr>
			</table>
		</div>
	
		<div class="info" name="suggest">
			<table border="2 solid" cellpadding="5" cellspacing="0" align="center" style="margin-top: 30px;width:100%">
				<tr><td colspan="2"><font size="5">员工反馈</font></td></tr>
				<tr>
					<td><font>员工ID</font></td>
					<td><font>意见内容</font></td>
				</tr>
				<c:forEach items="${sugList }" var="sug">
					<tr>
						<td><font>${sug.empId }</font></td>
						<td><font>${sug.suggestInfo }</font></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<!-- 发布培训 -->
		<div class="info" name="releaseTrain">
			<table border="2 solid" cellpadding="5" cellspacing="0" align="center" style="margin-top: 30px;width:100%">
				<tr><td colspan="2"><font size="5">新建部门培训</font></td></tr>
				<tr>
					<td><font>开始时间</font></td>
					<td><font>结束时间</font></td>
				</tr>
				<tr>
					<td><input type="date" name="tStartTime"></td>
					<td><input type="date" name="tEndTime"></td>
				</tr>
				<tr>
					<td><font>培训内容</font></td>
					<td><input type="text" name="tInfo"></td>
				</tr>
				<tr><td colspan="3"><button name="addTrain" value="${sup.supDeptId }">确认发布</button></td></tr>
				<tr><td colspan="2"><font size="5">修改已有部门培训</font></td></tr>
				<c:forEach items="${trainList }" var="t">
					<tr>
						<td><font>开始时间</font></td>
						<td><font>结束时间</font></td>
					</tr>
					<tr>
						<td><input type="text" name="tStartTimeOld${t.tId }" value="<f:formatDate value="${t.tStartTime }" pattern="yyyy-MM-dd"/>" readonly="readonly"></td>
						<td><font><input type="text" name="tEndTimeOld${t.tId }" value="<f:formatDate value="${t.tEndTime }" pattern="yyyy-MM-dd"/>" readonly="readonly"></font></td>
					</tr>
					<tr>
						<td><font>改为</font></td>
						<td><font>改为</font></td>
					</tr>
					<tr>
						<td><input type="date" name="tStartTimeNew${t.tId }"></td>
						<td><input type="date" name="tEndTimeNew${t.tId }"></td>
					</tr>
					<tr><td colspan="2"><font>培训内容</font><input type="text" name="tInfoNew${t.tId }" value="${t.tInfo}"></td></tr>
					<tr><td colspan="2"><button name="trainUpdate" value="${t.tId }">修改</button>&nbsp;&nbsp;&nbsp;<button name="trainRemove" value="${t.tId }">删除</button></td></tr>
				</c:forEach>
			</table>
			
		</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	</div>
</body>
</html>