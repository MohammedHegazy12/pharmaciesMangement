package com.springBoot1.SB2.repository;

import com.springBoot1.SB2.entity.Customer;
import com.springBoot1.SB2.entity.Transaction;
import com.springBoot1.SB2.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CustomerRepository extends BaseRepository<Customer, Long> {
    Optional<Customer> findByFnameAndLname(String fname, String lname);
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByPhone(String phone);
    @Query(nativeQuery = true, value = "SELECT * FROM customers where created_by =?1 ORDER BY id DESC LIMIT 5")
    public List<Customer> getLatest5Customers(String username);
    @Query(nativeQuery = true, value = "SELECT count(*) FROM customers where created_by =?1")
    public Integer getCountCustomers(String username);
}
