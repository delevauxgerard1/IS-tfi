package edu.spring.istfi.servicio;

import com.fasterxml.jackson.databind.JsonNode;
import edu.spring.istfi.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VentaServiceTest {

    @Mock
    private ArticuloService articuloService;
    @Mock
    private VentaRepository ventaRepository;
    @Mock
    private ClienteRepository clienteRepository;
    @Mock
    private PagoRepository pagoRepository;
    @Mock
    private LineaVentaRepository lineaVentaRepository;
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

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }





}

