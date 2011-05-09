package quanquen.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Place {
	private String name;
	private Address address;
	private String map;
	private String tel;
	private String fax;
	private String email;
	private String website;
	private String price;
	private String checkoutMethod;
	private LinkedHashSet<Category> categories;
	private Date postedDate;
	private Date lastUpdate;
	private LinkedList<Image> images;
	private LinkedHashSet<Member> membersLikeThis;
	private String announcement;
	private LinkedHashSet<Member> managers;
	private boolean isBlock;
	private int numberOfVisited;
	private LinkedHashSet<Article> articles;
	
	public Place(String name, Address address,
			LinkedHashSet<Category> categories, LinkedHashSet<Member> managers) {
		this.name = name;
		this.address = address;
		this.categories = categories;
		this.managers = managers;
		
		this.map = null;
		this.tel = null;
		this.fax = null;
		this.email = null;
		this.website = null;
		this.price = null;
		this.checkoutMethod = null;
		this.postedDate = new Date();
		this.lastUpdate = new Date();
		this.images = new LinkedList<Image>();
		this.membersLikeThis = new LinkedHashSet<Member>();
		this.announcement = null;
		this.isBlock = false;
		this.numberOfVisited = 0;
		this.articles = new LinkedHashSet<Article>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCheckoutMethod() {
		return checkoutMethod;
	}

	public void setCheckoutMethod(String checkoutMethod) {
		this.checkoutMethod = checkoutMethod;
	}

	public LinkedHashSet<Category> getCategories() {
		return categories;
	}

	public void setCategories(LinkedHashSet<Category> categories) {
		this.categories = categories;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public LinkedList<Image> getImages() {
		return images;
	}

	public void setImages(LinkedList<Image> images) {
		this.images = images;
	}
	
	public void addImage(Image image) {
		this.images.add(image);
	}

	public LinkedHashSet<Member> getMembersLikeThis() {
		return membersLikeThis;
	}

	public void setMembersLikeThis(LinkedHashSet<Member> membersLikeThis) {
		this.membersLikeThis = membersLikeThis;
	}

	public String getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

	public LinkedHashSet<Member> getManagers() {
		return managers;
	}

	public void setManagers(LinkedHashSet<Member> managers) {
		this.managers = managers;
	}

	public boolean isBlock() {
		return isBlock;
	}

	public void setBlock(boolean isBlock) {
		this.isBlock = isBlock;
	}

	public int getNumberOfVisited() {
		return numberOfVisited;
	}

	public void setNumberOfVisited(int numberOfVisited) {
		this.numberOfVisited = numberOfVisited;
	}

	public LinkedHashSet<Article> getArticles() {
		return articles;
	}

	public void setArticles(LinkedHashSet<Article> articles) {
		this.articles = articles;
	}
	
}
