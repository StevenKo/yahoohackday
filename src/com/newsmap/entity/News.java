package com.newsmap.entity;

public class News {
	String title;
	String source;
	String content;
	String url;
	String locationName;
	double longitude;
	double latitude;
	
	public News(String locationName, double longitude, double latitude) {
		new News("", "", "", "", locationName, longitude, latitude);
	}
	
	public News(String title, String source, String content, String url, String locationName, double longitude, double latitude) {
		this.title = title;
		this.source = source;
		this.content = content;
		this.url = url;
		this.locationName = locationName;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
}
