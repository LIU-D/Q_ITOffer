package com.itoffer.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import com.itoffer.dao.CompanyDAO;

/**
 * Application Lifecycle Listener implementation class ServletRequestListener
 *
 */
@WebListener
public class CompanyViewCountListener implements javax.servlet.ServletRequestListener {

    /**
     * Default constructor. 
     */
    public CompanyViewCountListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see CompanyViewCountListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see CompanyViewCountListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  {
    	HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
    	String requestURI = request.getRequestURI();
    	String queryString = request.getQueryString() == null ? "" : request.getQueryString();
    	if(requestURI.indexOf("companyServlet") >= 0 && queryString.indexOf("info") >= 0) {
    		int id = Integer.parseInt(queryString.substring(queryString.lastIndexOf('=') + 1));
    		CompanyDAO dao = new CompanyDAO();
    		dao.updateCompanyViewCount(id);
    	}
    }
}
