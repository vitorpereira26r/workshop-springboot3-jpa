package com.vitorpereira.courseProject.resources;

import com.vitorpereira.courseProject.entities.Order;
import com.vitorpereira.courseProject.entities.dtos.OrderItemDto;
import com.vitorpereira.courseProject.services.GlobalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class GlobalResource {

    private GlobalService service;

    public GlobalResource(GlobalService service) {
        this.service = service;
    }

    @PostMapping(value = "/add-item")
    public ResponseEntity<Order> addItem(@RequestBody OrderItemDto dto){
        Order entity = service.addItem(dto);
        return ResponseEntity.ok(entity);
    }
}
