
package com.bibliouni.repositorio;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bibliouni.modelo.Material;

class MaterialRepositoryTest {

    private MaterialRepository materialRepository;

    @BeforeEach
    void configurar() {
        materialRepository = new MaterialRepository();
    }

    @Test
    void debeGuardarMaterialExitosamente() {

        // Arrange
        Material material = new Material(1L, "Matemáticas", true);

        // Act
        Material resultado = materialRepository.guardar(material);

        // Assert
        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Matemáticas", resultado.getNombre());
    }

    @Test
    void debeBuscarMaterialGuardadoPorId() {

        // Arrange
        Material material = new Material(1L, "Matemáticas", true);
        materialRepository.guardar(material);

        // Act
        Optional<Material> resultado = materialRepository.buscarPorId(1L);

        // Assert
        assertTrue(resultado.isPresent());
        assertEquals("Matemáticas", resultado.get().getNombre());
    }

    @Test
    void debeRetornarVacioCuandoMaterialNoExiste() {

        // Act
        Optional<Material> resultado = materialRepository.buscarPorId(99L);

        // Assert
        assertFalse(resultado.isPresent());
    }

    @Test
    void debeActualizarMaterialConElMismoId() {

        // Arrange
        Material material1 = new Material(1L, "Matemáticas", true);
        Material material2 = new Material(1L, "Física", false);

        // Act
        materialRepository.guardar(material1);
        materialRepository.guardar(material2);

        Optional<Material> resultado = materialRepository.buscarPorId(1L);

        // Assert
        assertTrue(resultado.isPresent());
        assertEquals("Física", resultado.get().getNombre());
        assertFalse(resultado.get().isDisponible());
    }
}
