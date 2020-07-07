package br.edu.univas.denis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.denis.model.Delivery;
import br.edu.univas.denis.service.DeliveryService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDeliveryById(@PathVariable(value = "id") long id){
        return deliveryService.getDeliveryById(id);
    }

    @PostMapping()
    public ResponseEntity<Object> createDelivery(@RequestBody Delivery newDelivery){
        return deliveryService.createDelivery(newDelivery);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDelivery(@PathVariable(value = "id") long id, @RequestBody Delivery delivery){
        return deliveryService.updateDelivery(delivery, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDelivery(@PathVariable(value = "id") long id){
        return deliveryService.deleteDelivery(id);
    }
}