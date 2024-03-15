package edu.spring.istfi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "comprobante", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Venta> ventas = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "tipo_comprobante_id")
    private TipoComprobante tipoComprobante;
    @ManyToOne
    @JoinColumn(name = "condicion_tributaria_id")
    private CondicionTributaria condicionTributaria;

    public Comprobante() {
    }

    public Comprobante(int id, Set<Venta> ventas, TipoComprobante tipoComprobante, CondicionTributaria condicionTributaria) {
        this.id = id;
        this.ventas = ventas;
        this.tipoComprobante = tipoComprobante;
        this.condicionTributaria = condicionTributaria;
    }

    public TipoComprobante getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(TipoComprobante tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public CondicionTributaria getCondicionTributaria() {
        return condicionTributaria;
    }

    public void setCondicionTributaria(CondicionTributaria condicionTributaria) {
        this.condicionTributaria = condicionTributaria;
    }

    public Set<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
