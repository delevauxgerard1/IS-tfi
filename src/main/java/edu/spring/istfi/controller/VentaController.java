package edu.spring.istfi.controller;


import edu.spring.istfi.model.TipoPago;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
//http://localhost:8080/tfib/
@RequestMapping("tfib")
@CrossOrigin(value = "http://localhost:5173")
public class VentaController {

    @GetMapping("/listarTipoPago")
    public List<String> listarTiposPago() {
        return Arrays.asList(
                TipoPago.EFECTIVO.getDescripcion(),
                TipoPago.TARJETA_DEBITO.getDescripcion(),
                TipoPago.TARJETA_CREDITO.getDescripcion()
        );
    }
}
