package edu.spring.istfi.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Talle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    @ManyToMany(mappedBy = "talles")
    private Set<Articulo> articulos = new HashSet<>();
    // Métodos getter y setter para articulos
    public Set<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(Set<Articulo> articulos) {
        this.articulos = articulos;
    }
    public Talle() {
        // Constructor sin argumentos necesario para JPA/Hibernate
    }


    public Talle(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Talle(String descripcion) {
        this.descripcion = descripcion;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Talle - ID: " + id +
                ", Descripción: " + descripcion;
    }
}
