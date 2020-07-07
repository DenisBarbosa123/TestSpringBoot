package br.edu.univas.denis.service;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.univas.denis.model.Auditing;
import br.edu.univas.denis.model.Delivery;
import br.edu.univas.denis.repository.AuditingRepository;
import br.edu.univas.denis.repository.DeliveryRepository;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired 
    AuditingRepository auditingRepository;
    
    Random random = new Random();

	public ResponseEntity<Object> getDeliveryById(long id) {
        Optional<Delivery> delivery = deliveryRepository.findById(id);
        if(delivery.isPresent()){
            return ResponseEntity.ok(delivery);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Object> createDelivery(Delivery newDelivery) {
		try {
            Delivery deliveryCreated = deliveryRepository.save(newDelivery);
            Auditing log = new Auditing(random.nextInt(1), deliveryCreated, "CREATE", new Date());
            auditingRepository.save(log);
            return ResponseEntity.ok(deliveryCreated);
        } catch (Exception e) {
            return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
        }
	}

	public ResponseEntity<Object> updateDelivery(Delivery delivery, long id) {
		Optional<Delivery> oldDelivery = deliveryRepository.findById(id);
        if(oldDelivery.isPresent()){
            Delivery deliveryUpdated = deliveryRepository.save(buildDeliveryToUpdate(oldDelivery.get(), delivery));
            Auditing log = new Auditing(random.nextInt(1), deliveryUpdated, "UPDATE", new Date());
            auditingRepository.save(log);
            return ResponseEntity.ok(deliveryUpdated);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Object> deleteDelivery(long id) {
		Optional<Delivery> delivery = deliveryRepository.findById(id);
        if(delivery.isPresent()){
        	Auditing log = new Auditing(random.nextInt(1), delivery.get(), "DELETE", new Date());
            auditingRepository.save(log);
            deliveryRepository.delete(delivery.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    private Delivery buildDeliveryToUpdate(Delivery newDelivery, Delivery oldDelivery) {
        if(newDelivery.getCep() != null){
            oldDelivery.setCep(newDelivery.getCep());
        }

        if(newDelivery.getCpfReceiver() != null){
            oldDelivery.setCpfReceiver(newDelivery.getCpfReceiver());
        }

        if(newDelivery.getDeliveryDate() != null){
            oldDelivery.setDeliveryDate(newDelivery.getDeliveryDate());
        }

        if(newDelivery.getDeliveryStatus() != null){
            oldDelivery.setDelieryStatus(newDelivery.getDeliveryStatus());
        }

        return oldDelivery;
    }
}