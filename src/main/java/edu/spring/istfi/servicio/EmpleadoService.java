package edu.spring.istfi.servicio;

import edu.spring.istfi.model.Empleado;
import edu.spring.istfi.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;
    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }


    public Empleado buscarEmpleadoporLegajo(int legajo) {
        return empleadoRepository.findByLegajo(legajo);
    }
}
