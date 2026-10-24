# Evaluación de Características de Calidad ISO/IEC 25010 - BiblioUni

A continuación se evalúan las 8 características del modelo de calidad del producto de software según la norma **ISO/IEC 25010** aplicadas al sistema BiblioUni.

## 1. Tabla de Evaluación de Calidad

| Característica ISO/IEC 25010 | Relevancia | Justificación para BiblioUni | Ejemplo de Medición |
| :--- | :--- | :--- | :--- |
| **1. Adecuación Funcional** | **Alta** | El sistema debe cumplir estrictamente con los procesos bibliotecarios esenciales: registro de libros, gestión de usuarios, préstamos y devoluciones. | Porcentaje de casos de prueba funcionales aprobados exitosamente frente a los requisitos totales. |
| **2. Eficiencia de Desempeño** | **Media** | Los usuarios esperan respuestas rápidas al consultar el catálogo, aunque el volumen concurrente inicial sea moderado. | Tiempo de respuesta promedio de la API REST al consultar el catálogo de libros (ej. < 500 ms). |
| **3. Compatibilidad** | **Media** | La API REST y la interfaz deben interoperar correctamente con diferentes clientes HTTP y navegadores web modernos. | Verificación de que las respuestas JSON sean consumidas correctamente por diferentes navegadores o herramientas (Postman). |
| **4. Usabilidad** | **Alta** | BiblioUni debe ser intuitivo tanto para estudiantes como para bibliotecarios para evitar errores operativos en los préstamos. | Tasa de éxito de los usuarios al completar el flujo de un préstamo en menos de 3 clics o pasos. |
| **5. Fiabilidad (Confiabilidad)** | **Alta** | El sistema debe manejar fallos de manera robusta (ej. intentar prestar un libro ya agotado) sin corromper la base de datos. | Tasa de fallos o excepciones no controladas durante operaciones simultáneas de préstamos. |
| **6. Seguridad** | **Alta** | Es fundamental proteger las credenciales de los usuarios, controlar los roles (estudiante vs. bibliotecario) y evitar accesos no autorizados a la API. | Número de vulnerabilidades detectadas en los controles de autenticación y autorización de los endpoints. |
| **7. Mantenibilidad** | **Alta** | Al ser un proyecto modular (servicios, controladores, repositorios), el código debe ser fácil de modificar, probar y escalar. | Cobertura de código mediante pruebas unitarias (JUnit) y bajo acoplamiento entre clases. |
| **8. Portabilidad** | **Baja** | El despliegue inicial se realiza en un entorno controlado (local / contenedor Docker), por lo que la migración multiplataforma no es prioritaria en esta fase. | Facilidad para levantar el proyecto en un contenedor Docker sin dependencias manuales del sistema operativo. |

---

## 2. Las 3 Características Más Críticas y Cómo se Abordarán

1. **Adecuación Funcional:** Se abordará mediante **pruebas funcionales y de API**, validando exhaustivamente que las reglas de negocio de los préstamos, multas y disponibilidad de libros se cumplan sin excepciones.
2. **Fiabilidad:** Se abordará mediante **pruebas unitarias e de integración** robustas, aplicando "caminos tristes" para comprobar que el sistema reacciona de forma controlada ante datos inválidos o recursos inexistentes.
3. **Seguridad:** Se abordará mediante validación de entradas en los controladores REST y pruebas de control de acceso para garantizar que solo usuarios autorizados ejecuten operaciones administrativas o de préstamo.