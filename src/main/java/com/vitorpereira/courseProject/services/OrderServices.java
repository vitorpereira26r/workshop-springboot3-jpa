package com.vitorpereira.courseProject.services;

import com.vitorpereira.courseProject.entities.Order;
import com.vitorpereira.courseProject.entities.OrderItem;
import com.vitorpereira.courseProject.entities.Payment;
import com.vitorpereira.courseProject.entities.dtos.OrderItemDto;
import com.vitorpereira.courseProject.entities.dtos.OrderStatusDto;
import com.vitorpereira.courseProject.entities.enums.OrderStatus;
import com.vitorpereira.courseProject.repositories.OrderItemRepository;
import com.vitorpereira.courseProject.repositories.OrderRepository;
import com.vitorpereira.courseProject.services.excepitions.AlreadyPaid;
import com.vitorpereira.courseProject.services.excepitions.DatabaseException;
import com.vitorpereira.courseProject.services.excepitions.OrderStatusInvalid;
import com.vitorpereira.courseProject.services.excepitions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.util.Pair;
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
        order.setOrderStatus(OrderStatus.WAITING_PAYMENT);
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

    public Order changeOrderStatus(Long id, OrderStatusDto dto){

        OrderStatus newOrderStatus = dto.getOrderStatus();

        if(newOrderStatus == null){
            throw new OrderStatusInvalid("NULL");
        }
        if(newOrderStatus == OrderStatus.PAID && newOrderStatus == OrderStatus.WAITING_PAYMENT){
            throw new OrderStatusInvalid(dto.getNameOrderStatus());
        }

        try{
            Order order = repository.getReferenceById(id);

            if(order.getOrderStatus() == OrderStatus.WAITING_PAYMENT){
                throw new OrderStatusInvalid("WAITING_PAYMENT");
            }
            order.setOrderStatus(newOrderStatus);

            return repository.save(order);
        }
        catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public Order pay(Long id){
        try{
            Order order = repository.getReferenceById(id);
            if(order.getOrderStatus().getCode()==1){

                Payment payment = new Payment(null, Instant.now(), order);
                order.setPayment(payment);

                Integer orderStatusCode = order.getOrderStatus().getCode()+1;
                order.setOrderStatus(OrderStatus.valueOf(orderStatusCode));

                return repository.save(order);
            }
            throw new AlreadyPaid(id);
        }
        catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
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
