package com.muaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	
	public static boolean login(String username,String password) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");
			PraperedStatement ps=con.prepareStatement("select*from user where username=? and passwprd=?");
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs!=null && rs.next()) {
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}

}
