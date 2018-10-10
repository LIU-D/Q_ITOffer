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

/*******************************************
 * @author Lxd027
 * @date 2018-09-16 7:53:02 PM
 * @tags 求职者登陆功能实现
 ******************************************/

@WebServlet("/applicantLoginServlet")
public class ApplicantLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApplicantLoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
		//session
		
		//cookie
		rememberMe(rememberMe, email, password, request, response);
		int applicantID = dao.login(email, password);
		if (applicantID != 0) {
			// 用户登录成功，判断是否已有简历
			int resumeID = dao.isExistResume(applicantID);
			if (resumeID != 0) {
				response.sendRedirect("index.html");
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
