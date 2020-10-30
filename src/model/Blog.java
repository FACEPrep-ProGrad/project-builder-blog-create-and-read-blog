package model;

import java.time.LocalDate;

public class Blog{
	private String blogTitle;
	private String blogDescription;
	private LocalDate postedOn;
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogDescription() {
		return blogDescription;
	}
	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}
	public LocalDate getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(LocalDate postedOn) {
		this.postedOn = postedOn;
	}
	
	public Blog() {
		
	}
	
	public Blog(String blogTitle, String blogDescription, LocalDate postedOn) {
		super();
		this.blogTitle = blogTitle;
		this.blogDescription = blogDescription;
		this.postedOn = postedOn;
	}
	
	
}