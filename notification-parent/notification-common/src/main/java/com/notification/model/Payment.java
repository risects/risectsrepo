package com.notification.model;


		public class Payment
		{
		    private String[] tags;

		    private Amount amount;

		    private String description;

		    private PaymentDescriptor paymentDescriptor;

		    private String notes;

		    private String paymentMethod;

		    private Metadata[] metadata;

		    public String[] getTags ()
		    {
		        return tags;
		    }

		    public void setTags (String[] tags)
		    {
		        this.tags = tags;
		    }

		    public Amount getAmount ()
		    {
		        return amount;
		    }

		    public void setAmount (Amount amount)
		    {
		        this.amount = amount;
		    }

		    public String getDescription ()
		    {
		        return description;
		    }

		    public void setDescription (String description)
		    {
		        this.description = description;
		    }

		    public PaymentDescriptor getPaymentDescriptor ()
		    {
		        return paymentDescriptor;
		    }

		    public void setPaymentDescriptor (PaymentDescriptor paymentDescriptor)
		    {
		        this.paymentDescriptor = paymentDescriptor;
		    }

		    public String getNotes ()
		    {
		        return notes;
		    }

		    public void setNotes (String notes)
		    {
		        this.notes = notes;
		    }

		    public String getPaymentMethod ()
		    {
		        return paymentMethod;
		    }

		    public void setPaymentMethod (String paymentMethod)
		    {
		        this.paymentMethod = paymentMethod;
		    }

		    public Metadata[] getMetadata ()
		    {
		        return metadata;
		    }

		    public void setMetadata (Metadata[] metadata)
		    {
		        this.metadata = metadata;
		    }

		    
		
	

}
