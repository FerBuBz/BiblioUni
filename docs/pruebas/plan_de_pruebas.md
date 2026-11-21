# PLAN DE PRUEBAS – BIBLIOUNI

## 1. Identificación del plan

- **Nombre del proyecto:** BiblioUni – Sistema de Gestión Bibliotecaria.
- **Documento:** Plan de Pruebas de Software.
- **Norma de referencia:** IEEE 829.
- **Versión:** 1.0.
- **Responsable:** Fernando Buitrago.
- **Fecha:** Noviembre de 2026.

## 2. Alcance de las pruebas

El objetivo de este plan es verificar el correcto funcionamiento de las principales operaciones del sistema BiblioUni, enfocándose en la gestión de materiales, el registro de préstamos y el cálculo de multas.

**Funcionalidades que se probarán:**

- Creación y registro de materiales.
- Validación de los datos obligatorios de los materiales.
- Búsqueda de materiales por su identificador.
- Consulta de materiales existentes e inexistentes.
- Registro de préstamos de materiales disponibles.
- Validación de la disponibilidad de los materiales.
- Validación de las fechas de préstamo y devolución.
- Cálculo de multas por devoluciones tardías.
- Manejo de datos inválidos y situaciones no permitidas.

**Funcionalidades que no se probarán en esta etapa:**

- Registro y administración de usuarios.
- Control de un límite de préstamos por estudiante.
- Gestión de inventario mediante cantidades.
- Control de permisos y autenticación.
- Pruebas de integración con bases de datos externas.
- Pruebas de API REST.
- Pruebas de carga, rendimiento y seguridad avanzada.

## 3. Enfoque de pruebas

Se utilizarán diferentes técnicas para comprobar el comportamiento del sistema y detectar posibles errores.

- **Pruebas unitarias:** se utilizará JUnit 5 para verificar el funcionamiento de los métodos de los servicios y repositorios. También se empleará Mockito para simular las dependencias de los servicios.
- **Pruebas de validación:** se comprobará que el sistema acepte los datos correctos y rechace los datos incompletos o inválidos.
- **Técnicas de diseño:** se aplicarán partición de equivalencia, análisis de valores límite y caminos tristes para evaluar diferentes situaciones de funcionamiento.
- **Desarrollo basado en pruebas (TDD):** se aplicará el ciclo Red-Green-Refactor en dos funcionalidades seleccionadas, registrando cada etapa mediante commits en Git.

## 4. Criterios de entrada

Para iniciar la ejecución de las pruebas se deben cumplir las siguientes condiciones:

- Tener el proyecto configurado correctamente en Java y Maven.
- Contar con las dependencias de JUnit 5 y Mockito.
- Disponer de las clases y métodos que serán evaluados.
- Verificar que el proyecto compile correctamente.
- Tener documentados los escenarios y casos de prueba.
- Contar con los archivos de pruebas dentro de la estructura correspondiente del proyecto.
- Tener configurado Git para registrar los cambios realizados.

## 5. Criterios de salida

Se considerará finalizada esta etapa de pruebas cuando se cumplan las siguientes condiciones:

- Tener documentados al menos 15 casos de prueba.
- Ejecutar las pruebas unitarias diseñadas.
- Obtener resultados satisfactorios en las pruebas implementadas.
- No presentar fallos pendientes en las pruebas automatizadas.
- Contar con al menos 6 pruebas unitarias utilizando JUnit 5 y Mockito.
- Evidenciar dos ciclos completos de TDD mediante commits en Git.
- Ejecutar correctamente el comando `mvn test`.
- Conservar las evidencias de ejecución y los cambios realizados en el repositorio.

## 6. Recursos necesarios

**Herramientas de software:**

- **Java:** lenguaje utilizado para desarrollar el proyecto.
- **Maven:** herramienta para administrar el proyecto y ejecutar las pruebas.
- **JUnit 5:** herramienta para crear y ejecutar pruebas unitarias.
- **Mockito:** herramienta para simular dependencias durante las pruebas.
- **Git:** sistema para controlar las versiones y registrar los cambios.
- **GitHub:** plataforma para almacenar y compartir el proyecto.
- **Visual Studio Code:** entorno utilizado para desarrollar y ejecutar el proyecto.

**Recursos humanos:**

- Responsable del desarrollo y ejecución de las pruebas: estudiante encargado del proyecto BiblioUni.

## 7. Análisis de riesgos y contingencias

| Riesgo identificado | Impacto | Acción preventiva o contingencia |
|---|---|---|
| Errores en la lógica de préstamos | Alto | Diseñar pruebas para validar el registro y las condiciones del préstamo. |
| Registro de materiales con datos inválidos | Medio | Implementar validaciones para los campos obligatorios. |
| Préstamos de materiales no disponibles | Alto | Verificar la disponibilidad antes de registrar el préstamo. |
| Errores en el cálculo de multas | Alto | Realizar pruebas con diferentes fechas de devolución. |
| Fallos en las pruebas unitarias | Medio | Revisar los métodos y utilizar Mockito para aislar las dependencias. |
| Pérdida de avances del proyecto | Alto | Realizar commits frecuentes y mantener los cambios registrados en Git. |
| Errores durante la implementación de TDD | Medio | Respetar las fases Red-Green-Refactor y verificar los resultados de cada etapa. |

## 8. Conclusión del plan

Este plan permite organizar las pruebas del sistema BiblioUni y comprobar que sus funcionalidades principales respondan correctamente. Mediante las pruebas unitarias y las diferentes técnicas de diseño se busca identificar errores, validar las reglas implementadas y mejorar la confiabilidad del sistema.

Además, el uso de JUnit 5, Mockito y la metodología TDD permite desarrollar y verificar las funcionalidades de manera organizada, dejando evidencia de los cambios y de los resultados obtenidos durante el proceso.