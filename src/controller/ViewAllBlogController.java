package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dao.BlogDaoImpl;
import model.Blog;

// View Blog Servlet controller 
@WebServlet(urlPatterns = {"/allblogs"})
public class ViewAllBlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("View All Blogs");
		System.out.println("Getting all blog post");
		BlogDaoImpl blogDAO = new BlogDaoImpl();
		List<Blog> listBlog;
		try {
			listBlog = blogDAO.selectAllBlogs();
			for(Blog bloglist:listBlog) {
				System.out.print(bloglist.getBlogId()+"		");
				System.out.print(bloglist.getBlogTitle()+"		");
				System.out.print(bloglist.getBlogDescription()+"		");
				System.out.print(bloglist.getPostedOn());
				System.out.println();
			}
			request.setAttribute("listBlog", listBlog);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
