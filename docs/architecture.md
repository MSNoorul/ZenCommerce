# Architecture

## Overview
EcomExpress is a layered Spring Boot application with a focus on modularity, testability, and security. It uses JWT for stateless authentication and role-based access control.

## Architecture Diagram (Text)
- Client (Web/Mobile)
  - Communicates via REST API
- API Layer (Controllers)
  - Exposes REST endpoints for products, categories, cart, and orders
  - Validates requests and returns appropriate responses
- Service Layer
  - Business logic, orchestrating operations across repositories
- Data Access Layer (Repositories)
  - JPA/Hibernate repositories
- Security Layer
  - Spring Security configuration
  - JWT filter for authentication
  - Password encoding with BCrypt
- Data Layer
  - PostgreSQL (or configured DB)

## Core Layers
- API: Controllers
- Service: Business logic
- Repository: Data access (JPA)
- Security: Authentication, authorization, tokens

## Data Model (Entities)
- User(id, username, passwordHash, roles)
- Product(id, name, description, price, stock, category)
- Category(id, name, description)
- Cart(id, user_id, items...)
- CartItem(id, product_id, quantity, price)
- Order(id, user_id, total, status, created_at)
- OrderItem(id, product_id, quantity, price)

## Security Model
- JWT creation: tokens issued at login
- Token validation: filter checks signature and expiration
- Roles: USER, ADMIN
- Access rules (examples):
  - Admin: manage products, categories
  - User: view products, manage own cart and orders

## Deployment Considerations
- Separate DB and app with proper network policies
- Use environment variables for secrets
- Enable TLS in production

## Notes
- If you use OpenAPI, consider integrating Swagger/OpenAPI for interactive docs.
