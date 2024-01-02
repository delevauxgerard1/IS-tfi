package edu.spring.istfi.repository;


import edu.spring.istfi.model.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprobanteRepository extends JpaRepository<Comprobante,Integer> {
    Comprobante findById(int id);
}
