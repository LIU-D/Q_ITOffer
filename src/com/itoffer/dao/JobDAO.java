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
}
