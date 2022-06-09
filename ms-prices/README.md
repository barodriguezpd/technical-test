# Technical Test Readme 

### API First

* API definition according to business need: price and application dates of the product 

### Design decisions

1. **Microservice in layers**
* Controller: First point access
* Transformer: Responsible for transformations
* Service: Business logic
* Dao: Persistence control
* Repository: Persistence layer

2. Table prices add fields
* Id for use jpa with identifier

### H2 Console
* URL: http://localhost:8080/h2-console
* User: sa
* Password: password 

