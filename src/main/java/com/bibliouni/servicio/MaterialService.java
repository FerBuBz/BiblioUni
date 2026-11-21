
package com.bibliouni.servicio;

import java.util.Optional;

import com.bibliouni.modelo.Material;
import com.bibliouni.repositorio.MaterialRepository;

public class MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public Material crearMaterial(Long id, String nombre, boolean disponible) {
        if (id == null) {
             throw new IllegalArgumentException("El ID del material es obligatorio");
}
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "El nombre del material es obligatorio"
            );
        }

        Material material = new Material(id, nombre, disponible);
        return materialRepository.guardar(material);
    }

    public Optional<Material> buscarPorId(Long id) {
        return materialRepository.buscarPorId(id);
    }
}
