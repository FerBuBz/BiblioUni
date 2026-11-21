
package com.bibliouni.servicio;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import com.bibliouni.modelo.Prestamo;
import com.bibliouni.repositorio.PrestamoRepository;

@ExtendWith(MockitoExtension.class)
class PrestamoServiceTest {

    @Mock
    private PrestamoRepository prestamoRepository;

    @InjectMocks
    private PrestamoService prestamoService;

    @Test
    void debeRegistrarPrestamoExitosamente() {
        // Arrange
        Material material = new Material(1L, "Libro de Java", true);
        LocalDate fechaPrestamo = LocalDate.of(2026, 11, 21);
        LocalDate fechaDevolucion = LocalDate.of(2026, 11, 28);

        Prestamo prestamo = new Prestamo(
                1L, material, fechaPrestamo, fechaDevolucion);

        when(prestamoRepository.guardar(any(Prestamo.class)))
                .thenReturn(prestamo);

        // Act
        Prestamo resultado = prestamoService.registrarPrestamo(
                1L, material, fechaPrestamo, fechaDevolucion);

        // Assert
        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Libro de Java", resultado.getMaterial().getNombre());
        verify(prestamoRepository).guardar(any(Prestamo.class));
    }

    @Test
    void debeFallarCuandoElMaterialNoEstaDisponible() {
        // Arrange
        Material material = new Material(2L, "Libro de Kotlin", false);
        LocalDate fechaPrestamo = LocalDate.of(2026, 11, 21);
        LocalDate fechaDevolucion = LocalDate.of(2026, 11, 28);

        // Act y Assert
        assertThrows(IllegalArgumentException.class, () ->
                prestamoService.registrarPrestamo(
                        2L, material, fechaPrestamo, fechaDevolucion));

        verify(prestamoRepository, never()).guardar(any(Prestamo.class));
    }

    @Test
    void debeCalcularMultaPorDevolucionTardia() {
        // Arrange
        Material material = new Material(3L, "Libro de Python", true);
        LocalDate fechaPrestamo = LocalDate.of(2026, 11, 1);
        LocalDate fechaDevolucion = LocalDate.of(2026, 11, 10);

        Prestamo prestamo = new Prestamo(
                3L, material, fechaPrestamo, fechaDevolucion);

        LocalDate fechaEntregaReal = LocalDate.of(2026, 11, 13);

        // Act
        double multa = prestamoService.calcularMulta(
                prestamo, fechaEntregaReal);

        // Assert
        assertEquals(6000.0, multa);
        assertEquals(6000.0, prestamo.getMulta());
    }


@Test
void debeRechazarFechaDeDevolucionAnteriorAlPrestamo() {
    // Arrange
    Material material = new Material(4L, "Libro de prueba", true);
    LocalDate fechaPrestamo = LocalDate.of(2026, 11, 21);
    LocalDate fechaDevolucion = LocalDate.of(2026, 11, 15);

    // Act y Assert
    assertThrows(IllegalArgumentException.class, () ->
            prestamoService.registrarPrestamo(
                    4L, material, fechaPrestamo, fechaDevolucion));
}




}
