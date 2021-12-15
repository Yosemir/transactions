package com.nttdata.transaction.infrestructure.service;


import com.nttdata.transaction.domain.Transactions;
import com.nttdata.transaction.infrestructure.model.dao.TransactionsDao;
import com.nttdata.transaction.infrestructure.repository.TransactionsCrudRepository;
import com.nttdata.transaction.model.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;


@Component
public class TransactionsCrudService implements TransactionsRepository {


    @Autowired
    private TransactionsCrudRepository transactionsCrudRepository;

    @Override
    public Flux<Transactions> findAll() {
        return transactionsCrudRepository.findAll().map(transactionsDao -> getTransactions(transactionsDao));
    }

    @Override
    public Mono<Transactions> findById(Long id) {
        return transactionsCrudRepository.findById(id).map(transactionsDao -> getTransactions(transactionsDao));
    }

    @Override
    public Mono<Transactions> save(Transactions transactions) {
        return transactionsCrudRepository.save(getTransactionsDao(transactions)).map(this::getTransactions);
    }

    @Override
    public Mono<Transactions> update(Long id, Transactions transactions) {
        return transactionsCrudRepository.save(getTransactionsDao(transactions)).map(this::getTransactions);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return transactionsCrudRepository.deleteById(id);
    }




    public Transactions getTransactions(TransactionsDao transactionsDao){
        Transactions transactions = new Transactions();
        transactions.setId(transactionsDao.getId());
        transactions.setIdAccount(transactionsDao.getIdAccount());
        transactions.setAmount(transactionsDao.getAmount());
        transactions.setCommissionTrans(transactionsDao.getCommissionTrans());
        transactions.setDate(LocalDateTime.now().toLocalDate());
        return transactions;
    }


    public TransactionsDao getTransactionsDao(Transactions transactions){
        TransactionsDao transactionsDao = new TransactionsDao();
        transactionsDao.setId(transactions.getId());
        transactionsDao.setIdAccount(transactions.getIdAccount());
        transactionsDao.setAmount(transactions.getAmount());
        transactionsDao.setCommissionTrans(transactions.getCommissionTrans());
        transactionsDao.setDate(LocalDateTime.now().toLocalDate());
        return transactionsDao;
    }


}
