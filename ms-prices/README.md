# Technical Test Readme 

### API First

* API definition according to business need: price and application dates of the product 
* APi file: doc/api-definition.yml

### Design decisions

**Microservice in layers**
* Controller: First point access
* Transformer: Responsible for transformations
* Service: Business logic
* Dao: Persistence control
* Repository: Persistence layer

**Table prices add fields**
* Id for use jpa with identifier

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
