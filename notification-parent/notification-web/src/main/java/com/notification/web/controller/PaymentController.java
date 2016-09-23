package com.notification.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PaymentController {


		@RequestMapping(value="/payMerchant/{fromAccountNumber}/{toAccountNumber}",method = RequestMethod.POST)
		@ResponseBody
		public String sendSms (@PathVariable("fromAccountNumber") String fromAccountNumber, @PathVariable("toAccountNumber") String toAccountNumber){
		String response = "Thank you for using our service. " + "\n"
				+ "Your Transaction Ref number is 8573315966758940.";
			return response;
		} 
	

}
