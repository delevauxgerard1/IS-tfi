package edu.spring.istfi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Talle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "tipo_talle_id")
    private TipoTalle tipoTalle;
    @ManyToMany(mappedBy = "talles")
    private Set<Articulo> articulos = new HashSet<>();
    @OneToMany(mappedBy = "talle", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Stock> stocks = new HashSet<>();

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    public Set<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(Set<Articulo> articulos) {
        this.articulos = articulos;
    }

    public Talle() {
        // Constructor sin argumentos necesario para JPA/Hibernate
    }

    public Talle(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Talle(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Talle - ID: " + id +
                ", Descripción: " + descripcion;
    }

    public TipoTalle getTipoTalle() {
        return tipoTalle;
    }

    public void setTipoTalle(TipoTalle tipoTalle) {
        this.tipoTalle = tipoTalle;
    }
}
