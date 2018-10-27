package com.itoffer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.itoffer.pojo.Company;
import com.itoffer.pojo.ResumeBasicInfo;
import com.itoffer.util.DBUtil;

/*******************************************
 * @author		Lxd027
 * @date		2018-09-20 7:15:13 PM
 * @tags		数据库-简历添加
 ******************************************/

public class ResumeDAO {
	/**
	 * 简历基本信息添加和主键标识查询
	 * @param basicinfo
	 * @param applicantID
	 * @return
	 */
	
	public int save(ResumeBasicInfo resume) {
		int basicInfoID = 0;

		Connection conn = DBUtil.getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String sql = "insert into tb_resume(APPLICANT_ID, REALNAME, GENDER, BIRTHDAY, CURRENT_LOC, "
				+ "RESIDENT_LOC, TELEPHONE, EMAIL, JOB_INTENSION, JOB_EXPERIENCE)" + " VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			pStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pStmt.setInt(1, resume.getApplicantID());
			pStmt.setString(2, resume.getRealName());
			pStmt.setString(3, resume.getGender());
			pStmt.setString(4, resume.getBirthday());
			pStmt.setString(5, resume.getCurrentLoc());
			pStmt.setString(6, resume.getResidentLoc());
			pStmt.setString(7, resume.getTelephone());
			pStmt.setString(8, resume.getEmail());
			pStmt.setString(9, resume.getJobIntension());
			pStmt.setString(10, resume.getJobExperience());
			pStmt.executeUpdate();
			rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				basicInfoID = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pStmt, conn);
		}

		return basicInfoID;
	}
	
	/**
	 * 简历照片更新
	 * @param basicinfoId
	 * @param newFileName
	 * @return
	 */
	public void updateHeadShot(int basicinfoId, String newFileName) {
		String sql = "UPDATE tb_resume SET HEAD_SHOT=? WHERE BASICINFO_ID=?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newFileName);
			pstmt.setInt(2, basicinfoId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
	}
	
	/**
	 * 根据用户标识查询简历信息
	 * @param applicantID
	 * @return
	 */
	public ResumeBasicInfo selectBasicinfoByID(int applicantID) {
		ResumeBasicInfo resume = new ResumeBasicInfo();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tb_resume WHERE APPLICANT_ID = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, applicantID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				resume.setBasicInfoID(rs.getInt("COMPANY_ID"));
				resume.setRealName(rs.getString("REALNAME"));
				resume.setGender(rs.getString("GENDER"));
				resume.setBirthday(rs.getString("BIRTHDAY"));
				resume.setCurrentLoc(rs.getString("CURRENT_LOC"));
				resume.setResidentLoc(rs.getString("RESIDENT_LOC"));
				resume.setTelephone(rs.getString("TELEPHONE"));
				resume.setEmail(rs.getString("EMAIL"));
				resume.setJobIntension(rs.getString("JOB_INTENSION"));
				resume.setJobExperience(rs.getString("JOB_EXPERIENCE"));
				resume.setHeadShot(rs.getString("HEAD_SHOT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return resume;
	}
}
