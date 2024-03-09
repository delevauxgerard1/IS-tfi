package edu.spring.istfi.controller;

import edu.spring.istfi.model.Cliente;
import edu.spring.istfi.servicio.ClienteService;
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
public class ClienteController {
   /* private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteService clienteService;
    @GetMapping("/buscarCliente/{cuit}")
    public ResponseEntity<Cliente> buscarClienteDni(@PathVariable long cuit) {
        Cliente cliente = clienteService.buscarClienteporCuit(cuit);
        return ResponseEntity.ok(cliente);
    }*/
}
