# HotelUserRatingSystem

A secure backend microservices-based hotel rating system built using Spring Boot.  
The system manages users, hotels, and ratings using distributed microservices architecture with secure JWT-based authentication and API Gateway routing.

---

## Tech Stack

### Backend Framework
- Java
- Spring Boot

### Security
- Spring Security
- JWT Authentication

### Microservices Architecture
- Spring Cloud Gateway (API Gateway)
- Eureka Server (Service Discovery)
- Spring Config Server
- OpenFeign Client

### Databases (Polyglot Persistence)
- MySQL (UserService)
- MongoDB (RatingService)
- PostgreSQL (HotelService)

### ORM / Data Access
- Spring Data JPA
- Hibernate
- Spring Data MongoDB

### Fault Tolerance
- Resilience4j Circuit Breaker

### Build Tool
- Maven

### Development Tools
- IntelliJ IDEA
- Postman
- GitHub
- MySQL Workbench
- MongoDB Compass
- pgAdmin

---

## Microservices

- UserService
- HotelService
- RatingService
- ApiGateway
- ConfigServer
- ServiceRegistry

---

## Features

- User Login with JWT Authentication
- Token Validation using API Gateway
- Fetch User Details
- Fetch Hotel Details
- Fetch Ratings
- Centralized Configuration Management
- Service Discovery using Eureka
- Circuit Breaker Fallback Support
- Inter-Service Communication using OpenFeign
- Distributed Database Architecture

---

## Project Architecture

Client Request  
↓  
API Gateway  
↓  
JWT Validation  
↓  
UserService  
↓  
RatingService  
↓  
HotelService  
↓  
Response Returned

---

## Configuration Management

Centralized configuration is managed using Spring Cloud Config Server.

Configuration files stored in GitHub Config Repository:

- application.yml (Common configuration)
- USERSERVICE.yml
- HOTELSERVICE.yml
- RATINGSERVICE.yml
- APIGATEWAY.yml

ConfigServer fetches these files and provides config to all services at runtime.

---

## API Endpoints

### Authentication
- POST `/auth/login`

### Users
- GET `/users/{userId}`

### Hotels
- GET `/hotels/{hotelId}`

### Ratings
- GET `/ratings`
- POST `/ratings`

---

## Security

JWT-based authentication is implemented.

Protected APIs require:

Authorization: Bearer `<token>`

API Gateway validates every request before forwarding.

---

## Database Architecture

### UserService → MySQL
### RatingService → MongoDB
### HotelService → PostgreSQL

---

## How to Run

1. ConfigServer  
2. ServiceRegistry  
3. ApiGateway  
4. UserService  
5. HotelService  
6. RatingService  

---

## Tools Used

- Postman
- Eureka Dashboard
- Database Tools

---

## Author
**Ankit Chilami**
