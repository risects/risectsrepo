package com.notification.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String id;

	private String title;

	private String firstName;

	private String lastName;

	private String middleNames;

	private String mobileNo;

	private String nationalityCode;

	private String dateOfBirth;

	private Address address;

	private Boolean isNewToBank;

	private List<AccountList> accountList = new ArrayList<AccountList>();

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
	 * @return The title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title
	 *            The title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return The firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @param firstName
	 *            The firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return The lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @param lastName
	 *            The lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return The middleNames
	 */
	public String getMiddleNames() {
		return middleNames;
	}

	/**
	 * 
	 * @param middleNames
	 *            The middleNames
	 */
	public void setMiddleNames(String middleNames) {
		this.middleNames = middleNames;
	}

	/**
	 * 
	 * @return The mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * 
	 * @param mobileNo
	 *            The mobileNo
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * 
	 * @return The nationalityCode
	 */
	public String getNationalityCode() {
		return nationalityCode;
	}

	/**
	 * 
	 * @param nationalityCode
	 *            The nationalityCode
	 */
	public void setNationalityCode(String nationalityCode) {
		this.nationalityCode = nationalityCode;
	}

	/**
	 * 
	 * @return The dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * 
	 * @param dateOfBirth
	 *            The dateOfBirth
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * 
	 * @return The address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * 
	 * @param address
	 *            The address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * 
	 * @return The isNewToBank
	 */
	public Boolean getIsNewToBank() {
		return isNewToBank;
	}

	/**
	 * 
	 * @param isNewToBank
	 *            The isNewToBank
	 */
	public void setIsNewToBank(Boolean isNewToBank) {
		this.isNewToBank = isNewToBank;
	}

	/**
	 * 
	 * @return The accountList
	 */
	public List<AccountList> getAccountList() {
		return accountList;
	}

	/**
	 * 
	 * @param accountList
	 *            The accountList
	 */
	public void setAccountList(List<AccountList> accountList) {
		this.accountList = accountList;
	}

}
