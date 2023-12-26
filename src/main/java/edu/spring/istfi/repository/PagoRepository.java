package edu.spring.istfi.repository;

import edu.spring.istfi.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago,Integer> {
    Pago findById(int id);
}
