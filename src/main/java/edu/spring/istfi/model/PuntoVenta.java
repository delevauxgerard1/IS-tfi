package edu.spring.istfi.model;

public class PuntoVenta {
    private int numero;

    public PuntoVenta(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void iniciarVenta() {
        System.out.println("Venta iniciada en el punto de venta " + numero);
    }

    public void autorizarPago() {
        System.out.println("Pago autorizado en el punto de venta " + numero);
    }

    public void emitirComprobante() {
        System.out.println("Comprobante emitido en el punto de venta " + numero);
    }

    public void cancelarVenta() {
        System.out.println("Venta cancelada en el punto de venta " + numero);
    }

    @Override
    public String toString() {
        return "Punto de Venta - Número: " + numero;
    }
}
