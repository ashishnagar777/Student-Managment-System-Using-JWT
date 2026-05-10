# 🎓 Student Management System with JWT Authentication

A secure, full-stack **Student Management System** built with **Spring Boot 3** and **JWT-based authentication**. The application provides a RESTful API backend with role-based access control, persistent data storage, and an interactive Swagger UI for easy API exploration.

---

## Table of Contents

- [What It Does](#what-it-does)
- [Tech Stack](#tech-stack)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Configuration](#configuration)
  - [Running the Application](#running-the-application)
- [API Usage](#api-usage)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [Maintainer](#maintainer)

---

## What It Does

This project is a backend web application for managing student records in an academic environment. It handles **user authentication via JWT tokens**, protecting all sensitive endpoints so only authorized users can create, update, or delete student data. Admins and other roles can be defined to scope access appropriately.

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.2.2 |
| Security | Spring Security + JWT (jjwt 0.11.5) |
| Persistence | Spring Data JPA / Hibernate |
| Database | MySQL / PostgreSQL |
| View Layer | Thymeleaf |
| API Docs | SpringDoc OpenAPI (Swagger UI) |
| Build Tool | Maven |
| Utilities | Lombok, Spring DevTools |

---

## Features

- **JWT Authentication** — Stateless token-based login; secured endpoints require a valid `Bearer` token in the `Authorization` header.
- **Role-Based Access Control** — Different user roles (e.g., Admin, Student) with scoped permissions enforced by Spring Security.
- **Student CRUD Operations** — Create, read, update, and delete student records via REST API.
- **Dual Database Support** — Compatible with both MySQL and PostgreSQL; switch via `application.properties`.
- **Swagger UI** — Built-in interactive API documentation at `/swagger-ui.html`.
- **Hot Reload** — Spring DevTools enabled for faster development iteration.

---

## Getting Started

### Prerequisites

- **Java 17+** — [Download here](https://adoptium.net/)
- **Maven 3.8+** — [Download here](https://maven.apache.org/download.cgi) *(or use the included `mvnw` wrapper)*
- **MySQL** or **PostgreSQL** — A running database instance

### Installation

```bash
# 1. Clone the repository
git clone https://github.com/ashishnagar777/Student-Managment-System-Using-JWT.git
cd Student-Managment-System-Using-JWT
```

### Configuration

Open `src/main/resources/application.properties` and update the database settings:

**For MySQL:**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```

**For PostgreSQL:**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/student_db
spring.datasource.username=your_pg_username
spring.datasource.password=your_pg_password
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
```

Also set your JWT secret key:
```properties
jwt.secret=your_super_secret_key_here
jwt.expiration=86400000
```

> **Note:** Create the database (e.g., `student_db`) before starting the app. Spring will auto-create the tables on first run with `ddl-auto=update`.

### Running the Application

```bash
# Using the Maven wrapper (recommended)
./mvnw spring-boot:run

# Or on Windows
mvnw.cmd spring-boot:run

# Or build a JAR and run it
./mvnw clean package
java -jar target/StudentManagmentSystem-0.0.1-SNAPSHOT.jar
```

The application starts at **`http://localhost:8080`** by default.

---

## API Usage

### 1. Authenticate and get a token

```http
POST /api/auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "password"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

### 2. Use the token in subsequent requests

```http
GET /api/students
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```

### Swagger UI

All available endpoints are documented interactively at:

```
http://localhost:8080/swagger-ui.html
```

Use the **Authorize** button in Swagger UI to enter your JWT token and test secured endpoints directly in the browser.

---

## Project Structure

```
Student-Managment-System-Using-JWT/
├── src/
│   └── main/
│       ├── java/com/StudentMangSys/StudentManagmentSystem/
│       │   ├── config/        # Security & application configuration
│       │   ├── controller/    # REST API controllers
│       │   ├── dto/           # Request/Response data transfer objects
│       │   ├── entity/        # JPA entity classes (DB table mappings)
│       │   ├── repository/    # Spring Data JPA repositories
│       │   ├── security/      # JWT filter, provider, and utilities
│       │   └── service/       # Business logic layer
│       └── resources/
│           ├── templates/     # Thymeleaf HTML templates
│           └── application.properties
├── pom.xml
├── mvnw / mvnw.cmd            # Maven wrapper scripts
└── README.md
```

---

## Contributing

Contributions are welcome! To get started:

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-feature-name`
3. Commit your changes: `git commit -m "Add: your feature description"`
4. Push to your branch: `git push origin feature/your-feature-name`
5. Open a Pull Request against `main`

Please ensure your code compiles cleanly (`./mvnw clean package`) and follows the existing code style before submitting.

---

## Maintainer

**Ashish Nagar**
GitHub: [@ashishnagar777](https://github.com/ashishnagar777)

Feel free to open an [issue](https://github.com/ashishnagar777/Student-Managment-System-Using-JWT/issues) for bug reports, feature requests, or questions.
