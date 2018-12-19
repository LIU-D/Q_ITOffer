package com.itoffer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itoffer.pojo.Applicant;
import com.itoffer.pojo.ResumeBasicInfo;
import com.itoffer.dao.ResumeDAO;

/*******************************************
 * @author		Lxd027
 * @date		2018-09-20 6:42:21 PM
 * @tags		简历操作
 ******************************************/

@WebServlet("/resumeBasicInfoServlet")
public class ResumeBasicInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ResumeBasicInfoServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		
		if(action.equals("info")) {
			Applicant applicant = (Applicant)request.getSession().getAttribute("SESSION_APPLICANT");
			ResumeDAO dao = new ResumeDAO();
			ResumeBasicInfo resume  = dao.selectBasicInfoByID(applicant.getId());
			request.setAttribute("resume", resume);
			request.getRequestDispatcher("applicant/resume.jsp").forward(request, response);
			
		}else if(action.equals("edit")) {
			Applicant applicant = (Applicant)request.getSession().getAttribute("SESSION_APPLICANT");
			ResumeDAO dao = new ResumeDAO();
			ResumeBasicInfo resume  = dao.selectBasicInfoByID(applicant.getId());
			request.setAttribute("resume", resume);
			request.getRequestDispatcher("applicant/resumeBasicInfoUpdate.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		//获取请求操作类型
		String action = request.getParameter("action");
		//简历添加操作
		if(action.equals("add")) {
			//封装请求数据
			ResumeBasicInfo resume  = updateResumeBasicInfo(request);
			//将数据存储到数据库
			ResumeDAO dao = new ResumeDAO();
			int basicInfoID = dao.save(resume);
			//将简历标识存入会话对象
			request.getSession().setAttribute("SESSION_RESUMEID", basicInfoID);
			//System.out.println("basicInfoID:" + basicInfoID);
			//添加简历成功则重定向到简历界面，否则在重新添加
			if(basicInfoID > 0){
				response.sendRedirect("resumeBasicInfoServlet?action=info");
			}else{
				response.sendRedirect("applicant/resumeBasicInfoAdd.html");
			}
		}else if(action.equals("update")) {
			ResumeBasicInfo resume  = this.updateResumeBasicInfo(request);
			int basicInfoID = Integer.parseInt(request.getParameter("basicInfoID"));
			resume.setBasicInfoID(basicInfoID);
			resume.setResumeUpdate(resume);
			request.setAttribute("resume", resume);
			request.getRequestDispatcher("applicant/resumeBasicInfoUpdate.jsp").include(request, response);
		}
	}
	
	//将请求的简历数据封装成一个对象
	private ResumeBasicInfo updateResumeBasicInfo(HttpServletRequest request) {
		//从会话对象获取当前登陆用户标识
		Applicant applicant = (Applicant)request.getSession().getAttribute("SESSION_APPLICANT");
		//假设已经取得applicantID
		int applicantID = applicant.getId();
		//获得请求数据
		String realName = request.getParameter("realName");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String currentLoc = request.getParameter("currentLoc");
		String residentLoc = request.getParameter("residentLoc");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String jobIntension = request.getParameter("jobIntension");
		String jobExperience = request.getParameter("jobExperience");
		//String headshot
		ResumeBasicInfo resume = new ResumeBasicInfo();		
		resume.setApplicantID(applicantID);		
		resume.setRealName(realName);
		resume.setGender(gender);
		resume.setBirthday(birthday);
		if(null == currentLoc){
			resume.setCurrentLoc("");
		}else{
			resume.setCurrentLoc(currentLoc);
		}
		if(null == residentLoc){
			resume.setResidentLoc("");
		}else{
			resume.setResidentLoc(residentLoc);
		}
		resume.setTelephone(telephone);
		resume.setEmail(email);
		resume.setJobIntension(jobIntension);
		resume.setJobExperience(jobExperience);
		
		return resume;
	}
	
}
