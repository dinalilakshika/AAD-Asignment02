package com.example.assignment02aad.dao;

import com.example.assignment02aad.entity.impl.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer,String> {
}
