package com.notification.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.notification.utility.RestClientCaller;

@Controller
public class PaymentController {

	
		@RequestMapping(value="/payMerchant/{fromAccountNumber}/{amountValue}/{toAccountNumber}/{amountDirection}",method = RequestMethod.POST)
		@ResponseBody
		public String payTransactions (@PathVariable("fromAccountNumber") String fromAccountNumber,
									   @PathVariable("amountValue") String amountValue,
									   @PathVariable("amountDirection") String amountDirection,
									   @PathVariable("toAccountNumber") String toAccountNumber){
		String response = "Thank you for using our service. " + "\n"
				+ "Your Transaction Ref number is 8573315966758940.";
		new RestClientCaller().postCall(fromAccountNumber, toAccountNumber ,amountDirection, amountValue);
			return response;
		} 
	

}
