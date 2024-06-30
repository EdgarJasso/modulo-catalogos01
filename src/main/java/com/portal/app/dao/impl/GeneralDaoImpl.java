package com.portal.app.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.portal.app.dao.AppDao;
import com.portal.app.dao.GeneralDao;
import com.portal.app.dto.Catalogo;
import com.portal.app.dto.CatalogoDet;
import com.portal.app.request.AppRequest;
import com.portal.app.request.GeneralRequest;
import com.portal.app.response.AppResponse;
import com.portal.app.response.GeneralResponse;

@Repository
@Transactional(readOnly=true,rollbackFor = Exception.class)
public class GeneralDaoImpl implements GeneralDao
{
	private static final Logger log = LoggerFactory.getLogger(GeneralDaoImpl.class);
	
	@Autowired	private SessionFactory session;

	@Override
	@SuppressWarnings("unchecked")
	public List<Catalogo> getCatalogos(GeneralRequest request) {
		return session.getCurrentSession().createCriteria(Catalogo.class).list();
	}

	@Override
	@Transactional(readOnly = false)
	public String saveCatalogo(GeneralRequest request) {
		Catalogo catalogo = new Catalogo();
			catalogo.setCat_desc_str(request.getCatDescStr());
			catalogo.setCat_est_str("A");
		session.getCurrentSession().save(catalogo);
		return "Proceso realizado";
	}

	@Override
	@Transactional(readOnly = false)
	public String updateCatalogo(GeneralRequest request) {
		Catalogo catalogo = (Catalogo) session.getCurrentSession().createCriteria(Catalogo.class)
				.add(Restrictions.eq("cat_id_n", request.getCatIdN()))
				.uniqueResult();
		if(catalogo != null) {
			catalogo.setCat_desc_str(request.getCatDescStr());
			catalogo.setCat_est_str(request.getCatEstStr());
		}
		return "Proceso realizado";
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CatalogoDet> getCatalogosDet(GeneralRequest request) {
		return session.getCurrentSession().createCriteria(CatalogoDet.class)
				.add(Restrictions.eq("cat_id_n", request.getCatIdN()))
				.list();
	}

	@Override
	@Transactional(readOnly = false)
	public String saveCatalogoDet(GeneralRequest request) {
		CatalogoDet catalogoDet = new CatalogoDet();
		catalogoDet.setCat_id_n(request.getCatIdN());
		catalogoDet.setCatd_cve_str(request.getCatDCveStr());
		catalogoDet.setCatd_desc_str(request.getCatDescStr());
		catalogoDet.setCatd_est_str("A");
		log.debug("catalogoDet:"+new Gson().toJson(catalogoDet));
		session.getCurrentSession().save(catalogoDet);
	return "Proceso realizado";
	}

	@Override
	@Transactional(readOnly = false)
	public String updateCatalogoDet(GeneralRequest request) {
		CatalogoDet catalogoDet = (CatalogoDet) session.getCurrentSession().createCriteria(CatalogoDet.class)
				.add(Restrictions.eq("catd_id_n", request.getCatDIdN() ))
				.uniqueResult();
		if(catalogoDet != null) {
			catalogoDet.setCat_id_n(request.getCatIdN());
			catalogoDet.setCatd_cve_str(request.getCatDCveStr());
			catalogoDet.setCatd_desc_str(request.getCatDescStr());
			catalogoDet.setCatd_est_str(request.getCatEstStr());
		}
		return "Proceso realizado";
	}

	@Override
	@Transactional(readOnly = false)
	public String updateEstatusCatalogoDet(GeneralRequest request) {
		CatalogoDet catalogoDet = (CatalogoDet) session.getCurrentSession().createCriteria(CatalogoDet.class)
				.add(Restrictions.eq("catd_id_n", request.getCatDIdN() ))
				.uniqueResult();
		if(catalogoDet != null) {
			catalogoDet.setCatd_est_str(request.getCatEstStr());
		}
		return "Proceso realizado";
	}
	
	
	
	

}
