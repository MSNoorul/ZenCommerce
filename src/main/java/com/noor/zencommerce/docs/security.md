# Security Design

Authentication
- JWT-based authentication
- Token issued on login and includes user roles
- Tokens validated by a security filter on every request

Authorization
- Role-based access: USER, ADMIN
- Admins can manage products, categories; users can manage their cart and place orders

Password Storage
- BCrypt hashing via Spring Security PasswordEncoder

Token Lifecycle
- Access token expiration: defined by JWT_EXPIRATION_MS
- No refresh token flow by default (can be added later)

CSRF and CORS
- CSRF disabled for stateless JWT APIs
- CORS configured to allow your frontend domain (adjust as needed)

Endpoints Security (examples)
- /api/products: GET (USER), POST/PUT/DELETE (ADMIN)
- /api/cart: GET/POST (USER)
- /api/orders: POST (USER), GET (USER)
