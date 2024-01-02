package edu.spring.istfi.servicio;


import edu.spring.istfi.model.Marca;
import edu.spring.istfi.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaService {
    private final MarcaRepository marcaRepository;
    @Autowired
    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }


    public Marca buscarMarcaporDescripcion(String descripcion) {
        return marcaRepository.findByDescripcion(descripcion);
    }
}

