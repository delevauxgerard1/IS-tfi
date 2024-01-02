package edu.spring.istfi.repository;

import edu.spring.istfi.model.Talle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalleRepository extends JpaRepository<Talle, String> {
    Talle findByDescripcion(String descripcion);
}
