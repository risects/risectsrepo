package com.notifications.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.notification.model.BankDetail;
import com.notification.model.Offer;

@Service("bankService")

public class BankService {

	public List<BankDetail> findAllBanks() {
		
		List<BankDetail> bankDetails = new ArrayList<BankDetail>();
		
		/*BankDetail bd1 = new BankDetail();
		
		bd1.setAccountType("checking");
		bd1.setActive(true);
		bd1.setBankName("HSBC UK");
		bd1.setBankSortCode("102-203-304");
		bankDetails.add(bd1);*/
		
		BankDetail bd2 = new BankDetail();
		
		bd2.setAccountType("savings");
		bd2.setActive(true);
		bd2.setBankName("Barclays");
		bd2.setBankSortCode("202-303-404");
		bankDetails.add(bd2);
		
		BankDetail bd3 = new BankDetail();
		
		bd3.setAccountType("current");
		bd3.setActive(false);
		bd3.setBankName("Llyods UK");
		bd3.setBankSortCode("904-503-704");
		bankDetails.add(bd3);
		
		return bankDetails;
	}

	public List<Offer> findAllOffersByEmailId(String emailId) {
		
		List<Offer> offerList = new ArrayList<Offer>();
		
		Offer o1 = new Offer();
		o1.setCouponCode("90MILES");
		o1.setDescription("Enjoy 20,000 Bonus Miles when you Spend $1,000 in the First 90 Days!!");
		o1.setOfferedBy("BANK");
		
		Offer o2 = new Offer();
		o2.setCouponCode("10MILES");
		o2.setDescription("Get 10% Miles Back when you Redeem for Travel Statement Credits!!");
		o2.setOfferedBy("BANK");
		
		Offer o3 = new Offer();
		o3.setCouponCode("5OFF50US");
		o3.setDescription("$5 Off $50+ On Select Hotels");
		o3.setOfferedBy("BANK");
		
		Offer o4 = new Offer();
		o4.setCouponCode("100FF100US");
		o4.setDescription("Choose Your Own Coupons and Up to 12% Off or $100 Off!");
		o4.setOfferedBy("BANK");
		
		Offer o5 = new Offer();
		o5.setCouponCode("TN10SAVE");
		o5.setDescription("TicketNetwork: 10% Off Last-Minute Ticket Purchases");
		o5.setOfferedBy("BANK");
		
		Offer o6 = new Offer();
		o6.setCouponCode("BARCARD5");
		o6.setDescription("Enjoy $5 discount when you Spend $1,000");
		o6.setOfferedBy("BANK");
		
		Offer o7 = new Offer();
		o7.setCouponCode("10LLOYDS");
		o7.setDescription("10% Cashback @ Sizzling Pubs/Ember Inns/Harvester/Crown Carveries/Vintage Inns/Toby Carvery.");
		o7.setOfferedBy("BANK");
		
		Offer o8 = new Offer();
		o8.setCouponCode("10LLOYDS");
		o8.setDescription("5% off Argos when paying with Lloyds Debit Card and other exclusive offers.");
		o8.setOfferedBy("BANK");
		
		Offer o9 = new Offer();
		o9.setCouponCode("EARN10");
		o9.setDescription("Earn 10% cashback at Morrisons when you pay with your Lloyds debit or credit card.");
		o9.setOfferedBy("BANK");
		
		Offer o10 = new Offer();
		o10.setCouponCode("HOTEL10US");
		o10.setDescription("Choose Your Own Coupons and Up to 12% Off or $HOTEL0 Off!");
		o10.setOfferedBy("MERCHANT");
		
		Offer o11 = new Offer();
		o11.setCouponCode("HOTELSAVE");
		o11.setDescription("15% Off Early bird Booking");
		o11.setOfferedBy("MERCHANT");
		
		Offer o12 = new Offer();
		o12.setCouponCode("5");
		o12.setDescription("Enjoy $5 discount on your birthday!!");
		o12.setOfferedBy("MERCHANT");
		
		Offer o13 = new Offer();
		o13.setCouponCode("HOTELUNILIMITED");
		o13.setDescription("Try the unlimited (veg and non-veg) Price: Rs. 550 per person (inclusive of tax).");
		o13.setOfferedBy("MERCHANT");
		
		Offer o14 = new Offer();
		o14.setCouponCode("EARNHOTEL");
		o14.setDescription("15% on Food and Soft Beverages.");
		o14.setOfferedBy("MERCHANT");
		
			offerList.add(o1);
			offerList.add(o2);
			offerList.add(o3);
			offerList.add(o4);
			offerList.add(o5);
			offerList.add(o6);
			offerList.add(o7);
			offerList.add(o8);
			offerList.add(o9);
			offerList.add(o10);
			offerList.add(o11);
			offerList.add(o12);
			offerList.add(o13);
			offerList.add(o14);
			
		
		return offerList;
	}

	 
	
}
