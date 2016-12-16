package tool;

import java.sql.*;

public class ConnectSql {
	static String user="root";
	static String psw="";
	static String url="jdbc:mysql://localhost:3306/ejia?useUnicode=true&characterEncoding=UTF-8";
	static String driverClass="com.mysql.jdbc.Driver";
	static public Connection  GetConnection()
	{
		Connection  con=null;
		
		try {
			Class.forName(driverClass).newInstance();
			con=DriverManager.getConnection(url,user,psw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectSql cj=new ConnectSql();
		System.out.print(cj.GetConnection());
	}*/
}


