package com.notification.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.twilio.sdk.TwilioRestException;

@Controller
public class TwilioController {


		@RequestMapping(value="/sendSms/{toNumber}/{bodyMessage}",method = RequestMethod.POST)
		@ResponseBody
		public String sendSms (@PathVariable("toNumber") String toNumber, @PathVariable("bodyMessage") String bodyMessage){
		String response = "Message sent to " + toNumber;
		try {
			new SmsSender().sendMessage(toNumber,bodyMessage);
		} catch (TwilioRestException e) {
			e.printStackTrace();
			response = "Unable to sent sms to " + toNumber;
		}
		return response;
		} 
	

}