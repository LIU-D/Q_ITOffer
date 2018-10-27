<%@page import="com.itoffer.pojo.Job"%>
<%@page import="java.util.List"%>
<%@page import="com.itoffer.pojo.Company"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="../error.jsp"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>“锐聘之星”软件设计大赛 - 锐聘网</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/company.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="../top.jsp"></jsp:include>
	<%
		Company company = (Company)request.getAttribute("company");
		List<Job> jobList = (List<Job>)request.getAttribute("jobList");
	%>
	
	<div class="tn-grid">
		<div class="it-com-keyimg">
			<div class="tn-widget-content">
				<img src="images/635581231315281772.jpg" />
			</div>
		</div>
	</div>
	<div class="clear"></div>
	<div class="tn-grid">
		<div class="tn-widget-content">
			<div class="tn-box-content">
				<div class="tn-helper-clearfix">
					<div class="it-main2">
						<div class="it-ctn-heading">
							<div class="it-title-line">
								<span> <em><%=company.getViewNum() %></em> 浏览
								</span>
								<h3>企业简介</h3>
							</div>
						</div>
						<div class="it-com-textnote">
							<span class="kuai"> 行业：<%=company.getViewNum() %></span> <span class="kuai">
								所在地：<%=company.getArea() %> </span> <span class="kuai"> 规模：<%=company.getSize() %> </span> <span
								class="kuai"> 性质：<%=company.getType() %> </span>
						</div>
						<div class="it-company-text">
						
							<p class="p1" style="padding: 7px;">
								<strong> </strong> <span
									style="line-height: 3.5; font-size: 14px;">
									<%=company.getBrief() %> 
								</span>
							</p>
							<br />
							
							

						</div>
						<p class="tn-helper-right">
							<a href="/Home/SuccessCases?companyId=288" target="_blank"
								class="tn-action"> <span class="tn-icon"> </span> <span
								class="tn-action-text"> 成功案例 </span>
							</a>
						</p>
					</div>
				</div>
			</div>
		</div>

		<input type="hidden" id="videoListCompanyId" value="151" /> <input
			type="hidden" id="companyTotalVideoCount" value='1' />
		<div class="it-content-seqbox">
			<div id="morejob">
				<div class="it-ctn-heading">
					<div class="it-title-line">
						<h3>职位</h3>
					</div>
				</div>
				<!--职位列表-->
				<%
					if(jobList != null){
						for(Job job:jobList){
				%>
				<div class="it-post-box tn-border-dashed">
					<div class="it-post-name">
						<div class="tn-helper-right it-post-btn">
							<a class="it-font-underline" href="job.html" target=_blank><span
								class="tn-icon-view"></span><span class=tn-action-text>查看详细</span>
							</a><a class="tn-button-small" href="#"><span
								class="tn-button-text">申请</span> </a>
						</div>
						<h3>
							<a title=对日Java软件开发工程师 href="companyServlet?type=select&id=<%= job.getId() %>" target=_blank><%= job.getName() %></a>
						</h3>
					</div>
					<ul class="it-post">
						<li style="width: 300px;">薪资： <span class="it-font-size"><%= job.getSalary() %></span></li>
						<li style="width: 250px;"><span class=tn-text-note>工作地区：</span>
							<LaBEL for=""><%= job.getArea() %></LaBEL></li>
						<li><span class="tn-text-note">招聘人数：</span> 35</li>
						<li><span class="tn-text-note">申请人数：</span> 5</li>
					</ul>
				</div>
				<!--职位列表-->
				<%
						}
					}
				%>
			</div>
		</div>
		<div class="bottomban">
			<div class="bottombanbox">
				<img src="images/<%=company.getPic()%>" />
			</div>
		</div>
	</div>
	</div>
	</div>
	<!-- InstanceBeginEditable name="backtop" -->
	<p class="it-back-to-top" style="position: fixed" id="backTop"
		title="返回顶部">
		<a href="#top"> <span> </span> 返回顶部
		</a>
	</p>
	<!-- InstanceEndEditable -->
	<iframe src="foot.html" width="100%" height="150" scrolling="no"
		frameborder="0"></iframe>
	</div>
</body>
</html>