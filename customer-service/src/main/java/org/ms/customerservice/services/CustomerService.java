package org.ms.customerservice.services;

import java.util.List;

import org.ms.customerservice.dto.CustomerRequestDto;
import org.ms.customerservice.dto.CustomerResponseDto;

public interface CustomerService {

    CustomerResponseDto save(CustomerRequestDto customerRequestDto);

    CustomerResponseDto getCustomer(String id);

    CustomerResponseDto update(CustomerRequestDto customerRequestDto);

    List<CustomerResponseDto> getCustomers();

    void deleteCustomer(String id);
}
