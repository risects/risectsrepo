package com.notification.model;

public class AccountDetails {
    
    private String email;
    
    private String customerId;
    
    private String accountId;
    
    private String accountType;
    
    private String accountNickName;

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * @param accountId the accountId to set
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * @return the accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * @return the accountNickName
     */
    public String getAccountNickName() {
        return accountNickName;
    }

    /**
     * @param accountNickName the accountNickName to set
     */
    public void setAccountNickName(String accountNickName) {
        this.accountNickName = accountNickName;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "AccountDetails [email=" + email + ", customerId=" + customerId + ", accountId=" + accountId + ", accountType=" + accountType
                + ", accountNickName=" + accountNickName + "]";
    }
}
