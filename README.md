# Prueba Técnica SETI

---

## Descripción del Proyecto

Este proyecto implementa una API REST desarrollada en Spring Boot 3 con Java 17 que recibe pedidos en formato JSON, los transforma a XML, los envía a un servicio SOAP simulado y posteriormente convierte la respuesta SOAP nuevamente a JSON.

La solución cumple con los requerimientos funcionales definidos en la prueba técnica, garantizando la correcta transformación de datos, integración con servicios SOAP y despliegue mediante contenedores Docker.

---

## Objetivo

Exponer una API REST con mensajería JSON que permita:

* Recibir pedidos en formato JSON.
* Transformar la solicitud JSON a XML según la tabla de mapeo proporcionada.
* Consumir un servicio SOAP (simulado debido a indisponibilidad del endpoint real).
* Interpretar la respuesta XML del servicio SOAP.
* Retornar la respuesta transformada en formato JSON al consumidor.

> Nota: El endpoint SOAP externo suministrado en la prueba no se encontraba disponible al momento de la implementación, por lo cual se simuló la respuesta para garantizar el correcto funcionamiento del flujo completo solicitado.

---

## Tecnologías Utilizadas

* Java 17 (compatible con Java 21)
* Spring Boot 3.3.x
* Jackson Dataformat XML
* Lombok
* Maven
* Docker
* SoapUI (pruebas de servicios SOAP)

---

## Flujo Funcional

1. El cliente envía un pedido en formato JSON.
2. La API transforma el JSON al formato XML requerido por el servicio SOAP.
3. Se simula la respuesta del servicio SOAP.
4. La respuesta XML se convierte nuevamente a JSON.
5. Se retorna el resultado final al cliente.

---

## Despliegue con Docker

### Pasos para levantar el contenedor

Desde la raíz del proyecto ejecutar:

```bash
mvn clean package
docker build -t acme-api .
docker run -d -p 8080:8080 --name acme-container acme-api
```

La aplicación quedará disponible en:

```
http://localhost:8080
```

---

### Verificación del contenedor

Comprobar que el contenedor está activo:

```bash
docker ps
```

Visualizar los logs del contenedor:

```bash
docker logs -f acme-container
```

---

## Observaciones

* Se mantuvo una arquitectura clara y desacoplada para facilitar la mantenibilidad del sistema.
* Se utilizó simulación del servicio SOAP para no afectar la validación del flujo funcional exigido.
* La solución se encuentra lista para integrarse con el endpoint real una vez esté disponible.

---


