package com.info.demo.model;

import org.hibernate.query.criteria.internal.expression.function.CurrentTimeFunction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "orderr")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderDetail> orderDetailList;


    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date orderDate;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean completed;


    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
