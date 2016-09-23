package com.notification.model;

public class PaymentDescriptor {

	
	    private String id;

	    private String paymentDescriptorType;

	    public String getId ()
	    {
	        return id;
	    }

	    public void setId (String id)
	    {
	        this.id = id;
	    }

	    public String getPaymentDescriptorType ()
	    {
	        return paymentDescriptorType;
	    }

	    public void setPaymentDescriptorType (String paymentDescriptorType)
	    {
	        this.paymentDescriptorType = paymentDescriptorType;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [id = "+id+", paymentDescriptorType = "+paymentDescriptorType+"]";
	    }
	}


