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
@Table(name = "customers")
@Entity
public class Customer implements SuperEntity {
    @Id
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
}