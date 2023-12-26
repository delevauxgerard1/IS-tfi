package edu.spring.istfi.repository;

import edu.spring.istfi.model.PuntoVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuntodeVentaRepository extends JpaRepository<PuntoVenta,Integer> {
    PuntoVenta findById(int id);
}
