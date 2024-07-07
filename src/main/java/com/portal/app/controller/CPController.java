package com.portal.app.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.portal.app.request.CPRequest;
import com.portal.app.response.CPResponse;
import com.portal.app.service.CPService;
import com.portal.app.util.Parser;

import static com.portal.app.util.Constants.*;

@RestController
@RequestMapping(value="/service",  produces=MediaType.APPLICATION_JSON_VALUE)
public class CPController {

	private static final Logger log = LoggerFactory.getLogger(CPController.class);
	
	@Autowired  private Environment env;
	@Autowired	private CPService service;
	

	@PostMapping(value = "/codigoPostal/estadoList")
	public  ResponseEntity<CPResponse> estadoList(@RequestBody CPRequest request)
	{
		CPResponse response =  service.estadoList();
		int status	= response.getStatus();
		response = new CPResponse(Parser.ENCODE(response));
		HttpStatus httpStatus = null;
		switch (status) 
		{
			case OK: 			httpStatus = HttpStatus.OK;						break;
			case BAD_REQUEST: 	httpStatus = HttpStatus.BAD_REQUEST;			break;
			case CONFLICT:		httpStatus = HttpStatus.CONFLICT;				break;
			case ERROR:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
			default:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
		}
		return new ResponseEntity<CPResponse>(response,httpStatus);
	}

	@PostMapping(value = "/codigoPostal/view")
	public  ResponseEntity<CPResponse> cpView(@RequestBody CPRequest request){
		boolean encode = request.getData() != null ? true : false;

		CPResponse response = service.codigoPostalList(encode ? Parser.DECODE(request):request);
		int status	= response.getStatus();
		response = new CPResponse(Parser.ENCODE(response));
		HttpStatus httpStatus = null;
		switch (status) 
		{
			case OK: 			httpStatus = HttpStatus.OK;						break;
			case BAD_REQUEST: 	httpStatus = HttpStatus.BAD_REQUEST;			break;
			case CONFLICT:		httpStatus = HttpStatus.CONFLICT;				break;
			case ERROR:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
			default:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
		}
		return new ResponseEntity<CPResponse>(response,httpStatus);
	}

	@PostMapping(value = "/codigoPostal/cpData")
	public  ResponseEntity<CPResponse> cpData(@RequestBody CPRequest request){
		boolean encode = request.getData() != null ? true : false;

		CPResponse response = service.getCPData(encode ? Parser.DECODE(request):request);
		int status	= response.getStatus();
		response = new CPResponse(Parser.ENCODE(response));
		HttpStatus httpStatus = null;
		switch (status) 
		{
			case OK: 			httpStatus = HttpStatus.OK;						break;
			case BAD_REQUEST: 	httpStatus = HttpStatus.BAD_REQUEST;			break;
			case CONFLICT:		httpStatus = HttpStatus.CONFLICT;				break;
			case ERROR:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
			default:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
		}
		return new ResponseEntity<CPResponse>(response,httpStatus);
	}

	@PostMapping(value = "/codigoPostal/codigoSaveOrUpdate")
	public  ResponseEntity<CPResponse> codigoSaveOrUpdate(@RequestBody CPRequest request){
		boolean encode = request.getData() != null ? true : false;

		CPResponse response = service.codigoSaveOrUpdate(encode ? Parser.DECODE(request):request);
		int status	= response.getStatus();
		response = new CPResponse(Parser.ENCODE(response));
		HttpStatus httpStatus = null;
		switch (status) 
		{
			case OK: 			httpStatus = HttpStatus.OK;						break;
			case BAD_REQUEST: 	httpStatus = HttpStatus.BAD_REQUEST;			break;
			case CONFLICT:		httpStatus = HttpStatus.CONFLICT;				break;
			case ERROR:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
			default:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
		}
		return new ResponseEntity<CPResponse>(response,httpStatus);
	}

	@PostMapping(value = "/codigoPostal/codigoDelete")
	public  ResponseEntity<CPResponse> codigoDelete(@RequestBody CPRequest request){
		boolean encode = request.getData() != null ? true : false;

		CPResponse response = service.codigoDelete(encode ? Parser.DECODE(request):request);
		int status	= response.getStatus();
		response = new CPResponse(Parser.ENCODE(response));
		HttpStatus httpStatus = null;
		switch (status) 
		{
			case OK: 			httpStatus = HttpStatus.OK;						break;
			case BAD_REQUEST: 	httpStatus = HttpStatus.BAD_REQUEST;			break;
			case CONFLICT:		httpStatus = HttpStatus.CONFLICT;				break;
			case ERROR:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
			default:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
		}
		return new ResponseEntity<CPResponse>(response,httpStatus);
	}

	@PostMapping(value = "/codigoPostal/upload")
	public ResponseEntity<CPResponse> uploadArticulos(MultipartFile file,@ModelAttribute CPRequest request)
	{
		CPResponse response = new CPResponse();
		
		log.info("Subiendo layaout "+new Gson().toJson(request));
		log.info("Request "+new Gson().toJson(request));
		Long register = 0L;
		try
		{
			String fileName = file.getOriginalFilename();
			String ext 	= fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
			String _fileName = fileName.substring(0,fileName.lastIndexOf("."));
			
			log.info("File:"+_fileName);
			log.info("Ext:"+ext);
			
			String repo = env.getProperty("repo.path");
			String path = repo+_fileName+"."+ext;
			Path destinationFile = Paths.get(path);
			
			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, destinationFile,StandardCopyOption.REPLACE_EXISTING);

				log.info("Archivo subido: " + destinationFile );
				register = service.loadCsv(destinationFile.toString());
				response.setMessage("Archivo subido, <span class='pcolor-red'> "+register+" datos procesados</span>");
			
			}catch(Exception e){
				log.error(e.getMessage(), e);
				response.setStatus(ERROR);
				response.setMessage("(1)"+e.getMessage());
			}
			
			
			
		}catch(Exception e){
			log.error(e.getMessage(), e);
			response.setStatus(ERROR);
			response.setMessage("(2)"+e.getMessage());
		}
		
		int status	= response.getStatus();
		HttpStatus httpStatus = null;
		switch (status) 
		{
			case OK: 			httpStatus = HttpStatus.OK;						break;
			case BAD_REQUEST: 	httpStatus = HttpStatus.BAD_REQUEST;			break;
			case CONFLICT:		httpStatus = HttpStatus.CONFLICT;				break;
			case ERROR:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
			default:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
		}
		return new ResponseEntity<CPResponse>(response,httpStatus);

	}
	
}
