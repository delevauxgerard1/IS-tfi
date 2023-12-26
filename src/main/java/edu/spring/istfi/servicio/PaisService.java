package edu.spring.istfi.servicio;


import edu.spring.istfi.model.Pais;
import edu.spring.istfi.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService {
    private final PaisRepository paisRepository;
    @Autowired
    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }


    public Pais buscarPaisporDescripcion(String descripcion) {
        return paisRepository.findByDescripcion(descripcion);
    }
}

