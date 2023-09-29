package com.vitorpereira.courseProject.services;

import com.vitorpereira.courseProject.entities.Order;
import com.vitorpereira.courseProject.entities.OrderItem;
import com.vitorpereira.courseProject.entities.Product;
import com.vitorpereira.courseProject.entities.dtos.OrderItemDto;
import com.vitorpereira.courseProject.repositories.OrderItemRepository;
import com.vitorpereira.courseProject.repositories.OrderRepository;
import com.vitorpereira.courseProject.repositories.ProductRepository;
import com.vitorpereira.courseProject.services.excepitions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class GlobalService {

    private OrderItemRepository orderItemRepository;

    private OrderRepository orderRepository;

    private ProductRepository productRepository;

    public GlobalService(OrderItemRepository orderItemRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order addItem(OrderItemDto dto){

        System.out.println(1);
        Order order = orderRepository.findById(dto.getOrderId()).orElse(null);
        Product product = productRepository.findById(dto.getProductId()).orElse(null);

        OrderItem orderItem = new OrderItem(order, product, dto.getQuantity(), product.getPrice());
        orderItemRepository.save(orderItem);

        return order;
    }
}
