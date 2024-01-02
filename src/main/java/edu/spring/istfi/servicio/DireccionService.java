package edu.spring.istfi.servicio;


import edu.spring.istfi.model.Direccion;
import edu.spring.istfi.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DireccionService {
    private final DireccionRepository direccionRepository;
    @Autowired
    public DireccionService(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }


    public Direccion buscarDireccionporId(int id) {
        return direccionRepository.findById(id);
    }
}
