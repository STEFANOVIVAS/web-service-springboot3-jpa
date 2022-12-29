package com.estudandojava.services.repositories;

import com.estudandojava.services.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order,Long> {
}
