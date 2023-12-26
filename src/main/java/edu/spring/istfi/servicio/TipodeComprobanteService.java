package edu.spring.istfi.servicio;


import edu.spring.istfi.model.TipoComprobante;
import edu.spring.istfi.repository.TipodeComprobanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipodeComprobanteService {
    private final TipodeComprobanteRepository tipodeComprobanteRepository;
    @Autowired
    public TipodeComprobanteService(TipodeComprobanteRepository tipodeComprobanteRepository) {
        this.tipodeComprobanteRepository = tipodeComprobanteRepository;
    }


    public TipoComprobante buscarComprobanteporId(int id) {
        return tipodeComprobanteRepository.findById(id);
    }
}
