package com.notification.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.notification.model.Amount;
import com.notification.model.Metadata;
import com.notification.model.Payment;
import com.notification.model.PaymentDescriptor;

public class RestClientCaller {
	
	public String callRestUrl(String url) {
		String output = null;
		try {


			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(url);
			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			StringBuilder sb =  new StringBuilder();
			while ((output = br.readLine()) != null) {
				sb = sb.append(output);
			}
			output =  sb.toString();
			httpClient.getConnectionManager().shutdown();

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return output;

	}
	
	public String postCall(String fromAccountNumber,String toAccountNumber ,String amountDirection,String amountValue)
	{
		String url = "https://api108567live.gateway.akana.com:443/accounts/"+fromAccountNumber+"/transactions";
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost(url);
			
			Payment paymentRequest =  new Payment();
			
			Amount amount = new Amount();
			amount.setDirection(amountDirection);
			amount.setValue(amountValue);
			
			paymentRequest.setAmount(amount);
			
			paymentRequest.setDescription("From account number" + fromAccountNumber);
			
			PaymentDescriptor paymentDescriptor = new PaymentDescriptor();
			paymentDescriptor.setPaymentDescriptorType("INDIVIDUAL");
			paymentDescriptor.setId(toAccountNumber);
			
			paymentRequest.setPaymentDescriptor(paymentDescriptor);
		
			Metadata metaData1 = new Metadata();
			
			metaData1.setKey("RECEIPT");
			metaData1.setValue("https://upload.wikimedia.org/wikipedia/common");
			
			Metadata[] metaData = {metaData1};
			
			paymentRequest.setMetadata(metaData);

			String[] tags = {"RETAIL"};
			
			paymentRequest.setTags(tags );
			
			paymentRequest.setNotes("null");
			paymentRequest.setPaymentMethod("CARD");
			
			//System.out.println(MessageHelper.toJsonString(paymentRequest));
			StringEntity input = new StringEntity(MessageHelper.toJsonString(paymentRequest));
			postRequest.setEntity(input);
			postRequest.addHeader("accept", "application/json");
			HttpResponse response = httpClient.execute(postRequest);
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Your unique transaction reference number is :"+  UUID.randomUUID();
	}
	
	
}


