package edu.spring.istfi.repository;

import edu.spring.istfi.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {
    Empleado findByLegajo(int legajo);
}
