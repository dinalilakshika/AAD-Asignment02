package com.example.assignment02aad.dto.custom.impl;

import com.example.assignment02aad.dto.custom.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto implements ItemStatus {
    private String itemCode;
    private String description;
    private String qty;
    private String Price;
}
