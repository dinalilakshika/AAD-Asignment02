package com.example.assignment02aad.dto.custom.impl;

import com.example.assignment02aad.dto.custom.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements CustomerStatus {
    private String customerID;
    private String customerName;
    private String address;
    private String contactNo;
    private List<OrderDto> orderDto;
}