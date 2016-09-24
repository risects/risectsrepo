package com.notification.web.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class generateTransactionData {

	public static void main(String[] args) {
		generateTransactionData obj = new generateTransactionData();
		System.out.println(obj.getFile("transactions.json"));
	  }

	  private String getFile(String fileName) {

		StringBuilder result = new StringBuilder("");

		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		try  {
			 BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				
				result.append(line).append("\n");
			}

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(result.toString());
		return result.toString();

	  }
		
		
		
		
		/*

		List<Payment> paymentList = new ArrayList<Payment>();
		Payment paymentRequest1 =  new Payment();
		
		Amount amount1 = new Amount();
		amount1.setDirection("OUT");
		amount1.setValue("10.00");
		
		paymentRequest1.setAmount(amount1);
		
		paymentRequest1.setDescription("From account number" + "8573315966758940");
		
		PaymentDescriptor paymentDescriptor1 = new PaymentDescriptor();
		paymentDescriptor1.setPaymentDescriptorType("INDIVIDUAL");
		// Send to account id
		paymentDescriptor1.setId("9701229312305196");
		paymentRequest1.setTransactionDate("2016-05-04");
		paymentRequest1.setTransactionType("FOOD");
		
		paymentRequest1.setPaymentDescriptor(paymentDescriptor1);
	
		Metadata metaData1 = new Metadata();
		
		metaData1.setKey("RECEIPT");
		metaData1.setValue("https://upload.wikimedia.org/wikipedia/common");
		
		Metadata[] metaDataArr1 = {metaData1};
		
		paymentRequest1.setMetadata(metaDataArr1);

		String[] tags1 = {"RETAIL"};
		
		paymentRequest1.setTags(tags1 );
		
		paymentRequest1.setNotes("null");
		paymentRequest1.setPaymentMethod("CARD");
		paymentRequest1.setAccountType("Saving");
		paymentRequest1.setBankName("Barclays");
		paymentRequest1.setEmail("hackathonrise@gmail.com");
		
		Payment paymentRequest2 =  new Payment();
		
		Amount amount2 = new Amount();
		amount2.setDirection("OUT");
		amount2.setValue("20.00");
		
		paymentRequest2.setAmount(amount2);
		
		paymentRequest2.setDescription("From account number" + "8573325966758940");
		
		PaymentDescriptor paymentDescriptor2 = new PaymentDescriptor();
		paymentDescriptor2.setPaymentDescriptorType("INDIVIDUAL");
		// Send to account id
		paymentDescriptor2.setId("9702229322305296");
		paymentRequest2.setTransactionDate("2026-03-01");
		paymentRequest2.setTransactionType("FOOD");
		
		paymentRequest2.setPaymentDescriptor(paymentDescriptor2);
	
		Metadata metaData2 = new Metadata();
		
		metaData2.setKey("RECEIPT");
		metaData2.setValue("https://upload.wikimedia.org/wikipedia/common");
		
		Metadata[] metaDataArr2 = {metaData2};
		
		paymentRequest2.setMetadata(metaDataArr2);

		String[] tags2 = {"RETAIL"};
		
		paymentRequest2.setTags(tags2 );
		
		paymentRequest2.setNotes("null");
		paymentRequest2.setPaymentMethod("CARD");
		paymentRequest2.setAccountType("Saving");
		paymentRequest2.setBankName("Barclays");
		paymentRequest2.setEmail("rise.cts@gmail.com");
		paymentRequest2.setPaymentMethod("CARD");
		
		paymentList.add(paymentRequest1);
		paymentList.add(paymentRequest2);
		
		System.out.println(MessageHelper.toJsonString(paymentList));
		
	*/
		
	}

