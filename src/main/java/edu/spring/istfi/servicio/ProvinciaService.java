package edu.spring.istfi.servicio;


import edu.spring.istfi.model.Provincia;
import edu.spring.istfi.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaService {
    private final ProvinciaRepository provinciaRepository;
    @Autowired
    public ProvinciaService(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }


    public Provincia buscarProvinciaporDescripcion(String descripcion) {
        return provinciaRepository.findByDescripcion(descripcion);
    }
}

