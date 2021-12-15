package com.nttdata.transaction.infrestructure.res;

import com.nttdata.transaction.domain.Transactions;
import com.nttdata.transaction.operations.TransactionsOperations;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/transaction")
@RequiredArgsConstructor
public class TransactionsController {


    private static final Logger logger = LoggerFactory.getLogger(TransactionsController.class);
    private final TransactionsOperations transactionsOperations;


    @GetMapping("list")
    public Flux<Transactions> getall() {
            return transactionsOperations.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Transactions> getOne(@PathVariable Long id){
            return transactionsOperations.findById(id);
    }

    @PostMapping("add")
    public Mono<Transactions> save(@RequestBody Transactions transactions){
          return transactionsOperations.save(transactions);
    }

    @PutMapping("/{id}")
    public Mono<Transactions> update(@PathVariable Long id, @RequestBody Transactions transactions) {
            return transactionsOperations.update(id, transactions);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id){
            return transactionsOperations.delete(id);

    }


}
