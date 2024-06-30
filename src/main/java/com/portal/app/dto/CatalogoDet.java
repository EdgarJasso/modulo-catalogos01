package com.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CATALOGO_DET")
public class CatalogoDet {

	@Id
	@SequenceGenerator(name = "SEQ_CATALOGO_DET", sequenceName="SEQ_CATALOGO_DET") 
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_CATALOGO_DET")
	@Column private Long	catd_id_n;
	@Column private Long	cat_id_n;
	@Column private String	catd_cve_str;
	@Column private String  catd_desc_str;
	@Column private String	catd_est_str;
	
	public Long getCatd_id_n() {
		return catd_id_n;
	}
	public void setCatd_id_n(Long catd_id_n) {
		this.catd_id_n = catd_id_n;
	}
	public Long getCat_id_n() {
		return cat_id_n;
	}
	public void setCat_id_n(Long cat_id_n) {
		this.cat_id_n = cat_id_n;
	}
	public String getCatd_cve_str() {
		return catd_cve_str;
	}
	public void setCatd_cve_str(String catd_cve_str) {
		this.catd_cve_str = catd_cve_str;
	}
	public String getCatd_desc_str() {
		return catd_desc_str;
	}
	public void setCatd_desc_str(String catd_desc_str) {
		this.catd_desc_str = catd_desc_str;
	}
	public String getCatd_est_str() {
		return catd_est_str;
	}
	public void setCatd_est_str(String catd_est_str) {
		this.catd_est_str = catd_est_str;
	}
	
	
	
}
