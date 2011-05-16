package quanquen.model;

import java.io.Serializable;

public class Image implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8217166846099523776L;
	private String url;
	private String description;

	public Image() {
	}

	public Image(String url) {
		this.url = url;
		this.description = null;
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
		return (description == null) ? "" : description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
