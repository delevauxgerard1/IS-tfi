package edu.spring.istfi.model;

import jakarta.persistence.*;
@Entity
public class LineaVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cantidad;
    private float subtotal;
    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;
    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;
    // Constructor sin argumentos
    public LineaVenta() {
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    // Constructor con todos los campos como parámetros


    public LineaVenta(int id, int cantidad, float subtotal, Stock stock, Venta venta) {
        this.id = id;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.stock = stock;
        this.venta = venta;
    }

    // Getters y setters
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

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
    @Override
    public String toString() {
        return "Linea de Venta [Cantidad: " + cantidad + ", Subtotal: $" + subtotal + "]";
    }
}
