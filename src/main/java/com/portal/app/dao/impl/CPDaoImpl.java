package com.portal.app.dao.impl;

import java.math.BigDecimal;
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
import com.portal.app.dto.Estado;
import com.portal.app.dto.RsCPData;
import com.portal.app.request.CPRequest;
import com.portal.app.service.QueryBuilder;
@Repository
@Transactional(readOnly=true,rollbackFor = Exception.class)
public class CPDaoImpl implements CPDao{
	private static final Logger log = LoggerFactory.getLogger(CPDaoImpl.class);
	
	@Autowired	private SessionFactory session;
	@Autowired	private QueryBuilder	queryBuider;

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
	public Long getCodigoPostalListCount(CPRequest request) {
		log.info("getCodigoPostalListCount: "+new Gson().toJson(request));
		String sql = queryBuider.countGetCodigoPostalList();
		log.debug("sql:"+sql);
		BigDecimal total = (BigDecimal) session.getCurrentSession()
							.createSQLQuery(sql)
							.setParameter("codigo", request.getCodigoPStr())
							.setParameter("estado", request.getEstadoStr())
							.setParameter("mnpio", request.getMnpioStr())
							.uniqueResult();
		log.info("Total getCodigoPostalListCount: "+total.longValue());
		return total.longValue();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CodPostal> codigoPostalList(CPRequest request) {

		String codigo = request.getCodigoPStr();
		String estado = request.getEstadoStr();
		String mnpio  = request.getMnpioStr();
		String sortBy = request.getPager().getData().getSort();
		String order  =  request.getPager().getData().getOrder();
		Integer limit = request.getPager().getData().getLimit();
		Integer offset= request.getPager().getData().getOffset();

		return session.getCurrentSession().getNamedQuery("GET_CP_VIEW")
		.setParameter("codigo", codigo)
		.setParameter("estado", estado)
		.setParameter("mnpio", mnpio)
				.setParameter("sortBy", sortBy)
				.setParameter("order" , order)
				.setParameter("limit" , limit)
				.setParameter("offset", offset)
		.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RsCPData> getCPData(CPRequest request) {
		return session.getCurrentSession().getNamedQuery("GET_CP_DATA")
		.setParameter("codigo", request.getCodigoPStr())
		.list();
	}

	@Override
	@Transactional(readOnly = false)
	public void codigoSaveOrUpdate(CPRequest request) {
		CodPostal cp = (CodPostal) session.getCurrentSession()
						.createCriteria(CodPostal.class)
						.add(Restrictions.eq("cp_key_str", request.getCpKeyStr()))
						.uniqueResult();
		if(cp != null){
			cp.setCp_key_str(request.getCpKeyStr());
			cp.setD_codigo(request.getCpCodigoStr());
			cp.setC_estado(request.getCpCveEstadoStr());
			cp.setC_mnpio(request.getCpCveMnpioStr());
			cp.setId_asenta_cpcons(request.getCpIdAsentaCpconsStr());
			cp.setC_cve_ciudad(request.getCpCveCiudadStr());
			cp.setD_asenta(request.getCpAsentaStr());
			cp.setD_mnpio(request.getCpMnpioStr());
			cp.setD_ciudad(request.getCpCiudadStr());
			cp.setCp_freg_dt(new Date());
		}}

	@Override
	@Transactional(readOnly = false)
	public void codigoDelete(CPRequest request) {
		CodPostal cp = (CodPostal) session.getCurrentSession()
						.createCriteria(CodPostal.class)
						.add(Restrictions.eq("cp_key_str", request.getCpKeyStr()))
						.uniqueResult();
			log.debug("cp find: "+new Gson().toJson(cp));
		if(cp != null){
			session.getCurrentSession().delete(cp);
			log.debug("cp delete");
		}

	}

}
