package edu.spring.istfi.repository;

import edu.spring.istfi.model.LineaVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineaVentaRepository extends JpaRepository<LineaVenta,Integer> {
}
