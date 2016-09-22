package com.notification.model;

import java.io.Serializable;

public class BankDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5517485207514865686L;
	private String bankName;
	private String bankSortCode;
	private String accountType;
	private boolean active;
	
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankSortCode() {
		return bankSortCode;
	}
	public void setBankSortCode(String bankSortCode) {
		this.bankSortCode = bankSortCode;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
