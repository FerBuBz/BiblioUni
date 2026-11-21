# CASOS DE PRUEBA – BIBLIOUNI

## 1. Introducción

En este documento se presentan los casos de prueba diseñados para verificar el funcionamiento del sistema BiblioUni. Se utilizan técnicas de partición de equivalencia, análisis de valores límite y caminos tristes para comprobar el comportamiento del sistema con datos válidos e inválidos.

Las pruebas se enfocan principalmente en la creación y consulta de materiales, el registro de préstamos y el cálculo de multas.

## 2. Casos de prueba

### CP-001. Crear material con datos válidos

- **Funcionalidad:** Crear material.
- **Precondiciones:** El servicio de materiales está disponible.
- **Datos de entrada:** ID = 1, nombre = "Libro de Java", disponible = true.
- **Pasos:**
  1. Ingresar los datos del material.
  2. Ejecutar el método de creación.
  3. Verificar el resultado.
- **Resultado esperado:** El sistema crea el material y lo guarda correctamente.
- **Técnica aplicada:** Partición de equivalencia (clase válida).

### CP-002. Crear material con identificador nulo

- **Funcionalidad:** Validar identificador del material.
- **Precondiciones:** El servicio de materiales está disponible.
- **Datos de entrada:** ID = null, nombre = "Libro de Java", disponible = true.
- **Pasos:**
  1. Ingresar un material sin identificador.
  2. Ejecutar el método de creación.
  3. Verificar la respuesta.
- **Resultado esperado:** El sistema rechaza la operación y genera una excepción indicando que el ID es obligatorio.
- **Técnica aplicada:** Partición de equivalencia (clase inválida) y camino triste.

### CP-003. Crear material con nombre nulo

- **Funcionalidad:** Validar nombre del material.
- **Precondiciones:** El servicio de materiales está disponible.
- **Datos de entrada:** ID = 2, nombre = null, disponible = true.
- **Pasos:**
  1. Ingresar un material sin nombre.
  2. Ejecutar el método de creación.
  3. Verificar la respuesta.
- **Resultado esperado:** El sistema rechaza la operación porque el nombre es obligatorio.
- **Técnica aplicada:** Partición de equivalencia (clase inválida) y camino triste.

### CP-004. Crear material con nombre vacío

- **Funcionalidad:** Validar nombre del material.
- **Precondiciones:** El servicio de materiales está disponible.
- **Datos de entrada:** ID = 3, nombre = "", disponible = true.
- **Pasos:**
  1. Ingresar el nombre vacío.
  2. Ejecutar el método de creación.
  3. Verificar el resultado.
- **Resultado esperado:** El sistema rechaza el registro mediante una excepción.
- **Técnica aplicada:** Partición de equivalencia (clase inválida).

### CP-005. Crear material con nombre de un carácter

- **Funcionalidad:** Crear material.
- **Precondiciones:** El servicio de materiales está disponible.
- **Datos de entrada:** ID = 4, nombre = "A", disponible = true.
- **Pasos:**
  1. Ingresar un nombre de un carácter.
  2. Ejecutar el método de creación.
  3. Verificar el resultado.
- **Resultado esperado:** El sistema permite crear el material porque el nombre no está vacío.
- **Técnica aplicada:** Valores límite (mínimo nombre válido).

### CP-006. Consultar material existente

- **Funcionalidad:** Buscar material por ID.
- **Precondiciones:** Existe un material registrado con ID = 1.
- **Datos de entrada:** ID = 1.
- **Pasos:**
  1. Solicitar la búsqueda del material.
  2. Consultar el resultado.
  3. Verificar sus datos.
- **Resultado esperado:** El sistema devuelve el material correspondiente al identificador solicitado.
- **Técnica aplicada:** Partición de equivalencia (clase válida).

### CP-007. Consultar material inexistente

- **Funcionalidad:** Buscar material por ID.
- **Precondiciones:** No existe un material con ID = 999.
- **Datos de entrada:** ID = 999.
- **Pasos:**
  1. Solicitar la búsqueda.
  2. Consultar el resultado.
  3. Verificar la respuesta.
- **Resultado esperado:** El sistema devuelve un resultado vacío mediante un Optional.
- **Técnica aplicada:** Partición de equivalencia (clase inexistente) y camino triste.

### CP-008. Registrar préstamo con material disponible

- **Funcionalidad:** Registrar préstamo.
- **Precondiciones:** El material existe y está disponible.
- **Datos de entrada:** ID préstamo = 1, material disponible = true, fecha préstamo = 21/11/2026, fecha devolución = 28/11/2026.
- **Pasos:**
  1. Seleccionar un material disponible.
  2. Ingresar las fechas del préstamo.
  3. Ejecutar el registro.
  4. Verificar el resultado.
- **Resultado esperado:** El sistema registra el préstamo correctamente.
- **Técnica aplicada:** Partición de equivalencia (clase válida).

### CP-009. Registrar préstamo con material no disponible

- **Funcionalidad:** Validar disponibilidad del material.
- **Precondiciones:** El material existe, pero no está disponible.
- **Datos de entrada:** ID préstamo = 2, material disponible = false.
- **Pasos:**
  1. Seleccionar el material no disponible.
  2. Solicitar el préstamo.
  3. Verificar la respuesta.
