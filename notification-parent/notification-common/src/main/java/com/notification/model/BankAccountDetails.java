package com.notification.model;

import java.util.List;

public class BankAccountDetails {
    
    private List<AccountDetails> accountDetails;

    /**
     * @return the accountDetails
     */
    public List<AccountDetails> getAccountDetails() {
        return accountDetails;
    }

    /**
     * @param accountDetails the accountDetails to set
     */
    public void setAccountDetails(List<AccountDetails> accountDetails) {
        this.accountDetails = accountDetails;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BankAccountDetails [accountDetails=" + accountDetails + "]";
    }
}
