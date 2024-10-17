package com.example.assignment02aad.service;

import com.example.assignment02aad.dto.custom.impl.OrderDetailsDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrderDetailsService {
    void saveOrderDetail(OrderDetailsDto orderDetailsDto);
    OrderDetailsDto getOrderDetailById(String orderDetailId);
    List<OrderDetailsDto> getAllOrderDetails();
    void updateOrderdetail(String orderDetailId, OrderDetailsDto orderDetailsDto);
    void deleteOrderDetail(String orderDetailId);
}
