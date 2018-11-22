package com.itoffer.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ApplicantAuthorityFilter
 */
@WebFilter(
		urlPatterns = { "/applicant/*" }, 
		servletNames = {"com.itoffer.servlet.ResumeBasicInfoServlet","com.itoffer.servlet.ResumePicUploadServlet",
				"com.itoffer.servlet.JobApplyServlet"},
		initParams = { 
				@WebInitParam(name = "loginPage", value = "login.jsp")},
		dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD}
		)
public class ApplicantAuthorityFilter implements Filter {

	private String loginPage = "login.jsp";
    /**
     * Default constructor. 
     */
    public ApplicantAuthorityFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.loginPage = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		HttpSession session = httpRequest.getSession();
		if(session.getAttribute("SESSION_APPLICANT") == null) {
			String requestPath = httpRequest.getRequestURI();
			if(httpRequest.getQueryString() != null) {
				requestPath += "?" + httpRequest.getQueryString();
			}
			httpRequest.setAttribute("requestPath", requestPath);
			request.getRequestDispatcher("/" + loginPage).forward(request, response);
		}else {
			/************************************************************/
			chain.doFilter(request, response);
			/************************************************************/
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		loginPage= fConfig.getInitParameter("loginPage");
		if(null == loginPage) {
			loginPage = "login.jsp";
		}
	}

}
