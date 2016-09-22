package com.notification.model;

public class AccountList {

	private String id;
	private String description;
	private String nickName;
	private String customerId;
	private String accountType;
	private Integer sortCode;
	private String accountNo;
	private Integer currentBalance;
	private Card card;
	private Integer overdraftLimit;

	/**
	 * 
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 *            The description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return The nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * 
	 * @param nickName
	 *            The nickName
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	 * @return The accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * 
	 * @param accountType
	 *            The accountType
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * 
	 * @return The sortCode
	 */
	public Integer getSortCode() {
		return sortCode;
	}

	/**
	 * 
	 * @param sortCode
	 *            The sortCode
	 */
	public void setSortCode(Integer sortCode) {
		this.sortCode = sortCode;
	}

	/**
	 * 
	 * @return The accountNo
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * 
	 * @param accountNo
	 *            The accountNo
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
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
	 * @return The card
	 */
	public Card getCard() {
		return card;
	}

	/**
	 * 
	 * @param card
	 *            The card
	 */
	public void setCard(Card card) {
		this.card = card;
	}

	/**
	 * 
	 * @return The overdraftLimit
	 */
	public Integer getOverdraftLimit() {
		return overdraftLimit;
	}

	/**
	 * 
	 * @param overdraftLimit
	 *            The overdraftLimit
	 */
	public void setOverdraftLimit(Integer overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

}
