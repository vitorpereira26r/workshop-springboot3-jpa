package com.vitorpereira.courseProject.services;

import com.vitorpereira.courseProject.entities.Order;
import com.vitorpereira.courseProject.entities.OrderItem;
import com.vitorpereira.courseProject.entities.Payment;
import com.vitorpereira.courseProject.entities.dtos.OrderItemDto;
import com.vitorpereira.courseProject.repositories.OrderItemRepository;
import com.vitorpereira.courseProject.repositories.OrderRepository;
import com.vitorpereira.courseProject.services.excepitions.DatabaseException;
import com.vitorpereira.courseProject.services.excepitions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {

    private OrderRepository repository;

    private OrderItemRepository orderItemRepository;

    public OrderServices(OrderRepository repository, OrderItemRepository orderItemRepository){
        this.repository = repository;
        this.orderItemRepository = orderItemRepository;
    }

    public List<Order> findAll(){

        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

    public Order addOrder(Order order){
        order.setMoment(Instant.now());
        order.setPayment(new Payment(null, Instant.now(), order));
        return repository.save(order);
    }

    public void deleteById(Long id){
        try{
            repository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
        catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Order updateById(Long id, Order obj){
        try{
            Order entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Order entity, Order obj){
        entity.setOrderStatus(obj.getOrderStatus());
    }
}
