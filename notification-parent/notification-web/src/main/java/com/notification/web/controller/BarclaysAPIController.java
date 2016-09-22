package com.notification.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.notifications.service.IBarclaysService;


@Controller
public class BarclaysAPIController {

	private IBarclaysService barclaysAPI;
	
	@RequestMapping(value="/getCustomerList",method = RequestMethod.GET)
	@ResponseBody
	public String getCustomerList (){
	
	return barclaysAPI.getCustomersList();
	}
	
	@RequestMapping(value="/getMerchantsList",method = RequestMethod.GET)
	@ResponseBody
	public String getMerchantsList() {
		return barclaysAPI.getMerchantsList();
	}
	
	@RequestMapping(value="/getTransactionsList",method = RequestMethod.GET)
	@ResponseBody
	public String getTransactions() {
		return barclaysAPI.getTransactions();
	}
	
	
}
