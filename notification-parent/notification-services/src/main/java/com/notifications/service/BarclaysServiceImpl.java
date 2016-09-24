package com.notifications.service;

import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.notification.utility.FileUtility;
import com.notification.utility.RestClientCaller;


@Service("barclaysService")
public class BarclaysServiceImpl implements IBarclaysService {

	public static final String GET_CUSTOMERS = "http://api108448live.gateway.akana.com/customers";
	
	public static final String GET_TRANSACTIONS = "http://api112477live.broker.soa.com/transactions/8384692676375758";
	
	public static final String GET_MERCHANTS = "http://api108564live.gateway.akana.com/merchants";
	
	
	public String getCustomersList() {
		
		return new RestClientCaller().callRestUrl(GET_CUSTOMERS);
	}

	public String getMerchantsList() {
		return new RestClientCaller().callRestUrl(GET_MERCHANTS);
	}

	public String getTransactions() {
		String response = null;
		
		// response = new RestClientCaller().callRestUrl(GET_TRANSACTIONS);
		InputStream in = this.getClass().getResourceAsStream("/transactions.json");
		response = new FileUtility().getStringFromInputStream(in);
		return response;
	}
	
}
