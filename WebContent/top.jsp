<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.itoffer.pojo.*" %>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ request.getContextPath() + "/";

	Applicant applicant = (Applicant)session.getAttribute("applicant");
%>

<!-- top begin -->
<div class="head">
	<div class="head_area">
		<div class="head_nav">
			<ul>
				<li><img src="images/nav_inc1.png" /><a href="index.jsp" target="_parent">首页</a></li>
				<li><img src="images/nav_inc2.png" /><a href="#">成功案例</a></li>
				<li><img src="images/nav_inc3.png" /><a href="#">关于锐聘</a></li>
				<li><img src="images/nav_inc3.png" /><a href="applicant/resume.html" target="_parent">我的简历</a></li>
			</ul>
		</div>
		<div class="head_logo"><img src="images/head_logo.png" /></div>
		<div class="head_user">
		<%
			if(null == applicant){
		%>		
			<a href="login.jsp" target="_parent"><span class="type1">登录</span></a>
			<a href="register.jsp" target="_parent"><span class="type2">注册</span></a>			
		<%
			}else{
		%>
			<a href="resumeBasicInfoServlet?action=info" target="_parent">${sessionScope.applicant.email}<%=applicant.getEmail() %></a>
			<a href="logoutServlet" target="_parent">退出</a>
		<%		
			}
		%>
		</div>
		<div class="clear"></div>
	</div>
</div>

<div class="top_main">
	<div class="top_logo"><img src="images/main_logo.png" /></div>
	<div class="top_instr">提供岗前培训的IT职位</div>
	<div class="top_tel"><img src="images/it-phone.png" /></div>
	<div class="clear"></div>
</div>

<div class="clear"></div>
<!-- top end -->
    