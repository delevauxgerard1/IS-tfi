package edu.spring.istfi.repository;


import edu.spring.istfi.model.LineaVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineadeVentaRepository extends JpaRepository<LineaVenta,Integer> {
    LineaVenta findById(int id);
}
