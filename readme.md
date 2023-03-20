### SpringBoot Employee REST API
This is a SpringBoot project that implements a RESTful API for managing employees. 
The API includes a single endpoint secured with Spring Basic Authentication and uses the org.apache.logging.log4j logging library for logging. 
The project also includes JUnit test cases for testing the functionality of the REST API and Spring Actuator.


### Installation
1. Clone the repository using the following command:
	`git clone https://github.com/<username>/springboot-employee-rest-api.git`
	
2. Navigate to the project directory
	
3. Build the project using Maven:
	`mvn clean package`
	
4. Run the project using Maven:
	`mvn spring-boot:run`

5. Access the REST API at http://localhost:8081/api
	You will need to provide valid credentials to access the endpoint. 
	The default credentials are:
		Username: praveen
		Password: praveen
	To change the username and password, modify the application.properties file.
	
### Logging
This project uses the org.apache.logging.log4j logging library for logging. 
The log file is located at logs/app.log. The log level is set to INFO by default. 
You can change the log level in the src/main/resources/log4j2.properties configuration file.

### Testing
This project includes JUnit test cases for testing the functionality of the REST API. You can run the test cases using Maven:
	`mvn test`
	
## API Documentation
The API documentation is available in the Swagger UI at http://localhost:8081/api/swagger-ui.html. 
You can use this documentation to explore the API endpoints and test them out.

## Spring Actuator
The project includes Spring Actuator, which provides endpoints for monitoring and managing the application. 
The following endpoints are available:

| Endpoint             | Description                  | 
| ------------------   | ---------------------------- |
| `/actuator/health`   | Check the health of the app  | 
| `/actuator/info`     | Get the app version and name | 
| `/actuator/metrics`  | Get metrics about the app    | 


### Other Enhancement possibilities
Would create a docker container. 
Create multiple environments property configuration. 
Oauth with jwt authentication. 
Would create two microservices, one for the employee-service and one for the authentication-service.
Will create external configuration for the environment variables for production ready. 


#### My experience in Java

Please let us know more about your Java experience in a few sentences. For example:

	3 years of experience in developing Enterprise Applications using Java, Object Oriented Methodologies, Web services like REST for software development.
	Good knowledge in developing applications using core java concepts and experienced in working with Core Java SE 8 features like Lambda functions, Stream API.
	Good Hands-on experience in various spring framework modules like Spring Boot, Spring Security, Spring Data, Spring IOC.
