package edu.spring.istfi.servicio;

import edu.spring.istfi.model.Talle;
import edu.spring.istfi.repository.TalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TalleService {
    private final TalleRepository talleRepository;
    @Autowired
    public TalleService(TalleRepository talleRepository) {
        this.talleRepository = talleRepository;
    }


    public Talle buscarTalleporDescripcion(String descripcion) {
        return talleRepository.findByDescripcion(descripcion);
    }
}

