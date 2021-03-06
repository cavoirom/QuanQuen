package quanquen.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.text.DateFormatter;

public class Place implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8041524166672529186L;
	private int id;
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
	private Date postedDate = new Date();
	private Date lastUpdate = new Date();
	private LinkedList<Image> images;
	private LinkedHashSet<Member> membersLikeThis;
	private String announcement;
	private LinkedHashSet<Member> managers;
	private boolean isBlock;
	private int numberOfVisited;
	private LinkedHashSet<Article> articles;

	public Place() {
		this.images = new LinkedList<Image>();
		this.membersLikeThis = new LinkedHashSet<Member>();
		this.articles = new LinkedHashSet<Article>();
		this.categories = new LinkedHashSet<Category>();
	}

	public Place(int placeid) {
		this.images = new LinkedList<Image>();
		this.membersLikeThis = new LinkedHashSet<Member>();
		this.articles = new LinkedHashSet<Article>();
		this.categories = new LinkedHashSet<Category>();
		this.id = placeid;
	}

	public Place(String name, Address address,
			LinkedHashSet<Category> categories, LinkedHashSet<Member> managers) {
		this.name = name;
		this.address = address;
		this.categories = categories;
		this.managers = managers;
		this.postedDate = new Date();
		this.lastUpdate = new Date();
		this.images = new LinkedList<Image>();
		this.membersLikeThis = new LinkedHashSet<Member>();
		this.isBlock = false;
		this.numberOfVisited = 0;
		this.articles = new LinkedHashSet<Article>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return (map == null) ? "images/map/default.jpg" : map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public String getTel() {
		return (tel == null) ? "Không có" : tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return (fax == null) ? "Không có" : fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return (email == null) ? "Không có" : email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return (website == null) ? "Không có" : website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPrice() {
		return (price == null) ? "Không rõ" : price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCheckoutMethod() {
		return (checkoutMethod == null) ? "Tiền mặt" : checkoutMethod;
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

	public String getPostedDateString() {
		SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		return fm.format(postedDate);
	}
	
	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public Date getLastUpdate() {
		return (lastUpdate == null) ? postedDate : lastUpdate;
	}
	
	public String getLastUpdateString(){
		SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		if (lastUpdate == null){
			lastUpdate = postedDate;
		}
		return fm.format(lastUpdate);
	}
	
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public LinkedList<Image> getImages() {
		if (this.images == null || this.images.size() < 1) {
			this.images = new LinkedList<Image>();
			Image img = new Image("images/place/default.jpg", "Chưa có hình");
			this.images.add(img);
		}
		return this.images;
	}

	public void setImages(LinkedList<Image> images) {
		this.images = images;
	}

	public void addImage(Image image) {
		this.images.add(image);
	}

	public LinkedHashSet<Member> getMembersLikeThis() {
		return (membersLikeThis == null) ? new LinkedHashSet<Member>()
				: membersLikeThis;
	}

	public void setMembersLikeThis(LinkedHashSet<Member> membersLikeThis) {
		this.membersLikeThis = membersLikeThis;
	}

	public String getAnnouncement() {
		return (announcement == null) ? "" : announcement;
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

	public Image getRandom(){
		Random ran = new Random();
		return images.get(ran.nextInt(images.size()));
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Place) {
			Place that = (Place) obj;
			if (this.id == that.id) {
				return true;
			}
		}
		return false;
	}
}
