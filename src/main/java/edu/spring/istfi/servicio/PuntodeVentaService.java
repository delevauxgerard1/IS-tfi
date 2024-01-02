package edu.spring.istfi.servicio;

import edu.spring.istfi.model.PuntoVenta;
import edu.spring.istfi.repository.PuntodeVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PuntodeVentaService {
    private final PuntodeVentaRepository puntodeVentaRepository;
    @Autowired
    public PuntodeVentaService(PuntodeVentaRepository puntodeVentaRepository) {
        this.puntodeVentaRepository = puntodeVentaRepository;
    }


    public PuntoVenta buscarPuntodeVentaporId(int id) {
        return puntodeVentaRepository.findById(id);
    }
}
