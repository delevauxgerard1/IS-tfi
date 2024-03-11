package edu.spring.istfi.model;

public enum TipoPago {
    EFECTIVO("Efectivo"),
    TARJETA_DEBITO("Tarjeta débito"),
    TARJETA_CREDITO("Tarjeta crédito");

    private final String descripcion;

    TipoPago(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public static TipoPago fromDescripcion(String descripcion) {
        for (TipoPago tipoPago : TipoPago.values()) {
            if (tipoPago.getDescripcion().equalsIgnoreCase(descripcion)) {
                return tipoPago;
            }
        }
        throw new IllegalArgumentException("No se encontró Tipo Pago : " + descripcion);
    }

}
