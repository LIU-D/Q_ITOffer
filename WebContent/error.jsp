<%@ page language="java" contentType="text/html; charset=UTF-8" isErrorPage="true"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>锐聘网</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<style>
.success_content {
	width: 1000px;
	background: #fff;
	margin: 15px auto;
	box-shadow: 0 1px 3px #999;
	font-family: microsoft yahei;
}
.success_left {
	background: url(images/it-line03.png) repeat;
	width: 360px;
	float: left;
	height: 300px;
}
.success_left h2 {
	color: #19a8b6;
}
.success_right {
	float: left;
	text-align: center;
	width: 600px;
	padding-top: 95px;
}
.it-pageimg {
	background: url(images/it-img.png) no-repeat -440px -210px;
	height: 160px;
	width: 160px;
	margin: 47px 0px -35px 76px;
}
.green16 {
	font-size: 16px;
	color: #19a8b6;
}
.tn-button {
	background: url(images/it-button.png) no-repeat -205px -10px;
	height: 45px;
	width: 146px;
	font-size: 16px;
	display: inline-block;
	text-align: center;
	color: white;
	line-height: 45px;
}
.tn-button:hover {
	background: url(images/it-button.png) no-repeat -205px -65px;
	width: 146px;
	height: 45px;
}
.success_right p {
	line-height: 50px;
}
.success_right p span {
	margin-left: 20px;
}
</style>
<jsp:include page="top.jsp"></jsp:include>

<div class="success_content">
  <div class="success_left">
    <div class="it-pageimg"></div>
    <h2 align="center">出错了！</h2>
  </div>
  <div class="success_right">
    <p class="green16"><%=exception %></p>
    <p><a href="javascript:window.history.go(-1);"><span class="tn-button">返回上一步</span></a>
    <a href="index.jsp"><span class="tn-button">返回首页</span></a></p>
  </div>
  <div class="clear"></div>
</div>
<iframe src="foot.html" width="100%" height="150"  scrolling="no" frameborder="0" ></iframe>
</body>
</html>