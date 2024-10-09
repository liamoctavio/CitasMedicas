FROM eclipse-temurin:22-jdk AS buildstage

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .
COPY src /app/src
COPY Wallet_BD_Prueba /app/wallet

ENV TNS_ADMIN=/app/wallet

RUN mvn clean package

FROM eclipse-temurin:22-jdk

COPY  --from=buildstage /app/target/cit-0.1.jar /app/citas.jar
COPY Wallet_BD_Prueba /app/wallet

ENTRYPOINT [ "java", "-jar","/app/citas.jar" ]