package org.ms.billingservice.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.ms.billingservice.dto.InvoiceRequestDto;
import org.ms.billingservice.dto.InvoiceResponseDto;
import org.ms.billingservice.entities.Invoice;
import org.ms.billingservice.mappers.InvoiceMapper;
import org.ms.billingservice.model.Customer;
import org.ms.billingservice.openfeign.CustomerRestClient;
import org.ms.billingservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestClient customerRestClient;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper,
            CustomerRestClient customerRestClient) {
        this.invoiceMapper = invoiceMapper;
        this.invoiceRepository = invoiceRepository;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public InvoiceResponseDto save(InvoiceRequestDto invoiceRequestDto) {

        Customer customer;
        try {
            customer = customerRestClient.getCustomer(invoiceRequestDto.getCustomerID());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        Invoice invoice = invoiceMapper.fromInvoiceRequestDto(invoiceRequestDto);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());
        invoice.setCustomer(customer);
        Invoice savedInvoice = invoiceRepository.save(invoice);
        savedInvoice.setCustomer(customerRestClient.getCustomer(savedInvoice.getCustomerID()));
        return invoiceMapper.fromInvoice(savedInvoice);

    }

    @Override
    public InvoiceResponseDto getInvoice(String invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId).orElse(null);
        if (invoice == null)
            throw new RuntimeException("Invoice Not found");
        Customer customer = customerRestClient.getCustomer(invoice.getCustomerID());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDto> invoicesByCustomerId(String customerId) {
        List<Invoice> invoices = invoiceRepository.findByCustomerID(customerId);
        for (Invoice invoice : invoices) {
            Customer customer = customerRestClient.getCustomer(invoice.getCustomerID());
            invoice.setCustomer(customer);
        }
        return invoices.stream().map(invoice -> invoiceMapper.fromInvoice(invoice)).collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponseDto> listInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        for (Invoice invoice : invoices) {
            Customer customer = customerRestClient.getCustomer(invoice.getCustomerID());
            invoice.setCustomer(customer);
        }
        return invoices.stream().map((inv) -> invoiceMapper.fromInvoice((inv))).collect(Collectors.toList());
    }

}
