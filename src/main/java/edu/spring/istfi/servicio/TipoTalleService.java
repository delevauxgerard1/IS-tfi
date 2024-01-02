package edu.spring.istfi.servicio;


import edu.spring.istfi.model.TipoTalle;
import edu.spring.istfi.repository.TipoTalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoTalleService {
    private final TipoTalleRepository tipoTalleRepository;
    @Autowired
    public TipoTalleService(TipoTalleRepository tipoTalleRepository) {
        this.tipoTalleRepository = tipoTalleRepository;
    }


    public TipoTalle buscarTipoTalleporDescripcion(String descripcion) {
        return tipoTalleRepository.findByDescripcion(descripcion);
    }
}

