package com.notification.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

public class SmsSender {
	// Find your Account Sid and Token at twilio.com/user/account
	public static final String ACCOUNT_SID = "AC32cfd63ef917f6e483d9fea7782d5eaa";
	public static final String AUTH_TOKEN = "bbdb1c780650dba0352e7d8106ad02e0";

	public static void main(String[] args) throws TwilioRestException {
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

		// Build the parameters
		List params = new ArrayList();

		params.add(new BasicNameValuePair("To", "9552277877"));
		params.add(new BasicNameValuePair("From", "9552277877"));
		params.add(new BasicNameValuePair("Body",
				"Finally got message from Twilio"));

		MessageFactory messageFactory = client.getAccount().getMessageFactory();
		Message message = messageFactory.create(params);

		System.out.println(message.getSid());

	}
}
