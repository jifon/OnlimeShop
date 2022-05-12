package com.info.demo.service;

import com.info.demo.model.Category;
import com.info.demo.model.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {

    public void addOrderDetail(OrderDetail orderDetail);

    public List<OrderDetail> listOrderDetail();

    public void deleteOrderDetail(long orderDetailId);

    public void updateOrderDetail(OrderDetail orderDetail);

    public Optional<OrderDetail> getOrderDetail(long orderDetailId);
}
