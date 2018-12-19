<%@page import="com.itoffer.pojo.Job"%>
<%@page import="java.util.*"%>
<%@page import="com.itoffer.pojo.Company"%>
<%@page import="com.itoffer.dao.CompanyDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RTO服务_锐聘官网-大学生求职,大学生就业,IT行业招聘，IT企业快速入职 - 锐聘网</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/index.css" type="text/css" rel="stylesheet" />
<script src="js/a.js" type="text/javascript"></script>
<style>
.page01{
	margin-top:10px;
	text-align:center;
}
.page03{
	margin:5px;
	display:inline;
}
</style>
<body>
 <jsp:include page='${"companyServlet"}'>
 	<jsp:param value="pageList" name="action"/>
 	<jsp:param value="${param.pageNo}" name="pageNo"/>
</jsp:include>
</body>
</html>