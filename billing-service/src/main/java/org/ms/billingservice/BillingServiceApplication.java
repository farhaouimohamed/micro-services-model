package org.ms.billingservice;

import java.math.BigDecimal;

import org.ms.billingservice.dto.InvoiceRequestDto;
import org.ms.billingservice.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(InvoiceService invoiceService) {
        return args -> {
            invoiceService.save(new InvoiceRequestDto(new BigDecimal(98000), "C01"));
            invoiceService.save(new InvoiceRequestDto(new BigDecimal(54300), "C01"));
            invoiceService.save(new InvoiceRequestDto(new BigDecimal(56000), "C02"));
        };
    }
}
