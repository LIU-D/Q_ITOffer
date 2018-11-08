package com.itoffer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itoffer.pojo.Company;
import com.itoffer.pojo.Job;
import com.itoffer.util.DBUtil;

/************************************************
 * @author		Lixd027
 * @date		2018-10-26 7:19:48 PM
 * @tags		
 ***********************************************/

public class JobDAO {
	/**
	 * 职位数据操作
	 * @param companyID
	 * @return list
	 */
	public List<Job> getJobListByCompanyID(String companyID){
		List <Job> list = new ArrayList<Job>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM tb_job WHERE COMPANY_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(companyID));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Job job = new Job();
				job.setId(rs.getInt("JOB_ID"));
				job.setName(rs.getString("JOB_NAME"));
				job.setSalary(rs.getString("JOB_SALARY"));
				job.setArea(rs.getString("JOB_AREA"));
				job.setEndTime(rs.getString("JOB_ENDTIME"));
				list.add(job);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return list;
	}
	
	/**
	 * 根据职位编号查询职位详细信息
	 * @param jobid
	 * @return
	 */
	public Job getJobByID(String jobid) {
		Job job = new Job();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT tb_job.*, company_pic FROM tb_job INNER JOIN tb_company "
				+ "ON tb_job.company_id = tb_company.company_id WHERE job_id = ?";
		try {
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, Integer.parseInt(jobid));
				rs = pStmt.executeQuery();
				while(rs.next()){
					job.setId(rs.getInt("JOB_ID"));
					job.setName(rs.getString("JOB_NAME"));
					job.setHiringNum(rs.getInt("JOB_HIRINGNUM"));
					job.setSalary(rs.getString("JOB_SALARY"));
					job.setArea(rs.getString("JOB_AREA"));
					job.setDesc(rs.getString("JOB_DESC"));
					job.setEndTime(rs.getString("JOB_ENDTIME"));
					job.setState(rs.getInt("JOB_STATE"));
					
					Company company = new Company();
					company.setId(rs.getInt("COMPANY_ID"));
					company.setPic(rs.getString("COMPANY_PIC"));
					job.setCompany(company);
					
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeJDBC(rs, pStmt, conn);
		}
		return job;
	}
}
