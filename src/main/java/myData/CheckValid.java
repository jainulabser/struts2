package myData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckValid {
	private String name;
	private String mail;
	private String password;

	CheckValid(String name,String mail,String password)
	{
		this.name=name;
		this.mail=mail;
		this.password=password;
		System.out.println(name+" "+mail+" "+password);
	}

	public String valid() {
		// TODO Auto-generated method stub
		String result = null;
		String insertSql, checkSql;
		int flag=1;
		Connection con = null;
		try {
			String URL = "jdbc:mysql://localhost:3306/data?autoReconnect=true&useSSL=false";
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         con = DriverManager.getConnection(URL, "root", "welcome123");
			checkSql = "SELECT name from userregister where mail=?";
			PreparedStatement ps1 = con.prepareStatement(checkSql);
			ps1.setString(1, mail);
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				return "error";
			}
			insertSql = "insert into userregister(name,mail,password) values (?,?,?)";
			PreparedStatement ps2 = con.prepareStatement(insertSql);
			ps2.setString(1, name);
			ps2.setString(2, mail);
			ps2.setString(3, password);
			flag=ps2.executeUpdate();
			if (flag==1) {
				System.out.println("if");
				return "success";
			}
		} catch (Exception e) {
			System.out.println("inside catch");
			e.printStackTrace();
			return "error";
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("outside");
		return "error";


	}

}
