package quanquen.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3276678424933749112L;
	private int id;
	private Member author;
	private Date postedDate = new Date();
	private String content;

	public Comment() {
	}

	public Comment(int id) {
		this.id = id;
	}

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
	
	public String getPostedDateString(){
		SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		return fm.format(postedDate);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
