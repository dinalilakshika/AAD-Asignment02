package com.example.assignment02aad.customStatusCode;

import com.example.assignment02aad.dto.custom.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedCustomerErrorStatus implements CustomerStatus {
    private int status;
    private String statusMessage;
}