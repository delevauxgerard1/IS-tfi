package edu.spring.istfi.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.spring.istfi.model.*;
import edu.spring.istfi.servicio.ArticuloService;
import edu.spring.istfi.servicio.ClienteService;
import edu.spring.istfi.servicio.CondicionTributariaService;
import edu.spring.istfi.servicio.VentaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

//http://localhost:8080/tfib/
@RestController
@RequestMapping("tfib")
@CrossOrigin(value = "http://localhost:5173")
public class RealizarVentaController {

    private static final Logger logger = LoggerFactory.getLogger(RealizarVentaController.class);

    //Tipos de pago
    @GetMapping("/listarTipoPago")
    public List<String> listarTiposPago() {
        return Arrays.asList(
                TipoPago.EFECTIVO.getDescripcion(),
                TipoPago.TARJETA_DEBITO.getDescripcion(),
                TipoPago.TARJETA_CREDITO.getDescripcion()
        );
    }

    //Condición tributaria
    @Autowired
    private CondicionTributariaService condicionTributariaService;

    @GetMapping("/condiciontributaria")
    public List<CondicionTributaria> obtenerCondicionTributaria(){
        return condicionTributariaService.getAllTributaryConditions();
    }

    //Clientes
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/buscarCliente/{cuit}")
    public ResponseEntity<Cliente> buscarClienteCuit(@PathVariable long cuit) {
        Cliente cliente = clienteService.buscarClienteporCuit(cuit);
        return ResponseEntity.ok(cliente);
    }

    //Artículos consultas
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
    public ResponseEntity<Stock> obtenerStock(@PathVariable Long idArticulo, @PathVariable int idColor, @PathVariable int idTalle) {
        Stock stock = articuloService.obtenerStock(idArticulo,idColor,idTalle);
        return ResponseEntity.ok(stock);
    }

    //Ventas
    @Autowired
    private final VentaService ventaService;
    public RealizarVentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping("/realizarPago")
    public ResponseEntity<?> realizarPago(@RequestBody String requestBody) {
        try {
            String respuesta="failed";
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(requestBody);
            String tipoPago = jsonNode.get("tipoPago").asText();
            String comprobar=ventaService.comprobarStock(jsonNode);

            if (comprobar.equals("success")){
                if ( !tipoPago.equals("Efectivo")) {

                    //llamo para solicitar el Token
                    ResponseEntity<String> responseTokenPago = ventaService.solicitarToken(requestBody);
                    JsonNode respuestaJson1 = objectMapper.readTree((String) responseTokenPago.getBody());

                    ResponseEntity<String> responseConfirmarPago = ventaService.confirmarPago(requestBody,respuestaJson1);
                    JsonNode respuestaJson2 = objectMapper.readTree((String) responseConfirmarPago.getBody());
                    if (respuestaJson2.has("status") && respuestaJson2.get("status").asText().equals("approved") ) {

                        ventaService.procesarVenta(jsonNode);
                        respuesta="success";
                    }
                }
                if ( tipoPago.equals("Efectivo")) {
                    ventaService.procesarVenta(jsonNode);
                    respuesta="success";
                }
                return ResponseEntity.ok(respuesta);
            }else {
                respuesta="Stock insuficiente";
                return ResponseEntity.ok(respuesta);
            }

        } catch (Exception e) {
            e.printStackTrace(); // Manejar las excepciones según tus necesidades
            return ResponseEntity.status(500).body("Error al procesar la solicitud");
        }
    }
}
