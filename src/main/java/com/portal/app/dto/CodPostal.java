package com.portal.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@Table(name="COD_POSTAL")
@NamedNativeQueries({
@NamedNativeQuery
(
	name = "GET_CP_VIEW",
	query = "{ call PKG_PORTAL_CAT01.GET_CP_VIEW(?,:codigo, :estado, :mnpio"
												+ ",:sortBy,:order,:limit,:offset)}",
	callable = true,
	resultClass = CodPostal.class
)
})
public class CodPostal {

	@Id
	@Column private String	cp_key_str;
	@Column private String  d_codigo;
	@Column private String  c_estado;
	@Column private String  c_mnpio;
	@Column private String  id_asenta_cpcons;
	@Column private String  c_cve_ciudad;
	@Column private String  d_asenta;
	@Column private String  d_mnpio;
	@Column private String  d_ciudad;
	@Column private Date  	cp_freg_dt;
	
	public String getCp_key_str() {
		return cp_key_str;
	}
	public void setCp_key_str(String cp_key_str) {
		this.cp_key_str = cp_key_str;
	}
	public String getD_codigo() {
		return d_codigo;
	}
	public void setD_codigo(String d_codigo) {
		this.d_codigo = d_codigo;
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
	public String getId_asenta_cpcons() {
		return id_asenta_cpcons;
	}
	public void setId_asenta_cpcons(String id_senta_cpcons) {
		this.id_asenta_cpcons = id_senta_cpcons;
	}
	public String getC_cve_ciudad() {
		return c_cve_ciudad;
	}
	public void setC_cve_ciudad(String c_cve_ciudad) {
		this.c_cve_ciudad = c_cve_ciudad;
	}
	public String getD_asenta() {
		return d_asenta;
	}
	public void setD_asenta(String d_asenta) {
		this.d_asenta = d_asenta;
	}
	public String getD_mnpio() {
		return d_mnpio;
	}
	public void setD_mnpio(String d_mnpio) {
		this.d_mnpio = d_mnpio;
	}
	public String getD_ciudad() {
		return d_ciudad;
	}
	public void setD_ciudad(String d_ciudad) {
		this.d_ciudad = d_ciudad;
	}
	public Date getCp_freg_dt() {
		return cp_freg_dt;
	}
	public void setCp_freg_dt(Date cp_freg_dt) {
		this.cp_freg_dt = cp_freg_dt;
	}
	
	
	
}
