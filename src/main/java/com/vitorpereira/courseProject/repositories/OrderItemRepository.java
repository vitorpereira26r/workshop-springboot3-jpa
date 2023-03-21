package com.vitorpereira.courseProject.repositories;

import com.vitorpereira.courseProject.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
