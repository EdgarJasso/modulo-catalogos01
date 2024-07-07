package com.portal.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQueries({
@NamedNativeQuery
(
	name = "GET_RS_VIEW",
	query = "{ call PKG_PORTAL_CAT01.GET_RS_VIEW(?,:tipo, :giro)}",
	callable = true,
	resultClass = GetRSView.class
)
})
public class GetRSView {

	@Id
	@Column private Long rs_id_n;
	@Column private String rs_nombre_str;
	@Column private String rs_rfc_str;
	@Column private String rs_dir_str;
	@Column private Integer rs_tipo_n;
	@Column private String rs_tipo_str;
	@Column private Integer rs_giro_n;
	@Column private String rs_giro_str;
	@Column private String rs_calle_str;
	@Column private String rs_num_ext_str;
	@Column private String rs_num_int_str;
	@Column private String rs_colonia_str;
	@Column private Integer rs_mun_id_n;
	@Column private String rs_ciudad_str;
	@Column private Integer rs_edo_id_n;
	@Column private String edo_cve_str;
	@Column private String edo_desc_str;
	@Column private Integer rs_pais_id_n;
	@Column private String pais_cve_str;
	@Column private String pais_desc_str;
	@Column private String rs_cp_str;
	@Column private String rs_est_str;
	@Column private String rs_freg_dt;
	
	public Long getRs_id_n() {
		return rs_id_n;
	}
	public void setRs_id_n(Long rs_id_n) {
		this.rs_id_n = rs_id_n;
	}
	public String getRs_nombre_str() {
		return rs_nombre_str;
	}
	public void setRs_nombre_str(String rs_nombre_str) {
		this.rs_nombre_str = rs_nombre_str;
	}
	public String getRs_rfc_str() {
		return rs_rfc_str;
	}
	public void setRs_rfc_str(String rs_rfc_str) {
		this.rs_rfc_str = rs_rfc_str;
	}
	public String getRs_dir_str() {
		return rs_dir_str;
	}
	public void setRs_dir_str(String rs_dir_str) {
		this.rs_dir_str = rs_dir_str;
	}
	public Integer getRs_tipo_n() {
		return rs_tipo_n;
	}
	public void setRs_tipo_n(Integer rs_tipo_n) {
		this.rs_tipo_n = rs_tipo_n;
	}
	public String getRs_tipo_str() {
		return rs_tipo_str;
	}
	public void setRs_tipo_str(String rs_tipo_str) {
		this.rs_tipo_str = rs_tipo_str;
	}
	public Integer getRs_giro_n() {
		return rs_giro_n;
	}
	public void setRs_giro_n(Integer rs_giro_n) {
		this.rs_giro_n = rs_giro_n;
	}
	public String getRs_giro_str() {
		return rs_giro_str;
	}
	public void setRs_giro_str(String rs_giro_str) {
		this.rs_giro_str = rs_giro_str;
	}
	public String getRs_calle_str() {
		return rs_calle_str;
	}
	public void setRs_calle_str(String rs_calle_str) {
		this.rs_calle_str = rs_calle_str;
	}
	public String getRs_num_ext_str() {
		return rs_num_ext_str;
	}
	public void setRs_num_ext_str(String rs_num_ext_str) {
		this.rs_num_ext_str = rs_num_ext_str;
	}
	public String getRs_num_int_str() {
		return rs_num_int_str;
	}
	public void setRs_num_int_str(String rs_num_int_str) {
		this.rs_num_int_str = rs_num_int_str;
	}
	public String getRs_colonia_str() {
		return rs_colonia_str;
	}
	public void setRs_colonia_str(String rs_colonia_str) {
		this.rs_colonia_str = rs_colonia_str;
	}
	public Integer getRs_mun_id_n() {
		return rs_mun_id_n;
	}
	public void setRs_mun_id_n(Integer rs_mun_id_n) {
		this.rs_mun_id_n = rs_mun_id_n;
	}
	public String getRs_ciudad_str() {
		return rs_ciudad_str;
	}
	public void setRs_ciudad_str(String rs_ciudad_str) {
		this.rs_ciudad_str = rs_ciudad_str;
	}
	public Integer getRs_edo_id_n() {
		return rs_edo_id_n;
	}
	public void setRs_edo_id_n(Integer rs_edo_id_n) {
		this.rs_edo_id_n = rs_edo_id_n;
	}
	public String getEdo_cve_str() {
		return edo_cve_str;
	}
	public void setEdo_cve_str(String edo_cve_str) {
		this.edo_cve_str = edo_cve_str;
	}
	public String getEdo_desc_str() {
		return edo_desc_str;
	}
	public void setEdo_desc_str(String edo_desc_str) {
		this.edo_desc_str = edo_desc_str;
	}
	public Integer getRs_pais_id_n() {
		return rs_pais_id_n;
	}
	public void setRs_pais_id_n(Integer rs_pais_id_n) {
		this.rs_pais_id_n = rs_pais_id_n;
	}
	public String getPais_cve_str() {
		return pais_cve_str;
	}
	public void setPais_cve_str(String pais_cve_str) {
		this.pais_cve_str = pais_cve_str;
	}
	public String getPais_desc_str() {
		return pais_desc_str;
	}
	public void setPais_desc_str(String pais_desc_str) {
		this.pais_desc_str = pais_desc_str;
	}
	public String getRs_cp_str() {
		return rs_cp_str;
	}
	public void setRs_cp_str(String rs_cp_str) {
		this.rs_cp_str = rs_cp_str;
	}
	public String getRs_est_str() {
		return rs_est_str;
	}
	public void setRs_est_str(String rs_est_str) {
		this.rs_est_str = rs_est_str;
	}
	public String getRs_freg_dt() {
		return rs_freg_dt;
	}
	public void setRs_freg_dt(String rs_freg_dt) {
		this.rs_freg_dt = rs_freg_dt;
	}

	
	
	
	
}
