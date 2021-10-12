package org.ms.customerservice.mappers;

import org.mapstruct.Mapper;
import org.ms.customerservice.dto.CustomerRequestDto;
import org.ms.customerservice.dto.CustomerResponseDto;
import org.ms.customerservice.entities.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDto customerToCustomerResponseDto(Customer customer);

    Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto);

}
