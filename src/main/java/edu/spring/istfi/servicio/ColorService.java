package edu.spring.istfi.servicio;


import edu.spring.istfi.model.Color;
import edu.spring.istfi.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorService {
    private final ColorRepository colorRepository;
    @Autowired
    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }


    public Color buscarColorporDescripcion(String descripcion) {
        return colorRepository.findByDescripcion(descripcion);
    }
}
