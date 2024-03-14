package edu.spring.istfi.servicio;


import edu.spring.istfi.model.Cliente;
import edu.spring.istfi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente buscarClienteporCuit(long cuit) {
        return clienteRepository.findByDni(cuit);
    }

}
