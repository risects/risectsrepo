package com.notification.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.notification.model.BankDetail;
import com.notification.utility.MessageHelper;
import com.notifications.service.BankService;
 
 
@Controller
public class AggregatorRestController {
	
	@Autowired
	BankService bankService;  //Service which will do all data retrieval/manipulation work
 
    //-------------------Retrieve All Bank details of given user--------------------------------------------------------
     
    @RequestMapping(value="/BankDetails" ,method = RequestMethod.GET)
    @ResponseBody
    public String listAllBanks() {
    	String response = null;
        List<BankDetail> banks = bankService.findAllBanks();
        if(banks.isEmpty()){
        	response = HttpStatus.NO_CONTENT.toString(); 
            //return response (HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        response =  MessageHelper.toJsonString(banks);
        return response;
        //return new ResponseEntity<List<BankDetail>>(banks, HttpStatus.OK);
    }
   
 
 
}