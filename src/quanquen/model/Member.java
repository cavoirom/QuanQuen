package quanquen.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Member implements Serializable{
	private String username;
	private String password;
	private String fullName;
	private String email;
	private Date joinedDate = new Date();
	private String website;
	private Image avatar;
	private Address address;
	private Date birthday;
	private Group group;
	private LinkedHashSet<Member> friends;
	private LinkedList<Article> articles;
	private LinkedList<Comment> comments;
	private LinkedHashSet<Place> places;
	private boolean isActive;
	
	public Member(){
		
	}
	
	public Member(String username, String password, String email, Date birthday,
			Group group, boolean isActive) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.birthday = birthday;
		this.group = group;
		this.isActive = isActive;
		
		this.fullName = null;
		this.joinedDate = new Date();
		this.website = null;
		this.avatar = new Image();
		this.address = new Address();
		this.friends = new LinkedHashSet<Member>();
		this.articles = new LinkedList<Article>();
		this.comments = new LinkedList<Comment>();
		this.places = new LinkedHashSet<Place>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Image getAvatar() {
		return avatar;
	}

	public void setAvatar(Image avatar) {
		this.avatar = avatar;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public LinkedHashSet<Member> getFriends() {
		return friends;
	}

	public void setFriends(LinkedHashSet<Member> friends) {
		this.friends = friends;
	}

	public LinkedList<Article> getArticles() {
		return articles;
	}

	public void setArticles(LinkedList<Article> articles) {
		this.articles = articles;
	}

	public LinkedList<Comment> getComments() {
		return comments;
	}

	public void setComments(LinkedList<Comment> comments) {
		this.comments = comments;
	}

	public LinkedHashSet<Place> getPlaces() {
		return places;
	}

	public void setPlaces(LinkedHashSet<Place> places) {
		this.places = places;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean equals(Object obj){
		if (obj instanceof Member){
			Member that = (Member) obj;
			if(this.username.equals(that.username)){
				return true;
			}
		}
		return false;
	}
	
}
