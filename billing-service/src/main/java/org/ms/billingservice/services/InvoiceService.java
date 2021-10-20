package org.ms.billingservice.services;

import java.util.List;

import org.ms.billingservice.dto.InvoiceRequestDto;
import org.ms.billingservice.dto.InvoiceResponseDto;

public interface InvoiceService {

    InvoiceResponseDto save(InvoiceRequestDto invoiceRequestDto);

    InvoiceResponseDto getInvoice(String invoiceId);

    List<InvoiceResponseDto> invoicesByCustomerId(String customerID);

    List<InvoiceResponseDto> listInvoices();

}
