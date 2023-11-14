package edu.spring.istfi.servicio;

import edu.spring.istfi.model.Articulo;
import edu.spring.istfi.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloService {

    private final ArticuloRepository articuloRepository;

    @Autowired
    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    // Ejemplo: método para obtener todos los artículos
    public List<Articulo> obtenerTodosLosArticulos() {
        return articuloRepository.findAll();
    }

    // Ejemplo: método para guardar un artículo
    public Articulo guardarArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }
}

