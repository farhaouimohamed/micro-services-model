package org.ms.customerservice.web;

import java.util.List;

import org.ms.customerservice.dto.CustomerRequestDto;
import org.ms.customerservice.dto.CustomerResponseDto;
import org.ms.customerservice.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class CustomerRestApi {
    private CustomerService customerService;

    public CustomerRestApi(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    public List<CustomerResponseDto> allCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping(path = "/customers")
    public CustomerResponseDto save(CustomerRequestDto customerRequestDto) {
        return customerService.save(customerRequestDto);
    }

    @GetMapping(path = "/customers/{id}")
    public CustomerResponseDto getCustomer(@PathVariable String id) {
        return customerService.getCustomer(id);
    }
}
