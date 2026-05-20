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
- User-Hotel-Rating Mapping
- Secure REST APIs
- Service Discovery using Eureka
- Centralized Configuration Management
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

API Gateway validates every request token before forwarding to microservices.

---

## Database Architecture

### UserService
- MySQL

Stores:
- User Details
- Credentials

### RatingService
- MongoDB

Stores:
- Ratings
- Reviews
- User-Hotel Mapping

### HotelService
- PostgreSQL

Stores:
- Hotel Details
- Hotel Information

---

## How to Run

Start services in this order:

1. ConfigServer
2. ServiceRegistry
3. ApiGateway
4. UserService
5. HotelService
6. RatingService

---

## Tools Used for Testing

- Postman
- Eureka Dashboard
- Database Management Tools

---

## Author
**Ankit Chilami**
