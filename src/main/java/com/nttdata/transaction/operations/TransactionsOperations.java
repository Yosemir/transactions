package com.nttdata.transaction.operations;

import com.nttdata.transaction.domain.Transactions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionsOperations {

    Flux<Transactions> findAll();

    Mono<Transactions> findById(Long id);

    Mono<Transactions> save(Transactions transactions);

    Mono<Transactions> update(Long id, Transactions transactions);

    Mono<Void> delete(Long id);
}
