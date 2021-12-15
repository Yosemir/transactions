package com.nttdata.transaction.infrestructure.spring.config;

import com.nttdata.transaction.infrestructure.service.TransactionsCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringConfigurations    {

    @Bean
    public TransactionsCrudService transactionsRepository(){
        return new TransactionsCrudService();
    }
}
