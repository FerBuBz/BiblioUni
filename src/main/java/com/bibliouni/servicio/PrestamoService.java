
package com.bibliouni.servicio;

import java.time.LocalDate;

import com.bibliouni.modelo.Material;
import com.bibliouni.modelo.Prestamo;
import com.bibliouni.repositorio.PrestamoRepository;

public class PrestamoService {

    private final PrestamoRepository prestamoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    public Prestamo registrarPrestamo(Long id, Material material,
                                      LocalDate fechaPrestamo,
                                      LocalDate fechaDevolucion) {

        if (material == null || !material.isDisponible()) {
            throw new IllegalArgumentException("El material no está disponible");
        }

        Prestamo prestamo = new Prestamo(
                id, material, fechaPrestamo, fechaDevolucion);

        return prestamoRepository.guardar(prestamo);
    }

    public double calcularMulta(Prestamo prestamo, LocalDate fechaEntregaReal) {

        if (prestamo == null || fechaEntregaReal == null) {
            throw new IllegalArgumentException("Los datos son obligatorios");
        }

        long diasRetraso = java.time.temporal.ChronoUnit.DAYS.between(
                prestamo.getFechaDevolucion(), fechaEntregaReal);

        if (diasRetraso <= 0) {
            return 0.0;
        }

        double multaPorDia = 2000.0;
        double multa = diasRetraso * multaPorDia;

        prestamo.setMulta(multa);

        return multa;
    }
}
