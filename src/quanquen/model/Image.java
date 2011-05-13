package quanquen.model;

import java.io.Serializable;

public class Image implements Serializable{
	private String url;
	private String description;
	
	public Image(String url) {
		this.url = url;
		this.description = null;
	}

	public Image() {
	}

	public Image(String url, String description) {
		super();
		this.url = url;
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
