package com.example.assignment02aad.service.impl;

import com.example.assignment02aad.dao.OrderDetailDao;
import com.example.assignment02aad.dto.custom.impl.OrderDetailsDto;
import com.example.assignment02aad.entity.impl.OrderDetail;
import com.example.assignment02aad.exception.DataPersistException;
import com.example.assignment02aad.exception.OrderDetailNotFoundException;
import com.example.assignment02aad.service.OrderDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.assignment02aad.util.Mapping;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailsService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveOrderDetail(OrderDetailsDto orderDetailDto) {
        OrderDetail orderDetail = mapping.toOrderDetailEntity(orderDetailDto);

        OrderDetail savedOrderDetail = orderDetailDao.save(orderDetail);
        if (savedOrderDetail == null) {
            throw new DataPersistException("OrderDetail not saved");
        }
    }

    @Override
    public OrderDetailsDto getOrderDetailById(String orderDetailId) {
        Optional<OrderDetail> orderDetail = orderDetailDao.findById(orderDetailId);
        if (orderDetail.isPresent()) {
            return mapping.toOrderDetailDto(orderDetail.get());
        } else {
            throw new OrderDetailNotFoundException("OrderDetail not found");
        }
    }

    @Override
    public List<OrderDetailsDto> getAllOrderDetails() {
        List<OrderDetail> allOrderDetails = orderDetailDao.findAll();
        return mapping.asOrderDetailDto(allOrderDetails);
    }

    @Override
    public void updateOrderdetail(String orderDetailId, OrderDetailsDto orderDetailDto) {
        Optional<OrderDetail> orderDetailOptional = orderDetailDao.findById(orderDetailId);
        if (orderDetailOptional.isPresent()) {
            OrderDetail orderDetailToUpdate = orderDetailOptional.get();

            orderDetailToUpdate.setQty(orderDetailDto.getQuantity());
            orderDetailToUpdate.setUnitPrice(orderDetailDto.getUnitPrice());
            orderDetailToUpdate.setItem(mapping.toItemEntity(orderDetailDto.getItemDto()));

            orderDetailDao.save(orderDetailToUpdate);
        } else {
            throw new OrderDetailNotFoundException("OrderDetail not found for update");
        }
    }

    @Override
    public void deleteOrderDetail(String orderDetailId) {
        Optional<OrderDetail> orderDetailOptional = orderDetailDao.findById(orderDetailId);
        if (orderDetailOptional.isPresent()) {
            orderDetailDao.deleteById(orderDetailId);
        } else {
            throw new OrderDetailNotFoundException("OrderDetail not found for deletion");
        }
    }
}
