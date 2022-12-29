package com.estudandojava.services.resources;


import com.estudandojava.services.entities.Order;
import com.estudandojava.services.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/orders")
public class OrderResource {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public ResponseEntity<List<Order>> findAllOrders(){
        List<Order> list= orderService.findAllOrders();
        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Order> findOrdersById(@PathVariable Long id){
        Order order=orderService.findOrderById(id);
        return ResponseEntity.ok().body(order);

    }
}
