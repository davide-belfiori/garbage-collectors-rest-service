# garbage-collectors-rest-service

### Run Server locally

You can run it from Maven directly using the Spring Boot Maven plugin :

```sh
git clone https://github.com/davide-belfiori/garbage-collectors-rest-server.git
cd ./garbage-collectors-rest-server
mvn spring-boot:run
```
Server listens on port 8080

### Database configuration

By default this appliaction uses an in-memory database which gets populated at startup with data.
You can switch to a different one by setting connection parameters inside ```application-localDB.properties```, and changing
the active profile to ```spring.profiles.active=localDB``` inside ```application.properties```
