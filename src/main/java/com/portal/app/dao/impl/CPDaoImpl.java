package com.portal.app.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.portal.app.dao.CPDao;
import com.portal.app.dto.CodPostal;
import com.portal.app.dto.CodigoPostal;
import com.portal.app.dto.Estado;
import com.portal.app.request.CPRequest;
@Repository
@Transactional(readOnly=true,rollbackFor = Exception.class)
public class CPDaoImpl implements CPDao{
	private static final Logger log = LoggerFactory.getLogger(CPDaoImpl.class);
	
	@Autowired	private SessionFactory session;

	@Override
	@Transactional(readOnly = false)
	public boolean registroCP(CodPostal cp) {
		boolean insert = true;
		try {
			cp.setCp_freg_dt(new Date());
			session.getCurrentSession().saveOrUpdate(cp);
		} catch (Exception e) {
			log.info("========================================================");
			log.info("cp info: "+new Gson().toJson(cp));
			log.info("error: "+e.getMessage());
			log.info("========================================================");
		}
		if(cp.getCp_freg_dt().equals(null)) { insert = false;	}
		return insert;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Estado> estadoList() {
		return session.getCurrentSession()
			.createCriteria(Estado.class)
			.add(Restrictions.eq("pais_id_n", 1L))
			.addOrder(Order.asc("edo_desc_str"))
			.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CodigoPostal> codigoPostalList(CPRequest request) {
		return session.getCurrentSession().getNamedQuery("GET_CP_VIEW")
		.setParameter("codigo", request.getCodigoPStr())
		.setParameter("estado", request.getEstadoStr())
		.setParameter("mnpio", request.getMnpioStr())
		.list();
	}
	
	

}
