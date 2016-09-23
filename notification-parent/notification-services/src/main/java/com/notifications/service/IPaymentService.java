package com.notifications.service;

public interface IPaymentService {
	
	public String customerPayment(String fromAccountNumber, String outAmount,String toAccountNumber);

	public String merchantPayment(String fromAccountNumber, String inAmount,String toAccountNumber);

}
