package quanquen.bussinessaccess;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

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
	
	public List<Place> getByDescVisistor() {
		List<Place> places = new ArrayList<Place>();
		pm = Connection.getPersistenceManager();
		Query query = pm.newQuery(Place.class);
		query.setOrdering("this.numberOfVisited DESCENDING");
		query.setRange(0, 7);
		places = (List<Place>) query.execute();
		pm.close();
		return places;
	}
	
	public List<Place> getByDescVisistor(Category category) {
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
	
	public void addVisistor(Place place){
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
			edit.setNumberOfVisited(++number);
		tx.commit();
		pm.close();
	}
	
	public List<Place> getPlacesByAuthor(Member author) {
		List<Place> places = new ArrayList<Place>();
		pm = Connection.getPersistenceManager();
		Query query = pm.newQuery(Place.class);
		query.declareParameters("Member author");
		query.setFilter("this.managers.contains(author)");
		places = (List<Place>) query.execute(author);
		pm.close();
		return places;
	}

	@SuppressWarnings("unchecked")
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

	public List<Place> getPlacesByCategory(Category category) {
		List<Place> places = new ArrayList<Place>();
		pm = Connection.getPersistenceManager();
		Query query = pm.newQuery(Place.class);
		query.declareParameters("Category category");
		query.setFilter("this.categories.contains(category)");
		places = (List<Place>) query.execute(category);
		pm.close();
		return places;
	}
	
	public List<Place> getPlacesByCategory(String category, int page) {
		List<Place> places = new ArrayList<Place>();
		pm = Connection.getPersistenceManager();
		Query query = pm.newQuery(Place.class);
		query.declareParameters("String category");
		query.setFilter("this.categories.contains(category)");
		places = (List<Place>) query.execute(category);
		pm.close();
		return places;
	}

	public List<Place> getPlaces(String type, String searchvalue) {
		pm = Connection.getPersistenceManager();
		List<Place> places = new ArrayList<Place>();
		Query query = pm.newQuery(Place.class);
		if (type.equals("address"))
		query.setRange(0, 20);
		places = (List<Place>)query.execute();
		pm.close();
		return places;
	}

	public static void main(String[] args) {
		
	}

	private void addFilter(StringBuilder filter, String field, String value, String type) {
		if (value != null) {
			filter.append(" " + type + " " + field + " == '" + value + "'");
		}
	}
}
