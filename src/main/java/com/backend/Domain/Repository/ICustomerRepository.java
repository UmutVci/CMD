package com.backend.Domain.Repository;

import com.backend.Application.Services.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
