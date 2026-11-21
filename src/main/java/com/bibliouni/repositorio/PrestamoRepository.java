
package com.bibliouni.repositorio;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.bibliouni.modelo.Prestamo;

public class PrestamoRepository {

    private final Map<Long, Prestamo> prestamos = new HashMap<>();

    public Prestamo guardar(Prestamo prestamo) {
        prestamos.put(prestamo.getId(), prestamo);
        return prestamo;
    }

    public Optional<Prestamo> buscarPorId(Long id) {
        return Optional.ofNullable(prestamos.get(id));
    }
}
