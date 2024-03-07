package edu.spring.istfi.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class TipoComprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    @OneToMany(mappedBy = "tipoComprobante", cascade = CascadeType.ALL)
    private Set<Comprobante> comprobante = new HashSet<>();

    public TipoComprobante() {
    }

    public TipoComprobante(int id, String descripcion, Set<Comprobante> comprobante) {
        this.id = id;
        this.descripcion = descripcion;
        this.comprobante = comprobante;
    }

    public Set<Comprobante> getComprobante() {
        return comprobante;
    }

    public void setComprobante(Set<Comprobante> comprobante) {
        this.comprobante = comprobante;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
