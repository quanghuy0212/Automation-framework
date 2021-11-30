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
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "testdata\\com\\bankguru\\data\\newCustomerData.json"),PaymentData.class);
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	@JsonProperty("name")
	private String name;
	public String getName() {
		return name;
	}
	
	
}
