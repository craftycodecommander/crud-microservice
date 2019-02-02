# CRUD Microservice #

### About ###

This project contains the code to create a microservice using the 
[Spring Boot](http://spring.io/projects/spring-boot) framewowk. The code
also uses [Swagger](https://swagger.io/) by SMARTBEAR to document the service end points
and allow simple browser testing. Four endpoints exist:

* Create
* Read
* Update
* Delete

### Requirements ###

#### Maven ####
Make sure you have the latest version of [Maven](https://maven.apache.org/) on your classpath.

#### IDE ####
I would recommend either [Eclipse](https://www.eclipse.org/downloads/) or [IntelliJ](https://www.jetbrains.com/idea/?fromMenu).


### Building ###
From within the project directory execute
```bash
mvn clean install
```

### Usage ###

#### Pull the code ####
```bash
git clone https://github.com/craftycodecommander/crud-microservice.git
```

#### Running in an IDE ####
You can import the checked out project into an IDE of your choice. Once imported run the main class (com.companyname.microservice.ServiceApplication)

#### Running via the Maven plugin ####
```bash
mvn spring-boot:run
```

#### Running the packaged JAR ####
```bash
java -jar target/crud-microservice-0.0.1.jar
```


Once running, the Swagger description of the microservice can be accessed on [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
