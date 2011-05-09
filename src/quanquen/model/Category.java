package quanquen.model;

import java.util.LinkedHashSet;

public class Category {
	private String title;
	private LinkedHashSet<Place> places;
	public Category(String title) {
		this.title = title;
		
		this.places = new LinkedHashSet<Place>();
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LinkedHashSet<Place> getPlaces() {
		return places;
	}
	public void setPlaces(LinkedHashSet<Place> places) {
		this.places = places;
	}
	public void addPlace(Place place) {
		this.places.add(place);
	}
	
}