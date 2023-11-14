package com.example.demo.model;


public class Cliente {

    private int id;
    private int DNI;
    private int CUIT;
    private String razonSocial;

    // Constructor
    public Cliente(int id, int DNI, int CUIT, String razonSocial) {
        this.id = id;
        this.DNI = DNI;
        this.CUIT = CUIT;
        this.razonSocial = razonSocial;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getCUIT() {
        return CUIT;
    }

    public void setCUIT(int CUIT) {
        this.CUIT = CUIT;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
}
