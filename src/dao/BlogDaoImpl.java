package dao;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface{

	@Override
	public void insertBlog(Blog blog) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		String blogTitle = blog.getBlogTitle();
		String blogDescription = blog.getBlogDescription();
		LocalDate postedOn = blog.getPostedOn();
		
		ConnectionManager cm = new ConnectionManager();
		// insert all the details into database
		
		String sql = "insert into BLOG(blogtitle, blogdescription, postedon) VALUES(?,?,?)";
		
		//CREATE STATEMENT OBJECT
		
		PreparedStatement st = cm.getConnection().prepareStatement(sql);
		
		st.setString(1 , blogTitle);
		st.setString(2 , blogDescription);
		st.setDate(3 , Date.valueOf(postedOn));
		
		st.executeUpdate();
		cm.getConnection().close();
		
	}

	@Override
	public List<Blog> selectAllBlogs() throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		
		List<Blog> blogList = new ArrayList<Blog>();
		
		ConnectionManager connectionManager = new ConnectionManager();
		Statement st = connectionManager.getConnection().createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM BLOG");
		
		while(rs.next()) {
			
			String blogTitle = rs.getString("blogtitle");
			String blogDescription = rs.getString("blogdescription");
			LocalDate postedOn = rs.getDate("postedOn").toLocalDate();
						
			Blog blog = new Blog(blogTitle, blogDescription, postedOn);
						
			blogList.add(blog);
			connectionManager.getConnection().close();
			
			}
			
		return blogList;
	}
	
}