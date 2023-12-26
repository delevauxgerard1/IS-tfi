package edu.spring.istfi.repository;

import edu.spring.istfi.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color,String> {
    Color findByDescripcion(String descripcion);
}
