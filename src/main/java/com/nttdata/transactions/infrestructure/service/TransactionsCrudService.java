package com.nttdata.transactions.infrestructure.service;

import com.nttdata.transactions.domain.Transactions;
import com.nttdata.transactions.infrestructure.model.dao.TransactionsDao;
import com.nttdata.transactions.infrestructure.repository.TransactionsCrudRepository;
import com.nttdata.transactions.model.TransactionsRepository;
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


    public Transactions getTransactions(TransactionsDao accountDao){
        Transactions account = new Transactions();
        account.setId(accountDao.getId());
        account.setIdAccount(accountDao.getIdAccount());
        account.setIdAccountTwo(accountDao.getIdAccountTwo());
        account.setAmount(accountDao.getAmount());
        account.setTypeCredit(accountDao.getTypeCredit());
        account.setDate(LocalDateTime.now().toLocalDate());
        return account;
    }


    public TransactionsDao getTransactionsDao(Transactions transactions){
        TransactionsDao accountDao = new TransactionsDao();
        accountDao.setId(transactions.getId());
        accountDao.setIdAccount(transactions.getIdAccount());
        accountDao.setIdAccountTwo(transactions.getIdAccountTwo());
        accountDao.setAmount(transactions.getAmount());
        accountDao.setTypeCredit(transactions.getTypeCredit());
        accountDao.setDate(LocalDateTime.now().toLocalDate());
        return accountDao;
    }
}
