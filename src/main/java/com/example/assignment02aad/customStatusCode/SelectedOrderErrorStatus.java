package com.example.assignment02aad.customStatusCode;

import com.example.assignment02aad.dto.custom.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedOrderErrorStatus implements OrderStatus {
    private int status;
    private String statusMessage;
}
