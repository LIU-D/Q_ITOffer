package com.itoffer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.itoffer.util.DBUtil;

/*******************************************
 * @author		Lxd027
 * @date		2018-09-16 8:03:41 PM
 * @tags		验证E-mail,求职者信息保存
 ******************************************/

public class ApplicantDAO {
	//验证E-mail
	public boolean isExistEmail(String email) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT *FROM tb_applicant WHERE applicant_email=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) return true;
		} catch(SQLException e){
			e.printStackTrace();
			
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return false;
	}
	//求职者信息保存
	public void save(String email, String password) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO tb_applicant(applicant_email,applicant_pwd,applicant_registedate) VALUES(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			pstmt.setTimestamp(3, new Timestamp(new Date().getTime()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
	}
}
