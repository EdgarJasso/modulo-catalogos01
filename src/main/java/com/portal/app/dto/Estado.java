package com.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ESTADO")
public class Estado {

	@Id
	@Column private Long	edo_id_n;
	@Column private String  edo_desc_str;
	@Column private String  edo_cve_str;
	@Column private Long  pais_id_n;
	@Column private String  c_estado;
	
	public Long getEdo_id_n() {
		return edo_id_n;
	}
	public void setEdo_id_n(Long edo_id_n) {
		this.edo_id_n = edo_id_n;
	}
	public String getEdo_desc_str() {
		return edo_desc_str;
	}
	public void setEdo_desc_str(String edo_desc_str) {
		this.edo_desc_str = edo_desc_str;
	}
	public String getEdo_cve_str() {
		return edo_cve_str;
	}
	public void setEdo_cve_str(String edo_cve_str) {
		this.edo_cve_str = edo_cve_str;
	}
	public Long getPais_id_n() {
		return pais_id_n;
	}
	public void setPais_id_n(Long pais_id_n) {
		this.pais_id_n = pais_id_n;
	}
	public String getC_estado() {
		return c_estado;
	}
	public void setC_estado(String c_estado) {
		this.c_estado = c_estado;
	}

	
}
