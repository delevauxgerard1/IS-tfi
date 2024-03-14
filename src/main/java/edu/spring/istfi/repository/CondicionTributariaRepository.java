package edu.spring.istfi.repository;

import edu.spring.istfi.model.CondicionTributaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondicionTributariaRepository extends JpaRepository<CondicionTributaria,Integer> {
}
