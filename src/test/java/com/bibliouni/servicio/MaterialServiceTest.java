
package com.bibliouni.servicio;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bibliouni.modelo.Material;
import com.bibliouni.repositorio.MaterialRepository;

@ExtendWith(MockitoExtension.class)
class MaterialServiceTest {

    @Mock
    private MaterialRepository materialRepository;

    @InjectMocks
    private MaterialService materialService;

    @Test
    void debeCrearMaterialExitosamente() {

        // Arrange
        Material material = new Material(1L, "Matemáticas", true);

        when(materialRepository.guardar(any(Material.class)))
                .thenReturn(material);

        // Act
        Material resultado = materialService.crearMaterial(
                1L, "Matemáticas", true);

        // Assert
        assertNotNull(resultado);
        assertEquals("Matemáticas", resultado.getNombre());
        verify(materialRepository).guardar(any(Material.class));
    }



    @Test
void debeLanzarErrorCuandoNombreEstaVacio() {

    // Arrange
    String nombre = "";

    // Act y Assert
    assertThrows(IllegalArgumentException.class, () -> {
        materialService.crearMaterial(2L, nombre, true);
    });

    verify(materialRepository, never()).guardar(any(Material.class));
}


@Test
void debeLanzarErrorCuandoNombreEsNulo() {

    // Act y Assert
    assertThrows(IllegalArgumentException.class, () -> {
        materialService.crearMaterial(3L, null, true);
    });

    verify(materialRepository, never()).guardar(any(Material.class));
}







    @Test
    void debeBuscarMaterialPorIdExistente() {

        // Arrange
        Material material = new Material(1L, "Matemáticas", true);

        when(materialRepository.buscarPorId(1L))
                .thenReturn(Optional.of(material));

        // Act
        Optional<Material> resultado = materialService.buscarPorId(1L);

        // Assert
        assertTrue(resultado.isPresent());
        assertEquals("Matemáticas", resultado.get().getNombre());
    }

    @Test
    void debeBuscarMaterialPorIdInexistente() {

        // Arrange
        when(materialRepository.buscarPorId(99L))
                .thenReturn(Optional.empty());

        // Act
        Optional<Material> resultado = materialService.buscarPorId(99L);

        // Assert
        assertFalse(resultado.isPresent());
    }
}
