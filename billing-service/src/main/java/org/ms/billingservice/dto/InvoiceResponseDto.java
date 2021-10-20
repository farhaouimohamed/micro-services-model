package org.ms.billingservice.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.ms.billingservice.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceResponseDto {

    private String id;
    private Date date;
    private BigDecimal amount;
    private Customer customer;
}
