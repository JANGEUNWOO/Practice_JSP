package db;
//Ŭ������ : JdbcUtil.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtil {

	private static Connection con = null;
	private static String driver = "com.mysql.jdbc.Driver";
	//private static String url = "jdbc:mysql://localhost/mvc2_db";
	private static String url = "jdbc:mysql://localhost/mvc2_db?useUnicode=true&characterEncoding=UTF-8";
	private static String uid = "root";
	private static String upw = "1234";
	
	//Connection�� ��� �޼ҵ�
	public static Connection getConnection(){
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, upw);
			con.setAutoCommit(false);	//�ڵ� commit����		
			System.out.println("Ŀ�ؼ� ����");
		} catch (Exception e) {	e.printStackTrace(); }
		
		return con;		
	}
	//Connection���ҽ��� �ݴ� �޼���
	public static void close(Connection con){		
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	//Statement���ҽ��� �ݴ� �޼���
	public static void close(Statement stmt){
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	//PreparedStatement���ҽ��� �ݴ� �޼���
	public static void close(PreparedStatement pstmt){
		try {
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	//ResultSet���ҽ��� �ݴ� �޼���
	public static void close(ResultSet rs){		
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	//������DB�� �����ϴ� commit�޼���
	public static void commit(Connection con){		
		try {
			con.commit();
			System.out.println("commit success");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	//�ѹ��Ű�� �޼���
	public static void rollback(Connection con){		
		try {
			con.rollback();
			System.out.println("rollback success");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}	
}