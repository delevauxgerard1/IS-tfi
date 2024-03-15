package edu.spring.istfi.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long codigo;
    private String descripcion;
    private double costo;
    private double margenDeGanancia;
    private double iva = 0.21;
    @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Stock> stocks = new HashSet<>();
    public Set<Stock> getStocks() {
        return stocks;
    }
    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "articulo_talle", joinColumns = @JoinColumn(name = "articulo_id"), inverseJoinColumns = @JoinColumn(name = "talle_id"))
    private Set<Talle> talles = new HashSet<>();
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "articulo_color", joinColumns = @JoinColumn(name = "articulo_id"), inverseJoinColumns = @JoinColumn(name = "color_id")
    )
    private Set<Color> colores = new HashSet<>();
    @ManyToOne
    private Marca marca;
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    @ManyToOne
    private Categoria categoria;

    public Set<Talle> getTalles() {
        return talles;
    }

    public void setTalles(Set<Talle> talles) {
        this.talles = talles;
    }

    public Set<Color> getColores() {
        return colores;
    }

    public void setColores(Set<Color> colores) {
        this.colores = colores;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Marca getMarca() {
        return marca;
    }

    public Articulo() {
    }

    public Articulo(String descripcion, double costo, double margenDeGanancia) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        if (costo < 0) throw new RuntimeException("No se puede crear articulos con costo negativo");
        this.costo = costo;
        if (margenDeGanancia < 0) throw new RuntimeException("No se puede crear articulos con margen de ganancia negativo");
        this.margenDeGanancia = margenDeGanancia;
        this.iva = iva;
    }

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

    public double getPrecioDeVenta() {
       double netoGravado = calcularNetoGravado();
       double importeIVA = netoGravado * iva;
       return netoGravado + importeIVA;
    }

    private double calcularNetoGravado(){
        return costo * (margenDeGanancia / 100) + costo;
    }

    public double getNetoGravado() {
        // Implementa la lógica para calcular el neto gravado
        return costo + (costo * margenDeGanancia);
    }

    public double getCostoIVA() {
        // Implementa la lógica para calcular el costo con IVA
        return getNetoGravado() * (1 + (iva / 100));
    }

    @Override
    public String toString() {
        return "Articulo - ID: " + id +
                ", Código: " + codigo +
                ", Descripción: " + descripcion +
                ", Costo: " + costo +
                ", Margen de Ganancia: " + margenDeGanancia +
                ", IVA: " + iva +
                ", Neto Gravado: " + getNetoGravado() +
                ", Costo con IVA: " + getCostoIVA() +
                ", Precio de Venta: " + getPrecioDeVenta();
    }
}
