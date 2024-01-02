package edu.spring.istfi.repository;

import edu.spring.istfi.model.TipoComprobante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipodeComprobanteRepository extends JpaRepository<TipoComprobante,Integer> {
    TipoComprobante findById(int id);
}
