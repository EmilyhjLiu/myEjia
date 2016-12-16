package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import tool.ConnectSql;
import bean.Seller;

public class SellerDao {
	//查找用户是否存在以及用户名与密码是否匹配
	public boolean qUser(Seller seller)
	{
		boolean result=false;
		Connection con=ConnectSql.GetConnection();
		Statement st;
		try {
			String sql="select * from user where email='"+seller.getSellerEmail()+"' and password='"+seller.getSellerPassword()+"'";
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
			String sql="select * from seller where email='"+email+"'";
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
	public int addUser(Seller seller)
	{
		int result=0;
		Connection con=ConnectSql.GetConnection();
		PreparedStatement ps;
		try {
			String sql="insert into seller(email,password,phone,qq,logo,title,englishTitle,blankRate) values (?,?,?,?)";
			ps =con.prepareStatement(sql);
			ps.setString(1, seller.getSellerEmail());
			ps.setString(2, seller.getSellerPassword());
			ps.setString(3, seller.getSellerQQ());
			ps.setString(4, seller.getSellerLogo());
			ps.setString(5, seller.getSellerTitle());
			ps.setString(6, seller.getSellerTitle());
			ps.setLong(7, 0);
			result=ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return result;
	}
}
