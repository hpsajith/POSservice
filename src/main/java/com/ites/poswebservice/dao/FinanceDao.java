package com.ites.poswebservice.dao;

/**
 * Created by wannix on 1/18/17.
 */
public interface FinanceDao {
    void addFinancePosting(String bil, String refNo, String itemNo, int subDepNo, Double amt, String date, int uId, String rQty, String binIn, Double qty, int cat2);
}
