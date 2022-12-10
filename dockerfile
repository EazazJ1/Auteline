FROM maven:3.8.3-openjdk-17 as maven

COPY ./pom.xml ./pom.xml

COPY ./src ./src

RUN mvn dependency:go-offline -B

RUN mvn package

FROM openjdk:17-jdk-slim

WORKDIR /Auteline-DatabaseConfig

COPY --from=maven target/auteline-develop-1.0-SNAPSHOT.jar ./auteline-develop-1.0-SNAPSHOT.jar

# CMD ["java", "-jar", "auteline-develop-1.0-SNAPSHOT.jar", "MainApp.ATMTest"]

CMD "java -jar auteline-develop-1.0-SNAPSHOT.jar"