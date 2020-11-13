# Running the service
1. Create the jar using maven: `mvn clean install` (Note: We are creating a fat jar with embedded Tomcat)
2. Run Spring boot as a Java application: `java -jar target/health-status-indicator-0.0.1-SNAPSHOT.jar`

# Endpoints
Webpage: http://localhost:8080
Rest endpoints:
 - http://localhost:8080/health/status
 - http://localhost:8080/health/status/{name}