package com.caprusit.ems.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.caprusit.ems.domain.Admin;
import com.caprusit.ems.service.ISecurityService;

@Controller
@Scope("session")
public class SecurityController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ISecurityService securityService;

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(Admin admin) {

		ModelAndView model = new ModelAndView("login");
		return model;
	}

	@RequestMapping(value = "/changePassword.do", method = RequestMethod.POST)
	 public ModelAndView changePassword(HttpServletRequest request,
			                                      @RequestParam("cpwd") String oldPassword,
			                                                    @RequestParam("npwd") String newPassword
			                                                                ){
		
		//System.out.println(adminId);
		System.out.println(oldPassword + "   " + newPassword );
		String targetView = "/WEB-INF/views/ChangePassword.jsp";
		String status = "hello";
	/*	if (oldPassword != null && oldPassword.trim().length() > 0 && newPassword != null
				&& newPassword.trim().length() > 0 && confirmPassword != null && confirmPassword.trim().length() > 0) {
			if (newPassword.equals(confirmPassword)) {
				
			     } 
			else {
				status = "new password and confirm password are n't matched ";
			        }
		     } 
		else {
			status = " Password fields must not be empty";
		         } */
		Admin admin = new Admin();
		//admin.setAdminId(adminId);
		admin.setPassword(newPassword);
		System.out.println(admin);  
		String statusMsg = securityService.changePassword(admin);

		status = statusMsg;
		ModelAndView model = new ModelAndView(targetView, "status", status);
		model.addObject("statusMsg", statusMsg);

		return model;
	}

	
	
}
