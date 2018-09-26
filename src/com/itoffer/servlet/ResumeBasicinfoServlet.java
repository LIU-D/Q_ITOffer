package com.itoffer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itoffer.pojo.ResumeBasicInfo;
import com.itoffer.dao.ResumeDAO;

/*******************************************
 * @author		Lxd027
 * @date		2018-09-20 6:42:21 PM
 * @tags		请求添加简历
 ******************************************/

@WebServlet("/resumeBasicinfoServlet")
public class ResumeBasicinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ResumeBasicinfoServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		//获取请求操作类型
		String type = request.getParameter("type");
		System.out.println("TYPE:" + type);
		//简历添加操作
		if(type.equals("add")) {
			//封装请求数据
			ResumeBasicInfo resume  = addResumeBasicInfo(request);
			//将数据存储到数据库
			ResumeDAO dao = new ResumeDAO();
			int basicInfoID = dao.save(resume);
			//添加简历成功则重定向到简历界面，否则在重新添加
			if(basicInfoID > 0){
				response.sendRedirect("applicant/resume.html");
			}else{
				response.sendRedirect("applicant/resumeBasicInfoAdd.html");
			}
		}//add
	}
	
	//将请求的简历数据封装成一个对象
	private ResumeBasicInfo addResumeBasicInfo(HttpServletRequest request) {
		//假设已经取得applicantID
		int applicantID = 22;
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
