# API Reference (ZenCommerce)

Auth
- POST /api/auth/login
  - Request: { "username": "<user>", "password": "<pass>" }
  - Response: { "token": "<jwt>", "expiresIn": 3600 }

Users (optional admin-only)
- GET /api/users (ADMIN)
- GET /api/users/{id} (ADMIN)

Products
- GET /api/products
  - Query params: page, size, search
  - Response: list of products
- POST /api/products (ADMIN)
  - Body: { "name": "...", "description": "...", "price": 9.99, "stock": 100, "categoryId": 1 }
- GET /api/products/{id}
- PUT /api/products/{id} (ADMIN)
  - Body: { "name": "...", "price": ..., "stock": ..., "categoryId": ... }
- DELETE /api/products/{id} (ADMIN)

Categories
- GET /api/categories
- POST /api/categories (ADMIN)
- GET /api/categories/{id}
- PUT /api/categories/{id} (ADMIN)
- DELETE /api/categories/{id} (ADMIN)

Cart
- POST /api/cart/add
  - Body: { "productId": 1, "quantity": 2 }
- GET /api/cart
- POST /api/cart/checkout
  - Body: { "address": "...", "paymentMethod": "CARD" }

Orders
- POST /api/orders
- GET /api/orders/{id}
- GET /api/orders (USER)
- GET /api/orders?userOnly=true (USER)

Error handling
- 400 Bad Request: validation errors
- 401 Unauthorized: missing/invalid token
- 403 Forbidden: insufficient permissions
- 404 Not Found: resource not found
- 500 Internal Server Error: server issue

Security notes
- JWT tokens must be sent in Authorization header: Bearer <token>
- Roles enforced via method/security annotations in services/controllers
