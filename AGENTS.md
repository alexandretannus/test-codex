# Repository Guidelines

## Project Structure & Module Organization
This is a Maven-based Spring Boot app (Java 21).
- `pom.xml`: dependencies and build configuration.
- `src/main/java/com/example/demo`: application code (entrypoint, controllers, security config).
- `src/main/resources/application.properties`: runtime configuration (port, datasource, JPA, actuator).
- `src/test/java/com/example/demo`: tests.
- `docker-compose.yml`, `Dockerfile`: local containerized stack (app, PostgreSQL, pgAdmin).
- `insomnia/`: Insomnia import files for API testing.
- `target/`: build output (generated; do not edit).

## Build, Test, and Development Commands
- `mvn clean compile`: clean and compile sources.
- `mvn test`: run unit/integration tests via Surefire.
- `mvn spring-boot:run`: run app locally (default port `8080`, configurable with `SERVER_PORT`).
- `mvn clean package`: build runnable artifact.
- `docker compose up --build -d`: start app + Postgres + pgAdmin stack.
- `docker compose down`: stop and remove containers.

## Coding Style & Naming Conventions
- Follow Java conventions: `PascalCase` classes, `camelCase` methods/fields, lowercase package names.
- Keep package root under `com.example.demo` and organize by feature/layer (e.g., `controller`, `config`).
- Match existing formatting style in the repository (tabs are currently used in Java files).
- Prefer small, focused classes and explicit endpoint/security mappings.

## Testing Guidelines
- Testing stack: JUnit 5 + Spring Boot Test (`spring-boot-starter-test`).
- Place tests under matching package paths in `src/test/java`.
- Name test classes `*Tests` (example: `DemoApplicationTests`).
- Run `mvn test` before opening a PR; add tests for any behavior or security rule changes.

## Commit & Pull Request Guidelines
- Current history uses concise, imperative commit subjects (examples: `Add Docker Compose stack...`, `change java version to 21...`).
- Use one logical change per commit and include context in the body when needed.
- PRs should include:
  - What changed and why.
  - How it was validated (`mvn test`, manual endpoint checks, etc.).
  - Related issue/reference if applicable.
  - API/config impact notes (ports, env vars, auth rules).

## API Workflow
- Import `insomnia/demo-api-insomnia.json` into Insomnia.
- Set environment values:
  - `base_url` (local: `http://localhost:8080`, Docker setup in README uses `http://localhost:8082`).
  - `username` and `password` for Basic Auth requests.
- Verify endpoints in this order:
  - `GET /hello` (public).
  - `GET /actuator/health` (public).
  - `GET /actuator/info` (requires Basic Auth by current security config).
- For API changes, update both:
  - `insomnia/demo-api-insomnia.json` (request collection/folders).
  - `README.md` or config notes if ports/auth behavior changed.
