package quanquen.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Article implements Serializable{
	private int id;
	private String title;
	private Member author;
	private Date postedDate = new Date();
	private String content;
	private LinkedHashSet<Member> membersLikeThis;
	private LinkedList<Comment> comments;
	private int pageViews;
	
	public Article(String title, Member author, Date postedDate, String content) {
		this.title = title;
		this.author = author;
		this.postedDate = postedDate;
		this.content = content;
		
		this.membersLikeThis = new LinkedHashSet<Member>();
		this.comments = new LinkedList<Comment>();
		this.pageViews = 0;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public LinkedHashSet<Member> getMembersLikeThis() {
		return membersLikeThis;
	}

	public void setMembersLikeThis(LinkedHashSet<Member> membersLikeThis) {
		this.membersLikeThis = membersLikeThis;
	}

	public LinkedList<Comment> getComments() {
		return comments;
	}

	public void setComments(LinkedList<Comment> comments) {
		this.comments = comments;
	}

	public int getPageViews() {
		return pageViews;
	}

	public void setPageViews(int pageViews) {
		this.pageViews = pageViews;
	}
	
	public boolean equals(Object obj){
		if (obj instanceof Article){
			Article that = (Article) obj;
			if(this.id == that.id){
				return true;
			}
		}
		return false;
	}
	
}
