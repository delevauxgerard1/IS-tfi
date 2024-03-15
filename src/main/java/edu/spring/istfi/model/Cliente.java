package edu.spring.istfi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long cuit;
    private String nombre;
    private String domicilio;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Venta> venta = new HashSet<>();

    public Cliente() {
    }

    public Cliente(int id, long cuit, String nombre, String domicilio, Set<Venta> venta) {
        this.id = id;
        this.cuit = cuit;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.venta = venta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public Set<Venta> getVenta() {
        return venta;
    }

    public void setVenta(Set<Venta> venta) {
        this.venta = venta;
    }
}
