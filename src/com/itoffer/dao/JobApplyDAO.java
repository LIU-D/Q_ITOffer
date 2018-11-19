package com.itoffer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.Date;

import com.itoffer.pojo.Company;
import com.itoffer.pojo.Job;
import com.itoffer.pojo.JobApply;
import com.itoffer.util.DBUtil;

/************************************************
 * @author		Lixd027
 * @date		2018-11-15 2:44:42 PM
 * @tags		职位申请信息处理类
 ***********************************************/

public class JobApplyDAO {
	/**
	 * 保存职位信息
	 * @param jobid
	 * @param applicantid
	 */
	public boolean save(JobApply jobApply){
		boolean ret = true;
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO tb_jobapply (applicant_id, job_id) VALUES (?, ?)";
		try {
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, jobApply.getApplicantId());
				pStmt.setInt(2, jobApply.getJobId());
				if(0 == pStmt.executeUpdate()){
					ret = false;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(rs, pStmt, conn);
		}		
		
		return ret;
	}
	
	public List<JobApply> getJobApplyList(int applicantId){
		List<JobApply> list = new ArrayList<JobApply>();
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		/*
		 * 	SELECT a.APPLY_ID, a.APPLY_STATE, a.APPLY_DATE, j.job_id, j.JOB_NAME, c.COMPANY_ID, c.COMPANY_NAME
			FROM tb_jobapply as a , tb_job as j, tb_company as c
			WHERE a.job_id = j.job_id and j.company_id = c.company_id and a.applicant_id = 18
		 * 
		 */
		String sql = "SELECT a.APPLY_ID, a.APPLY_STATE, a.APPLY_DATE, j.job_id, j.JOB_NAME, c.COMPANY_ID, c.COMPANY_NAME "
				+ "FROM tb_jobapply as a , tb_job as j, tb_company as c "
				+ "WHERE a.job_id = j.job_id and j.company_id = c.company_id and a.applicant_id = ?";
		try {
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, applicantId);
				rs = pStmt.executeQuery();
				while(rs.next()){
					
					JobApply ja = new JobApply();
					ja.setApplyId(rs.getInt("APPLY_ID"));
					ja.setState(rs.getInt("APPLY_STATE"));
					ja.setApplicantId(applicantId);
					ja.setApplyDate(rs.getString("APPLY_DATE"));
					
					Job j = new Job();
					j.setId(rs.getInt("JOB_ID"));
					j.setName(rs.getString("JOB_NAME"));
					
					Company com = new Company();
					com.setId(rs.getInt("COMPANY_ID"));
					com.setName(rs.getString("COMPANY_NAME"));
					
					j.setCompany(com);
					ja.setJob(j);
					
					list.add(ja);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(rs, pStmt, conn);
		}		
		
		return list;
	}
}
	

