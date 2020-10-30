package dao;

import java.io.IOException;
import java.sql.SQLException;

import model.User;

public interface UserDaoInterface{
	int signUp(User user) throws ClassNotFoundException, SQLException, IOException;
	boolean loginUser(User user) throws ClassNotFoundException, SQLException, IOException ;
}
