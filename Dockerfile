FROM alpine
RUN apk update
RUN apk fetch openjdk11
RUN apk add openjdk11
COPY target/transactions-0.0.1-SNAPSHOT.jar  transactions-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","transactions-0.0.1-SNAPSHOT.jar"]