package edu.spring.istfi.servicio;

import edu.spring.istfi.model.Articulo;
import edu.spring.istfi.model.Color;
import edu.spring.istfi.model.Talle;
import edu.spring.istfi.repository.ArticuloRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ArticuloService {

    private final ArticuloRepository articuloRepository;

    @Autowired
    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    public Articulo createArticulo(String descripcion, double costo, double margenDeGanancia){
        Articulo newArticulo = new Articulo(descripcion,costo,margenDeGanancia);
        articuloRepository.save(newArticulo);

        return newArticulo;
    }

    public Articulo buscarArticuloPorCodigo(long codigo) {
        return articuloRepository.findByCodigo(codigo);
    }
    public List<Articulo> buscarPorDescripcion(String descripcion) {
        return articuloRepository.findByDescripcionContaining(descripcion);
    }



    public List<Articulo> obtenerTodosLosArticulos() {
        return articuloRepository.findAll();
    }

    public List<Talle> obtenerTallesDeArticulo(long codigo) {
        Articulo articulo = articuloRepository.findByCodigo(codigo);
        if (articulo != null) {
            Hibernate.initialize(articulo.getTalles()); // Cargar talles
            return new ArrayList<>(articulo.getTalles());
        }
        return Collections.emptyList();
    }

    public List<Color> obtenerColoresDeArticulo(long codigo) {
        Articulo articulo = articuloRepository.findByCodigo(codigo);
        if (articulo != null) {
            Hibernate.initialize(articulo.getColores()); // Cargar colores
            return new ArrayList<>(articulo.getColores());
        }
        return Collections.emptyList();
    }
    public List<Talle> obtenerTallesDeArticuloPorDescripcion(String descripcion) {
        List<Articulo> articulos = articuloRepository.findByDescripcionContaining(descripcion);
        List<Talle> talles = new ArrayList<>();
        for (Articulo articulo : articulos) {
            talles.addAll(articulo.getTalles());
        }
        return talles;
    }

    public List<Color> obtenerColoresDeArticuloPorDescripcion(String descripcion) {
        List<Articulo> articulos = articuloRepository.findByDescripcionContaining(descripcion);
        List<Color> colores = new ArrayList<>();
        for (Articulo articulo : articulos) {
            colores.addAll(articulo.getColores());
        }
        return colores;
    }
}

