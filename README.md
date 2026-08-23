# Demo Spring Boot API

This project is a simple Spring Boot application that exposes sample REST APIs backed by in-memory dummy data.

## Project structure

- `src/main/java/com/sid/demo/controller` - REST controllers
- `src/main/java/com/sid/demo/model` - DTO/model classes
- `src/main/resources/application.properties` - application settings

## Prerequisites

- Java 21+
- Maven

## Run the application

```bash
./mvnw spring-boot:run
```

The app runs on:

```text
http://localhost:8080
```

## API endpoints

### Products

- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get product by ID
- `POST /api/products` - Create a new product

Example body for create product:

```json
{
  "name": "Keyboard",
  "category": "Accessories",
  "price": 59.99,
  "inStock": true
}
```

### Users

- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID

## Example responses

### GET /api/products

```json
[
  {
    "id": 1,
    "name": "Laptop",
    "category": "Electronics",
    "price": 999.99,
    "inStock": true
  }
]
```

### GET /api/users

```json
[
  {
    "id": 1,
    "name": "Alice Johnson",
    "email": "alice@example.com",
    "role": "Admin"
  }
]
```

## Testing

```bash
./mvnw test
```

## Postman collection

A ready-to-import Postman collection is available in:

```text
postman/demo-sample-api.postman_collection.json
```
