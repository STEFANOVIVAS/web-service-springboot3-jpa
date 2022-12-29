package com.estudandojava.services.services;




import com.estudandojava.services.entities.Order;
import com.estudandojava.services.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAllOrders(){
        return orderRepository.findAll();

    }
    public Order findOrderById(Long id){
        Optional<Order> order=orderRepository.findById(id);
        return order.get();
    }
}
