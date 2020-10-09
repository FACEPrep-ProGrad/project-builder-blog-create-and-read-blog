package dao;
/*
1.Create a dao-class called BlogDaoImpl inside the dao package.
2.It should implement the BlogDaoInterface.
3.Implement the following methods,
◦void insertBlog(Blog blog) - method to insert the blog into the database.
◦List selectAllBlogs() - method to retrieve the blogs from the database.
*/

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface {
	List<Blog> blogslist=new ArrayList<Blog>();
	Connection con;
	@Override
	public void insertBlog(Blog blog) throws Exception {
		con=ConnectionManager.getConnection();
		Statement statement=con.createStatement();
		statement.executeUpdate("INSERT INTO blog VALUES("+blog.getBlogId()+",'"+blog.getBlogTitle()+"','"+blog.getBlogDescription()+"',"+blog.getPostedOn()+")");
		System.out.println("Blog Inserted");
	}
	
	@Override
	public List<Blog> selectAllBlogs() throws Exception {
		con=ConnectionManager.getConnection();
		Statement statement=con.createStatement();
		ResultSet resultset=statement.executeQuery("SELECT * FROM blog");
		while(resultset.next()) {
			Blog blog=new Blog();
			blog.setBlogId(resultset.getInt("id"));
			blog.setBlogTitle(resultset.getString("title"));
			blog.setBlogDescription(resultset.getString("blogdesc"));
			blog.setPostedOn(resultset.getString("postedon"));
			blogslist.add(blog);
			
		}
		return blogslist;
	}
	
}