package com.example.demo.model;

public enum Rol {
    ADMINISTRATIVO("Administrativo"),
    VENDEDOR("Vendedor");

    private final String nombre;

    Rol(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
