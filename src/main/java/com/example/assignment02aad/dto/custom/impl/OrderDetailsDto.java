package com.example.assignment02aad.dto.custom.impl;

import com.example.assignment02aad.dto.custom.OrderDetailsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDto implements OrderDetailsStatus {
    private Long orderDetailsId;
    private ItemDto itemDto;
    private String itemCode;
    private int quantity;
    private double unitPrice;
}

