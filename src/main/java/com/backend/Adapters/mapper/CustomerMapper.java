package com.backend.Adapters.mapper;

import com.backend.Adapters.dto.CustomerDto;
import com.backend.Application.Services.Models.Customer;

public class CustomerMapper {
    public static Customer mapToCustomer (CustomerDto customerDto){
        return new Customer(
                customerDto.getId(),
                customerDto.getName(),
                customerDto.getAge()
        );
    }
    public static CustomerDto mapToCustomerDto (Customer customer){
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getAge()
        );
    }
}
