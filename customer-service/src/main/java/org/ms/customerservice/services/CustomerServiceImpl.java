package org.ms.customerservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.ms.customerservice.dto.CustomerRequestDto;
import org.ms.customerservice.dto.CustomerResponseDto;
import org.ms.customerservice.entities.Customer;
import org.ms.customerservice.mappers.CustomerMapper;
import org.ms.customerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDto save(CustomerRequestDto customerRequestDto) {
        Customer customer = customerMapper.customerRequestDtoToCustomer(customerRequestDto);
        Customer saveCustomer = customerRepository.save(customer);

        CustomerResponseDto customerResponseDto = customerMapper.customerToCustomerResponseDto(saveCustomer);

        return customerResponseDto;
    }

    @Override
    public CustomerResponseDto getCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();
        return customerMapper.customerToCustomerResponseDto(customer);
    }

    @Override
    public CustomerResponseDto update(CustomerRequestDto customerRequestDto) {
        Customer customer = customerMapper.customerRequestDtoToCustomer(customerRequestDto);
        Customer updatedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDto(updatedCustomer);
    }

    @Override
    public List<CustomerResponseDto> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDto> customerResponseDtos = customers.stream()
                .map(cust -> customerMapper.customerToCustomerResponseDto(cust)).collect(Collectors.toList());
        return customerResponseDtos;
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

}
