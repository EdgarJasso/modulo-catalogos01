package com.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CATALOGO")
public class Catalogo {

	@Id
	@SequenceGenerator(name = "SEQ_CATALOGO", sequenceName="SEQ_CATALOGO") 
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_CATALOGO")
	@Column private Long	cat_id_n;
	@Column private String  cat_desc_str;
	@Column private String	cat_est_str;
	
	public Long getCat_id_n() {
		return cat_id_n;
	}
	public void setCat_id_n(Long cat_id_n) {
		this.cat_id_n = cat_id_n;
	}
	public String getCat_desc_str() {
		return cat_desc_str;
	}
	public void setCat_desc_str(String cat_desc_str) {
		this.cat_desc_str = cat_desc_str;
	}
	public String getCat_est_str() {
		return cat_est_str;
	}
	public void setCat_est_str(String cat_est_str) {
		this.cat_est_str = cat_est_str;
	}
	
	
}
