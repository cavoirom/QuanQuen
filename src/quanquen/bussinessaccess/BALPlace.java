package quanquen.bussinessaccess;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import quanquen.model.Article;
import quanquen.model.Category;
import quanquen.model.Member;
import quanquen.model.Place;

public class BALPlace {
	private static PersistenceManager pm;
	private int numberResult = 20;

	public BALPlace() {
	}

	public BALPlace(int numberResult) {
		this.numberResult = numberResult;
	}
	//OK
	public List<Place> getPlacesByVisistorDesc() {
		List<Place> places = new ArrayList<Place>();
		pm = Connection.getPersistenceManager();
		Query query = pm.newQuery(Place.class);
		query.setOrdering("this.numberOfVisited DESCENDING");
		query.setRange(0, 7);
		places = (List<Place>) query.execute();
		pm.close();
		return places;
	}
	//OK
	public List<Place> getPlacesByDateDesc(){
		List<Place> places = new ArrayList<Place>();
		pm = Connection.getPersistenceManager();
		Query query = pm.newQuery(Place.class);
		query.setOrdering("this.postedDate DESCENDING");
		query.setRange(0, 7);
		places = (List<Place>) query.execute();
		pm.close();
		return places;
	}
	//OK
	public List<Place> getPlacesByVisistorDesc(Category category) {
		List<Place> places = new ArrayList<Place>();
		pm = Connection.getPersistenceManager();
		Query query = pm.newQuery(Place.class);
		query.declareParameters("Category category");
		query.setFilter("this.categories.contains(category)");
		query.setOrdering("this.numberOfVisited DESCENDING");
		query.setRange(0, 7);
		places = (List<Place>) query.execute(category);
		pm.close();
		return places;
	}
	//OK
	public List<Place> getPlacesByVisistorDesc(int id) {
		Category category = new Category(id);
		return getPlacesByVisistorDesc(category);
	}
	//OK
	public void updateNumberVisisted(Place place){
		pm = Connection.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.begin();
			Query query = pm.newQuery(Place.class);
			query.declareParameters("Place place");
			query.setFilter("this.id == place.id");
			query.setRange(0, 1);
			List<Place> places = (List<Place>)query.execute(place);
			Place edit = places.get(0);
			int number = edit.getNumberOfVisited();
			number++;
			edit.setNumberOfVisited(number);
		tx.commit();
		pm.close();
	}
	//Pass
	public void updateNumberVisisted(int id){
		Place place = new Place(id);
		updateNumberVisisted(place);
	}
	//OK
	public List<Place> getPlacesByAuthor(Member author, int page) {
		List<Place> places = new ArrayList<Place>();
		pm = Connection.getPersistenceManager();
		Query query = pm.newQuery(Place.class);
		query.declareParameters("Member author");
		query.setFilter("this.managers.contains(author)");
		query.setRange((page - 1) * numberResult, numberResult);
		places = (List<Place>) query.execute(author);
		pm.close();
		return places;
	}
	//OK
	public List<Place> getPlacesByAuthor(String username, int page){
		Member author = new Member(username);
		return getPlacesByAuthor(author, page);
	}
	//OK
	public List<Place> getPlacesByCategory(Category category, int page) {
		List<Place> places = new ArrayList<Place>();
		pm = Connection.getPersistenceManager();
		Query query = pm.newQuery(Place.class);
		query.declareParameters("Category category");
		query.setFilter("this.categories.contains(category)");
		query.setRange((page - 1) * numberResult, numberResult);
		places = (List<Place>) query.execute(category);
		pm.close();
		return places;
	}
	//OK
	public List<Place> getPlacesByCategory(int id, int page) {
		Category category = new Category(id);
		return getPlacesByCategory(category, page);
	}
	
	public List<Place> getPlacesByTypes(String type, String searchvalue, int page) {
		pm = Connection.getPersistenceManager();
		List<Place> places = new ArrayList<Place>();
		Query query = pm.newQuery(Place.class);
		query.setRange(0, 20);
		//Pass
		if(type.equals("name") || type.equals("price")){
			query.declareParameters("String " + type);
			query.setFilter("this." + type +".matches('(?i).*" + searchvalue + ".*')");
			places = (List<Place>)query.execute(searchvalue);
		}
//		if (type.equals("category")){
//			places = getPlacesByCategory(searchvalue, page);
//		}
		if (type.equals("author")){
			Member member = new Member();
			member.setUsername(searchvalue);
			places = getPlacesByAuthor(member, page);
		}
		pm.close();
		return places;
	}

	//Pass
	public Place getPlaceByID(int id) {
		pm = Connection.getPersistenceManager();
		Place place = null;
		Query query = pm.newQuery(Place.class);
		query.declareParameters("int id");
		query.setFilter("this.id == id");
		query.setRange(0,1);
		List<Place> places = (List<Place>)query.execute(id);
		if (places.size()>0){
			place = places.get(0);
		}
		pm.close();
		return place;
	}
	
	public static void main(String[] args) {
		String value = "phong";
		String names = "name";
		new BALPlace().updateNumberVisisted(1);
	}

	public Place getPlacesByArticleId(int id) {
		List<Place> places;
		Article article = new Article(id);
		pm = Connection.getPersistenceManager();
		Query query = pm.newQuery(Place.class);
		query.declareParameters("Article article");
		query.setFilter("this.articles.contains(article)");
		places = (List<Place>) query.execute(article);
		Place place = places.get(0);
		pm.close();
		return place;
	}
}
