package com.caprusit.ems.controller;

import org.springframework.http.MediaType;
import java.io.Serializable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.caprusit.ems.domain.Employee;
import com.caprusit.ems.service.IManageUserService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;

@Controller
@RestController
public class ManageUserController implements Serializable{

	private static final long serialVersionUID = 1L;
	@Autowired
	private IManageUserService manageUserService;
	
	@RequestMapping(value = "/getAllProfiles", method = RequestMethod.GET)
	public @ResponseBody String getAllProfiles( ModelMap model ) {
	    String jsonData = "[{\"firstname\":\"ajitesh\",\"lastname\":\"kumar\",\"address\":\"211/20-B,mgstreet\",\"city\":\"hyderabad\",\"phone\":\"999-888-6666\"},{\"firstname\":\"nidhi\",\"lastname\":\"rai\",\"address\":\"201,mgstreet\",\"city\":\"hyderabad\",\"phone\":\"999-876-5432\"}]";
	    return jsonData;
	}
}
