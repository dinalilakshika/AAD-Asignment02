package com.example.assignment02aad.service.impl;

import com.example.assignment02aad.customStatusCode.SelectedCustomerErrorStatus;
import com.example.assignment02aad.dao.CustomerDao;
import com.example.assignment02aad.dto.custom.CustomerStatus;
import com.example.assignment02aad.dto.custom.impl.CustomerDto;
import com.example.assignment02aad.entity.impl.Customer;
import com.example.assignment02aad.exception.CustomerNotFoundException;
import com.example.assignment02aad.exception.DataPersistException;
import com.example.assignment02aad.service.CustomerService;
import com.example.assignment02aad.util.AppUtil;
import lombok.SneakyThrows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.assignment02aad.util.Mapping;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao dao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveCustomer(CustomerDto dto) {
        dto.setCustomerID(AppUtil.generateCustomerId());
        Customer savedCustomer = dao.save(mapping.toCustomerEntity(dto));

        if (savedCustomer == null){
            throw new DataPersistException("Customer has not saved");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        Optional<Customer> foundCustomer = dao.findById(id);

        if (!foundCustomer.isPresent()){
            throw new CustomerNotFoundException("Customer Not Found");
        }
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> allCustomer = dao.findAll();
        return mapping.asCustomerDto(allCustomer);
    }

    @SneakyThrows
    @Override
    public CustomerStatus getCustomer(String id) {
        if (dao.existsById(id)){
            Customer selectedCustomer = dao.getReferenceById(id);
            return mapping.toCustomerDto(selectedCustomer);
        } else {
            return new SelectedCustomerErrorStatus(2, "Selected Customer Not Found");
        }
    }

    @Override
    public void updateCustomer(CustomerDto dto, String id) {
        Optional<Customer> byId = dao.findById(id);

        if (!byId.isPresent()){
            throw new CustomerNotFoundException("Customer Not Found");
        } else {
            byId.get().setCustomerName(dto.getCustomerName());
            byId.get().setCustomerAddress(dto.getAddress());
            byId.get().setCustomerPhone(dto.getContactNo());
        }
    }
}
