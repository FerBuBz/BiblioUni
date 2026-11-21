
package com.bibliouni.modelo;

import java.time.LocalDate;

public class Prestamo {

    private Long id;
    private Material material;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private double multa;

    public Prestamo(Long id, Material material, LocalDate fechaPrestamo,
                    LocalDate fechaDevolucion) {
        this.id = id;
        this.material = material;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.multa = 0.0;
    }

    public Long getId() {
        return id;
    }

    public Material getMaterial() {
        return material;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }
}
