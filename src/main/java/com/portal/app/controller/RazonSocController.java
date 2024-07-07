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

import com.portal.app.request.RazonSocRequest;
import com.portal.app.response.RazonSocResponse;
import com.portal.app.service.RazonSocService;
import com.portal.app.util.Parser;

@RestController
@RequestMapping(value="/service",produces=MediaType.APPLICATION_JSON_VALUE)
public class RazonSocController{
	@Autowired	private RazonSocService service;
	
	@PostMapping(value = "/razonSoc/view")
	public  ResponseEntity<RazonSocResponse> razonSocView(@RequestBody RazonSocRequest request)
	{
		RazonSocResponse response =  service.razonSocView(Parser.DECODE(request));
		int status	= response.getStatus();
		response = new RazonSocResponse(Parser.ENCODE(response));
		HttpStatus httpStatus = null;
		switch (status) 
		{
			case OK: 			httpStatus = HttpStatus.OK;						break;
			case BAD_REQUEST: 	httpStatus = HttpStatus.BAD_REQUEST;			break;
			case CONFLICT:		httpStatus = HttpStatus.CONFLICT;				break;
			case ERROR:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
			default:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
		}
		return new ResponseEntity<RazonSocResponse>(response,httpStatus);
	}

	@PostMapping(value = "/razonSoc/save")
	public  ResponseEntity<RazonSocResponse> razonSocSave(@RequestBody RazonSocRequest request)
	{
		RazonSocResponse response =  service.razonSocSave(Parser.DECODE(request));
		int status	= response.getStatus();
		response = new RazonSocResponse(Parser.ENCODE(response));
		HttpStatus httpStatus = null;
		switch (status) 
		{
			case OK: 			httpStatus = HttpStatus.OK;						break;
			case BAD_REQUEST: 	httpStatus = HttpStatus.BAD_REQUEST;			break;
			case CONFLICT:		httpStatus = HttpStatus.CONFLICT;				break;
			case ERROR:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
			default:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
		}
		return new ResponseEntity<RazonSocResponse>(response,httpStatus);
	}
	
	@PostMapping(value = "/razonSoc/update")
	public  ResponseEntity<RazonSocResponse> razonSocUpdate(@RequestBody RazonSocRequest request)
	{
		RazonSocResponse response =  service.razonSocUpdate(Parser.DECODE(request));
		int status	= response.getStatus();
		response = new RazonSocResponse(Parser.ENCODE(response));
		HttpStatus httpStatus = null;
		switch (status) 
		{
			case OK: 			httpStatus = HttpStatus.OK;						break;
			case BAD_REQUEST: 	httpStatus = HttpStatus.BAD_REQUEST;			break;
			case CONFLICT:		httpStatus = HttpStatus.CONFLICT;				break;
			case ERROR:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
			default:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
		}
		return new ResponseEntity<RazonSocResponse>(response,httpStatus);
	}

	@PostMapping(value = "/razonSoc/updateEstatus")
	public  ResponseEntity<RazonSocResponse> razonSocUpdateEstatus(@RequestBody RazonSocRequest request)
	{
		RazonSocResponse response =  service.razonSocUpdateEstatus(Parser.DECODE(request));
		int status	= response.getStatus();
		response = new RazonSocResponse(Parser.ENCODE(response));
		HttpStatus httpStatus = null;
		switch (status) 
		{
			case OK: 			httpStatus = HttpStatus.OK;						break;
			case BAD_REQUEST: 	httpStatus = HttpStatus.BAD_REQUEST;			break;
			case CONFLICT:		httpStatus = HttpStatus.CONFLICT;				break;
			case ERROR:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
			default:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
		}
		return new ResponseEntity<RazonSocResponse>(response,httpStatus);
	}
	
}
