package com.itoffer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itoffer.dao.JobDAO;
import com.itoffer.pojo.Job;
@WebServlet("/jobServlet")
public class JobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public JobServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		//职位详情查询
		if(action.equals("info")) {
			String jobid = request.getParameter("jobid");
			JobDAO dao = new JobDAO();
			Job job = dao.getJobByID(jobid);
			request.setAttribute("job", job);
			request.setAttribute("company", job.getCompany());
			request.getRequestDispatcher("recruit/job.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
