# Technical Test Readme 

### API First

* API definition according to business need: price and application dates of the product 
* API file: doc/api-definition.yml

### Design decisions

**Microservice in layers**
* Controller: First point access
* Transformer: Responsible for transformations
* Service: Business logic
* Dao: Persistence control
* Repository: Persistence layer

**Table prices add fields**
* Id for use jpa with identifier
* Date field (start_date, end_date) in database how to numbers

**Test of charge**

The load test allowed us to determine that by storing the date fields, the queries improved in response times.
Test result files
* doc/gatling-simulation-withdates
* doc/gatling-simulation-withdatenumber

The separation in layers made it easy for the change to only be made at the persistence and transformers level without affecting the other layers

### Build and running
* Build

mvn clean package

* Runing

java -jar target/ms-prices-0.0.1-SNAPSHOT.jar

### H2 Console
* URL: http://localhost:8080/h2-console
* User: sa
* Password: password 

### Swagger
* URL: http://localhost:8080/swagger-ui/index.html?url=/v3/api-docs&validatorUrl=#/

### Test Example
- Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
curl -X GET "http://localhost:8080/price?brand=1&date=2020-06-14%2010%3A00&product=35455" -H "accept: application/json"

- Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
curl -X GET "http://localhost:8080/price?brand=1&date=2020-06-14%2016%3A00&product=35455" -H "accept: application/json"

- Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
curl -X GET "http://localhost:8080/price?brand=1&date=2020-06-14%2021%3A00&product=35455" -H "accept: application/json"

- Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
curl -X GET "http://localhost:8080/price?brand=1&date=2020-06-15%2010%3A00&product=35455" -H "accept: application/json"

- Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
curl -X GET "http://localhost:8080/price?brand=1&date=2020-06-16%2021%3A00&product=35455" -H "accept: application/json"

### PostmanFile
doc/PricesTest.postman_collection.json

### Container Build
For container build execute

docker build -t my_docker_hub_username/technical_test:1_0_0 .

For running

docker run -p 8080:8080 --env SPRING_PROFILES_ACTIVE=docker my_docker_hub_username/technical_test:1_0_0