- **Resultado esperado:** El sistema rechaza el préstamo mediante una excepción y no guarda el registro.
- **Técnica aplicada:** Partición de equivalencia (clase inválida) y camino triste.

### CP-010. Registrar préstamo sin material

- **Funcionalidad:** Validar material obligatorio.
- **Precondiciones:** El servicio de préstamos está disponible.
- **Datos de entrada:** Material = null.
- **Pasos:**
  1. Intentar registrar un préstamo sin seleccionar un material.
  2. Ejecutar el método de registro.
  3. Verificar la respuesta.
- **Resultado esperado:** El sistema rechaza la operación mediante una excepción.
- **Técnica aplicada:** Partición de equivalencia (clase inválida) y camino triste.

### CP-011. Registrar préstamo con fecha de devolución nula

- **Funcionalidad:** Validar fechas del préstamo.
- **Precondiciones:** El material existe y está disponible.
- **Datos de entrada:** Fecha préstamo = 21/11/2026, fecha devolución = null.
- **Pasos:**
  1. Seleccionar un material disponible.
  2. Ingresar la fecha de préstamo.
  3. Dejar vacía la fecha de devolución.
  4. Ejecutar el registro.
- **Resultado esperado:** El sistema rechaza la operación porque las fechas son obligatorias.
- **Técnica aplicada:** Partición de equivalencia (clase inválida).

### CP-012. Registrar préstamo con fecha de devolución anterior

- **Funcionalidad:** Validar orden de las fechas.
- **Precondiciones:** El material existe y está disponible.
- **Datos de entrada:** Fecha préstamo = 21/11/2026, fecha devolución = 20/11/2026.
- **Pasos:**
  1. Seleccionar un material disponible.
  2. Ingresar las fechas.
  3. Ejecutar el registro.
  4. Verificar la respuesta.
- **Resultado esperado:** El sistema rechaza el préstamo porque la fecha de devolución es anterior a la fecha del préstamo.
- **Técnica aplicada:** Valores límite (fecha anterior) y camino triste.

### CP-013. Devolver material en la fecha establecida

- **Funcionalidad:** Calcular multa.
- **Precondiciones:** Existe un préstamo con fecha límite de devolución 20/11/2026.
- **Datos de entrada:** Fecha límite = 20/11/2026, fecha de entrega real = 20/11/2026.
- **Pasos:**
  1. Consultar el préstamo.
  2. Ingresar la fecha de entrega real.
  3. Ejecutar el cálculo de la multa.
  4. Verificar el resultado.
- **Resultado esperado:** El sistema calcula una multa de $0 porque no existen días de retraso.
- **Técnica aplicada:** Valores límite (cero días de retraso).

### CP-014. Devolver material con un día de retraso

- **Funcionalidad:** Calcular multa por devolución tardía.
- **Precondiciones:** Existe un préstamo cuya fecha límite es 20/11/2026.
- **Datos de entrada:** Fecha límite = 20/11/2026, fecha de entrega real = 21/11/2026.
- **Pasos:**
  1. Consultar el préstamo.
  2. Ingresar la fecha de entrega real.
  3. Ejecutar el cálculo de la multa.
  4. Verificar el resultado.
- **Resultado esperado:** El sistema identifica un día de retraso y calcula una multa de $2.000.
- **Técnica aplicada:** Valores límite (primer día de retraso).

### CP-015. Calcular multa sin fecha de entrega real

- **Funcionalidad:** Validar datos para el cálculo de multas.
- **Precondiciones:** Existe un préstamo registrado.
- **Datos de entrada:** Préstamo válido, fecha de entrega real = null.
- **Pasos:**
  1. Consultar el préstamo.
  2. Intentar calcular la multa sin ingresar la fecha de entrega.
  3. Verificar la respuesta.
- **Resultado esperado:** El sistema rechaza la operación mediante una excepción porque los datos son obligatorios.
- **Técnica aplicada:** Partición de equivalencia (clase inválida) y camino triste.

## 3. Resumen de técnicas aplicadas

| Técnica | Casos identificados | Cantidad |
|---|---|---:|
| Partición de equivalencia | CP-001, CP-002, CP-003, CP-004, CP-006, CP-007, CP-008, CP-009, CP-010, CP-011, CP-015 | 11 |
| Valores límite | CP-004, CP-005, CP-012, CP-013, CP-014 | 5 |
| Caminos tristes | CP-002, CP-003, CP-007, CP-009, CP-010, CP-012, CP-015 | 7 |

## 4. Conclusión

Los casos de prueba diseñados permiten evaluar las principales funcionalidades implementadas en BiblioUni. Se incluyen escenarios exitosos, validaciones de datos, consultas de materiales, registro de préstamos y cálculo de multas.

La aplicación de las técnicas de partición de equivalencia, valores límite y caminos tristes ayuda a identificar posibles errores y comprobar que el sistema responda correctamente ante diferentes situaciones.

Estos casos sirven como guía para organizar las pruebas y verificar el comportamiento del proyecto durante su desarrollo.