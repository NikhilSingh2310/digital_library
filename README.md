# Digital Library

## Overview
Digital Library is a Spring Boot-based application that provides a platform to manage and access digital books efficiently. The application is designed with role-based authentication and supports PostgreSQL as the database.

## Features
- User registration and authentication (Admin & Customer)
- Role-based access control
- Book management (Admin)
- Book browsing and borrowing (Customer)
- PostgreSQL database integration
- Docker support for deployment

## Technologies Used
- **Backend:** Java, Spring Boot, Spring MVC, Spring Data JPA
- **Database:** PostgreSQL
- **Build Tool:** Maven
- **Deployment:** Render (with Docker)

## Installation and Setup

### Prerequisites
- Java 21
- Maven
- PostgreSQL
- Docker (for deployment)

### Clone the Repository
```sh
git clone https://github.com/NikhilSingh2310/digital_library.git
cd digital_library
```

### Configure Database
Update `application.properties` with your PostgreSQL credentials:
```properties
spring.datasource.url=jdbc:postgresql://<YOUR_RENDER_DB_URL>:5432/<YOUR_DATABASE_NAME>
spring.datasource.username=<YOUR_DB_USERNAME>
spring.datasource.password=<YOUR_DB_PASSWORD>
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
server.port=${PORT:8080}
```

### Build and Run the Application
```sh
mvn clean package
java -jar target/digitallibrary-0.0.1-SNAPSHOT.jar
```

## Deployment (Render)
### Using Docker
1. **Ensure Docker is installed.**
2. **Create `Dockerfile` in the project root** (already provided).
3. **Build and run the Docker container:**
   ```sh
   docker build -t digital-library .
   docker run -p 8080:8080 digital-library
   ```
4. **Deploy to Render** following the Render setup guide.

## API Endpoints
| Method | Endpoint                   | Description               |
|--------|----------------------------|---------------------------|
| POST   | `/api/users/signup`        | User registration         |
| POST   | `/api/users/login`         | User authentication       |
| POST   | `/api/users/profile/complete` | Complete user profile |
| GET    | `/api/books`               | View all books           |
| POST   | `/api/books/add` (Admin)   | Add a new book           |

## Notes
- No testing framework has been implemented.
- Ensure to use the correct **database credentials** for deployment.
- Keep the `.env` file secure if used for environment variables.

## Author
**Nikhil Singh**

