package com.notification.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.notification.model.Offer;
import com.notification.utility.MessageHelper;
import com.notifications.service.BankService;


@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	BankService bankService;
	
	@RequestMapping(value="/offers/{custEmailId}",method = RequestMethod.GET)
	@ResponseBody
	public String getCustomerOfferList (@PathVariable("custEmailId") String custEmailId){
	
		// find by email id
    	List<Offer> bankOffers = bankService.findAllOffersByEmailId(custEmailId);
       
        return MessageHelper.toJsonString(bankOffers);
   
	}
	
}
