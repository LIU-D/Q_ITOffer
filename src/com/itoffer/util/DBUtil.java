package com.itoffer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*******************************************
 * @author		Lxd027
 * @date		2018-09-07 4:03:39 PM
 * @tags		数据库连接资源释放工具类
 ******************************************/

public class DBUtil {
	
	static String dbname = "webbkg";
	static String user = "root";
	static String pwd = "741258o";
	static String url = "jdbc:mysql://localhost:3306/" + dbname + "?user=" + user + "&password=" + pwd
            			 + "&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
	//在类被加载的时候执行且仅会被执行一次
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//建立连接
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeJDBC(ResultSet rs,Statement stmt,Connection conn) {
		if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
            	stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}

}
