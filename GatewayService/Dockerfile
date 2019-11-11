FROM java:8-jre
WORKDIR usr/src
ENV MYSQL_USER=approot
ENV MYSQL_PASSWORD=root123
ENV MYSQL_ROOT_PASSWORD=root123
ENV MYSQL_URL=jdbc:mysql://localhost:3306/UserDb
ADD ./target/gatewayservice-1.0.jar /usr/src/gatewayservice-1.0.jar
ENTRYPOINT ["java","-jar","gatewayservice-1.0.jar"]