package quanquen.model;

import java.util.Date;

public class Comment {
	private Member author;
	private Date postedDate = new Date();
	private String content;
	
	public Comment(Member author, Date postedDate, String content) {
		super();
		this.author = author;
		this.postedDate = postedDate;
		this.content = content;
	}

	public Member getAuthor() {
		return author;
	}

	public void setAuthor(Member author) {
		this.author = author;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
