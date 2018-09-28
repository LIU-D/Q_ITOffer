package com.itoffer.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.itoffer.dao.ResumeDAO;

/*******************************************
 * @author		Lxd027
 * @date		2018-09-27 3:29:02 PM
 * @tags		用户头像图片操作
 ******************************************/

@WebServlet("/resumePicUploadServlet")
@MultipartConfig
public class ResumePicUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ResumePicUploadServlet() { super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//获取上传文件域
		Part part = request.getPart("headShot");
		//获取上传文件名称
		String fileName = part.getSubmittedFileName();
		//文件重命名
		String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
		//将上传的文件保存至
		String filepath = getServletContext().getRealPath("/applicant/images");
		File f = new File(filepath);
		if(!f.exists()) f.mkdirs();
		part.write(filepath + "/" + newFileName);
		//更新简历照片
		ResumeDAO dao = new ResumeDAO();
		int basicInfoID = 15;
		dao.updateHeadShot(basicInfoID,newFileName);
		//照片更新成功
		response.sendRedirect("applicant/resume.html");
	}
}
