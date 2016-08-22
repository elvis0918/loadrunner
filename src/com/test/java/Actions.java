package com.test.java;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import lrapi.lr;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Actions
{

	public int init() throws Throwable {
		return 0;
	}//end of init


	public int action() throws Throwable {
		////
		//
		int CoulumCount;
		int RowCount;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.0.185:3306/jopmx";
		String user = "root";
		String password = "123456";
		Class.forName(driver);
		lr.start_transaction("JDBC_Test_Start");
		Connection conn = (Connection)DriverManager.getConnection(url, user, password);
		if(!conn.isClosed()){
			System.out.println("connection success!");
		}
		Statement stat = conn.createStatement();
		
//		lr.start_transaction("Search users");
//		ResultSet rs = stat.executeQuery("select * from t_sys_user");
//		lr.end_transaction("Search users",lr.AUTO);
//		ResultSetMetaData rsmd = rs.getMetaData();
//		CoulumCount = rsmd.getColumnCount();
//		rs.last();
//		RowCount = rs.getRow();
//		System.out.println("�����������"+CoulumCount);
//		System.out.println("�����������"+RowCount);
//		rs.close();
//		conn.close();
		
		lr.start_transaction("Search_users");
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("insert into t_sys_user(id,username) values(?,?)");
		for(int i = 0 ; i < 50; i++){
			ps.setInt(1, i);
			ps.setString(2, "hello"+i);
			ps.executeUpdate();
		}
		lr.end_transaction("Search_users", lr.AUTO);
		lr.end_transaction("JDBC_Test_Start", lr.AUTO);
		
		return 0;
	}//end of action


	public int end() throws Throwable {
		return 0;
	}//end of end
}
