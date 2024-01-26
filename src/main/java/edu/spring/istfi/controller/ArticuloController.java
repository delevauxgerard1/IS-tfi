package edu.spring.istfi.controller;
import edu.spring.istfi.model.Articulo;
import edu.spring.istfi.model.Color;
import edu.spring.istfi.model.Talle;
import edu.spring.istfi.servicio.ArticuloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/obtenerTallesDeArticulo/{codigo}")
    public ResponseEntity<List<Talle>> obtenerTallesDeArticulo(@PathVariable long codigo) {
        List<Talle> talles = articuloService.obtenerTallesDeArticulo(codigo);
        return ResponseEntity.ok(talles);
    }

    @GetMapping("/obtenerColoresDeArticulo/{codigo}")
    public ResponseEntity<List<Color>> obtenerColoresDeArticulo(@PathVariable long codigo) {
        List<Color> colores = articuloService.obtenerColoresDeArticulo(codigo);
        return ResponseEntity.ok(colores);
    }
    @GetMapping("/obtenerTallesPorDescripcion/{descripcion}")
    public ResponseEntity<List<Talle>> obtenerTallesDeArticuloPorDescripcion(@PathVariable String descripcion) {
        List<Talle> talles = articuloService.obtenerTallesDeArticuloPorDescripcion(descripcion);
        return ResponseEntity.ok(talles);
    }

    @GetMapping("/obtenerColoresPorDescripcion/{descripcion}")
    public ResponseEntity<List<Color>> obtenerColoresDeArticuloPorDescripcion(@PathVariable String descripcion) {
        List<Color> colores = articuloService.obtenerColoresDeArticuloPorDescripcion(descripcion);
        return ResponseEntity.ok(colores);
    }
}
