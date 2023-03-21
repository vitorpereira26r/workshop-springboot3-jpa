package com.vitorpereira.courseProject.repositories;

import com.vitorpereira.courseProject.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
