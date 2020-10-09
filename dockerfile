FROM arm32v7/openjdk
MAINTAINER Sylvain SICARD <sylvain@mssd.fr>

ENV DB_HOST=192.168.1.100
ENV DB_PORT=32768
ENV DB_NAME=homebrewery
ENV DB_USER=homebrewery
ENV DB_PASSWORD=homebrewery

ENV INGRESS_ENDPOINT=http://192.168.1.100:8888/
ENV APP_CODE=fr.mssd.homebrewery

ADD target/lib /usr/share/home-brewery/lib

ARG JAR_FILE

ADD target/${JAR_FILE} /usr/share/home-brewery/service.jar
 
EXPOSE 8889
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/home-brewery/service.jar"]