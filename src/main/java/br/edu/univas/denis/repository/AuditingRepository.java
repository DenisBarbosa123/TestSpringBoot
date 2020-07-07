package br.edu.univas.denis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.univas.denis.model.Auditing;

@Repository
public interface AuditingRepository extends JpaRepository<Auditing, Long>{
    
}