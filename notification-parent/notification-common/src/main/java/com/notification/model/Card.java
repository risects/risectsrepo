package com.notification.model;

public class Card {

	private String cardNumber;

	private String displayName;

	private Integer maxSpend;

	private Integer currentBalance;

	private String type;

	private String customerId;

	private String expiryDate;

	/**
	 * 
	 * @return The cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * 
	 * @param cardNumber
	 *            The cardNumber
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * 
	 * @return The displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * 
	 * @param displayName
	 *            The displayName
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * 
	 * @return The maxSpend
	 */
	public Integer getMaxSpend() {
		return maxSpend;
	}

	/**
	 * 
	 * @param maxSpend
	 *            The maxSpend
	 */
	public void setMaxSpend(Integer maxSpend) {
		this.maxSpend = maxSpend;
	}

	/**
	 * 
	 * @return The currentBalance
	 */
	public Integer getCurrentBalance() {
		return currentBalance;
	}

	/**
	 * 
	 * @param currentBalance
	 *            The currentBalance
	 */
	public void setCurrentBalance(Integer currentBalance) {
		this.currentBalance = currentBalance;
	}

	/**
	 * 
	 * @return The type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            The type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return The customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * 
	 * @param customerId
	 *            The customerId
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * 
	 * @return The expiryDate
	 */
	public String getExpiryDate() {
		return expiryDate;
	}

	/**
	 * 
	 * @param expiryDate
	 *            The expiryDate
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

}
