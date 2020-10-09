package model;

import java.time.LocalDate;

/*
1.Create a model class called as `Blog' inside the model package with the following arguments,
◦int blogId - String blogTitle; - String blogDescription; - LocalDate postedOn;
2.Include appropriate getters and setters method.
*/

public class Blog{
	int blogId;
	String blogTitle;
	String blogDescription;
	String postedOn;
	
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
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
	public String getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(String postedOn) {
		this.postedOn = postedOn;
	}
}