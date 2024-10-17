package com.example.assignment02aad.service;

import com.example.assignment02aad.dto.custom.impl.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    void saveUser(UserDto userDto);
    UserDto getUserById(String userId);
    List<UserDto> getAllUsers();
    void updateUser(String userId, UserDto userDto);
    void deleteUser(String userId);
}
