# CASOS DE PRUEBA – BIBLIOUNI

## 1. Introducción

En este documento se presentan los casos de prueba diseñados para verificar el funcionamiento del sistema BiblioUni. Se utilizan técnicas de partición de equivalencia y análisis de valores límite para comprobar el comportamiento del sistema tanto con datos válidos como inválidos.

## 2. Casos de prueba

### CP-001. Registrar material con datos válidos

- **Funcionalidad:** Registrar material.
- **Precondiciones:** El sistema está disponible y el material no se encuentra registrado.
- **Datos de entrada:** Título: "Cálculo Diferencial", autor: "Carlos Pérez", cantidad: 5.
- **Pasos:**
  1. Ingresar los datos del material.
  2. Ejecutar el registro.
  3. Consultar el resultado.
- **Resultado esperado:** El material se registra correctamente y queda disponible en el catálogo.
- **Técnica aplicada:** Partición de equivalencia (clase válida).

### CP-002. Registrar material sin título

- **Funcionalidad:** Registrar material.
- **Precondiciones:** El sistema permite acceder al formulario o servicio de registro.
- **Datos de entrada:** Título vacío, autor: "Carlos Pérez", cantidad: 5.
- **Pasos:**
  1. Enviar los datos del material.
  2. Ejecutar el registro.
  3. Verificar la respuesta.
- **Resultado esperado:** El sistema rechaza el registro porque el título es obligatorio.
- **Técnica aplicada:** Partición de equivalencia (clase inválida).

### CP-003. Consultar material existente

- **Funcionalidad:** Buscar material por ID.
- **Precondiciones:** Existe un material registrado con ID 10.
- **Datos de entrada:** ID = 10.
- **Pasos:**
  1. Solicitar la búsqueda del material.
  2. Consultar el resultado.
- **Resultado esperado:** El sistema devuelve el material correspondiente al ID 10.
- **Técnica aplicada:** Partición de equivalencia (identificador existente).

### CP-004. Consultar material inexistente

- **Funcionalidad:** Buscar material por ID.
- **Precondiciones:** No existe un material con ID 999.
- **Datos de entrada:** ID = 999.
- **Pasos:**
  1. Solicitar la búsqueda.
  2. Verificar la respuesta del servicio.
- **Resultado esperado:** El sistema devuelve un resultado vacío o una excepción controlada, sin generar errores inesperados.
- **Técnica aplicada:** Partición de equivalencia (clase inválida) y camino triste.

### CP-005. Registrar estudiante con datos válidos

- **Funcionalidad:** Registrar usuario.
- **Precondiciones:** El usuario no está registrado previamente.
- **Datos de entrada:** Nombre: "Andrés Gómez", correo: "andres@universidad.edu", rol: "ESTUDIANTE".
- **Pasos:**
  1. Ingresar los datos del estudiante.
  2. Ejecutar el registro.
  3. Consultar el usuario creado.
- **Resultado esperado:** El sistema registra correctamente al estudiante con el rol indicado.
- **Técnica aplicada:** Partición de equivalencia (clase válida).

### CP-006. Registrar préstamo con cero préstamos activos

- **Funcionalidad:** Registrar préstamo.
- **Precondiciones:** El estudiante está activo, tiene cero préstamos activos y el libro está disponible.
- **Datos de entrada:** Préstamos activos = 0, material disponible = 1.
- **Pasos:**
  1. Seleccionar al estudiante.
  2. Seleccionar el libro disponible.
  3. Solicitar el préstamo.
- **Resultado esperado:** El préstamo se registra correctamente y el estudiante pasa a tener un préstamo activo.
- **Técnica aplicada:** Partición de equivalencia (clase válida).

### CP-007. Registrar préstamo con dos préstamos activos

- **Funcionalidad:** Registrar préstamo.
- **Precondiciones:** El estudiante está activo y tiene dos préstamos activos.
- **Datos de entrada:** Préstamos activos = 2, material disponible = 1.
- **Pasos:**
  1. Seleccionar al estudiante.
  2. Seleccionar un libro disponible.
  3. Solicitar el préstamo.
- **Resultado esperado:** El sistema permite el préstamo y el estudiante queda con tres préstamos activos.
- **Técnica aplicada:** Partición de equivalencia (clase válida).

### CP-008. Registrar el tercer préstamo permitido

- **Funcionalidad:** Validar límite máximo de préstamos.
- **Precondiciones:** El estudiante está activo y tiene dos préstamos activos.
- **Datos de entrada:** Préstamos actuales = 2, nuevo préstamo = 1.
- **Pasos:**
  1. Seleccionar al estudiante.
  2. Solicitar un nuevo préstamo.
  3. Verificar la cantidad de préstamos activos.
- **Resultado esperado:** El sistema permite registrar el tercer préstamo, alcanzando el límite establecido.
- **Técnica aplicada:** Valores límite (límite máximo permitido).

### CP-009. Intentar registrar un cuarto préstamo

- **Funcionalidad:** Validar límite máximo de préstamos.
- **Precondiciones:** El estudiante está activo y ya tiene tres préstamos activos.
- **Datos de entrada:** Préstamos actuales = 3, nuevo préstamo = 1.
- **Pasos:**
  1. Seleccionar al estudiante.
  2. Solicitar un nuevo préstamo.
  3. Verificar la respuesta del sistema.
