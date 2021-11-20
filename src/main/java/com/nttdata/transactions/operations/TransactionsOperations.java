package com.nttdata.transactions.operations;

import com.nttdata.transactions.domain.Transactions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionsOperations {

    Flux<Transactions> findAll() throws Exception;

    Mono<Transactions> findById(Long id) throws Exception;

    Mono<Transactions> save(Transactions transactions) throws Exception;

    Mono<Transactions> update(Long id, Transactions transactions) throws Exception;

    Mono<Void> delete(Long id) throws Exception;
}
