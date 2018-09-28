package com.itoffer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
