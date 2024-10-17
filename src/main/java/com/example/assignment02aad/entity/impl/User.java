package com.example.assignment02aad.entity.impl;

import com.example.assignment02aad.entity.SuperEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements SuperEntity {
    @Id
    private String userId;
    private String userName;
    private String password;
}
