Here is an updated README incorporating the PostgreSQL and pgAdmin Docker setup from the screenshot.

---

# Job Company API

A comprehensive RESTful API for managing job listings, companies, applications, and reviews. Built with Java and Spring Boot, this API serves as a back-end solution for job management systems.

## Table of Contents

1. [Overview](#overview)
2. [Features](#features)
3. [Technology Stack](#technology-stack)
4. [Getting Started](#getting-started)
5. [Configuration](#configuration)
6. [Database Setup](#database-setup)
7. [API Documentation](#api-documentation)
8. [Testing](#testing)
9. [Contributing](#contributing)
10. [License](#license)

## Overview

The Job Company API allows users to perform CRUD operations on job postings, companies, applications, and reviews. This API can be integrated with front-end applications or serve as a standalone service.

## Features

- **CRUD Operations**: Full support for creating, reading, updating, and deleting jobs, companies, applications, and reviews.
- **User Authentication**: Secure authentication for user sessions.
- **Pagination & Filtering**: Efficient data access with pagination and filtering.
- **Error Handling**: Structured error responses for various edge cases.

## Technology Stack

- **Java 11+**
- **Spring Boot** for API development
- **PostgreSQL** for database management
- **Docker** for containerization
- **Maven** for dependency management
- **JUnit** for testing

## Getting Started

### Prerequisites

Ensure you have the following installed:
- Java 11 or higher
- Maven 3.6 or later
- Docker

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/malise5/job-company-Api.git
   cd job-company-Api
   ```

2. Set up PostgreSQL database using Docker:
   ```bash
   docker run -d \
     --name postgres_container \
     -e POSTGRES_USER=embarkx \
     -e POSTGRES_PASSWORD=embarkx \
     -e PGDATA=/data/postgres \
     -v postgres:/data/postgres \
     -p 5432:5432 \
     --network postgres \
     --restart unless-stopped \
     postgres
   ```

3. Set up pgAdmin for managing PostgreSQL:
   ```bash
   docker run -d \
     --name pgadmin_container \
     -e PGADMIN_DEFAULT_EMAIL=pgadmin4@pgadmin.org \
     -e PGADMIN_DEFAULT_PASSWORD=admin \
     -e PGADMIN_CONFIG_SERVER_MODE=False \
     -v pgadmin:/var/lib/pgadmin \
     -p 5050:80 \
     --network postgres \
     --restart unless-stopped \
     dpage/pgadmin4
   ```

4. Install dependencies:
   ```bash
   mvn install
   ```

5. Build the Docker image:
   ```bash
   ./mvnw spring-boot:build-image -D"spring-boot.build-image.imageName=malise/jobappimage"
   ```

6. Configure database settings in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://postgres_container:5432/job_company_db
   spring.datasource.username=embarkx
   spring.datasource.password=embarkx
   ```

7. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Configuration

You can further configure the application by editing `application.properties`:
- **Server Port**: Change from the default `8080` by modifying `server.port`.
- **Database Settings**: Customize database connection parameters if needed.

## Database Setup

The application uses PostgreSQL as its database. After starting the PostgreSQL and pgAdmin containers:
- Access pgAdmin at `http://localhost:5050`.
- Login with the email and password you configured.
- Add a new server in pgAdmin, setting `postgres_container` as the hostname, and create a database named `job_company_db`.

## API Documentation

API documentation is available via Swagger once the server is running:

- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8080/v3/api-docs`

### Endpoints

| Method | Endpoint                   | Description                   |
|--------|-----------------------------|-------------------------------|
| GET    | `/api/jobs`                 | Retrieve all job listings     |
| POST   | `/api/jobs`                 | Create a new job              |
| PUT    | `/api/jobs/{id}`            | Update a job                  |
| DELETE | `/api/jobs/{id}`            | Delete a job                  |
| GET    | `/api/companies`            | Retrieve all companies        |
| POST   | `/api/companies`            | Register a new company        |
| GET    | `/api/applications`         | Retrieve all applications     |
| POST   | `/api/applications`         | Submit a new application      |
| GET    | `/api/reviews`              | Retrieve all reviews          |
| POST   | `/api/reviews`              | Submit a new review           |
| PUT    | `/api/reviews/{id}`         | Update a review               |
| DELETE | `/api/reviews/{id}`         | Delete a review               |

Refer to Swagger for additional query parameters and request/response formats.

## Testing

To run tests:
```bash
mvn test
```
The tests cover API functionality, validation, and error handling.

## Contributing

We welcome contributions! Here’s how to get started:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add feature'`).
4. Push to your branch (`git push origin feature/your-feature`).
5. Submit a Pull Request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

