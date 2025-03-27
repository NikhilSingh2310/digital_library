# Digital Library

This is a Spring Boot-based Digital Library application that provides a backend for managing books.

## Features
- Manage books (add, update, delete, list)
- Search books by title

## Tech Stack
- **Backend:** Spring Boot, Spring Data JPA
- **Database:** PostgreSQL
- **Build Tool:** Maven
- **Deployment:** Docker, Render

## Installation & Setup
### Prerequisites
- Java 17+
- Maven
- PostgreSQL
- Docker (optional, for containerized deployment)

### Configuration
Set up the required environment variables:
```
SPRING_DATASOURCE_URL=jdbc:postgresql://<your-db-host>/<your-db-name>
SPRING_DATASOURCE_USERNAME=<your-db-username>
SPRING_DATASOURCE_PASSWORD=<your-db-password>
SPRING_JPA_HIBERNATE_DDL_AUTO=update
```

### Run Locally
1. Clone the repository:
   ```sh
   git clone https://github.com/NikhilSingh2310/digital_library.git
   cd digital_library
   ```
2. Build the project:
   ```sh
   mvn clean package -DskipTests
   ```
3. Run the application:
   ```sh
   java -jar target/digitallibrary-0.0.1-SNAPSHOT.jar
   ```

### Run with Docker
1. Build and run the Docker container:
   ```sh
   docker build -t digital-library .
   docker run -p 8080:8080 --env-file .env digital-library
   ```

## API Endpoints
| Method | Endpoint            | Description               |
|--------|---------------------|---------------------------|
| POST   | /api/books          | Add a new book           |
| GET    | /api/books          | Get all books            |
| GET    | /api/books/{id}     | Get book by ID           |
| GET    | /api/books/search   | Search book by title     |
| PUT    | /api/books/{id}     | Update book details      |
| DELETE | /api/books/{id}     | Delete a book            |
| POST   | /api/books/exit     | Shutdown application     |

## Deployment on Render
1. Push the repository to GitHub.
2. Connect Render with the repository.
3. Set environment variables in Render.
4. Deploy and monitor logs for any errors.

## Future Scope & Improvements
- Implement role-based authentication and authorization.
- Improve error handling and validation.
- Add unit and integration tests.
- Implement caching for faster responses.
- Enhance logging and monitoring.
- Introduce API documentation using Swagger.
- Implement pagination for large data sets.

## Author
Nikhil Singh

