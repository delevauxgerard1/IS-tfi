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
    @ManyToOne
    @JoinColumn(name = "tipo_comprobante_id")
    private TipoComprobante tipoComprobante;

    public CondicionTributaria() {
    }

    public CondicionTributaria(int id, String descripcion, TipoComprobante tipoComprobante) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipoComprobante = tipoComprobante;
    }

    public TipoComprobante getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(TipoComprobante tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
