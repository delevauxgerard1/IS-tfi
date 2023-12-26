package edu.spring.istfi.servicio;


import edu.spring.istfi.model.Categoria;
import edu.spring.istfi.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;
    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }


    public Categoria buscarCategoriaporDescripcion(String descripcion) {
        return categoriaRepository.findByDescripcion(descripcion);
    }
}

