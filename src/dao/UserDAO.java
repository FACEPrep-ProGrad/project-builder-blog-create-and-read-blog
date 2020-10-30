package dao;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;

import utility.ConnectionManager;
import model.User;

public class UserDAO implements UserDaoInterface{

	@Override
	public int signUp(User user) throws ClassNotFoundException, SQLException, IOException {
		String email = user.getEmail();
		String password = user.getPassword();
		LocalDate date = user.getDate();
		
		ConnectionManager cm = new ConnectionManager();
		// insert all the details into database
		
		String sql = "insert into USERINFO(email, password, signupdate) VALUES(?,?,?)";
		
		//CREATE STATEMENT OBJECT
		
		PreparedStatement st = cm.getConnection().prepareStatement(sql);
		
		st.setString(1 , password);
		st.setString(2 , email);
		st.setDate(3 , Date.valueOf(date));
		
		st.executeUpdate();
		cm.getConnection().close();
		return 0;
	}

	@Override
	public boolean loginUser(User user) throws ClassNotFoundException, SQLException, IOException {
		String email = user.getEmail();
		String password = user.getPassword();
		
		ConnectionManager con = new ConnectionManager();
		Statement st = con.getConnection().createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * from USERINFO");
		
		while(rs.next()) {
			System.out.println("user : Email => " + email + "   password => " + password);
			System.out.println("database : Email => " + rs.getString("EMAIL") + "   password => " + rs.getString("PASSWORD"));

			if(email.equals(rs.getString("EMAIL")) && password.equals(rs.getString("PASSWORD"))) {
				System.out.println("Login successFully");
				con.getConnection().close();
				return true;
			}
			else {
				System.out.println("Not Login successFully");

				con.getConnection().close();
				return false;
			}
		}
		
		return false;
	}
	
}
