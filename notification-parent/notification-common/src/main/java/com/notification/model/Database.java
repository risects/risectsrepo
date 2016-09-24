package com.notification.model;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private Map<String, BankAccountDetails> map = new HashMap<String, BankAccountDetails>();

    /**
     * @return the map
     */
    public Map<String, BankAccountDetails> getMap() {
        return map;
    }

    /**
     * @param map
     *            the map to set
     */
    public void setMap(Map<String, BankAccountDetails> map) {
        this.map = map;
    }
    public void putData(String key, BankAccountDetails value) {
        this.map.put(key, value);
    }
}
