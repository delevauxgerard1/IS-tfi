package edu.spring.istfi.repository;

import edu.spring.istfi.model.TipoTalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTalleRepository extends JpaRepository<TipoTalle, String> {
    TipoTalle findByDescripcion(String descripcion);
}
