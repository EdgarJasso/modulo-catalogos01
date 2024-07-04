package com.portal.app.service.impl;

import static com.portal.app.util.Constants.*;

import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.portal.app.dto.CodPostal;
import com.portal.app.dto.CodigoPostal;
import com.portal.app.request.CPRequest;
import com.portal.app.service.Job;
import com.portal.app.service.SubJob;
import com.portal.app.util.Contador;

@Component
public class JobImpl implements Job {
	
	private static final Logger log = LoggerFactory.getLogger(JobImpl.class);
	
	@Autowired private SubJob 		subjob;
	@Autowired private Contador 	globalCount;
	
	@Override
	@Async("cpExecutor")
	public void loadCsvToSaveCP(String path) {
		log.info("loadCsvToSaveCP: " + path);
		
		File fileCheck = new File(path);
		
		if( !path.endsWith(".csv") ){
			log.error("Archivo .csv requerido");
			return;
		}
		
		if( !fileCheck.exists() ){
			log.error("Archivo no encontrado");
			return;
		}
		
		Long item 	= 0L;
		Long errors = 0L;
		Long oks 	= 0L;
		
		try (CSVReader reader = new CSVReader(new FileReader(fileCheck))){
			String [] values = null;
			while((values = reader.readNext()) != null) {
				List<String> row = Arrays.asList(values);
				try {
					//get datos de cada fila del archivo
					String dcodigo = row.get(0).trim();
					String dasenta = row.get(1).trim();
					String dmnpio  = row.get(3).trim();
					String dciudad = row.get(5).trim();
					String cestado = row.get(7).trim();
					String cmnpio  = row.get(11).trim();
					String idSenta = row.get(12).trim();
					String cvecdd  = row.get(14).trim();
					
					if(!dcodigo.equalsIgnoreCase("")) {
						String pk = dcodigo+"-"+cestado+"-"+cmnpio+"-"+cvecdd+"-"+idSenta;
						CodPostal cp = new CodPostal();
							cp.setCp_key_str(pk);
							cp.setD_codigo(dcodigo);
							cp.setC_estado(cestado);
							cp.setC_mnpio(cmnpio);
							cp.setId_asenta_cpcons(idSenta);
							cp.setC_cve_ciudad(cvecdd);
							cp.setD_asenta(dasenta);
							cp.setD_mnpio(dmnpio);
							cp.setD_ciudad(dciudad);
							
						subjob.regitrarSocio(cp);
					}
					oks++;
					
				} catch (Exception e) {
					errors++;
					log.error(e.getMessage());
					log.info("item "+item+" ErrorCarga => " + new Gson().toJson(row));
				}	
				item++;
			}
			
			log.info("ARCHIVO FINALIZADO ");
			log.info("Total Ok: " + oks);
			log.info("Total Errores: " + errors);
			globalCount.setValor(oks);
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		
	}
	
	
	
}
