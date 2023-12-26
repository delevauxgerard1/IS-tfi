package edu.spring.istfi.servicio;


import edu.spring.istfi.model.Venta;
import edu.spring.istfi.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {
    private final VentaRepository ventaRepository;
    @Autowired
    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }


    public Venta buscarVentaporId(int id) {
        return ventaRepository.findById(id);
    }
}
