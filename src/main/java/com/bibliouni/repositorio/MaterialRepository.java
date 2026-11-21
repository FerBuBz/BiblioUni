package com.bibliouni.repositorio;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.bibliouni.modelo.Material;

public class MaterialRepository {

    private final Map<Long, Material> materiales = new HashMap<>();

    public Material guardar(Material material) {
        materiales.put(material.getId(), material);
        return material;
    }

    public Optional<Material> buscarPorId(Long id) {
        return Optional.ofNullable(materiales.get(id));
    }
}