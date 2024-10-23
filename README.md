# JobCompanyReviewApp

JobCompanyReviewApp is a Spring Boot-based application that allows to review and rate companies with jobs. The application uses a PostgreSQL database for storing company, job and review data. This project can be run using Docker and Docker Compose for seamless setup and deployment.

## Features
- List, create, update, and delete company job reviews.
- Rating system for companies.
- REST API integration.
- PostgreSQL database for persistent data storage.
- PgAdmin for easy database management.

## Prerequisites
Before you begin, ensure you have the following installed on your local machine:
- **Docker**
- **Docker Compose**
- **Java 17 (or later)**
- **Maven**

## Getting Started

### 1. Clone the Repository
Start by cloning the repository to your local machine:
```bash
git clone https://github.com/veliataseven/JobCompanyReviewApp.git
cd JobCompanyReviewApp
```

### 2. Build the Docker Image
Build the Spring Boot application Docker image from the root directory:
```bash
./mvnw spring-boot:build-image "-Dspring-boot.build-image.imageName=jobappimage"
```
### 3. Run Docker Compose
Start the services (Spring Boot App, PostgreSQL, PgAdmin) by running from the root directory:
```bash
docker-compose up
```

### 4. Access Services
* Spring Boot App: http://localhost:8080
* PgAdmin: http://localhost:5050
  * Default email: pgadmin4@pgadmin.org 
  * Default password: admin

## Configuration
### Database

The database configuration is managed through environment variables in the _docker-compose.yaml_ file:
```yaml
SPRING_DATASOURCE_URL: jdbc:postgresql://postgres_container:5432/postgres
SPRING_DATASOURCE_USERNAME: user
SPRING_DATASOURCE_PASSWORD: pass
```

You can change these values if necessary to match your local environment or deployment preferences.

## Project Structure
**src/main/java:** Contains the Java code for the Spring Boot application.

**src/main/resources:** Configuration files, including application.properties for Spring Boot.

**docker-compose.yaml:** Defines the services for running the Spring Boot app, PostgreSQL, and PgAdmin in containers.

**Dockerfile:** Used to build the Docker image for the Spring Boot application.

## Technologies Used

* Java 17
* Spring Boot
* PostgreSQL
* Docker & Docker Compose
* PgAdmin
