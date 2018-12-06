<%@page import="com.itoffer.pojo.Applicant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="../error.jsp" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的简历 - 锐聘网</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/my_resume.css" type="text/css" rel="stylesheet" />
<%request.setCharacterEncoding("utf-8"); %>
<jsp:include page="../top.jsp"/>
<jsp:useBean id="resume" class="com.itoffer.pojo.ResumeBasicInfo" scope="request"/>

<div class="resume_con">
	<!--tab设置-->
	<div class="user_operate">
		<ul style="float:left">
			<li><a href="resumeBasicInfoServlet?action=info" class="active">我的简历</a></li>
			<li><a href="jobApply.html">我的申请</a></li>
			<div class="clear"></div>
		</ul>
		<div class="clear"></div>
	</div>
    <!--主体部分-->
    <div class="resume_main">
    	<!--左边-->
	    <div class="resume_left">
			<div class="resume_title">
				<div style="float:left">基本信息</div>
			</div>
			<div class="all_resume">
				<div class="table_style">
				<%if(request.getParameter("action").equals("update")){%>
					<jsp:setProperty property="*" name="resume"/>
					<jsp:setProperty property="resumeUpdate" value="<%=resume %>" name="resume"/>
					<h3><font color="red"><jsp:getProperty property="updateResult" name="resume"/></font></h3>
				<%} %>
					<form action="resumeBasicInfoServlet?action=update" method="post">
					<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					
					<input type="hidden" name="basicInfoID" value="<jsp:getProperty property='basicInfoID' name='resume'/>" >
				
					  <tr>
					    <th width="110" align="right" bgcolor="#F8F8F8">姓名：</th>
					    <td bgcolor="#F8F8F8"><input type="text" id="realName" name="realName" value="<jsp:getProperty property="realName" name="resume"/>" ></td>
					  </tr>
					</table>
					<div class="he"></div>
					<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="110" align="right" bgcolor="#F8F8F8">性别：</th>
					    <td bgcolor="#F8F8F8">
					    <input type="radio" name="gender" value="男"
					    <%if("男".equals(resume.getGender())){%>checked="checked" <%} %>>男&nbsp;&nbsp;
					    <input type="radio" name="gender" value="女"
					    <%if("女".equals(resume.getGender())){%>checked="checked"<%} %>>女 
					    </td>
					  </tr>
					</table>
					<div class="he"></div>
					<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="110" align="right" bgcolor="#F8F8F8">出生日期：</th>
					    <td bgcolor="#F8F8F8"><input type="text" id="birthday" name="birthday" value="<jsp:getProperty property="birthday" name="resume"/>"></td>
					  </tr>
					</table>
					<div class="he"></div>
					<table width="300" border="0" cellpadding="3" cellspacing="1"
							bgcolor="#EEEEEE">
							<tr>
								<th width="110" align="right" bgcolor="#F8F8F8">当前所在地：</th>
								<td bgcolor="#F8F8F8"><input type="text" id="currentLoc" name="currentLoc" value="<jsp:getProperty property="currentLoc" name="resume"/>"></td>
							</tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1"
							bgcolor="#EEEEEE">
							<tr>
								<th width="110" align="right" bgcolor="#F8F8F8">户口所在地：</th>
								<td bgcolor="#F8F8F8"><input type="text" id="residentLoc" name="residentLoc" value="<jsp:getProperty property="residentLoc" name="resume"/>" /></td>
							</tr>
						</table>
						<div class="he"></div>
					<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="110" align="right" bgcolor="#F8F8F8">出生日期：</th>
					    <td bgcolor="#F8F8F8"><input type="text" id="birthday" name="birthday" value="<jsp:getProperty property="birthday" name="resume"/>"></td>
					  </tr>
					</table>
					<div class="he"></div>
					<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="110" align="right" bgcolor="#F8F8F8">手机：</th>
					    <td bgcolor="#F8F8F8"><input type="text" id="telephone" name="telephone" value="<jsp:getProperty property="telephone" name="resume"/>"></td>
					  </tr>
					</table>
					<div class="he"></div>
					<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="110" align="right" bgcolor="#F8F8F8">邮件：</th>
					    <td bgcolor="#F8F8F8"><input type="text" id="email" name="email" value="<jsp:getProperty property="email" name="resume"/>"></td>
					  </tr>
					</table>
					<div class="he"></div>
					<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="110" align="right" bgcolor="#F8F8F8">求职意向：</th>
					    <td bgcolor="#F8F8F8"><input type="text"  name="jobIntension" value="<jsp:getProperty property="jobIntension" name="resume"/>"></td>
					  </tr>
					</table>
					<div class="he"></div>
					<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="110" align="right" bgcolor="#F8F8F8">工作经验：</th>
					    <td bgcolor="#F8F8F8"><input type="text"  name="jobExperience" value="<jsp:getProperty property="jobExperience" name="resume"/>"></td>
					  </tr>
					</table>
					<div class="he"></div>
					<div style="margin-left:100px;"><input name="submit" type="submit" class="save1" value="保存"> 
					<input name="cancel" type="reset" class="cancel2" value="取消"
					onclick="javascript:window.location.href='resumeBasicInfoServlet?action=info';"></div>
				</form>

				</div>
				<div style="float:right" class="uploade">
				<c:choose>
					<c:when test="${not empty requestScope.resume.headShot }">
						<img style="width:250px" src="applicant/images/<jsp:getProperty property="headShot" name="resume"/>">
					</c:when>
					<c:otherwise>
						<img style="width:250px" src="applicant/images/anonymous.png">
					</c:otherwise>	
				</c:choose>
					<div align="center">
						<a href="applicant/resumeBasicInfoPicUpload.jsp" class="uploade_btn">更换照片</a>
					</div>
				</div>
				<div class="clear"></div>
			</div>
	    </div>
    	<!--右边-->
		<iframe src="applicant/resume_right.html" width="290" height="650"  scrolling="no" frameborder="0"></iframe>
		<div style="clear:both"></div>
	</div>
</div>

<iframe src="foot.html" width="100%" height="150"  scrolling="no" frameborder="0" ></iframe>
</body>
</html>