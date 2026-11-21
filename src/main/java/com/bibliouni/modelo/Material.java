package com.bibliouni.modelo;

public class Material {

    private Long id;
    private String nombre;
    private boolean disponible;

    public Material(Long id, String nombre, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.disponible = disponible;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isDisponible() {
        return disponible;
    }
}