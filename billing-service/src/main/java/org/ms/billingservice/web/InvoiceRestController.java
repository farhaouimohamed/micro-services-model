package org.ms.billingservice.web;

import java.util.List;

import org.ms.billingservice.dto.InvoiceRequestDto;
import org.ms.billingservice.dto.InvoiceResponseDto;
import org.ms.billingservice.services.InvoiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class InvoiceRestController {
    private InvoiceService invoiceService;

    public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(path = "/invoices/{id}")
    public InvoiceResponseDto getInvoice(@PathVariable(name = "id") String invoiceId) {
        return invoiceService.getInvoice(invoiceId);
    }

    @GetMapping(path = "/invoicesByCustomer/{customerId}")
    public List<InvoiceResponseDto> getInvoicesByCustomer(@PathVariable String customerId) {
        return invoiceService.invoicesByCustomerId(customerId);
    }

    @PostMapping(path = "/invoices")
    public InvoiceResponseDto save(@RequestBody InvoiceRequestDto invoiceRequestDto) {
        return invoiceService.save(invoiceRequestDto);
    }

    @GetMapping(path = "/invoices")
    public List<InvoiceResponseDto> allInvoices(InvoiceRequestDto invoiceRequestDto) {
        return invoiceService.listInvoices();
    }
}
