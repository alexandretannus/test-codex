# demo

Spring Boot 4 Maven project using Java 25 with:

- Spring Web
- Spring Data JPA
- Spring Security
- Spring Validation
- Spring Actuator
- PostgreSQL driver

## Configuration

Application configuration is in `src/main/resources/application.properties`.

## Run locally

```bash
mvn spring-boot:run
```

## Run with Docker Compose

This repository includes a full Docker setup for:

- Spring app on `8082`
- PostgreSQL on `5432`
- pgAdmin on `8085`

### Start

```bash
docker compose up --build -d
```

### Access

- App: `http://localhost:8082`
- PostgreSQL: `localhost:5432`
- pgAdmin: `http://localhost:8085`
  - Email: `admin@demo.local`
  - Password: `admin`

When adding the database server in pgAdmin, use:

- Host: `db`
- Port: `5432`
- Username: `postgres`
- Password: `postgres`
- Database: `demo`

### Stop

```bash
docker compose down
```
