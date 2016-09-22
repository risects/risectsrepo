package com.notification.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.notification.model.BankDetail;
import com.notifications.service.BankService;
 
 
@Controller
public class AggregatorRestController {
	
	@Autowired
	BankService bankService;  //Service which will do all data retrieval/manipulation work
 
    //-------------------Retrieve All Bank details of given user--------------------------------------------------------
     
    @RequestMapping(value="/getBankDetails" ,method = RequestMethod.GET)
    public ResponseEntity<List<BankDetail>> listAllBanks() {
        List<BankDetail> banks = bankService.findAllBanks();
        if(banks.isEmpty()){
            return new ResponseEntity<List<BankDetail>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<BankDetail>>(banks, HttpStatus.OK);
    }
 
 
}