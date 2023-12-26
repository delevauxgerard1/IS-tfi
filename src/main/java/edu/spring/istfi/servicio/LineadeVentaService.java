package edu.spring.istfi.servicio;


import edu.spring.istfi.model.LineaVenta;
import edu.spring.istfi.repository.LineadeVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineadeVentaService {
    private final LineadeVentaRepository lineadeVentaRepository;
    @Autowired
    public LineadeVentaService(LineadeVentaRepository lineadeVentaRepository) {
        this.lineadeVentaRepository = lineadeVentaRepository;
    }


    public LineaVenta buscarLineadeVentaporId(int id) {
        return lineadeVentaRepository.findById(id);
    }
}
