package br.edu.univas.denis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.univas.denis.model.Delivery;
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long>{
    
}