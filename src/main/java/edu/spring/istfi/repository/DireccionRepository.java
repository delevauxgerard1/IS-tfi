package edu.spring.istfi.repository;


import edu.spring.istfi.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepository extends JpaRepository<Direccion,Integer> {
    Direccion findById(int id);
}
