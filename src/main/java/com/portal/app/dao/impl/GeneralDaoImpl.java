package com.portal.app.dao.impl;

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
import com.portal.app.dao.GeneralDao;
import com.portal.app.dto.Catalogo;
import com.portal.app.dto.CatalogoDet;
import com.portal.app.request.GeneralRequest;

@Repository
@Transactional(readOnly=true,rollbackFor = Exception.class)
public class GeneralDaoImpl implements GeneralDao{
	
	@Autowired	private SessionFactory session;

	@Override
	@SuppressWarnings("unchecked")
	public List<Catalogo> catalogoList(GeneralRequest request) {
		return session.getCurrentSession().createCriteria(Catalogo.class)
				.add(Restrictions.eq("cat_est_str", "A"))
				.addOrder(Order.asc("cat_id_n"))
				.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<CatalogoDet> catalogoListByID(GeneralRequest request) {
		return session.getCurrentSession().createCriteria(CatalogoDet.class)
				.add(Restrictions.eq("cat_id_n", request.getIdPadre()))
				.addOrder(Order.asc("catd_id_n"))
				.list();
	}

	@Override
	@Transactional(readOnly = false)
	public void catalogoSave(GeneralRequest request) {
		CatalogoDet catalogoDet = new CatalogoDet();
		catalogoDet.setCat_id_n(request.getIdPadre());
		catalogoDet.setCatd_cve_str(request.getClave());
		catalogoDet.setCatd_desc_str(request.getDesc());
		catalogoDet.setCatd_est_str(request.getEstatus());
		
		session.getCurrentSession().save(catalogoDet);
	}

	@Override
	@Transactional(readOnly = false)
	public void catalogoUpdate(GeneralRequest request) {
		CatalogoDet catalogoDet = (CatalogoDet) session.getCurrentSession()
								 .createCriteria(CatalogoDet.class)
								 .add(Restrictions.eq("catd_id_n", request.getIdDetalle()))
								 .uniqueResult();
		if(catalogoDet != null) {
			catalogoDet.setCat_id_n(request.getIdPadre());
			catalogoDet.setCatd_cve_str(request.getClave());
			catalogoDet.setCatd_desc_str(request.getDesc());
			catalogoDet.setCatd_est_str(request.getEstatus());
		}
	}

	@Override
	@Transactional(readOnly = false)
	public void catalogoUpdateEstatus(GeneralRequest request) {
		CatalogoDet catalogoDet = (CatalogoDet) session.getCurrentSession()
								 .createCriteria(CatalogoDet.class)
								 .add(Restrictions.eq("catd_id_n", request.getIdDetalle()))
								 .uniqueResult();
		if(catalogoDet != null) {
			catalogoDet.setCatd_est_str(request.getEstatus());
		}
	}

	
	
}
