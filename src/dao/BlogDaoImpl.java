package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface{

	// method to insert the blog into the database.
	@Override
	public void insertBlog(Blog blog) throws ClassNotFoundException, SQLException {
		
		int blogid=blog.getBlogId();
		String blogtitle=blog.getBlogTitle();
		String blogdescription=blog.getBlogDescription();
		LocalDate postedon1=blog.getPostedOn();
		
		// inserting details into database
		
	String sql="insert into blog(blogid,blogtitle,blogdescription,postedon)values(?,?,?,?)";
	// creating statement object
	PreparedStatement st=ConnectionManager.getConnection().prepareStatement(sql);
		
	java.sql.Date postedon=java.sql.Date.valueOf(postedon1);
	
	st.setInt(1, blogid);
	st.setString(2, blogtitle);
	st.setString(3, blogdescription);
	st.setDate(4,postedon);
	st.executeUpdate();
	ConnectionManager.getConnection().close();
	}
// method to retrieve the blogs from the database.
	@Override
	public List<Blog> selectAllBlogs() throws ClassNotFoundException, SQLException {
		
		String sql="select * from blog";
		
		PreparedStatement st=ConnectionManager.getConnection().prepareStatement(sql);
		
		ResultSet rs=st.executeQuery();
		
		while(rs.next()) {
		int blogid=rs.getInt(1);
		String blogtitle=rs.getString(2);
		String blogdescription=rs.getString(3);
		Date postedon=rs.getDate(4);
		System.out.println("Blog id:"+blogid);
		System.out.println("Blog title:"+blogtitle);
		System.out.println("Blog description:"+blogdescription);
		System.out.println("Blog postedon:"+postedon);
		}
		return null;
	}
	
}