Prueba Técnica SETI

Este proyecto implementa una API REST en Spring Boot 3 + Java 17 que recibe pedidos en formato JSON, los transforma a XML, los envía a un servicio SOAP mock, y convierte la respuesta SOAP nuevamente a JSON.
Se cumple exactamente con los requerimientos solicitados en la prueba técnica. 

-Objetivo
Exponer una API REST con mensajería JSON que:
Reciba pedidos en JSON.
Transforme el JSON a XML según tabla de mapeo.
Consuma un servicio SOAP externo.
Interprete la respuesta XML del SOAP.
Retorne la información transformada a JSON.

-Tecnologías utilizadas
Java 17+ (compatible con Java 21)
Spring Boot 3.3.x
Jackson Dataformat XML
Lombok
Maven
Docker
SoapUI (para pruebas SOAP)
