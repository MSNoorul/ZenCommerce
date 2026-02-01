# ZenCommerce

ZenCommerce is a secure, JWT-authenticated Spring Boot backend for an e-commerce platform. It provides product, category, cart, and order management with role-based access control.

## Key Features
- JWT-based authentication and authorization (roles: USER, ADMIN)
- CRUD APIs for products, categories, carts, and orders
- Secure password storage with BCrypt
- Stateless authentication with JWT
- Basic analytics endpoints (optional)
- HATEOAS-friendly responses (optional)

## Tech Stack
- Backend: Java 17, Spring Boot 3.x, Spring Security, JWT
- Data: PostgreSQL (configurable)
- Build: Maven or Gradle
- Testing: JUnit 5, Mockito

## Project Structure
- `src/` – Java source code
- `docs/` – Documentation (this folder)
- `config/` – configuration files (properties, YAML, Dockerfiles if any)
- `scripts/` – database seeding, migration, utilities
- `tests/` – tests or test notes

Comprehensive documentation for ZenCommerce is available in the docs/ folder:

- [docs/api.md](/docs/api.md) — API reference and usage
- [docs/architecture.md](/docs/architecture.md) — System architecture and data model
- [docs/security.md](/docs/security.md) — Security design and JWT details
- [docs/contributing.md](/docs/contributing.md) — Contribution guidelines
- [docs/changelog.md](/docs/changelog.md) — Change log
- [docs/deploy.md](/docs/deploy.md) — Deployment notes and Docker guidance
- [docs/setup.md](/docs/setup.md) — How to set up and run the project locally

## Prerequisites
- Java JDK 17 or higher
- Maven or Gradle
- PostgreSQL (or your preferred DB)
- Docker (optional, for quick DB setup)

## Getting Started

### Quick Start (local)
1. Clone the repository
2. Create and configure the database
   - Update `application.properties` (or `application.yml`) with DB connection and JWT settings
   - Example environment variables:
     - `SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/`
     - `SPRING_DATASOURCE_USERNAME=postgres`
     - `SPRING_DATASOURCE_PASSWORD=yourpassword`
     - `JWT_SECRET=your_jwt_secret`
     - `JWT_EXPIRATION_MS=3600000`
3. Build the project
   - Maven: `mvn clean package`
   - Gradle: `./gradlew clean build`
4. Run
   - `java -jar target/ZenCommerce-0.1.0.jar`
   - Or run from IDE with Spring Boot support

### Docker (optional)
If you’ve provided a docker-compose.yml (recommended for quick start), run:
