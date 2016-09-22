package com.notifications.service;

import org.springframework.stereotype.Service;

import com.notification.utility.RestClientCaller;


@Service("barclaysService")
public class BarclaysServiceImpl implements IBarclaysService {

	public static final String GET_CUSTOMERS = "customers";
	
	public static final String GET_TRANSACTIONS = "transactions/8384692676375758";
	
	public static final String GET_MERCHANTS = "merchants";
	
	RestClientCaller clientCaller;
	
	public String getCustomersList() {
		
		return clientCaller.callRestUrl(GET_CUSTOMERS);
	}

	public String getMerchantsList() {
		return clientCaller.callRestUrl(GET_TRANSACTIONS);
	}

	public String getTransactions() {
		return clientCaller.callRestUrl(GET_MERCHANTS);
	}

	

}
