package com.example.demo.model;

public class Comprobante {
    private int codigo;

    public Comprobante(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Comprobante - Código: " + codigo;
    }
}
