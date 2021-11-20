package com.nttdata.transactions.infrestructure.res;


import com.nttdata.transactions.domain.Transactions;
import com.nttdata.transactions.operations.TransactionsOperations;
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
    public Flux<Transactions> getall() throws Exception{
        try {
            return transactionsOperations.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Mono<Transactions> getOne(@PathVariable Long id) throws Exception {
        try {
            return transactionsOperations.findById(id);
        }catch (Exception e){
            throw e;
        }
    }

    @PostMapping("add")
    public Mono<Transactions> save(@RequestBody Transactions transactions) throws Exception {
        try {
            return transactionsOperations.save(transactions);
        }catch (Exception e){
            throw e;
        }
    }

    @PutMapping("/{id}")
    public Mono<Transactions> update(@PathVariable Long id, @RequestBody Transactions transactions) throws Exception {
        try {
            return transactionsOperations.update(id , transactions);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) throws Exception {
        try {
            return transactionsOperations.delete(id);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
