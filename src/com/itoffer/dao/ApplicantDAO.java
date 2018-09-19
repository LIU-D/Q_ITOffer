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
 * @tags		数据处理、业务流程控制
 ******************************************/

public class ApplicantDAO {

	/**
	 * 验证email 是否被注册过..
	 * @param email
	 */
	public boolean isExistEmail(String email){
		Connection conn=DBUtil.getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		String sql="SELECT * FROM tb_applicant WHERE applicant_email=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,email);
			rs=pstmt.executeQuery();
			if(rs.next())
				return true;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return false;
	}
	
	/**
	 * 求职者信息注册保存..
	 * @param email
	 * @param password
	 */
	public static void save(String email,String password) {
		Connection conn =DBUtil.getConnection();
		PreparedStatement pstmt =null;
		String sql ="INSERT INTO tb_applicant(applicant_email,applicant_pwd,applicant_registdate)VALUES(?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,email);
			pstmt.setString(2,password);
			pstmt.setTimestamp(3, new Timestamp(new Date().getTime()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(null, pstmt, conn);
		}
	}
	
	/**
	 * 注册用户登录.
	 * @param email
	 * @param passord
	 * @return
	 */
	public int login(String email,String password){
		int applicantID=0;
		Connection conn=DBUtil.getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		String sql=" SELECT applicant_id FROM tb_applicant WHERE applicant_email=? and applicant_pwd=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2,password);
			rs = pstmt.executeQuery();
			if(rs.next())
				applicantID=rs.getInt("applicant_id");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return applicantID;
	}
	
	/**
	 * 判断是否已有简历
	 * @param applicantID
	 * @return
	 */
	public int isExistResume(int applicantID){
		int resumeID=0;
		Connection conn =DBUtil.getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		String sql="SELECT basicinfo_id FROM tb_resume WHERE applicant_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, applicantID);
			rs = pstmt.executeQuery();
			if(rs.next())
				resumeID =rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return resumeID;
	}
}

