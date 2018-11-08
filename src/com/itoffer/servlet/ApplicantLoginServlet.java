package com.itoffer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itoffer.dao.ApplicantDAO;
import com.itoffer.pojo.Applicant;

/*******************************************
 * @author Lxd027
 * @date 2018-09-16 7:53:02 PM
 * @tags 求职者登陆功能实现
 ******************************************/

@WebServlet("/applicantLoginServlet")
public class ApplicantLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ApplicantLoginServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求和响应编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// 获取请求参数
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		// 登录验证
		ApplicantDAO dao = new ApplicantDAO();
		//cookie
		rememberMe(rememberMe, email, password, request, response);
		int applicantID = dao.login(email, password);
		if (applicantID != 0) {
			//登陆成功，将求职者信息存入会话对象
			Applicant applicant = new Applicant(applicantID,email,password);
			request.getSession().setAttribute("SESSION_APPLICANT", applicant);
			//System.out.println("SESSION_APPLICANT: " + request.getSession().getAttribute("SESSION_APPLICANT"));

			// 用户登录成功，判断是否已有简历
			int resumeID = dao.isExistResume(applicantID);
			if (resumeID != 0) {
				//若已有简历，则将简历标识存到会话对象
				request.getSession().setAttribute("SESSION_RESUMEID", resumeID);
				//System.out.println("SESSION_RESUMEID: " + request.getSession().getAttribute("SESSION_RESUMEID"));
				//跳到首页
				response.sendRedirect("index.jsp");
			} else {
				// 若简历不存在，则跳到简历填写向导页面
				response.sendRedirect("regsuccess.html");
			}
		} else {
			// 用户登录信息错误，进行错误提示
			out.print("<script type='text/javascript'>");
			out.print("alert('用户名或密码错误，请重新输入！');");
			out.print("window.location='login.html';");
			out.print("</script>");
		}
	}
	
	private void rememberMe(String rememberMe, String email, String password, HttpServletRequest request, HttpServletResponse response) {
		//判断是否需要通过cookie记住邮箱和密码
		if("true".equals(rememberMe)) {
			//记住邮箱及密码
			Cookie cookie = new Cookie("COOKIE_APPLICANTEMAIL",email);
			cookie.setPath("/");
			cookie.setMaxAge(2 * 60 * 60);
			response.addCookie(cookie);
			cookie = new Cookie("COOKIE_APPLICANTPWD",password);
			cookie.setPath("/");
			cookie.setMaxAge(2 * 60 * 60);
			response.addCookie(cookie);
		} else {
			//将邮箱及密码cookie删除
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					if("COOKIE_APPLICANTEMAIL".equals(cookie.getName()) || "COOKIE_APPLICANTPWD".equals(cookie.getName())) {
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
					}
				}
			}
		}
	}

}
