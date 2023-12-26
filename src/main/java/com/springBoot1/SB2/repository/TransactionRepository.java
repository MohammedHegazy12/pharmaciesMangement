package com.springBoot1.SB2.repository;

import com.springBoot1.SB2.entity.Transaction;
import com.springBoot1.SB2.repository.base.BaseRepository;
import com.springBoot1.SB2.repository.custom.NMonthsTransactionPricesMap;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends BaseRepository<Transaction, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM transactions where created_by =?1 ORDER BY id DESC LIMIT 5")
    public List<Transaction> getLatest5Transactions(String username);
    @Query(nativeQuery = true, value = "SELECT count(*) FROM transactions where created_by =?1")
    public Integer getCountTransaction(String username);
    @Query(nativeQuery = true, value = "SELECT SUM(price) AS summation, MONTH(created_at) as mnth, YEAR(created_at) as yer FROM  transactions WHERE created_by = ?1  GROUP BY yer, mnth ORDER BY yer DESC, mnth DESC LIMIT ?2")
    public List<NMonthsTransactionPricesMap> latestNMonthsTransactionPrices(String username, Integer months);
}
