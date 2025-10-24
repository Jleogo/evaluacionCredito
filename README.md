# evaluacionCredito
Proyecto de valuacion de riesgo crediticio con SpringBoot
Motor de evaluación de riesgo crediticio para empresas, desarrollado en Java con Spring Boot, H2 y JPA.  
Permite evaluar automáticamente el nivel de riesgo de una empresa basado en múltiples reglas de negocio.
# Descripcion
Este proyecto implementa un motor modular y extensible para evaluar riesgo crediticio de empresas en América Latina.  
Aplica reglas como deuda vencida, monto solicitado vs ventas, historial de pagos, demandas legales etc.
# Tecnologias
- Java 21+
- Spring Boot 3.5
- Spring Data JPA
- H2 Database
- Maven
- Postman para pruebas
# Reglas implementadas
- Deuda Activa: Si la empresa tiene deuda vencida mayor 90 días se Rechaza la solicitud  
- Alta Solicitud vs Ventas: Monto solicitado mayor 8x ventas promedio riesgo ALTO  
- Empresa Nueva: Empresa con menor a 18 meses riesgo MEDIO  
- Demanda Legal Abierta: Juicio mercantil en curso riesgo ALTO  
- Historial Excelente: Últimos 12 pagos a tiempo baja un nivel de riesgo  
- Producto Estricto: ARRENDAMIENTO_FINANCIERO sube un nivel de riesgo
# Cómo ejecutar
- Crear Directorio de forma local
- Acceder al directorio local
- Clonar el repositorio dentro el directorio local git clone https://github.com/Jleogo/evaluacionCredito.git
- Construir el proyecto con el comando comando mvn clean install
- Ejecutar el comando mvn spring-boot:run
# End Point 
POST http://localhost:8080/api/risk/evaluar
Ejemplo de request : {
    "empresaId": "5",
    "montoSolicitado": 100000,
    "productoFinanciero": "LINEA_OPERATIVA",
    "fechaSolicitud": "2025-10-23"
}
Ejemplo de respuesta: {
    "nivelRiesgo": "BAJO",
    "reglasEvaluadas": [
        "Deuda Activa > 90 días",
        "Monto solicitado es mayor a  8x ventas",
        "Empresa nueva < 18 meses",
        "Demanda legal abierta",
        "Historial excelente",
        "Producto estricto"
    ],
    "motivoFinal": "Evaluación basada en reglas configuradas"
}
# Supuestos y Limitaciones
- Las fuentes de información (ventas, pasivos, juicios) están simuladas mediante interfaces y datos en H2.
- El motor permite agregar más reglas y proveedores sin modificar la lógica central.
- Validaciones básicas de request @NotNull, @DecimalMin están habilitadas.
- La persistencia actual es en memoria H2, por lo que los datos se reinician en cada ejecución.




