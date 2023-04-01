# Customer Account & Transactions API

This is a Spring Boot application that implements a REST API for managing customer accounts and transactions.

## Prerequisites

- Java 11
- Maven

## Running the Application

1. Clone the repository and navigate to the project root directory.

    git clone git@github.com:nurbulamanyc/pismo.git
    
    
<br>
2. Compile and package the application using Maven.

    mvn clean package
    
<br>
3. Run the application.

    java -jar target/pismo-0.0.1-SNAPSHOT.jar
    
The application will start on port 8080.

## API Endpoints

The following API endpoints are available:

- Create Account: `POST /accounts`
- Retrieve Account: `GET /accounts/:accountId`
- Create Transaction: `POST /transactions`

## Running Tests

You can use `curl` to test the API endpoints. Ensure that the application is running before executing these commands.

1. Create an account:

```bash
curl -X POST -H "Content-Type: application/json" -d '{"document_number": "12345678900"}' http://localhost:8080/accounts
```

<br>2. Retrieve an account (replace :accountId with the actual account ID):
```bash
curl -X GET http://localhost:8080/accounts/:accountId
```


<br>3. Create a transaction:
```bash
curl -X POST -H "Content-Type: application/json" -d '{"accountId": 1, "operationTypeId": 4, "amount": 123.45}' http://localhost:8080/transactions

```
