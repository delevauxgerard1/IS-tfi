package edu.spring.istfi.controller;
import edu.spring.istfi.model.Articulo;
import edu.spring.istfi.servicio.ArticuloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

@RestController
//http://localhost:8080/tfib/
@RequestMapping("tfib")
@CrossOrigin(value = "http://localhost:5173")
public class ArticuloController {
    private static final Logger logger = LoggerFactory.getLogger(ArticuloController.class);

    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/articulos")
    public List<Articulo> obtenerArticulos(){
        return articuloService.obtenerTodosLosArticulos();
    }

    @GetMapping("/buscarPorDescripcion/{descripcion}")
    public List<Articulo> buscarArticulosPorDescripcion(@PathVariable String descripcion) {
        return articuloService.buscarPorDescripcion(descripcion);
    }

    @GetMapping("/buscarPorCodigo")
    /*public ResponseEntity<Articulo> buscarArticulosPorCodigo(@RequestParam long codigo){
        Articulo articulo = articuloService.buscarArticuloPorCodigo(codigo);

        if (articulo != null) {
            return new ResponseEntity<>(articulo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        //devuelve HttpStatus.NOT_FOUND si el código no se encuentra
    }*/

    public List<Articulo> buscarArticulosPorCodigo(@RequestParam long codigo) {
        return (List<Articulo>) Collections.singletonList(articuloService.buscarArticuloPorCodigo(codigo));
    }
}
