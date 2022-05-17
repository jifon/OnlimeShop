package com.info.demo.dao;

import com.info.demo.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    //данные о самых продоваемых продуктах
    @Query("SELECT DISTINCT e FROM OrderDetail e INNER JOIN e.product INNER JOIN e.order WHERE e.order.orderDate > :orderDate AND e.order.orderDate < :orderDatee GROUP BY e.product.productId ORDER BY sum(e.quantity) DESC")
    List<OrderDetail> find(@RequestParam("date") Date orderDate, @RequestParam("datee") Date orderDatee);

    //еще не заказанные товары
    @Query("SELECT DISTINCT e FROM OrderDetail e INNER JOIN e.product INNER JOIN e.order WHERE e.order.orderDate > :orderDate AND e.order.orderDate < :orderDatee AND e.order.completed = false GROUP BY e.product.productId")
    List<OrderDetail> findNotCompleted(@RequestParam("date") Date orderDate, @RequestParam("datee") Date orderDatee);
}
