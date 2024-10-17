package com.example.assignment02aad.customStatusCode;

import com.example.assignment02aad.dto.custom.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserErrorStatus implements UserStatus {
    private int status;
    private String statusMessage;
}
