package com.portal.app.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.portal.app.dao.RazonSocDao;
import com.portal.app.dto.GetRSView;
import com.portal.app.dto.RazonSocial;
import com.portal.app.request.RazonSocRequest;

@Repository
@Transactional(readOnly=true,rollbackFor = Exception.class)
public class RazonSocDaoImpl implements RazonSocDao{
	
	@Autowired	private SessionFactory session;

	@Override
	@SuppressWarnings("unchecked")
	public List<GetRSView> getRSView(RazonSocRequest request) {
		return session.getCurrentSession().getNamedQuery("GET_RS_VIEW")
				.setParameter("tipo", request.getRsTipoN())
				.setParameter("giro", request.getRsGiroN())
				.list();
	}

	@Override
	@Transactional(readOnly = false)
	public void razonSocSave(RazonSocRequest request) {
		RazonSocial rs =  new RazonSocial();
			rs.setRs_nombre_str(request.getRsNombreStr());
			rs.setRs_rfc_str(request.getRsRfcStr());
			rs.setRs_tipo_n(request.getRsTipoN());
			rs.setRs_giro_n(request.getRsGiroN());
			rs.setRs_colonia_str(request.getRsColoniaStr());
			rs.setRs_calle_str(request.getRsCalleStr());
			rs.setRs_num_ext_str(request.getRsNumExtStr());
			rs.setRs_num_int_str(request.getRsNumIntStr());
			rs.setRs_mun_id_n(request.getRsMunIdN());
			rs.setRs_ciudad_str(request.getRsCiudadStr());
			rs.setRs_edo_id_n(request.getRsEdoIdN());
			rs.setRs_pais_id_n(1L);
			rs.setRs_cp_str(request.getRsCpStr());
			rs.setRs_est_str(request.getRsEstStr());
			rs.setRs_freg_dt(new Date());


		session.getCurrentSession().save(rs);
	}

	@Override
	@Transactional(readOnly = false)
	public void razonSocUpdate(RazonSocRequest request) {
		RazonSocial rs =  (RazonSocial) session.getCurrentSession()
							.createCriteria(RazonSocial.class)
							.add(Restrictions.eq("rs_id_n", request.getRsIdN()))
							.uniqueResult();
		if (rs != null) {
				rs.setRs_nombre_str(request.getRsNombreStr());
				rs.setRs_rfc_str(request.getRsRfcStr());
				rs.setRs_tipo_n(request.getRsTipoN());
				rs.setRs_giro_n(request.getRsGiroN());
				rs.setRs_calle_str(request.getRsCalleStr());
				rs.setRs_num_ext_str(request.getRsNumExtStr());
				rs.setRs_num_int_str(request.getRsNombreStr());
				rs.setRs_mun_id_n(request.getRsMunIdN());
				rs.setRs_ciudad_str(request.getRsCiudadStr());
				rs.setRs_edo_id_n(request.getRsEdoIdN());
				rs.setRs_pais_id_n(1L);
				rs.setRs_cp_str(request.getRsCpStr());
				rs.setRs_est_str(request.getRsEstStr());
				rs.setRs_freg_dt(new Date());
		}
	}

	@Override
	@Transactional(readOnly = false)
	public void razonSocUpdteEstatus(RazonSocRequest request) {
		RazonSocial rs =  (RazonSocial) session.getCurrentSession()
							.createCriteria(RazonSocial.class)
							.add(Restrictions.eq("rs_id_n", request.getRsIdN()))
							.uniqueResult();
		if (rs != null) {
				rs.setRs_est_str(request.getRsEstStr());
				rs.setRs_freg_dt(new Date());
		}
	}

	

	

	
	
}
