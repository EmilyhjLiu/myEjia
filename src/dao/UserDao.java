package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.User;
import tool.ConnectSql;

public class UserDao {
		//查找用户是否存在以及用户名与密码是否匹配
		public boolean qUser(User user)
		{
			boolean result=false;
			Connection con=ConnectSql.GetConnection();
			Statement st;
			try {
				String sql="select * from user where email='"+user.getUserEmail()+"' and password='"+user.getUserPassword()+"'";
				st =con.createStatement();
				ResultSet rs=st.executeQuery(sql);
				if(rs.next())
				{
					result=true;
				}
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		
		//查找邮箱是否已被注册
		public boolean QueryEmail(String email)
		{
			boolean result=false;
			Connection con=ConnectSql.GetConnection();
			Statement st;
			try {
				String sql="select * from user where email='"+email+"'";
				st =con.createStatement();
				ResultSet rs=st.executeQuery(sql);
				if(rs.next())
				{
					result=true;
				}
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}

		
		//用户注册
		public int addUser(User user)
		{
			int result=0;
			Connection con=ConnectSql.GetConnection();
			PreparedStatement ps;
			try {
				String sql="insert into user(email,password,phone,address) values (?,?,?,?)";
				ps =con.prepareStatement(sql);
				ps.setString(1, user.getUserEmail());
				ps.setString(2, user.getUserPassword());
				ps.setString(3, user.getUserPhone());
				ps.setString(4, user.getUserAddress());
				result=ps.executeUpdate();
				ps.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
			}
			return result;
		}		

		
		/*		//找回密码时重置密码
		public int updateuser(String password,String email)
		{
			int result=0;
			Connection con=Connectjava.GetConnection();
			PreparedStatement ps;
			try {
				String sql="update user set password=? where email=?";
				ps =con.prepareStatement(sql);
				ps.setString(1,password);
				ps.setString(2,email);
				result=ps.executeUpdate();
				ps.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		

		//根据用户名查找用户id
		public int QueryingId(User user)
		{
			int result=0;
			Connection con=Connectjava.GetConnection();
			Statement st;
			try {
				String sql="select * from user where name='"+user.getUser_name()+"'";
				st =con.createStatement();
				ResultSet rs=st.executeQuery(sql);
				if(rs.next())
				{
					result=rs.getInt(1);
					user.setUser_id(result);
				}
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}		*/
		//		//找回密码是根据邮箱查找用户名密码
//		public User Querypsw(String email)
//		{
//			User user=new User();
//			Connection con=Connectjava.GetConnection();
//			Statement st;
//			try {
//				String sql="select * from user where email='"+email+"'";
//				st =con.createStatement();
//				ResultSet rs=st.executeQuery(sql);
//				while(rs.next())
//				{
//					user.setUser_name(rs.getString(2));
//					user.setUser_password(rs.getString(3));
//				}
//				rs.close();
//				st.close();
//				con.close();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return user;
//		}

			
		public static void main(String[] args) {
			UserDao  userdao=new UserDao();
			User user=new User();
			user.setUserEmail("111");
			user.setUserPassword("1");
			user.setUserAddress("1");
			user.setUserPhone("1");
			
			int a=0;
			if(!userdao.QueryEmail(user.getUserEmail())){
				a=userdao.addUser(user);
			}
			System.out.print(a);
			
//			boolean a=userdao.Querying(user);
//			System.out.print(a);
		}
}
