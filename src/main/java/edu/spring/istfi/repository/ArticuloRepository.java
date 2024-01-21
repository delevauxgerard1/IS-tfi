package edu.spring.istfi.repository;

import edu.spring.istfi.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
    Articulo findByCodigo(long codigo);

    List<Articulo> findByDescripcionContaining(String descripcion);
}

