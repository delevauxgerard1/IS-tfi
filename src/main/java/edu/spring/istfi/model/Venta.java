package edu.spring.istfi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime fecha;
    private long numComprobante;
    private double total;
    @ManyToOne
    @JoinColumn(name = "comprobante_id")
    private Comprobante comprobante;
    @OneToOne
    @JoinColumn(name = "pago_id")
    private Pago pago;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<LineaVenta> lineaVentas = new HashSet<>();



    public Set<LineaVenta> getLineaVentas() {
        return lineaVentas;
    }
    public void setLineaVentas(Set<LineaVenta> lineaVentas) {
        this.lineaVentas = lineaVentas;
    }


    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public long getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(long numComprobante) {
        this.numComprobante = numComprobante;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Venta() {
    }

    public Venta(int id, LocalDateTime fecha, long numComprobante, double total, Comprobante comprobante, Pago pago, Set<LineaVenta> lineaVentas) {
        this.id = id;
        this.fecha = fecha;
        this.numComprobante = numComprobante;
        this.total = total;
        this.comprobante = comprobante;
        this.pago = pago;
        this.lineaVentas = lineaVentas;
    }

    private double getTotal() {
        // Lógica para calcular el total de la venta
        return 0;
    }
}
