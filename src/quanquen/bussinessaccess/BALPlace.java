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
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		tx.setNontransactionalRead(true);
		tx.setNontransactionalWrite(true);
		tx.begin();
		pm.setDetachAllOnCommit(true);
		Query query = pm.newQuery(Place.class);
		query.setOrdering("this.numberOfVisited DESCENDING");
		query.setRange(0, 7);
		places = (List<Place>) query.execute();
		tx.commit();
		pm.close();
		return places;
	}
	//OK
	public List<Place> getPlacesByDateDesc(){
		List<Place> places = new ArrayList<Place>();
		pm = Connection.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		tx.setNontransactionalRead(true);
		tx.setNontransactionalWrite(true);
		tx.begin();
		pm.setDetachAllOnCommit(true);
		Query query = pm.newQuery(Place.class);
		query.setOrdering("this.postedDate DESCENDING");
		query.setRange(0, 5);
		places = (List<Place>) query.execute();
		tx.commit();
		pm.close();
		return places;
	}
	//OK
	public List<Place> getPlacesByVisistorDesc(Category category) {
		List<Place> places = new ArrayList<Place>();
		pm = Connection.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		tx.setNontransactionalRead(true);
		tx.setNontransactionalWrite(true);
		tx.begin();
		Query query = pm.newQuery(Place.class);
		query.declareParameters("Category category");
		query.setFilter("this.categories.contains(category)");
		query.setOrdering("this.numberOfVisited DESCENDING");
		query.setRange(0, 7);
		places = (List<Place>) query.execute(category);
		tx.commit();
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
		pm.setDetachAllOnCommit(true);
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
	public List<Place> getPlacesByAuthor(String username, String filter, int page) {
		List<Place> places = new ArrayList<Place>();
		pm = Connection.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		tx.setNontransactionalRead(true);
		tx.setNontransactionalWrite(true);
		tx.begin();
		Query query = pm.newQuery(Place.class);
		query.declareVariables("Member member");
		query.setFilter("(this.managers.contains(member) && member.username.matches('(?i).*" + username + ".*'))" + filter);
		query.setRange((page - 1) * numberResult, numberResult);
		places = (List<Place>) query.execute();
		tx.commit();
		pm.close();
		return places;
	}

	//OK
	public List<Place> getPlacesByCategory(String title, String filter, int page) {
		List<Place> places = new ArrayList<Place>();
		pm = Connection.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		tx.setNontransactionalRead(true);
		tx.setNontransactionalWrite(true);
		tx.begin();
		Query query = pm.newQuery(Place.class);
		query.declareVariables("Category category");
		query.setFilter("(this.categories.contains(category) && category.title.matches('(?i).*" + title + ".*'))" + filter);
		query.setRange((page - 1) * numberResult, numberResult);
		places = (List<Place>) query.execute();
		tx.commit();
		pm.close();
		return places;
	}
	
	public List<Place> getPlacesByTypes(String type, String searchvalue, String address, int page) {
		pm = Connection.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		tx.setNontransactionalRead(true);
		tx.setNontransactionalWrite(true);
		tx.begin();
		List<Place> places = new ArrayList<Place>();
		Query query = pm.newQuery(Place.class);
		query.setRange(0, 20);
		//Pass
		if(type.equals("name") || type.equals("price")){
			query.setFilter("this." + type + ".matches('(?i).*" + searchvalue + ".*')" + filterAddress(address));
			places = (List<Place>)query.execute();
		}
		if (type.equals("category")){
			places = getPlacesByCategory(searchvalue, filterAddress(address), page);
		}
		if (type.equals("author")){
			places = getPlacesByAuthor(searchvalue, filterAddress(address), page);
		}
		tx.commit();
		pm.close();
		return places;
	}
	
	public List<Integer> getListIdPlaceByAddress(String province, String district){
		pm = Connection.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		tx.setNontransactionalRead(true);
		tx.setNontransactionalWrite(true);
		tx.begin();
		Query query = pm.newQuery(Place.class);
		query.setFilter(getFilter("province", province) + addFilter("&&","district", district));
		query.setResult("this.id");
		List<Integer> placesId = (List<Integer>)query.execute();
		tx.commit();
		pm.close();
		return placesId;
	}
	
	public List<Place> getPlacesByCategoryAddress(String province, String district, String category, int page){
		return getPlacesByCategory(category, addFilter("&&", "province", province) + addFilter("&&", "district", district), page);
	}
	
	private String addFilter(String rel, String type, String filter){
		if (filter == null || filter.equals("")){
			return "";
		}
		return " " + rel + " this.address." + type + ".matches('(?i).*" + filter + ".*')";
	}
	
	private String getFilter(String type, String filter){
		return "this.address." + type + ".matches('(?i).*" + filter + ".*')";
	}
	
	private String filterAddress(String address){
		if (address == null || address.equals(""))
			return "";
		return " && (this.address.province.matches('(?i).*" + address + ".*')" + " || this.address.district.matches('(?i).*" + address + ".*')" + " || this.address.street.matches('(?i).*" + address + ".*')" + " || this.address.houseNumber.matches('(?i).*" + address + ".*'))";
	}

	//Pass
	public Place getPlaceByID(int id) {
		pm = Connection.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		tx.setNontransactionalRead(true);
		tx.setNontransactionalWrite(true);
		tx.begin();
		Place place = null;
		Query query = pm.newQuery(Place.class);
		query.declareParameters("int id");
		query.setFilter("this.id == id");
		query.setRange(0,1);
		List<Place> places = (List<Place>)query.execute(id);
		if (places.size()>0){
			place = places.get(0);
		}
		tx.commit();
		pm.close();
		return place;
	}

	public Place getPlacesByArticleId(int id) {
		List<Place> places;
		Article article = new Article(id);
		pm = Connection.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		tx.setNontransactionalRead(true);
		tx.setNontransactionalWrite(true);
		tx.begin();
		Query query = pm.newQuery(Place.class);
		query.declareVariables("Article article");
		query.setFilter("this.articles.contains(article) && article.id==id");
		places = (List<Place>) query.execute(id);
		Place place = places.get(0);
		tx.commit();
		pm.close();
		return place;
	}
	
	//Pass -->Tested
	public Place getPlaceAndUpdateNumber(Place place){
		pm = Connection.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		tx.setNontransactionalRead(true);
		tx.setNontransactionalWrite(true);
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
		return edit;
	}
	
	//Pass -->Tested
	public Place getPlaceAndUpdateNumber(int id){
		Place place = new Place(id);
		return getPlaceAndUpdateNumber(place);
	}
	
	public List<Place> getPlacesByListArticleId(List<Integer> ids){
		List<Place> places = new ArrayList<Place>();
		pm = Connection.getPersistenceManager();
		pm.setDetachAllOnCommit(true);
		Transaction tx = pm.currentTransaction();
		tx.setNontransactionalRead(true);
		tx.setNontransactionalWrite(true);
		tx.begin();
		Query query = pm.newQuery(Place.class);
		query.declareParameters("Integer id");
		query.declareVariables("Article articleIn");
		query.setFilter("this.articles.contains(articleIn) && articleIn.id==id");
		query.setRange(0, 1);
		for (Integer id: ids){
			List<Place> pls = (List<Place>) query.execute(id);
			places.addAll(pls);
		}
		tx.commit();
		pm.close();
		return places;
	}
	public static void main(String[] args) {
		System.out.println(new BALPlace().getListIdPlaceByAddress("Hồ chí minh", "Thủ đức").size());
	}
}
