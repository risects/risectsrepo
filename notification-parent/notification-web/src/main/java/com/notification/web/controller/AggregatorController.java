package com.notification.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.notification.model.AccountDetails;
import com.notification.model.BankAccountDetails;
import com.notification.model.Database;

@Controller
@RequestMapping("/aggregator")
public class AggregatorController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Aggregator");
		return "register";

	}
	
	@RequestMapping(value = "/saveAccDetails", method = RequestMethod.POST)
	public String saveAccountDetails(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
	    System.out.println("save account details");
	    String chkboxValues[] = request.getParameterValues("bankChk");
	    System.out.println("values :: " + chkboxValues.length);
	    
	    String email = request.getParameter("email");
	    System.out.println("email :: " + email);
	    
	    String bankDetails = null;
	    String accountDetails [] = null;
	    String accNickName = null;
	    String custId = null;
	    String accType = null;
	    String accNo = null;
	    Database database = null;
	    AccountDetails details = null;
	    List<AccountDetails> accountDetailsList = new ArrayList<AccountDetails>();
	    BankAccountDetails bankAccountDetails = new BankAccountDetails();
	    
	    ApplicationContext context = new ClassPathXmlApplicationContext("/accountDetails.xml");
        database = (Database)context.getBean("database");

	    
	    for(int i = 0; i < chkboxValues.length; i++){
	        if(chkboxValues[i].equalsIgnoreCase("BarclaysAccount1")){
	            bankDetails = request.getParameter("bankValuesForBar1");
	        }else if(chkboxValues[i].equalsIgnoreCase("BarclaysAccount2")){
	            bankDetails = request.getParameter("bankValuesForBar2");
	        }else if(chkboxValues[i].equalsIgnoreCase("LLoydsAccount")){
	            bankDetails = request.getParameter("bankValuesForLLoyds");
	        }
	        System.out.println("bank details :: " + bankDetails);
	        accountDetails = bankDetails.split(",");
	        accNickName = accountDetails[0];
	        custId = accountDetails[1];
	        accType = accountDetails[2];
	        accNo = accountDetails[3];
	        
	        details = new AccountDetails();
	        details.setAccountId(accNo);
	        details.setAccountNickName(accNickName);
	        details.setAccountType(accType);
	        details.setCustomerId(custId);
	        details.setEmail(email);
	    }
	    accountDetailsList.add(details);
	    bankAccountDetails.setAccountDetails(accountDetailsList);
	    
	    database.putData(email, bankAccountDetails);
	    
	    System.out.println("values :: " + database.getMap());
	    return "confirmationPage";
	}


}
