package com.portal.app.request;

import java.io.Serializable;

public class Request implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private Long    id;
	private Long 	usr_id_n;
	private String	usr_cve_str;
	private Long	app_id_n;
	private Long 	perf_id_n;
	private String	usr_email_str;
	private Long	menu_id_n;
	private String	menu_uid_str;
	private String 	data;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUsr_id_n() {
		return usr_id_n;
	}
	public void setUsr_id_n(Long usr_id_n) {
		this.usr_id_n = usr_id_n;
	}
	public String getUsr_cve_str() {
		return usr_cve_str;
	}
	public void setUsr_cve_str(String usr_cve_str) {
		this.usr_cve_str = usr_cve_str;
	}
	public Long getApp_id_n() {
		return app_id_n;
	}
	public void setApp_id_n(Long app_id_n) {
		this.app_id_n = app_id_n;
	}
	public Long getPerf_id_n() {
		return perf_id_n;
	}
	public void setPerf_id_n(Long perf_id_n) {
		this.perf_id_n = perf_id_n;
	}
	public String getUsr_email_str() {
		return usr_email_str;
	}
	public void setUsr_email_str(String usr_email_str) {
		this.usr_email_str = usr_email_str;
	}
	public Long getMenu_id_n() {
		return menu_id_n;
	}
	public void setMenu_id_n(Long menu_id_n) {
		this.menu_id_n = menu_id_n;
	}
	public String getMenu_uid_str() {
		return menu_uid_str;
	}
	public void setMenu_uid_str(String menu_uid_str) {
		this.menu_uid_str = menu_uid_str;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
