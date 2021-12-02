package com.bankguru.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class PaymentData {
	public static PaymentData getPayment() {
		try {
			ObjectMapper mapper=new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "\\testdata\\com\\bankguru\\data\\newCustomerData.json"),PaymentData.class);
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@JsonProperty("urlPage")
	private String urlPage;
	public String geturlPage() {
		return urlPage;
	}
	
	@JsonProperty("customerName")
	private String customerName;
	public String getcustomerName() {
		return customerName;
	}
	
	@JsonProperty("dob")
	private String dob;
	public String getDob() {
		return dob;
	}
	
	@JsonProperty("address")
	private String address;
	public String getAddress() {
		return address;
	}
	
	@JsonProperty("city")
	private String city;
	public String getCity() {
		return city;
	}
	
	@JsonProperty("state")
	private String state;
	public String getState() {
		return state;
	}
	
	@JsonProperty("pin")
	private String pin;
	public String getPin() {
		return pin;
	}
	
	@JsonProperty("mobile")
	private String mobile;
	public String getMobile() {
		return mobile;
	}
	
	@JsonProperty("emailCus")
	private String emailCus;
	public String getEmailCus() {
		return emailCus;
	}
	
	@JsonProperty("editAddress")
	private String editAddress;
	public String getEditAddress() {
		return editAddress;
	}
	
	@JsonProperty("editCity")
	private String editCity;
	public String getEditCity() {
		return editCity;
	}
	
	@JsonProperty("editState")
	private String editState;
	public String getEditState() {
		return editState;
	}
	
	@JsonProperty("editPin")
	private String editPin;
	public String getEditPin() {
		return editPin;
	}
	
	@JsonProperty("initialDeposit")
	private String initialDeposit;
	public String getInitialDeposit() {
		return initialDeposit;
	}
	
	@JsonProperty("amount")
	private String amount;
	public String getAmount() {
		return amount;
	}
	
	@JsonProperty("description")
	private String description;
	public String getDescription() {
		return description;
	}
	
	@JsonProperty("currentBalace")
	private String currentBalace;
	public String getCurrentBalace() {
		return currentBalace;
	}
	
	@JsonProperty("amountWithdrawal")
	private String amountWithdrawal;
	public String getAmountWithdrawal() {
		return amountWithdrawal;
	}
	
	@JsonProperty("descriptionWithdrawal")
	private String descriptionWithdrawal;
	public String getdescriptionWithdrawal() {
		return descriptionWithdrawal;
	}
	
	@JsonProperty("currentBalanceWithdrawal")
	private String currentBalanceWithdrawal;
	public String getCurrentBalanceWithdrawal() {
		return currentBalanceWithdrawal;
	}
	
	@JsonProperty("amountTransfer")
	private String amountTransfer;
	public String getAmountTransfer() {
		return amountTransfer;
	}
	
	@JsonProperty("descriptionTransfer")
	private String descriptionTransfer;
	public String getDescriptionTransfer() {
		return descriptionTransfer;
	}
	
	@JsonProperty("balance")
	private String balance;
	public String getBalance() {
		return balance;
	}
	
	@JsonProperty("password")
	private String password;
	public String getPassword() {
		return password;
	}
	
	@JsonProperty("gender")
	private String gender;
	public String getGender() {
		return gender;
	}
	
	@JsonProperty("dobOutput")
	private String dobOutput;
	public String getdobOutput() {
		return dobOutput;
	}
	
	
}
