FROM openjdk:17


COPY target/TaskController-0.0.1-SNAPSHOT.jar TaskController-0.0.1-SNAPSHOT.jar

# Defina o comando padrão a ser executado quando o contêiner for iniciado
CMD ["java", "-jar", "-Dserver.port=9000", "TaskController-0.0.1-SNAPSHOT.jar"]