package com.itoffer.dao;

import java.sql.*;
import java.util.*;
import com.itoffer.pojo.*;
import com.itoffer.util.DBUtil;
/************************************************
 * @author		Lixd027
 * @date		2018-10-18 10:02:33 AM
 * @tags		
 ***********************************************/

public class CompanyDAO {
	public List <Company> getCompanyList(){
		List <Company> list = new ArrayList<Company>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT tb_company.COMPANY_ID, tb_company.COMPANY_NAME, tb_company.COMPANY_PIC, " +
				"tb_job.JOB_ID, tb_job.JOB_NAME, tb_job.JOB_SALARY, tb_job.JOB_AREA, tb_job.JOB_ENDTIME " + 
				"FROM tb_company " + 
				"LEFT JOIN tb_job " + 
				"ON tb_company.COMPANY_ID = tb_job.COMPANY_ID " + 
				"WHERE tb_company.COMPANY_STATE = 1 and tb_job.JOB_ID IN(" + 
				"SELECT MAX(tb_job.JOB_ID) " + 
				"FROM tb_job WHERE tb_job.JOB_STATE = 1 " + 
				"GROUP BY tb_job.COMPANY_ID)";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Company company = new Company();
				Job job = new Job();
				company.setId(rs.getInt("COMPANY_ID"));
				company.setPic(rs.getString("COMPANY_PIC"));
				job.setId(rs.getInt("JOB_ID"));
				job.setName(rs.getString("JOB_NAME"));
				job.setSalary(rs.getString("JOB_SALARY"));
				job.setArea(rs.getString("JOB_AREA"));
				job.setEndTime(rs.getString("JOB_ENDTIME"));
				company.getJobs().add(job);
				list.add(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return list;
	}
	
	public Company getCompanyByID(String companyID) {
		Company company = new Company();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tb_company WHERE COMPANY_ID = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(companyID));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				company.setId(rs.getInt("COMPANY_ID"));
				company.setArea(rs.getString("COMPANY_AREA"));
				company.setBrief(rs.getString("COMPANY_BRIEF"));
				company.setPic(rs.getString("COMPANY_PIC"));
				company.setSize(rs.getString("COMPANY_SIZE"));
				company.setType(rs.getString("COMPANY_TYPE"));
				company.setViewNum(rs.getInt("COMPANY_ID"));
				company.setName(rs.getString("COMPANY_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return company;
	}
}
