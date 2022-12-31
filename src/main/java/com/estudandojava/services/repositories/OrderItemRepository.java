package com.estudandojava.services.repositories;


import com.estudandojava.services.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
