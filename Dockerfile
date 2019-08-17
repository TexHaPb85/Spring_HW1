FROM alpine

RUN apk add --no-cache \
    openjdk11 --repository=http://dl-cdn.alpinelinux.org/alpine/edge/community \
    maven \
    curl

VOLUME /home/hw13app

WORKDIR /home/hw13app

COPY ./ /home/hw13app

ARG JAR_FILE=target\spring_hw1-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} test.jar

EXPOSE 8081

CMD java -jar library.jar