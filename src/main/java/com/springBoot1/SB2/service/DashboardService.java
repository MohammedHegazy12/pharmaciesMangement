package com.springBoot1.SB2.service;

import com.springBoot1.SB2.dto.customer.ShowAllCustomerDTO;
import com.springBoot1.SB2.dto.transaction.ShowAllTransactionDTO;
import com.springBoot1.SB2.repository.custom.NMonthsTransactionPricesMap;
import com.springBoot1.SB2.repository.custom.NMonthsTransactionPricesMapImpl;

import java.util.List;

public interface DashboardService {
    public List<ShowAllTransactionDTO> getLatest5Transactions();
    public List<ShowAllCustomerDTO> getLatest5Customers();
    public Integer getCountCustomers();
    public Integer getCountTransaction();
    public  List<NMonthsTransactionPricesMapImpl> getLatestNMonthsTransactionPrices(Integer months);
}
