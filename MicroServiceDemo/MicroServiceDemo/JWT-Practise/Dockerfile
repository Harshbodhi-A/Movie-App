FROM openjdk
WORKDIR usr/src
ENV MONGO_URI=mongodb://localhost:27017/myTestDB
ADD ./target/JWT-Practise-0.0.1-SNAPSHOT.jar /usr/src/JWT-Practise-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","JWT-Practise-0.0.1-SNAPSHOT.jar"]