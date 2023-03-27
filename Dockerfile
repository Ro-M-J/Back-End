
FROM amazoncorreto:17-alpine-jdk
MAINTAINER  RosaM
COPY target/mgb-0.0.1-SNAPSHOT.jar protafolio-app.jar
ENTRYPOINT ["java","-jar","/protafolio-app.jar"]