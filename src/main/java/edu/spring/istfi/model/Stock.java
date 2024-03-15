package edu.spring.istfi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cantidad;
    @ManyToOne
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;
    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;
    @ManyToOne
    @JoinColumn(name = "talle_id")
    private Talle talle;
    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<LineaVenta> lineaVentas = new HashSet<>();
    public Set<LineaVenta> getStocks() {
        return lineaVentas;
    }
    public void setStocks(Set<Stock> stocks) {
        this.lineaVentas = lineaVentas;
    }

    public Stock() {
    }

    public Stock(int cantidad) {
        this.cantidad = cantidad;
    }

    public Stock(int id, int cantidad, Articulo articulo, Color color, Talle talle) {
        this.id = id;
        this.cantidad = cantidad;
        this.articulo = articulo;
        this.color = color;
        this.talle = talle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Talle getTalle() {
        return talle;
    }

    public void setTalle(Talle talle) {
        this.talle = talle;
    }
}
