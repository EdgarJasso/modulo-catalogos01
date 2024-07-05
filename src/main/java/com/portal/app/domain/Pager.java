package com.portal.app.domain;

public class Pager 
{
	private boolean 	cache;
	private String  	contentType;
	private PagerData	data;
	
	public boolean isCache() {
		return cache;
	}
	public void setCache(boolean cache) {
		this.cache = cache;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public PagerData getData() {
		return data;
	}
	public void setData(PagerData data) {
		this.data = data;
	}
}
