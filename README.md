Prueba Técnica SETI

Este proyecto implementa una API REST desarrollada en Spring Boot 3 con Java 17 que recibe pedidos en formato JSON, los transforma a XML, los envía a un servicio SOAP simulado y posteriormente convierte la respuesta SOAP nuevamente a JSON.
El desarrollo cumple con los requerimientos funcionales establecidos en la prueba técnica, incluyendo la transformación de datos y la correcta exposición del servicio mediante contenedores Docker.

-Objetivo
Exponer una API REST con mensajería JSON que permita:
Recibir pedidos en formato JSON.
Transformar la solicitud JSON a XML según la tabla de mapeo proporcionada.
Consumir un servicio SOAP (simulado debido a indisponibilidad del endpoint real).
Interpretar la respuesta XML del servicio SOAP.
Retornar la respuesta transformada en formato JSON al consumidor.
Nota: El endpoint SOAP externo suministrado en la prueba no se encontraba disponible al momento de la implementación, por lo cual se simuló la respuesta para garantizar el correcto funcionamiento del flujo completo solicitado.

-Tecnologías utilizadas
Java 17 (compatible con Java 21)
Spring Boot 3.3.x
Jackson Dataformat XML
Lombok
Maven
Docker
SoapUI (pruebas de servicios SOAP)

-Funcionalidad principal
El cliente envía un pedido en formato JSON.
La API transforma el JSON al XML requerido por el servicio SOAP.
Se simula la respuesta del servicio SOAP.
La respuesta XML se convierte nuevamente a JSON.
Se retorna el resultado final al cliente.
