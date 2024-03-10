package edu.spring.istfi.controller;


import edu.spring.istfi.model.*;
import edu.spring.istfi.servicio.ArticuloService;
import edu.spring.istfi.servicio.ClienteService;
import edu.spring.istfi.servicio.CondicionTributariaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
//http://localhost:8080/tfib/
@RequestMapping("tfib")
@CrossOrigin(value = "http://localhost:5173")
public class RealizarVentaController {
    private static final Logger logger = LoggerFactory.getLogger(RealizarVentaController.class);

    @GetMapping("/listarTipoPago")
    public List<String> listarTiposPago() {
        return Arrays.asList(
                TipoPago.EFECTIVO.getDescripcion(),
                TipoPago.TARJETA_DEBITO.getDescripcion(),
                TipoPago.TARJETA_CREDITO.getDescripcion()
        );
    }
    @Autowired
    private CondicionTributariaService condicionTributariaService;

    @GetMapping("/condiciontributaria")
    public List<CondicionTributaria> obtenerCondicionTributaria(){
        return condicionTributariaService.getAllTributaryConditions();
    }

    //clientes consultas
    @Autowired
    private ClienteService clienteService;
    @GetMapping("/buscarCliente/{cuit}")
    public ResponseEntity<Cliente> buscarClienteDni(@PathVariable long cuit) {
        Cliente cliente = clienteService.buscarClienteporCuit(cuit);
        return ResponseEntity.ok(cliente);
    }

    //articulos consultas
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

    @GetMapping("/obtenerStock/{idArticulo}/{idColor}/{idTalle}")
    public ResponseEntity<Stock> obtenerColoresDeArticuloPorDescripcion(@PathVariable Long idArticulo, @PathVariable int idColor, @PathVariable int idTalle) {
        Stock stock = articuloService.obtenerStock(idArticulo,idColor,idTalle);
        return ResponseEntity.ok(stock);
    }
}
