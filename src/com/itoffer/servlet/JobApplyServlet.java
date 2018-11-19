package com.itoffer.servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itoffer.dao.JobApplyDAO;
import com.itoffer.dao.JobDAO;
import com.itoffer.pojo.Applicant;
import com.itoffer.pojo.Job;
import com.itoffer.pojo.JobApply;
@WebServlet("/jobApplyServlet")
public class JobApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public JobApplyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		//System.out.println("action: " + action);
		//职位申请
		if(action.equals("apply")) {
			String jobid = request.getParameter("jobid");
			Applicant applicant = (Applicant) request.getSession().getAttribute("SESSION_APPLICANT");
			JobApplyDAO japDAO = new JobApplyDAO();
			//JobDAO jbDAO = new JobDAO();
			//Job job = jbDAO.getJobByID(jobid);
			JobApply jbApply = new JobApply();
			jbApply.setApplicantId(applicant.getId());
			jbApply.setJobId(Integer.parseInt(jobid));
			japDAO.save(jbApply);
			//request.setAttribute("job", job);
			//request.setAttribute("company", job.getCompany());
			response.sendRedirect(request.getContextPath() + "/jobApplyServlet?action=myApply");
		}else if(action.equals("myApply")) {
			Applicant applicant = (Applicant) request.getSession().getAttribute("SESSION_APPLICANT");
			JobApplyDAO dao = new JobApplyDAO();
			List<JobApply> jobList = dao.getJobApplyList(applicant.getId());
			request.setAttribute("jobList", jobList);
			request.getRequestDispatcher("applicant/jobApply.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
