<%@page import="com.itoffer.pojo.Applicant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="../error.jsp" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的简历 - 锐聘网</title>
<link href="./css/base.css" type="text/css" rel="stylesheet" />
<link href="./css/my_resume.css" type="text/css" rel="stylesheet" />

<jsp:include page="../top.jsp"/>
<jsp:useBean id="resume" class="com.itoffer.pojo.ResumeBasicInfo" scope="request"/>
	<div class="resume_con">
		<!--tab设置-->
		<div class="user_operate">
			<ul style="float: left">
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
					<div style="float: left">基本信息</div>
					<div class="btn">
						<a href="resumeBasicInfoServlet?action=edit">修改</a>
					</div>
				</div>
				<div class="all_resume">
					<div class="table_style">
						<table width="300" border="0" cellpadding="3" cellspacing="1"
							bgcolor="#EEEEEE">
							<tr>
								<th width="110" align="right" bgcolor="#F8F8F8">姓名：</th>
								<td bgcolor="#F8F8F8">
								<jsp:getProperty property="realName" name="resume"/>
								</td>
							</tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1"
							bgcolor="#EEEEEE">
							<tr>
								<th width="110" align="right" bgcolor="#F8F8F8">性别：</th>
								<td bgcolor="#F8F8F8"><jsp:getProperty property="gender" name="resume"/></td>
							</tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1"
							bgcolor="#EEEEEE">
							<tr>
								<th width="110" align="right" bgcolor="#F8F8F8">当前所在地：</th>
								<td bgcolor="#F8F8F8"><jsp:getProperty property="currentLoc" name="resume"/></td>
							</tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1"
							bgcolor="#EEEEEE">
							<tr>
								<th width="110" align="right" bgcolor="#F8F8F8">户口所在地：</th>
								<td bgcolor="#F8F8F8"><jsp:getProperty property="residentLoc" name="resume"/></td>
							</tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1"
							bgcolor="#EEEEEE">
							<tr>
								<th width="110" align="right" bgcolor="#F8F8F8">出生日期：</th>
								<td bgcolor="#F8F8F8"><jsp:getProperty property="birthday" name="resume"/></td>
							</tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1"
							bgcolor="#EEEEEE">
							<tr>
								<th width="110" align="right" bgcolor="#F8F8F8">手机：</th>
								<td bgcolor="#F8F8F8"><jsp:getProperty property="telephone" name="resume"/></td>
							</tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1"
							bgcolor="#EEEEEE">
							<tr>
								<th width="110" align="right" bgcolor="#F8F8F8">邮件：</th>
								<td bgcolor="#F8F8F8"><jsp:getProperty property="email" name="resume"/></td>
							</tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1"
							bgcolor="#EEEEEE">
							<tr>
								<th width="110" align="right" bgcolor="#F8F8F8">求职意向：</th>
								<td bgcolor="#F8F8F8"><jsp:getProperty property="jobIntension" name="resume"/></td>
							</tr>
						</table>
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1"
							bgcolor="#EEEEEE">
							<tr>
								<th width="110" align="right" bgcolor="#F8F8F8">工作经验：</th>
								<td bgcolor="#F8F8F8"><jsp:getProperty property="jobExperience" name="resume"/></td>
							</tr>
						</table>
						<div class="he"></div>
					</div>
					<div style="float: right" class="uploade">
						<%
							if(resume.getHeadShot().equals(null)){
						%>		
							<img style="width:250px" src="applicant/images/anonymous.png">		
						<%
							}else{
						%>
							<img style="width:250px" src="applicant/images/<jsp:getProperty property="headShot" name="resume"/>">
						<%		
							}
						%>
						<div align="center">
							<a href="applicant/resumeBasicInfoPicUpload.html" class="uploade_btn">更换照片</a>
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<div class="resume_title">
					<div style="float: left">教育经历</div>
					<div class="btn">添加</div>
				</div>
				<div class="it-table-grid">
					<ul>
						<li class="tn-border-gray tn-border-bottom it-table-grid-header">
							<p class="tn-name">毕业院校</p>
							<p class="tn-date">就读时间</p>
							<p class="tn-degree">学历</p>
							<p class="tn-fieldofstudy">专业</p>
						</li>
						<li class="tn-border-gray tn-border-bottom">
							<p class="tn-name" title="青软实训">青软实训</p>
							<p class="tn-date">2013/10-2014/10</p>
							<p class="tn-degree" title="">本科&nbsp;</p>
							<p class="tn-fieldofstudy" title="软件工程">软件工程&nbsp;</p> <span
							class="tn-actions"><a href="#"
								class="tn-action tn-action-text-icon"> <span
									class="tn-icon it-icon-modify"></span><span
									class="tn-action-text">修改</span>
							</a> <a href="" class="tn-action tn-action-text-icon tn-delete">
									<span class="tn-icon it-icon-delete"></span><span
									class="tn-action-text">删除</span>
							</a></span>
						</li>
					</ul>
				</div>

				<div class="resume_title">
					<div style="float: left">工作经历</div>
					<div class="btn">添加</div>
				</div>
				<div class="it-table-grid">
					<ul>
						<li class="tn-border-gray tn-border-bottom it-table-grid-header">
							<p class="tn-name">工作公司</p>
							<p class="tn-date">在职时间</p>
							<p class="tn-degree">部门</p>
							<p class="tn-fieldofstudy">职位名称</p>
						</li>
						<li class="tn-border-gray tn-border-bottom">
							<p class="tn-name" title="青软实训">青软实训</p>
							<p class="tn-date">2013/10-2014/10</p>
							<p class="tn-degree" title="">研发部</p>
							<p class="tn-fieldofstudy" title="软件工程">软件开发工程师</p> <span
							class="tn-actions"><a href="#"
								class="tn-action tn-action-text-icon"> <span
									class="tn-icon it-icon-modify"></span><span
									class="tn-action-text">修改</span>
							</a> <a href="" class="tn-action tn-action-text-icon tn-delete">
									<span class="tn-icon it-icon-delete"></span><span
									class="tn-action-text">删除</span>
							</a></span>
						</li>

					</ul>
				</div>

				<div class="resume_title">
					<div style="float: left">项目经验</div>
					<div class="btn">添加</div>
				</div>
				<div class="it-table-grid">
					<ul>
						<li class="tn-border-gray tn-border-bottom it-table-grid-header">
							<p class="tn-name">项目名称</p>
							<p class="tn-date">参与时间</p>
							<p class="tn-degree">担任职位</p>
						</li>


					</ul>
				</div>
				<div class="resume_title">
					<div style="float: left">培训经历</div>
					<div class="btn">添加</div>
				</div>
				<div class="it-table-grid">
					<ul>
						<li class="tn-border-gray tn-border-bottom it-table-grid-header">
							<p class="tn-name">培训名称</p>
							<p class="tn-date">培训时间</p>

						</li>


					</ul>
				</div>
				<div class="resume_title">
					<div style="float: left">获得证书</div>
					<div class="btn">添加</div>
				</div>
				<div class="it-table-grid">
					<ul>
						<li class="tn-border-gray tn-border-bottom it-table-grid-header">
							<p class="tn-name">证书名称</p>

						</li>


					</ul>
				</div>
				<div class="resume_title">
					<div style="float: left">语言能力</div>
					<div class="btn">添加</div>
				</div>

				<div class="it-table-grid">
					<ul>
						<li class="tn-border-gray tn-border-bottom it-table-grid-header">
							<p class="tn-name">语言</p>
							<p class="tn-date">听说</p>
							<p class="tn-degree">读写</p>
							<p class="tn-fieldofstudy">等级考试</p>
						</li>
						<li class="tn-border-gray tn-border-bottom">
							<p class="tn-name" title="英语">英语</p>
							<p class="tn-date">熟练</p>
							<p class="tn-degree" title="">熟练</p>
							<p class="tn-fieldofstudy" title="CET-6">CET-6</p> <span
							class="tn-actions"><a href="#"
								class="tn-action tn-action-text-icon"> <span
									class="tn-icon it-icon-modify"></span><span
									class="tn-action-text">修改</span>
							</a> <a href="" class="tn-action tn-action-text-icon tn-delete">
									<span class="tn-icon it-icon-delete"></span><span
									class="tn-action-text">删除</span>
							</a></span>
						</li>

					</ul>
				</div>
				<div class="resume_title">
					<div style="float: left">IT技能</div>
					<div class="btn">添加</div>
				</div>
				<div class="it-table-grid">
					<ul>
						<li class="tn-border-gray tn-border-bottom it-table-grid-header">
							<p class="tn-auto">技能名称</p>

							<p class="tn-name">熟练程度</p>
						</li>
						<li class="tn-border-gray tn-border-bottom">
							<p class="tn-auto">Oracle</p>
							<p class="tn-name">熟练</p> <span class="tn-actions"><a
								href="#" class="tn-action tn-action-text-icon"> <span
									class="tn-icon it-icon-modify"></span><span
									class="tn-action-text">修改</span>
							</a> <a href="" class="tn-action tn-action-text-icon tn-delete">
									<span class="tn-icon it-icon-delete"></span><span
									class="tn-action-text">删除</span>
							</a></span>
						</li>
						<li class="tn-border-gray tn-border-bottom">
							<p class="tn-auto">JavaEE</p>
							<p class="tn-name">熟练</p> <span class="tn-actions"><a
								href="#" class="tn-action tn-action-text-icon"> <span
									class="tn-icon it-icon-modify"></span><span
									class="tn-action-text">修改</span>
							</a> <a href="" class="tn-action tn-action-text-icon tn-delete">
									<span class="tn-icon it-icon-delete"></span><span
									class="tn-action-text">删除</span>
							</a></span>
						</li>
						<li class="tn-border-gray tn-border-bottom">
							<p class="tn-auto">Java</p>
							<p class="tn-name">熟练</p> <span class="tn-actions"><a
								href="#" class="tn-action tn-action-text-icon"> <span
									class="tn-icon it-icon-modify"></span><span
									class="tn-action-text">修改</span>
							</a> <a href="" class="tn-action tn-action-text-icon tn-delete">
									<span class="tn-icon it-icon-delete"></span><span
									class="tn-action-text">删除</span>
							</a></span>
						</li>

					</ul>
				</div>
				<div class="resume_title">
					<div style="float: left">其他信息</div>
					<div class="btn">添加</div>
				</div>
				<div class="it-table-grid">
					<ul>
						<li class="tn-border-gray tn-border-bottom it-table-grid-header">
							<p class="tn-name">标题</p>
							<p class="tn-auto">描述</p>
						</li>



					</ul>
				</div>
				<div class="resume_title">
					<div style="float: left">简历附件</div>
					<div class="btn">添加</div>
				</div>
				<div class="it-table-grid">
					<div class="it-table-grid">暂无附件！</div>
				</div>


			</div>
			<!--右边-->
			<iframe src="applicant/resume_right.html" width="290" height="650"
				scrolling="no" frameborder="0"></iframe>

			<div style="clear: both"></div>
		</div>
	</div>

	<iframe src="./foot.html" width="100%" height="150" scrolling="no"
		frameborder="0"></iframe>
</body>
</html>
