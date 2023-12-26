package edu.spring.istfi.servicio;


import edu.spring.istfi.model.Comprobante;
import edu.spring.istfi.repository.ComprobanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComprobanteService {
    private final ComprobanteRepository comprobanteRepository;
    @Autowired
    public ComprobanteService(ComprobanteRepository comprobanteRepository) {
        this.comprobanteRepository = comprobanteRepository;
    }


    public Comprobante buscarComprobanteporId(int id) {
        return comprobanteRepository.findById(id);
    }
}
