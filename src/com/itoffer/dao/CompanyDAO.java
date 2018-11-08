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
	
	/**
	 * 
	 * 处于招聘状态企业，  分页读取数据库记录
	 * 
	 */
	public List<Company> getCompanyPageList(int pageNo,int pageSize) {
		/*
		 *  SELECT *
			FROM tb_company LEFT JOIN tb_job 
			ON tb_job.company_id=tb_company.company_id 
			WHERE company_state=1 and job_id IN (SELECT MAX(job_id) FROM tb_job WHERE job_state=1 GROUP BY company_id)
			LIMIT 1,2
		 */
		//开始和结束位置
		
		List<Company> list = new ArrayList<Company>();
		int beginPos = (pageNo - 1) * pageSize;
		//int endPos = beginPos + pageSize;
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM tb_company "
				+ "LEFT JOIN tb_job "
				+ "ON tb_job.company_id=tb_company.company_id "
				+ "WHERE company_state=1 and job_id IN (SELECT MAX(job_id) FROM tb_job WHERE job_state=1 GROUP BY company_id) "
				+ "LIMIT ?,?";
		try {
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, beginPos);
				pStmt.setInt(2, pageSize);
				rs = pStmt.executeQuery();
				while(rs.next()){
					int companyID = rs.getInt("company_id");
					String pic = rs.getString("company_pic");
					String name = rs.getString("company_name");
					int viewNum = rs.getInt("company_viewnum");
					
					int jobID = rs.getInt("job_id");
					String jobName = rs.getString("job_name");
					String jobArea = rs.getString("job_area");
					String jobSalary = rs.getString("job_salary");
					String jobTime = rs.getString("job_endtime");
					
					Company company = new Company();
					company.setId(companyID);
					company.setPic(pic);
					company.setName(name);
					company.setViewNum(viewNum);
					
					Job job = new Job();
					job.setId(jobID);
					job.setName(jobName);
					job.setArea(jobArea);
					job.setSalary(jobSalary);
					job.setEndTime(jobTime);
					
					company.getJobs().add(job);
					//加入链表
					list.add(company);
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.closeJDBC(rs, pStmt, conn);
		}

		return list;
	}
	

	/**
	 * 
	 * 
	 * @author sunhm
	 * @日期:2018年10月30日
	 * @功能：处于招聘状态的企业数量
	 * @return
	 *
	 */
	public int getRecordCount() {
		int recordCount = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT count(*) FROM tb_company "
					+ "LEFT JOIN tb_job ON tb_job.company_id=tb_company.company_id "
					+ "WHERE company_state=1 and job_id IN ("
					+ "SELECT MAX(job_id) FROM tb_job WHERE job_state=1 GROUP BY company_id"
					+ ")";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				recordCount = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return recordCount;
	}

}
