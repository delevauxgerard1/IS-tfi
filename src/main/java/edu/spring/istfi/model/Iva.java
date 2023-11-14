package edu.spring.istfi.model;

public enum Iva {
    IVA_COMUN(0.21);
    private double importe;
    Iva(Double importe){this.importe=importe;}

    public double getImporte() {
        return importe;
    }


}
