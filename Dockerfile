FROM openjdk:17-alpine

#ARG JAR_FILER=target/*.jar
#COPY ${JAR_FILE} mtms.jar
COPY target/mtms.jar mtms.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "mtms.jar"]

#CMD ["java", "-jar", "/mtms.jar"]
