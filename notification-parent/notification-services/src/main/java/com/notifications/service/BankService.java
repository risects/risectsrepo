package com.notifications.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.notification.model.BankDetail;

@Service("bankService")

public class BankService {

	public List<BankDetail> findAllBanks() {
		
		List<BankDetail> bankDetails = new ArrayList<BankDetail>();
		
		BankDetail bd1 = new BankDetail();
		
		bd1.setAccountType("checking");
		bd1.setActive(true);
		bd1.setBankName("HSBC UK");
		bd1.setBankSortCode("102-203-304");
		bankDetails.add(bd1);
		
		BankDetail bd2 = new BankDetail();
		
		bd2.setAccountType("savings");
		bd2.setActive(true);
		bd2.setBankName("Barclays");
		bd2.setBankSortCode("202-303-404");
		bankDetails.add(bd2);
		
		BankDetail bd3 = new BankDetail();
		
		bd3.setAccountType("current");
		bd3.setActive(false);
		bd3.setBankName("Lyods UK");
		bd3.setBankSortCode("904-503-704");
		bankDetails.add(bd3);
		
		return bankDetails;
	}

	 
	
}
