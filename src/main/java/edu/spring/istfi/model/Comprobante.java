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
    private int codigo;
    @OneToMany(mappedBy = "comprobante", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Venta> ventas = new HashSet<>();

    public Comprobante(int id, int codigo, Set<Venta> ventas) {
        this.id = id;
        this.codigo = codigo;
        this.ventas = ventas;
    }

    public Set<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Comprobante - Código: " + codigo;
    }
}
