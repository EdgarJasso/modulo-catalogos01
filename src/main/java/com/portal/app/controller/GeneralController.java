package com.portal.app.controller;

import static com.portal.app.util.Constants.BAD_REQUEST;
import static com.portal.app.util.Constants.CONFLICT;
import static com.portal.app.util.Constants.ERROR;
import static com.portal.app.util.Constants.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.app.request.GeneralRequest;
import com.portal.app.response.GeneralResponse;
import com.portal.app.service.GeneralService;
import com.portal.app.util.Parser;

@RestController
@RequestMapping(value="/service",produces=MediaType.APPLICATION_JSON_VALUE)
public class GeneralController{
	@Autowired	private GeneralService service;
	
	@PostMapping(value = "/general/list")
	public  ResponseEntity<GeneralResponse> catalogoList(@RequestBody GeneralRequest request)
	{
		GeneralResponse response =  service.catalogoList(Parser.DECODE(request));
		int status	= response.getStatus();
		response = new GeneralResponse(Parser.ENCODE(response));
		HttpStatus httpStatus = null;
		switch (status) 
		{
			case OK: 			httpStatus = HttpStatus.OK;						break;
			case BAD_REQUEST: 	httpStatus = HttpStatus.BAD_REQUEST;			break;
			case CONFLICT:		httpStatus = HttpStatus.CONFLICT;				break;
			case ERROR:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
			default:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
		}
		return new ResponseEntity<GeneralResponse>(response,httpStatus);
	}
	
	@PostMapping(value = "/general/detList")
	public  ResponseEntity<GeneralResponse> catalogoByIdList(@RequestBody GeneralRequest request)
	{
		GeneralResponse response =  service.catalogoByIdList(Parser.DECODE(request));
		int status	= response.getStatus();
		response = new GeneralResponse(Parser.ENCODE(response));
		HttpStatus httpStatus = null;
		switch (status) 
		{
			case OK: 			httpStatus = HttpStatus.OK;						break;
			case BAD_REQUEST: 	httpStatus = HttpStatus.BAD_REQUEST;			break;
			case CONFLICT:		httpStatus = HttpStatus.CONFLICT;				break;
			case ERROR:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
			default:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
		}
		return new ResponseEntity<GeneralResponse>(response,httpStatus);
	}
	
	@PostMapping(value = "/general/save")
	public  ResponseEntity<GeneralResponse> catalogoSave(@RequestBody GeneralRequest request)
	{
		GeneralResponse response =  service.catalogoSave(Parser.DECODE(request));
		int status	= response.getStatus();
		response = new GeneralResponse(Parser.ENCODE(response));
		HttpStatus httpStatus = null;
		switch (status) 
		{
			case OK: 			httpStatus = HttpStatus.OK;						break;
			case BAD_REQUEST: 	httpStatus = HttpStatus.BAD_REQUEST;			break;
			case CONFLICT:		httpStatus = HttpStatus.CONFLICT;				break;
			case ERROR:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
			default:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
		}
		return new ResponseEntity<GeneralResponse>(response,httpStatus);
	}
	
	@PostMapping(value = "/general/update")
	public  ResponseEntity<GeneralResponse> catalogoUpdate(@RequestBody GeneralRequest request)
	{
		GeneralResponse response =  service.catalogoUpdate(Parser.DECODE(request));
		int status	= response.getStatus();
		response = new GeneralResponse(Parser.ENCODE(response));
		HttpStatus httpStatus = null;
		switch (status) 
		{
			case OK: 			httpStatus = HttpStatus.OK;						break;
			case BAD_REQUEST: 	httpStatus = HttpStatus.BAD_REQUEST;			break;
			case CONFLICT:		httpStatus = HttpStatus.CONFLICT;				break;
			case ERROR:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
			default:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
		}
		return new ResponseEntity<GeneralResponse>(response,httpStatus);
	}

	@PostMapping(value = "/general/updateEstatus")
	public  ResponseEntity<GeneralResponse> catalogoUpdateEstatus(@RequestBody GeneralRequest request)
	{
		GeneralResponse response =  service.catalogoUpdateEstatus(Parser.DECODE(request));
		int status	= response.getStatus();
		response = new GeneralResponse(Parser.ENCODE(response));
		HttpStatus httpStatus = null;
		switch (status) 
		{
			case OK: 			httpStatus = HttpStatus.OK;						break;
			case BAD_REQUEST: 	httpStatus = HttpStatus.BAD_REQUEST;			break;
			case CONFLICT:		httpStatus = HttpStatus.CONFLICT;				break;
			case ERROR:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
			default:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
		}
		return new ResponseEntity<GeneralResponse>(response,httpStatus);
	}
	
}
