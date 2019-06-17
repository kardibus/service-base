package com.example.serviceBase.Repository;

import com.example.serviceBase.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
