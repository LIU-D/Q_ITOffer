<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>我的工作申请 - 锐聘网</title>
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link href="css/myapplys.css" rel="stylesheet" type="text/css" />
<jsp:include page="../top.jsp" />
<div id="tn-content" class="tn-content-bg">
	<div class="tn-wrapper">
		<div class="tn-grid">
			<div class="it-content-box it-person">
				<div class="tn-box-content">
					<div class="tn-tabs">
						<ul class="tn-tabs-nav tn-widget-content ">
							<li><a href="resume.html">我的简历</a></li>
							<li class="tn-tabs-selected"><a
								href="jobApplyServlet?action=myApply">我的申请</a></li>
						</ul>
						<div class="tn-tabs-panel tn-widget-content">
							<form action="#" method="post" id="Form-Apply">
								<table class="tn-table-grid">
									<tbody>
										<tr class="tn-table-grid-header">
											<th class="tn-width-check"><input type="checkbox"
												class="tn-checkbox" id="selectAll" name="selectall">
											</th>
											<th>企业名称</th>
											<th class="it-text-ctnter">职位名称</th>
											<th class="it-text-ctnter">申请状态</th>
											<th></th>
										</tr>

										<c:forEach items="${requestScope.jobList }" var="apply">
											<tr class="tn-table-grid-row">
												<td class="tn-width-check"><input type="checkbox"
													class="tn-checkbox tnui-apply" value="494"
													name="applyIdList"></td>
												<td class="tn-width-auto"><a title=易科德软件有限公司 href="#"
													target="_blank"> ${apply.job.company.name }</a></td>
												<th class="tn-width-pic-mini"><a title=软件开发工程师/实施工程师
													href="#" target="_blank"> ${apply.job.name }</a></th>
												<td class="tn-width-category"><div
														class="tn-instructions">
														<div class="it-instructions-tit">
															<span style="width: 26px">申请</span><span
																style="width: 132px">审核</span><span style="width: 132px">通知</span>
														</div>
														<div
															class="tn-progress-bar tn-widget-content tn-corner-all">

															<!-- 进度begin -->
															<c:choose>
																<c:when test="${apply.state==1 }">
																	<div style="width: 0%;"
																		class="tn-progress-bar-value tn-widget-header tn-corner-left tn-border-tbl">
																	</div>
																</c:when>
																<c:when test="${apply.state==2 }">
																	<div style="width: 50%;"
																		class="tn-progress-bar-value tn-widget-header tn-corner-left tn-border-tbl">
																	</div>
																</c:when>
																<c:when test="${apply.state==3 }">
																	<div style="width: 100%;"
																		class="tn-progress-bar-value tn-widget-header tn-corner-left tn-border-tbl">
																	</div>
																</c:when>
															</c:choose>
															<!--  进度end -->

														</div>
														<ul class="tn-helper-clearfix tn-step-scale"></ul>
													</div></td>
												<td class="tn-width-action2"><span class="tn-action">
														<a class="tn-action tn-action-text-icon tnui-apply-delete"
														href="#"> <span class="tn-icon it-icon-delete"></span><span
															class="tn-action-text">删除</span></a>
												</span></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</form>
							<div class="it-page-results tn-helper-clearfix">
								<div class="tn-helper-left">
									<a
										class="tn-button tn-corner-all tn-button-text-only tn-button-semidlong"
										href="#" id="deleteAll"> <span class="tn-button-text">删除</span></a>
								</div>
								<div
									class="tn-pagination tn-pagination-simple tn-helper-clearfix">
									<div class="tn-pagination-btn">
										<span class="tn-page-prev tn-page-thumb">上一页</span> <span
											class="tn-page-number tn-selected">1</span> <a href="#"
											class="tn-page-number">2</a> <a href="#"
											class="tn-page-thumb tn-page-next">下一页</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<iframe src="foot.html" width="100%" height="150" scrolling="no"
	frameborder="0"></iframe>
</body>
</html>