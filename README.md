Here’s the full README for your Job Company API, including the additional endpoint for reviews:

---

# Job Company API

A robust RESTful API designed to manage job listings, companies, applications, and reviews. Built with Java and Spring Boot, this API provides a structured approach to job posting, company data management, and application tracking.

## Table of Contents

1. [Overview](#overview)
2. [Features](#features)
3. [Technology Stack](#technology-stack)
4. [Getting Started](#getting-started)
5. [Configuration](#configuration)
6. [API Documentation](#api-documentation)
7. [Testing](#testing)
8. [Contributing](#contributing)
9. [License](#license)

## Overview

The Job Company API allows users to create, retrieve, update, and delete data related to job postings, companies, applications, and reviews. This API is ideal for integration with front-end applications or for use as a standalone back-end in job management systems.

## Features

- **CRUD Operations**: Full create, read, update, and delete support for jobs, companies, applications, and reviews.
- **User Authentication**: Secure authentication for user sessions.
- **Pagination & Filtering**: Efficient data access with paginated responses and filters.
- **Error Handling**: Clear, structured responses for errors.

## Technology Stack

- **Java 11+**
- **Spring Boot** for REST API development
- **MySQL** for data persistence
- **Maven** for dependency management
- **JUnit** for unit testing

## Getting Started

### Prerequisites

Ensure you have the following installed:
- Java 11 or later
- Maven 3.6 or later
- MySQL or a compatible SQL database

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/malise5/job-company-Api.git
   cd job-company-Api
   ```

2. Install dependencies:
   ```bash
   mvn install
   ```

3. Build the Docker image:
   ```bash
   ./mvnw spring-boot:build-image -D"spring-boot.build-image.imageName=malise/jobappimage"
   ```

4. Configure database settings in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/job_company_db
   spring.datasource.username=your_db_username
   spring.datasource.password=your_db_password
   ```

5. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Configuration

Additional configuration options are available in `application.properties`, including:
- **Server Port**: Change default port from `8080` by updating `server.port`.
- **Logging**: Customize logging levels and output.

## API Documentation

Once the server is running, API documentation is available at:
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
| GET    | `/api/reviews`              | Retrieve all reviews          |
| POST   | `/api/reviews`              | Submit a new review           |
| PUT    | `/api/reviews/{id}`         | Update a review               |
| DELETE | `/api/reviews/{id}`         | Delete a review               |

Refer to the Swagger UI for the full list and detailed documentation of each endpoint.

## Testing

To run tests:
```bash
mvn test
```
Tests cover basic functionality for all primary API operations, including validation and edge cases.

## Contributing

We welcome contributions! To contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add new feature'`).
4. Push to your branch (`git push origin feature/your-feature`).
5. Submit a Pull Request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Feel free to modify any part of the README as needed, and let me know if you need further adjustments or additions!