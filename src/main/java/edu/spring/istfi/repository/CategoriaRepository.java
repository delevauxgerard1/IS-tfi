package edu.spring.istfi.repository;


import edu.spring.istfi.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, String> {
    Categoria findByDescripcion(String descripcion);
}
