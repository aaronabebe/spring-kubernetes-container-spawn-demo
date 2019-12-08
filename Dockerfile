FROM openjdk:13-alpine
VOLUME /tmp
ADD /target/kubernetes-spawn-demo-*.jar app.jar
ENV SPRING_PROFILE "local"
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=${SPRING_PROFILE}","-jar","/app.jar"]