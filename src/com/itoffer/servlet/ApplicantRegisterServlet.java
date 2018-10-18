package com.itoffer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itoffer.dao.ApplicantDAO;

/*******************************************
 * @author		Lxd027
 * @date		2018-09-16 7:50:02 PM
 * @tags		求职者注册功能实现
 ******************************************/

@WebServlet("/applicantRegisterServlet")
public class ApplicantRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantRegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求和响应编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//获取请求参数
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String verifyCode = request.getParameter("verifyCode");
		System.out.println("input verifycode: " + verifyCode);
		//判断验证码是否正确
		String sessionValidateCode = (String)request.getSession().getAttribute("SESSION_VALIDATECODE");
		if(!sessionValidateCode.equals(verifyCode)) {
			out.print("<script type='text/javascript'>");
			out.print("alert('验证码错误，请重新输入！');");
			out.print("window.location='register.html';");
			out.print("</script>");
		} else {
			//判断邮箱是否已被注册
			ApplicantDAO dao = new ApplicantDAO();
			boolean flag = dao.isExistEmail(email);
			if(flag) {
				//邮箱已注册，进行错误提示
				out.print("<script type='text/javascript'>");
				out.print("alert('邮箱已被注册，请重新输入！');");
				out.print("window.location='register.html';");
				out.print("</script>");
			} else {
				//邮箱未被注册，保存注册用户信息
				dao.save(email,password);
				//注册成功，重定向到登陆页面
				response.sendRedirect("login.jsp");
			}
		}
		
	}
}