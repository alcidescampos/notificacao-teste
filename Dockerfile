FROM registry.cnj.jus.br/ia/docker/ubuntu-ia/oracle-jdk/buildah:22.04

 
COPY target/quarkus-app /opt/app

EXPOSE 8080

WORKDIR /opt/app

ENTRYPOINT java $JAVA_OPTS -Dquarkus.http.port=8080 $APP_OPTS -jar quarkus-run.jar
