package com.nttdata.transaction.impl;


import com.nttdata.transaction.domain.Transactions;
import com.nttdata.transaction.model.TransactionsRepository;
import com.nttdata.transaction.operations.TransactionsOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionsImpl implements TransactionsOperations {


    private final TransactionsRepository transactionsRepository;

    @Override
    public Flux<Transactions> findAll() throws Exception{
        try {
            return transactionsRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Mono<Transactions> findById(Long id) throws Exception{
        try {
            return transactionsRepository.findById(id);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Mono<Transactions> save(Transactions transactions) throws Exception{
        try {
            return transactionsRepository.save(transactions);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Mono<Transactions> update(Long id, Transactions transactions) throws Exception{
        try {
            return transactionsRepository.update(id, transactions);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Mono<Void> delete(Long id) throws Exception{
        return transactionsRepository.delete(id);
    }

}
