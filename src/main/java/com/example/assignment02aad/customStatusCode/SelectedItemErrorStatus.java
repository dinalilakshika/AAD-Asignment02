package com.example.assignment02aad.customStatusCode;

import com.example.assignment02aad.dto.custom.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedItemErrorStatus implements ItemStatus {
    private int status;
    private String statusMessage;
}
