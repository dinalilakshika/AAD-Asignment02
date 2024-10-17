package com.example.assignment02aad.service;

import com.example.assignment02aad.dto.custom.CustomerStatus;
import com.example.assignment02aad.dto.custom.impl.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {
    void saveCustomer(CustomerDto dto);
    void deleteCustomer(String id);
    List<CustomerDto> getAllCustomers();
    CustomerStatus getCustomer(String id);
    void updateCustomer(CustomerDto dto, String id);
}
