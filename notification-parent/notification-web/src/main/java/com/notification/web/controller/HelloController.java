package com.notification.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.notifications.service.HelloService;

/**
 * @author RAHUL
 *
 */
@Controller
public class HelloController {
	@Autowired
	private HelloService helloService;
	
	
	@RequestMapping(value="/userDetails/{userName}",method = RequestMethod.GET)
	@ResponseBody
	public void isUserName (@PathVariable String userName){
	System.out.println("==============>"+userName);
	helloService.getName(userName);
	} 
	
	@RequestMapping(value="/status",method = RequestMethod.GET)
	@ResponseBody
	public String getStatus (){
	
	return "Version 1.0 : "+ HttpStatus.OK.toString() + "  Ok";
	} 
}
