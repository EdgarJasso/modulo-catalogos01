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
	public void loadCsvToSaveCP(CPRequest request) {
		log.info("loadCsvToSaveCP " + new Gson().toJson(request));
		
		String archivo = request.getCsvPath();
		File fileCheck = new File(archivo);
		
		if( !archivo.endsWith(".csv") ){
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
					String codigo = row.get(0).trim();
					String asenta = row.get(1).trim();
					String ciudad = row.get(2).trim();
					String estado = row.get(3).trim();
					String mnpio  = row.get(4).trim();
					String cvecdd = row.get(5).trim();
					
					if(!codigo.equalsIgnoreCase("")) {
						CodigoPostal cp = new CodigoPostal();
							cp.setD_codigo(codigo);
							cp.setD_asenta(asenta);
							cp.setD_ciudad(ciudad);
							cp.setC_estado(estado);
							cp.setC_mnpio(mnpio);
							cp.setC_cve_ciudad(cvecdd);
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
