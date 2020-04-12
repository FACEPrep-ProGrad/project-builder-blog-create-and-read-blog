package dao;

import java.util.List;

import model.Blog;

/*
1.Create an interface called BlogDaoInterface inside the dao package with the following methods,
◦void insertBlog(Blog blog)
◦List selectAllBlogs()
*/
 public interface BlogDaoInterface{
	 void insertBlog(Blog blog) throws Exception;
	 List<Blog> selectAllBlogs() throws Exception;
 }