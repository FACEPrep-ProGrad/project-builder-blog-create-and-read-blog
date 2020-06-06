package dao;

import java.sql.SQLException;
import java.util.List;

import model.Blog;

interface BlogDaoInterface{
	
	void insertBlog(Blog blog) throws ClassNotFoundException, SQLException;
	List<Blog> selectAllBlogs() throws ClassNotFoundException, SQLException;
}