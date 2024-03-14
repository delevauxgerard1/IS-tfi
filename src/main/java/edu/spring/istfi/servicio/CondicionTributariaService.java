package edu.spring.istfi.servicio;



import edu.spring.istfi.model.CondicionTributaria;
import edu.spring.istfi.repository.CondicionTributariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondicionTributariaService {

    @Autowired
    private final CondicionTributariaRepository  condicionTributariaRepository;

    public CondicionTributariaService(CondicionTributariaRepository condicionTributariaRepository) {
        this.condicionTributariaRepository = condicionTributariaRepository;
    }

    public List<CondicionTributaria> getAllTributaryConditions() {
        return condicionTributariaRepository.findAll();
    }

}
