package com.info.demo.service;


import com.info.demo.dao.OrderDetailRepository;
import com.info.demo.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService{

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }

    @Override
    public List<OrderDetail> listOrderDetail() {
        return orderDetailRepository.findAll();
    }

    @Override
    public void deleteOrderDetail(long orderDetailId) {
        orderDetailRepository.deleteById(orderDetailId);
    }

    @Override
    public void updateOrderDetail(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }

    @Override
    public Optional<OrderDetail> getOrderDetail(long orderDetailId) {
        return orderDetailRepository.findById(orderDetailId);
    }


    @Override
    public List<OrderDetail> findByDate(Date orderDate, Date orderDatee) {
        return orderDetailRepository.find(orderDate, orderDatee);
    }

    @Override
    public List<OrderDetail> findNotCompleted(Date orderDate, Date orderDatee) {
        return orderDetailRepository.findNotCompleted(orderDate, orderDatee);
    }


}
