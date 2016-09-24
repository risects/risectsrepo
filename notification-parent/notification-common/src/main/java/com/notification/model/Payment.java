package com.notification.model;


		public class Payment
		{
		    private String[] tags;

		    private Amount amount;

		    private String description;
		    
		    private String accountType;
		    
		    private String email;

		    private PaymentDescriptor paymentDescriptor;

		    private String notes;

		    private String paymentMethod;

		    private Metadata[] metadata;
		    
		    private String transactionDate;
		    
		    private String transactionType;
		    
		    public String getTransactionType() {
				return transactionType;
			}

			public void setTransactionType(String transactionType) {
				this.transactionType = transactionType;
			}

			private String bankName;
		    
		    //yyyy-mm-dd
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

		    public String getAccountType() {
				return accountType;
			}

			public void setAccountType(String accountType) {
				this.accountType = accountType;
			}

			public String getTransactionDate() {
				return transactionDate;
			}

			public void setTransactionDate(String transactionDate) {
				this.transactionDate = transactionDate;
			}

			public String getBankName() {
				return bankName;
			}

			public void setBankName(String bankName) {
				this.bankName = bankName;
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

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

}
