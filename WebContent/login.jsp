<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录 - 锐聘网</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/login.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
	function validate() {
		var email = document.getElementById("email");
		var password = document.getElementById("password");
		if (email.value == "") {
			alert("邮箱不能为空！");
			email.focus();
			return false;
		}
		if (password.value == "") {
			alert("密码不能为空！");
			password.focus();
			return false;
		}
		return true;
	}
</script>
<!-- 网站公共头部 -->
<jsp:include page="top.jsp"/>
<%
String applicantEmail = "";
String applicantPwd = "";
// 从客户端读取Cookie
Cookie[] cookies = request.getCookies();  
if (cookies != null) {  
  for (Cookie cookie : cookies) {  
    if ("COOKIE_APPLICANTEMAIL".equals(cookie.getName())) {  

    	applicantEmail = cookie.getValue();
      	// 解密获取存储在Cookie中的求职者Email
        //applicantEmail = com.itoffer.sunhm.util.CookieEncryptTool.decodeBase64(cookie.getValue());   
    }  
    if ("COOKIE_APPLICANTPWD".equals(cookie.getName())) {  
    	 applicantPwd = cookie.getValue();
    	// 解密获取存储在Cookie中的求职者登录密码
        //applicantPwd = com.itoffer.sunhm.util.CookieEncryptTool.decodeBase64(cookie.getValue());  
    }  
  }
}
%>
	<!-- 登录部分开始 -->
	<div class="content">
		<div class="page_name">登陆</div>
		<div class="login_content">
			<!-- 登录表单开始 -->
			<form action="applicantLoginServlet" method="post" onsubmit="return validate();">
			<input type="hidden" name="requestPath" value="${requestScope.requestPath }">
				<div class="login_l">
					<p class="font14" style="color: gray">使用注册邮箱登录</p>
					<div class="span1">
						<label class="tn-form-label">邮箱：</label> <input class="tn-textbox"
							type="text" name="email" id="email" value="<%=applicantEmail%>">
					</div>
					<div class="span1">
						<label class="tn-form-label">密码：</label> <input class="tn-textbox"
							type="password" name="password" id="password" value="<%=applicantPwd%>">
					</div>
					<div class="tn-form-row-button">
						<div class="span1">
							<input name="submit" type="submit" class="tn-button-text"
								value="登   录"> <span class="it-register-text"> <input
								checked="checked" name="rememberMe" id="rememberMe"
								class="tn-checkbox" type="checkbox" value="true"> <label
								for="RememberPassword" style="color: gray"> 记住密码</label></span>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</form>
			<!-- 登录表单结束 -->
			<div class="login_r">
				<p align="center">
					<b>还没有帐号？</b><a href="register.jsp">10秒钟快速注册</a>
				</p>
				<div>
					<img src="images/login_pic.jpg">
				</div>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<!-- 登录部分结束 -->

	<!-- 网站公共尾部 -->
	<iframe src="foot.html" width="100%" height="150" scrolling="no"
		frameborder="0"></iframe>
</body>
</html>