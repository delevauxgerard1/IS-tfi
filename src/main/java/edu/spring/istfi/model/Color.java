package edu.spring.istfi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Color {
    public Color() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;

    @ManyToMany(mappedBy = "colores")
    private Set<Articulo> articulos = new HashSet<>();

    @OneToMany(mappedBy = "color", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Stock> stocks = new HashSet<>();


    // Métodos getter y setter
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


    public Color(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Color(String descripcion) {
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
        return "Color - ID: " + id +
                ", Descripción: " + descripcion;
    }

}
