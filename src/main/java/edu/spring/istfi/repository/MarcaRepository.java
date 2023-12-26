package edu.spring.istfi.repository;


import edu.spring.istfi.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, String> {
    Marca findByDescripcion(String descripcion);
}