- **Resultado esperado:** El sistema rechaza la solicitud porque el estudiante alcanzó el máximo de tres préstamos activos.
- **Técnica aplicada:** Valores límite (superación del límite) y camino triste.

### CP-010. Registrar préstamo con una unidad disponible

- **Funcionalidad:** Validar disponibilidad de inventario.
- **Precondiciones:** El libro tiene exactamente una unidad disponible y el estudiante cumple las condiciones del préstamo.
- **Datos de entrada:** Stock disponible = 1.
- **Pasos:**
  1. Seleccionar el libro.
  2. Solicitar el préstamo.
  3. Consultar el inventario.
- **Resultado esperado:** El préstamo se aprueba y el inventario queda con cero unidades disponibles.
- **Técnica aplicada:** Valores límite (mínimo disponible).

### CP-011. Intentar prestar un libro sin existencias

- **Funcionalidad:** Validar disponibilidad de materiales.
- **Precondiciones:** El libro está registrado, pero no tiene unidades disponibles.
- **Datos de entrada:** Stock disponible = 0.
- **Pasos:**
  1. Seleccionar el libro.
  2. Solicitar el préstamo.
  3. Verificar la respuesta.
- **Resultado esperado:** El sistema rechaza el préstamo y no modifica el inventario.
- **Técnica aplicada:** Valores límite (cero unidades) y camino triste.

### CP-012. Devolver un libro en la fecha establecida

- **Funcionalidad:** Calcular multa por devolución.
- **Precondiciones:** Existe un préstamo activo cuya fecha límite es el 20/11/2026.
- **Datos de entrada:** Fecha límite = 20/11/2026, fecha de devolución = 20/11/2026.
- **Pasos:**
  1. Consultar el préstamo.
  2. Registrar la devolución.
  3. Verificar el cálculo de la multa.
- **Resultado esperado:** El sistema registra la devolución sin generar una multa por retraso.
- **Técnica aplicada:** Valores límite (cero días de retraso).

### CP-013. Devolver un libro con un día de retraso

- **Funcionalidad:** Calcular multa por devolución tardía.
- **Precondiciones:** Existe un préstamo cuya fecha límite es el 20/11/2026.
- **Datos de entrada:** Fecha límite = 20/11/2026, fecha de devolución = 21/11/2026.
- **Pasos:**
  1. Consultar el préstamo.
  2. Registrar la devolución.
  3. Calcular los días de retraso.
  4. Verificar la multa generada.
- **Resultado esperado:** El sistema identifica un día de retraso y calcula la multa correspondiente según la tarifa diaria configurada.
- **Técnica aplicada:** Valores límite (primer día de retraso).

### CP-014. Solicitar préstamo con estudiante inactivo

- **Funcionalidad:** Validar estado del usuario.
- **Precondiciones:** Existe un usuario registrado, pero su estado es inactivo.
- **Datos de entrada:** Usuario = "Andrés Gómez", estado = INACTIVO, material disponible = 1.
- **Pasos:**
  1. Seleccionar al usuario.
  2. Seleccionar un libro disponible.
  3. Solicitar el préstamo.
- **Resultado esperado:** El sistema rechaza la solicitud porque el estudiante no está activo.
- **Técnica aplicada:** Partición de equivalencia (clase inválida) y camino triste.

### CP-015. Intentar registrar una devolución sin autorización

- **Funcionalidad:** Validar permisos de devolución.
- **Precondiciones:** Existe un préstamo activo y el usuario no tiene permisos de bibliotecario.
- **Datos de entrada:** Usuario sin autorización, operación = registrar devolución administrativa.
- **Pasos:**
  1. Ingresar con un usuario sin permisos administrativos.
  2. Intentar registrar la devolución.
  3. Consultar la respuesta de la API.
- **Resultado esperado:** El sistema rechaza la operación y devuelve una respuesta de acceso no autorizado o prohibido, según la configuración de seguridad.
- **Técnica aplicada:** Partición de equivalencia (clase no autorizada) y camino triste.

## 3. Resumen de técnicas aplicadas

| Técnica | Casos identificados | Cantidad |
|---|---|---:|
| Partición de equivalencia | CP-001, CP-002, CP-003, CP-004, CP-005, CP-006, CP-007, CP-014, CP-015 | 9 |
| Valores límite | CP-008, CP-009, CP-010, CP-011, CP-012, CP-013 | 6 |
| Caminos tristes | CP-004, CP-009, CP-011, CP-014, CP-015 | 5 |

## 4. Conclusión

Los casos de prueba diseñados permiten evaluar diferentes situaciones que pueden presentarse durante el funcionamiento de BiblioUni. Se incluyen operaciones exitosas, validaciones de límites y situaciones en las que el sistema debe rechazar determinadas solicitudes.

La aplicación de estas técnicas ayuda a identificar posibles errores y comprobar que las reglas de negocio se cumplan correctamente, contribuyendo a mejorar la calidad y confiabilidad del sistema.