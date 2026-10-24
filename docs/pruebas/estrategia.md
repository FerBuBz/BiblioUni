# Estrategia de Pruebas - BiblioUni

A continuación se detalla la estrategia de pruebas formal para el sistema **BiblioUni**, alineada con los requerimientos del proyecto y los fundamentos de calidad de software.

##  Cuestionario de la Estrategia de Pruebas

### 1. ¿Qué se va a probar?
Se probarán los componentes principales del sistema BiblioUni estructurados en capas:
* **Modelo (Entidades y Base de Datos):** Validación de la persistencia, restricciones y mapeo de datos para libros, usuarios, préstamos y multas.
* **Servicios (Lógica de Negocio):** Componentes como `PrestamoService`, `MaterialService` y `MultaService`, validando reglas de negocio, límites de préstamos y cálculos de penalizaciones.
* **Controladores REST (API):** Endpoints expuestos para la consulta de catálogos y gestión de peticiones HTTP.

### 2. ¿Qué tipos de pruebas aplican y por qué?
* **Pruebas Unitarias:** Aplican para verificar de forma aislada la lógica de los servicios y métodos individuales mediante JUnit 5.
* **Pruebas de Integración:** Aplican para asegurar que la comunicación entre los servicios, controladores y la base de datos funcione correctamente sin fricciones.
* **Pruebas Funcionales y de API:** Aplican para comprobar que los endpoints REST respondan adecuadamente a las solicitudes de los clientes y cumplan con los casos de uso esperados.
* **Pruebas No Funcionales:** Aplican de forma preliminar para evaluar aspectos de seguridad (control de roles de usuario) y eficiencia de desempeño en las consultas.

### 3. ¿Qué niveles de pruebas se ejecutarán?
* **Nivel Unitario:** Pruebas aisladas para validar funciones específicas dentro de los servicios.
* **Nivel de Integración:** Pruebas de comunicación entre los controladores REST y los servicios del sistema.
* **Nivel de Sistema:** Validación de flujos completos de extremo a extremo dentro de la arquitectura de Spring Boot.

### 4. ¿Qué no se probará y por qué?
* **Pruebas de Carga masiva o Estrés extremo:** No se ejecutarán en esta fase inicial debido a que el volumen concurrente estimado para el alcance académico actual es moderado y controlado.
* **Pruebas de seguridad avanzada (Penetration Testing):** Se omitirán auditorías de seguridad externas y avanzadas por exceder el enfoque funcional y básico de validación de roles de la práctica.

##  Componentes del Gancho Innovador
Los componentes correspondientes al gancho innovador (como el servicio de recomendación inteligente de libros basados en lecturas previas y el sistema de alertas automatizadas de devolución) se probarán mediante:
* **Pruebas unitarias de algoritmos de sugerencia:** Validando que las entradas del historial devuelvan listas de recomendaciones coherentes.
* **Pruebas de integración de la API de notificaciones:** Comprobando que el sistema dispare las alertas automáticas en los plazos establecidos previos al vencimiento del préstamo.