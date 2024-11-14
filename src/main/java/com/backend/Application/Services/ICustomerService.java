package com.backend.Application.Services;

import com.backend.Adapters.dto.CustomerDto;

import java.util.List;

public interface ICustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto getCustomer(Long id);
    List<CustomerDto> getAllCustomers();
    CustomerDto updateCustomer(Long id, CustomerDto updatedCustomerDto);
}
