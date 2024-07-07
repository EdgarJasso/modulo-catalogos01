package com.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQueries({
@NamedNativeQuery
(
	name = "GET_CP_DATA",
	query = "{ call PKG_PORTAL_CAT01.GET_CP_DATA(?,:codigo)}",
	callable = true,
	resultClass = RsCPData.class
)
})
public class RsCPData {

	@Id
	@Column private Long	id_n;
	@Column private String  pais_id_n;
	@Column private String  pais_cve_str;
	@Column private String  pais_desc_str;
	@Column private String  c_estado;
	@Column private String  edo_cve_str;
	@Column private String  edo_desc_str;
	@Column private String  d_codigo;
	@Column private String  c_mnpio;
	@Column private String  id_asenta_cpcons;
	@Column private String  c_m_str;
	@Column private String  d_asenta;
	
}
