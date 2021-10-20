package org.ms.billingservice.mappers;

import org.mapstruct.Mapper;
import org.ms.billingservice.dto.InvoiceRequestDto;
import org.ms.billingservice.dto.InvoiceResponseDto;
import org.ms.billingservice.entities.Invoice;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDto(InvoiceRequestDto invoiceRequestDto);

    InvoiceResponseDto fromInvoice(Invoice invoice);
}
