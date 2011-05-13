package quanquen.model;

import java.io.Serializable;
import java.util.LinkedHashSet;

public class Category implements Serializable{
	private int id;
	private String title;
	private LinkedHashSet<Place> places;
	public Category(String title) {
		this.title = title;
		
		this.places = new LinkedHashSet<Place>();
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
	public LinkedHashSet<Place> getPlaces() {
		return places;
	}
	public void setPlaces(LinkedHashSet<Place> places) {
		this.places = places;
	}
	public void addPlace(Place place) {
		this.places.add(place);
	}
	public boolean equals(Object obj){
		if (obj instanceof Category){
			Category that = (Category) obj;
			if(this.title.equals(that.title)){
				return true;
			}
		}
		return false;
	}
}
