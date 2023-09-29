package com.vitorpereira.courseProject.resources;

import com.vitorpereira.courseProject.entities.Order;
import com.vitorpereira.courseProject.entities.dtos.OrderItemDto;
import com.vitorpereira.courseProject.entities.dtos.OrderStatusDto;
import com.vitorpereira.courseProject.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.RemoteServer;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    private OrderServices orderServices;

    public OrderResource(OrderServices orderServices){
        this.orderServices = orderServices;
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = orderServices.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order obj = orderServices.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Order> findById(@RequestBody Order order){
        Order entity = orderServices.addOrder(order);
        return ResponseEntity.ok(entity);
    }

    @PostMapping(value = "/pay/{id}")
    public ResponseEntity<Order> pay(@PathVariable Long id){
        Order order = orderServices.pay(id);
        return ResponseEntity.ok(order);
    }
    
    @PostMapping(value = "/change-order-status/{id}")
    public ResponseEntity<Order> changeOrderStatus(@PathVariable Long id, @RequestBody OrderStatusDto dto){
        Order order = orderServices.changeOrderStatus(id, dto);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        orderServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Order> updateById(@PathVariable Long id, @RequestBody Order order){
        Order entity = orderServices.updateById(id, order);
        return ResponseEntity.ok(entity);
    }
}
