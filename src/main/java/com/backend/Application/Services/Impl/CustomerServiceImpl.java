package com.backend.Application.Services.Impl;

import com.backend.Adapters.dto.CustomerDto;
import com.backend.Adapters.mapper.CustomerMapper;
import com.backend.Application.Services.ICustomerService;
import com.backend.Application.Services.Models.Customer;
import com.backend.Domain.Repository.ICustomerRepository;
import com.backend.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {
    private ICustomerRepository iCustomerRepository;
    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        Customer savedCustomer = iCustomerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(savedCustomer);
    }

    @Override
    public CustomerDto getCustomer(Long id) {
        Customer customer = iCustomerRepository.findById(id) .orElseThrow(() ->
                new ResourceNotFoundException("Could not find customer with that : " + id));
        return CustomerMapper.mapToCustomerDto(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = iCustomerRepository.findAll();
        return customers.stream().map((Customer) -> CustomerMapper.mapToCustomerDto(Customer))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto updatedCustomerDto) {
        Customer customer = iCustomerRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Could not find customer with id : " + id));
        customer.setName(updatedCustomerDto.getName());
        customer.setAge(updatedCustomerDto.getAge());
        Customer updatedCustomer = iCustomerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(updatedCustomer);
    }
}
