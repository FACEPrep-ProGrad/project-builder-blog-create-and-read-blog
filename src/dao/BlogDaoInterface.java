package dao;

import java.sql.SQLException;
import java.util.List;

import model.Blog;

 public interface BlogDaoInterface
{
	public void insertBlog(Blog blog);
	
	public List selectAllBlogs();
	
}