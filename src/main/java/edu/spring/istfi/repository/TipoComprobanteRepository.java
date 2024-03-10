package edu.spring.istfi.repository;

import edu.spring.istfi.model.TipoComprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoComprobanteRepository extends JpaRepository<TipoComprobante,Integer> {
}
