package com.springBoot1.SB2.service;

import com.springBoot1.SB2.dto.customer.ShowAllCustomerDTO;
import com.springBoot1.SB2.dto.transaction.ShowAllTransactionDTO;
import com.springBoot1.SB2.mapper.customer.CustomerMapper;
import com.springBoot1.SB2.mapper.transaction.TransactionMapper;
import com.springBoot1.SB2.repository.CustomerRepository;
import com.springBoot1.SB2.repository.TransactionRepository;
import com.springBoot1.SB2.repository.custom.NMonthsTransactionPricesMap;
import com.springBoot1.SB2.repository.custom.NMonthsTransactionPricesMapImpl;
import com.springBoot1.SB2.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardServiceImpl implements  DashboardService{
   @Autowired
    private TransactionRepository transactionRepository;
   @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TransactionMapper transactionMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public List<ShowAllTransactionDTO> getLatest5Transactions() {
        return transactionMapper.mapToShowAll(transactionRepository.getLatest5Transactions(UserUtil.getCurrentUsername()));
    }

    @Override
    public List<ShowAllCustomerDTO> getLatest5Customers() {
        return customerMapper.mapToShowAll(customerRepository.getLatest5Customers(UserUtil.getCurrentUsername()));
    }

    @Override
    public Integer getCountCustomers() {
        return customerRepository.getCountCustomers(UserUtil.getCurrentUsername());
    }

    @Override
    public Integer getCountTransaction() {
        return transactionRepository.getCountTransaction(UserUtil.getCurrentUsername());
    }

    @Override
    public List<NMonthsTransactionPricesMapImpl> getLatestNMonthsTransactionPrices(Integer months) {
        return transactionRepository.latestNMonthsTransactionPrices(UserUtil.getCurrentUsername(),months).stream()
                .map(nm -> new NMonthsTransactionPricesMapImpl(nm.getSummation(),nm.getMnth(),nm.getYer()))
                .collect(Collectors.toList());
    }
}
