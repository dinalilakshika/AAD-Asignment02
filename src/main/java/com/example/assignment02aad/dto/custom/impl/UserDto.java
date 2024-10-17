package com.example.assignment02aad.dto.custom.impl;

import com.example.assignment02aad.dto.custom.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements UserStatus {
    private String userId;
    private String userName;
    private String email;
    private String password;
    private List<CustomerDto> customerDto;
    private List<ItemDto> itemDto;
}
