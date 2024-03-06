package edu.spring.istfi.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int codigo;
    private Date fecha;
    private double monto;
    @Enumerated(EnumType.STRING)
    private TipoPago tipoPago;

    @OneToOne(mappedBy = "pago")
    private Venta venta;

    public Pago(int id, int codigo, Date fecha, double monto, TipoPago tipoPago, Venta venta) {
        this.id = id;
        this.codigo = codigo;
        this.fecha = fecha;
        this.monto = monto;
        this.tipoPago = tipoPago;
        this.venta = venta;
    }

    // Getters y setters

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
