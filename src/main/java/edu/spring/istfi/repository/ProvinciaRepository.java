package edu.spring.istfi.repository;

import edu.spring.istfi.model.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, String> {
    Provincia findByDescripcion(String descripcion);
}
