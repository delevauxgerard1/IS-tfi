package edu.spring.istfi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class CondicionTributaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    @OneToMany(mappedBy = "condicionTributaria", cascade = CascadeType.ALL)
    private Set<Comprobante> comprobante = new HashSet<>();

    public CondicionTributaria() {
    }

    public CondicionTributaria(int id, String descripcion, Set<Comprobante> comprobante) {
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
