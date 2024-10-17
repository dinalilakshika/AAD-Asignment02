package com.example.assignment02aad.service;

import com.example.assignment02aad.dto.custom.impl.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrderService {
    void saveOrder(OrderDto orderDto);
    OrderDto getOrderById(String orderId);
    List<OrderDto> getAllOrders();
    void updateOrder(String orderId, OrderDto orderDto);
    void deleteOrder(String orderId);
}
