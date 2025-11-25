FROM eclipse-temurin:17-jre-alpine
ARG JAR_FILE=target/acme-pedidos-clean-architecture-0.0.1-SNAPSHOT.jar
WORKDIR /app
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
