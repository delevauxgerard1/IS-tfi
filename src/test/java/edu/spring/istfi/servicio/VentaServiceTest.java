package edu.spring.istfi.servicio;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.spring.istfi.model.*;
import edu.spring.istfi.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import edu.spring.istfi.model.Cliente;
import edu.spring.istfi.repository.ClienteRepository;
import edu.spring.istfi.repository.ComprobanteRepository;
import edu.spring.istfi.repository.CondicionTributariaRepository;
import edu.spring.istfi.repository.PagoRepository;
import java.util.Optional;

public class VentaServiceTest {

    @Mock
    private ArticuloRepository articuloRepository;
    @Mock
    private ClienteRepository clienteRepository;
    @Mock
    private PagoRepository pagoRepository;
    @Mock
    private LineaVentaRepository lineaVentaRepository;
    @Mock
    private VentaRepository ventaRepository;
    @Mock
    private ComprobanteRepository comprobanteRepository;
    @Mock
    private CondicionTributariaRepository condicionTributariaRepository;
    @Mock
    private TipoComprobanteRepository tipoComprobanteRepository;
    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private VentaService ventaService;
    @InjectMocks
    private ArticuloService articuloService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSolicitarToken() throws Exception {
        // Creamos el body de la petición a la API externa
        String requestBody = "{\"datosTarjeta\":{\"numero\":\"4507990000004905\",\"vencimiento\":{\"mes\":\"08\",\"año\":\"24\"},\"cvv\":\"123\",\"dni\":\"25123456\"},\"datosCliente\":{\"nombreCliente\":\"Gerard Delevaux\"},\"montoTotal\":\"10000\"}";

        // Creamos una respuesta simulada del servicio externo con un token específico
        ResponseEntity<String> mockResponse = ResponseEntity.ok("{\"id\":\"cd956207-2916-4898-b46f-f1437cf8ba87\"}");

        // Configuramos el comportamiento del mock del restTemplate para que devuelva la respuesta simulada
        when(restTemplate.postForEntity(anyString(), any(), eq(String.class))).thenReturn(mockResponse);

        // Llamamos al método que estamos probando (solicitarToken) con el requestBody simulado
        ResponseEntity<String> responseEntity = ventaService.solicitarToken(requestBody);

        // Parseamos el cuerpo de la respuesta para verificar si contiene un ID de token
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(responseEntity.getBody());
        JsonNode idNode = responseJson.get("id");

        // Verificamos que el ID del token no sea nulo
        assertNotNull(idNode);
    }

    @Test
    public void testProcesarVentaCorrectamente() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        // Definimos un objeto JsonNode simulado con datos de venta
        String json = "{\"condicionTributaria\":{\"id\":1,\"descripcion\":\"Responsable Inscripto\",\"tipoComprobante\":{\"id\":1,\"descripcion\":\"Factura A\"}},\"montoTotal\":2860,\"idCliente\":1,\"lineasDeVenta\":{\"lineaDeVenta0\":{\"cantidad\":1,\"descripcion\":\"Remera Run\",\"id\":1,\"idColor\":1,\"color\":\"Blanco\",\"idTalle\":1,\"talle\":\"M\",\"marca\":\"Adidas\",\"totalVenta\":1430},\"lineaDeVenta1\":{\"cantidad\":1,\"descripcion\":\"Remera Run\",\"id\":2,\"idColor\":1,\"color\":\"Blanco\",\"idTalle\":1,\"talle\":\"M\",\"marca\":\"Adidas\",\"totalVenta\":1430}},\"datosCliente\":{\"idCliente\":1,\"cuitCliente\":20368661601,\"direccionCliente\":\"25 de Mayo 577\",\"nombreCliente\":\"Gerard Delevaux\"},\"tipoFacturaCliente\":\"Factura B\",\"tipoPago\":\"Efectivo\"}";        JsonNode jsonNode = objectMapper.readTree(json);

        when(clienteRepository.findById(anyInt())).thenReturn(Optional.of(new Cliente()));
        when(condicionTributariaRepository.findById(anyInt())).thenReturn(Optional.of(new CondicionTributaria()));
        when(tipoComprobanteRepository.findById(anyInt())).thenReturn(Optional.of(new TipoComprobante()));
        when(comprobanteRepository.save(any())).thenReturn(new Comprobante());
        when(pagoRepository.save(any())).thenReturn(new Pago());
        when(ventaRepository.save(any())).thenReturn(new Venta());

        // Llamamos al método que estamos probando
        ventaService.procesarVenta(jsonNode);

        // Verificamos que los métodos necesarios hayan sido invocados
        verify(clienteRepository, times(1)).findById(anyInt());
        verify(condicionTributariaRepository, times(1)).findById(anyInt());
        verify(tipoComprobanteRepository, times(1)).findById(anyInt());
        verify(comprobanteRepository, times(1)).save(any());
        verify(pagoRepository, times(1)).save(any());
        verify(ventaRepository, times(1)).save(any());
    }

    @Test
    public void testProcesarVentaSinStockDisponible() throws Exception {
        // Simulamos un JSON con datos de venta
        String json = "{\"condicionTributaria\":{\"id\":1,\"descripcion\":\"Responsable Inscripto\",\"tipoComprobante\":{\"id\":1,\"descripcion\":\"Factura A\"}},\"montoTotal\":2860,\"idCliente\":1,\"lineasDeVenta\":{\"lineaDeVenta0\":{\"cantidad\":5,\"descripcion\":\"Remera Run\",\"id\":1,\"idColor\":1,\"color\":\"Blanco\",\"idTalle\":1,\"talle\":\"M\",\"marca\":\"Adidas\",\"totalVenta\":1430}},\"datosCliente\":{\"idCliente\":1,\"cuitCliente\":20368661601,\"direccionCliente\":\"25 de Mayo 577\",\"nombreCliente\":\"Gerard Delevaux\"},\"tipoFacturaCliente\":\"Factura B\",\"tipoPago\":\"Efectivo\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);

        // Simulamos un stock insuficiente para la venta
        when(articuloService.obtenerStock(anyInt(), anyInt(), anyInt())).thenReturn(new Stock(0));

        // Llamamos al método que estamos probando
        ventaService.procesarVenta(jsonNode);

        // Verificamos que el método de guardado de línea de venta no haya sido invocado
        verify(lineaVentaRepository, never()).save(any());
    }


}
