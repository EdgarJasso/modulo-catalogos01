package com.portal.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="RAZON_SOCIAL")
public class RazonSocial {

	@Id
	@SequenceGenerator(name = "SEQ_RAZON_SOCIAL", sequenceName="SEQ_RAZON_SOCIAL") 
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_RAZON_SOCIAL")
	@Column private Long	rs_id_n;
	@Column private String  rs_nombre_str;
	@Column private String  rs_rfc_str;
	@Column private Long 	rs_tipo_n;
	@Column private Long 	rs_giro_n;
	@Column private String  rs_calle_str;
	@Column private String  rs_colonia_str;
	@Column private String  rs_num_ext_str;
	@Column private String  rs_num_int_str;
	@Column private Long  	rs_mun_id_n;
	@Column private String  rs_ciudad_str;
	@Column private Long 	rs_edo_id_n;
	@Column private Long 	rs_pais_id_n;
	@Column private String  rs_cp_str;
	@Column private String  rs_est_str;
	@Column private Date  	rs_freg_dt;
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
	public Long getRs_tipo_n() {
		return rs_tipo_n;
	}
	public void setRs_tipo_n(Long rs_tipo_n) {
		this.rs_tipo_n = rs_tipo_n;
	}
	public Long getRs_giro_n() {
		return rs_giro_n;
	}
	public void setRs_giro_n(Long rs_giro_n) {
		this.rs_giro_n = rs_giro_n;
	}
	public String getRs_calle_str() {
		return rs_calle_str;
	}
	public void setRs_calle_str(String rs_calle_str) {
		this.rs_calle_str = rs_calle_str;
	}
	public String getRs_colonia_str() {
		return rs_colonia_str;
	}
	public void setRs_colonia_str(String rs_colonia_str) {
		this.rs_colonia_str = rs_colonia_str;
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
	public Long getRs_mun_id_n() {
		return rs_mun_id_n;
	}
	public void setRs_mun_id_n(Long rs_mun_id_n) {
		this.rs_mun_id_n = rs_mun_id_n;
	}
	public String getRs_ciudad_str() {
		return rs_ciudad_str;
	}
	public void setRs_ciudad_str(String rs_ciudad_str) {
		this.rs_ciudad_str = rs_ciudad_str;
	}
	public Long getRs_edo_id_n() {
		return rs_edo_id_n;
	}
	public void setRs_edo_id_n(Long rs_edo_id_n) {
		this.rs_edo_id_n = rs_edo_id_n;
	}
	public Long getRs_pais_id_n() {
		return rs_pais_id_n;
	}
	public void setRs_pais_id_n(Long rs_pais_id_n) {
		this.rs_pais_id_n = rs_pais_id_n;
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
	public Date getRs_freg_dt() {
		return rs_freg_dt;
	}
	public void setRs_freg_dt(Date rs_freg_dt) {
		this.rs_freg_dt = rs_freg_dt;
	}
	
	
	
	
	
}
