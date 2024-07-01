package com.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CODIGO_POSTAL")
public class CodigoPostal {

	@Id
	@SequenceGenerator(name = "SEQ_CODIGO_POSTAL", sequenceName="SEQ_CODIGO_POSTAL") 
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_CODIGO_POSTAL")
	@Column private Long	id_n;
	@Column private String  d_codigo;
	@Column private String  d_asenta;
	@Column private String  d_ciudad;
	@Column private String  c_estado;
	@Column private String  c_mnpio;
	@Column private String  c_cve_ciudad;
	
	
	public Long getId_n() {
		return id_n;
	}
	public void setId_n(Long id_n) {
		this.id_n = id_n;
	}
	public String getD_codigo() {
		return d_codigo;
	}
	public void setD_codigo(String d_codigo) {
		this.d_codigo = d_codigo;
	}
	public String getD_asenta() {
		return d_asenta;
	}
	public void setD_asenta(String d_asenta) {
		this.d_asenta = d_asenta;
	}
	public String getD_ciudad() {
		return d_ciudad;
	}
	public void setD_ciudad(String d_ciudad) {
		this.d_ciudad = d_ciudad;
	}
	public String getC_estado() {
		return c_estado;
	}
	public void setC_estado(String c_estado) {
		this.c_estado = c_estado;
	}
	public String getC_mnpio() {
		return c_mnpio;
	}
	public void setC_mnpio(String c_mnpio) {
		this.c_mnpio = c_mnpio;
	}
	public String getC_cve_ciudad() {
		return c_cve_ciudad;
	}
	public void setC_cve_ciudad(String c_cve_ciudad) {
		this.c_cve_ciudad = c_cve_ciudad;
	}
	
	
}
