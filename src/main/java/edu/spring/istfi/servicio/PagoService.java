package edu.spring.istfi.servicio;


import edu.spring.istfi.model.Pago;
import edu.spring.istfi.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoService {
    private final PagoRepository pagoRepository;
    @Autowired
    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }


    public Pago buscarPagoporId(int id) {
        return pagoRepository.findById(id);
    }
}
