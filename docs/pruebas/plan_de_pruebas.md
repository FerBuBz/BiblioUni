# PLAN DE PRUEBAS – BIBLIOUNI

## 1. Identificación del plan

- **Nombre del proyecto:** BiblioUni – Sistema de Gestión Bibliotecaria.
- **Documento:** Plan de Pruebas de Software.
- **Norma de referencia:** IEEE 829.
- **Versión:** 1.0.
- **Responsable:** Fernando Buitrago.
- **Fecha:** Noviembre de 2026.

## 2. Alcance de las pruebas

El objetivo de este plan es verificar el correcto funcionamiento del sistema BiblioUni, especialmente en los procesos relacionados con la gestión de materiales, usuarios, préstamos, devoluciones y multas.

**Funcionalidades que se probarán:**

- Registro y consulta de materiales.
- Registro y validación de usuarios.
- Registro de préstamos de libros.
- Control del límite máximo de tres préstamos activos por estudiante.
- Validación de disponibilidad de materiales.
- Cálculo de multas por devoluciones tardías.
- Actualización del inventario.
- Validación de operaciones no permitidas.

**Funcionalidades que no se probarán en esta etapa:**

- Pruebas de carga masiva y estrés extremo.
- Auditorías avanzadas de seguridad.
- Pruebas de penetración externas.
- Evaluación de infraestructura en producción.

## 3. Enfoque de pruebas

Se utilizará una combinación de técnicas de prueba para verificar la calidad y el comportamiento del sistema.

- **Pruebas unitarias:** se utilizará JUnit 5 y Mockito para comprobar individualmente los servicios MaterialService y PrestamoService, simulando la comunicación con los repositorios.
- **Pruebas de integración:** se verificará la comunicación entre los servicios y la base de datos utilizando H2 como entorno de pruebas.
- **Pruebas de API:** se utilizará Postman para validar las respuestas de los endpoints REST.
- **Técnicas de diseño:** se aplicarán partición de equivalencia y análisis de valores límite para identificar posibles errores en los datos de entrada.
- **Desarrollo basado en pruebas (TDD):** se aplicará el ciclo Red-Green-Refactor en dos funcionalidades seleccionadas.

## 4. Criterios de entrada

Para iniciar la ejecución de las pruebas se deben cumplir las siguientes condiciones:

- Tener el proyecto configurado correctamente en Java y Maven.
- Contar con las dependencias de JUnit 5 y Mockito.
- Disponer de las clases y métodos que serán evaluados.
- Verificar que el proyecto compile correctamente.
- Tener configurado el entorno de pruebas con H2 cuando se ejecuten pruebas de integración.
- Contar con los escenarios y casos de prueba documentados.
- Verificar que los endpoints estén disponibles cuando se realicen pruebas de API.

## 5. Criterios de salida

Se considerará finalizada esta etapa de pruebas cuando se cumplan las siguientes condiciones:

- Tener documentados al menos 15 casos de prueba.
- Haber ejecutado el 100 % de los casos de prueba diseñados.
- Obtener al menos un 60 % de cobertura de código mediante JaCoCo.
- No presentar defectos críticos pendientes.
- Tener implementadas y aprobadas al menos 6 pruebas unitarias con JUnit 5 y Mockito.
- Evidenciar dos ciclos completos de TDD mediante commits.
- Ejecutar correctamente el comando `mvn test`.

## 6. Recursos necesarios

**Herramientas de software:**

- Java: lenguaje de programación.
- Maven: administración y ejecución del proyecto.
- JUnit 5: ejecución de pruebas unitarias.
- Mockito: simulación de dependencias.
- Postman: validación de servicios API.
- JaCoCo: medición de cobertura de código.
- H2: base de datos para pruebas.
- Git y GitHub: control de versiones y seguimiento de cambios.
- Visual Studio Code: entorno de desarrollo.

**Recursos humanos:**

- Responsable del desarrollo y ejecución de las pruebas: estudiante encargado del proyecto BiblioUni.

## 7. Análisis de riesgos y contingencias

| Riesgo identificado | Impacto | Acción preventiva o contingencia |
|---|---|---|
| Errores en la lógica de préstamos | Alto | Diseñar pruebas para validar disponibilidad y límites de préstamos. |
| Registro de préstamos con materiales no disponibles | Alto | Implementar validaciones antes de aprobar cada préstamo. |
| Fallos en las pruebas unitarias | Medio | Revisar las dependencias y utilizar Mockito para aislar los servicios. |
| Problemas de conexión con la base de datos H2 | Medio | Verificar la configuración y realizar pruebas de conexión. |
| Cobertura de código inferior al 60 % | Medio | Ampliar los casos de prueba y utilizar JaCoCo para identificar código sin evaluar. |
| Pérdida de avances del proyecto | Alto | Realizar commits frecuentes y mantener los cambios sincronizados con GitHub. |
| Errores durante la implementación de TDD | Medio | Respetar las fases Red-Green-Refactor y verificar cada ejecución. |

**Conclusión del plan:**

Este plan permitirá organizar las pruebas de BiblioUni y comprobar que sus funcionalidades principales respondan correctamente. Mediante las pruebas unitarias, de integración y API se busca identificar errores, mejorar la confiabilidad del sistema y garantizar que las reglas de negocio se cumplan antes de considerar finalizada esta etapa del proyecto.
