package com.springBoot1.SB2.controller;

import com.springBoot1.SB2.dto.customer.ShowAllCustomerDTO;
import com.springBoot1.SB2.dto.transaction.ShowAllTransactionDTO;
import com.springBoot1.SB2.service.DashboardService;
import com.springBoot1.SB2.util.ApiResponseUtil;
import com.springBoot1.SB2.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${API.URL_PREFIX}dashboard")
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;
    @GetMapping("/latest-5transactions-added-by-current-user")
@CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getLatest5Transactions(){
        List<ShowAllTransactionDTO> latest5Transactions =
              dashboardService.getLatest5Transactions();
        return ApiResponseUtil.successPayload(latest5Transactions, HttpStatus.OK);
    }
    @GetMapping("/latest-5customers-added-by-current-user")
@CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getLatest5Customers(){
        List<ShowAllCustomerDTO> getLatest5Customers =
              dashboardService.getLatest5Customers();
        return ApiResponseUtil.successPayload(getLatest5Customers, HttpStatus.OK);
    }
    @GetMapping("/count-customers-added-by-current-user")
@CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getCountCustomers(){
        Integer countOfCustomers =
                dashboardService.getCountCustomers();
        return ApiResponseUtil.successPayload(countOfCustomers, HttpStatus.OK);
    }
    @GetMapping("/count-transactions-added-by-current-user")
@CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getCountTransaction(){
        Integer countOfTransactions =
              dashboardService.getCountTransaction();
        return ApiResponseUtil.successPayload(countOfTransactions, HttpStatus.OK);
    }
    @GetMapping("/latest-n-months-transaction-prices/{months}")
@CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> latestNMonthsTransactionPrices(@PathVariable("months") Integer months){
        return ApiResponseUtil.successPayload(dashboardService.getLatestNMonthsTransactionPrices(months), HttpStatus.OK);
    }

}
