package com.portal.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.portal.app.request.AppRequest;
import com.portal.app.request.PageRequest;
import com.portal.app.util.AppInfo;

@Controller
@RequestMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PageController 
{
	private static final Logger log = LoggerFactory.getLogger(PageController.class);
	
	@Autowired	private AppInfo 	appInfo;
	
	@GetMapping("/" )
	public String home (Model model, @ModelAttribute AppRequest request)
	{
		log.info("Get Home");
		
		model.addAttribute("id",			appInfo.getId() );
		model.addAttribute("name",			appInfo.getName());
		model.addAttribute("desc",			appInfo.getDesc() );
		model.addAttribute("version",		appInfo.getVersion() );
		model.addAttribute("release",		appInfo.getRelease() );
		model.addAttribute("developer",		appInfo.getDeveloper() );
		return "home";
	}
	
	@RequestMapping(value="/page/resources")
	public String resources(@ModelAttribute PageRequest request, ModelMap map)
	{
		map.addAttribute("resources", appInfo.getResources());
		return "resources";
	}

	@RequestMapping(value="/page/{page}")
	public String page(@PathVariable("page") String page, ModelMap map)
	{
		map.addAttribute("resources", appInfo.getResources());
		log.debug(" Página " +  page );
		return page+"/"+page;
	}
	
	@RequestMapping(value="/page/form/{menu}/{form}",method = RequestMethod.POST)
	public String form(	@PathVariable("menu") String  menu, 
						@PathVariable("form") String  form, 
						@RequestBody PageRequest request,
						ModelMap map)
	{
		log.debug("Menu " + menu +  " Form: "+ form +" : " +new Gson().toJson(request));
		
		map.addAttribute("resources", appInfo.getResources());
		map.addAttribute("object",request);
		
		return menu+"/"+form;
	}
}
