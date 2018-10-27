package com.itoffer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itoffer.dao.CompanyDAO;
import com.itoffer.dao.JobDAO;
import com.itoffer.pojo.Company;
import com.itoffer.pojo.Job;
/************************************************
 * @author		Lixd027
 * @date		2018-10-26 7:01:16 PM
 * @tags		
 ***********************************************/
@WebServlet("/companyServlet")
public class CompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CompanyServlet() { super(); }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("info")) {
			String companyID = request.getParameter("id");
			CompanyDAO dao = new CompanyDAO();
			Company company = dao.getCompanyByID(companyID);
			request.setAttribute("company", company);
			JobDAO jobdao = new JobDAO();
			List<Job> jobList = jobdao.getJobListByCompanyID(companyID);
			request.setAttribute("jobList", jobList);
			request.getRequestDispatcher("recruit/company.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
