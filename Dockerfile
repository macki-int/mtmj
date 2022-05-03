FROM openjdk:17-alpine

#ARG JAR_FILER=target/*.jar
#COPY ${JAR_FILE} wims.jar
COPY target/mtms.jar mtms.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "wims.jar"]

#CMD ["java", "-jar", "/mtms.jar"]
