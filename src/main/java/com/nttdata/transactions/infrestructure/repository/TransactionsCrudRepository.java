package com.nttdata.transactions.infrestructure.repository;


import com.nttdata.transactions.infrestructure.model.dao.TransactionsDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsCrudRepository extends ReactiveCrudRepository<TransactionsDao, Long> {


}
