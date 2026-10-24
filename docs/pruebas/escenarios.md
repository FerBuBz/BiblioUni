# Escenarios de Prueba Narrativos - BiblioUni

A continuación se presentan los escenarios de prueba diseñados para guiar el desarrollo de las pruebas en las Unidades 2 y 3.

| ID | Componente Bajo Prueba | Descripción del Escenario | Tipo de Prueba | Prioridad |
| :--- | :--- | :--- | :--- | :--- |
| **EP-001** | `PrestamoService` | Verificar que un estudiante activo pueda solicitar con éxito el préstamo de un libro disponible. | Unitaria / Integración | Alta |
| **EP-002** | `PrestamoService` | Verificar que un estudiante **no** pueda tener más de 3 préstamos activos simultáneamente (Camino Triste). | Unitaria | Alta |
| **EP-003** | `MaterialController` | Verificar que la API REST devuelva la lista completa de libros con código HTTP 200 al consultar el catálogo. | API / Integración | Alta |
| **EP-004** | `MaterialService` | Verificar que un libro inexistente devuelva un error controlado al intentar buscarlo por su ID (Camino Triste). | Unitaria | Media |
| **EP-005** | `UsuarioService` | Verificar que el sistema registre correctamente a un nuevo usuario con rol de estudiante y datos válidos. | Unitaria | Alta |
| **EP-006** | `MultaService` | Verificar que se calcule automáticamente una penalización o multa cuando un libro se devuelve fuera de la fecha límite. | Unitaria | Media |
| **EP-007** | `PrestamoController` | Verificar que un usuario sin autenticación o sin permisos de bibliotecario no pueda registrar devoluciones administrativas. | API / Seguridad | Alta |
| **EP-008** | `InventarioService` | Verificar que el stock disponible de un libro disminuya en una unidad inmediatamente después de aprobarse un préstamo. | Integración | Alta |
| **EP-009** | `RecomendacionService` | **[Gancho Innovador]** Verificar que el sistema sugiera libros relacionados basados en el historial de lecturas previos del usuario. | Unitaria | Media |
| **EP-010** | `NotificacionInnovadoraController` | **[Gancho Innovador]** Verificar que la API envíe una alerta o notificación automatizada cuando se acerque la fecha de devolución del libro. | API / Integración | Media |