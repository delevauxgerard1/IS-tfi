package com.example.demo.model;

public class Articulo {
    private long codigo;
    private String descripcion;
    private double costo;
    private double margenDeGanancia;
    private double iva;

    public Articulo(long codigo, String descripcion, double costo, double margenDeGanancia, double iva) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.costo = costo;
        this.margenDeGanancia = margenDeGanancia;
        this.iva = iva;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getMargenDeGanancia() {
        return margenDeGanancia;
    }

    public void setMargenDeGanancia(double margenDeGanancia) {
        this.margenDeGanancia = margenDeGanancia;
    }

    public double getIVA() {
        return iva;
    }

    public void setIVA(double iva) {
        this.iva = iva;
    }

    public double getNetoGravado() {
        // Implementa la lógica para calcular el neto gravado
        return costo + (costo * margenDeGanancia);
    }

    public double getCostoIVA() {
        // Implementa la lógica para calcular el costo con IVA
        return getNetoGravado() * (1 + (iva / 100));
    }

    public double getPrecioVenta() {
        // Implementa la lógica para calcular el precio de venta
        return getCostoIVA();
    }

    @Override
    public String toString() {
        return "Articulo - Código: " + codigo +
                ", Descripción: " + descripcion +
                ", Costo: " + costo +
                ", Margen de Ganancia: " + margenDeGanancia +
                ", IVA: " + iva +
                ", Neto Gravado: " + getNetoGravado() +
                ", Costo con IVA: " + getCostoIVA() +
                ", Precio de Venta: " + getPrecioVenta();
    }
}
