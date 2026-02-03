# API Reference (ZenCommerce)

All endpoints are prefixed by `api.prefix` (configured in application properties). Security configuration expects `/api/v1` by default, so the examples below use `/api/v1` as the prefix.

Responses (unless noted otherwise) are wrapped in:
```json
{ "message": "...", "data": { } }
```

## Auth
- POST `/api/v1/auth/login`
  - Request:
    ```json
    { "email": "user@example.com", "password": "secret" }
    ```
  - Response data:
    ```json
    { "id": 1, "token": "<jwt>" }
    ```

## Users
- GET `/api/v1/users/{userId}`
- POST `/api/v1/users/add`
  - Body:
    ```json
    { "firstName": "...", "lastName": "...", "email": "...", "password": "..." }
    ```
- PUT `/api/v1/users/{userId}/update`
  - Body:
    ```json
    { "firstName": "...", "lastName": "..." }
    ```
- DELETE `/api/v1/users/{userId}`

## Products
- GET `/api/v1/products/all`
- GET `/api/v1/products/product/{productId}/product`
- POST `/api/v1/products/add` (ADMIN)
  - Body:
    ```json
    {
      "name": "...",
      "brand": "...",
      "price": 9.99,
      "inventory": 100,
      "description": "...",
      "category": { "id": 1, "name": "..." }
    }
    ```
- PUT `/api/v1/products/product/{productId}/update` (ADMIN)
  - Body matches `AddProductRequest`
- DELETE `/api/v1/products/product/{productId}/delete` (ADMIN)
- GET `/api/v1/products/products/by/brand-and-name?brandName=...&productName=...`
- GET `/api/v1/products/products/by/category-and-brand?category=...&brand=...`
- GET `/api/v1/products/products/{name}/products`
- GET `/api/v1/products/product/by-brand?brand=...`
- GET `/api/v1/products/product/{category}/all/products`
- GET `/api/v1/products/distinct/products`
- GET `/api/v1/products/distinct/brands`
- GET `/api/v1/products/product/count/by-brand/and-name?brand=...&name=...`

## Categories
- GET `/api/v1/categories/all`
- POST `/api/v1/categories/add`
  - Body:
    ```json
    { "name": "..." }
    ```
- GET `/api/v1/categories/category/{id}/category`
- GET `/api/v1/categories/category/{name}/category`
- PUT `/api/v1/categories/category/{id}/update`
  - Body:
    ```json
    { "name": "..." }
    ```
- DELETE `/api/v1/categories/category/{id}/delete`

## Carts (secured)
- GET `/api/v1/carts/user/{userId}/my-cart`
- DELETE `/api/v1/carts/{cartId}/clear`
- GET `/api/v1/carts/{cartId}/cart/total-price`

## Cart Items (secured)
- POST `/api/v1/cartItems/item/add?productId=1&quantity=2`
- DELETE `/api/v1/cartItems/cart/{cartId}/item/{itemId}/remove`
- PUT `/api/v1/cartItems/cart/{cartId}/item/{itemId}/update?quantity=3`

## Orders
- POST `/api/v1/orders/user/place-order?userId=1`
- GET `/api/v1/orders/{orderId}/order`
- GET `/api/v1/orders/user/{userId}/order`
- POST `/api/v1/orders/payment/create-payment-intent`
  - Body:
    ```json
    { "amount": 1099, "currency": "usd" }
    ```
  - Response: Stripe payment intent JSON string

## Images
- POST `/api/v1/images/upload`
  - Multipart form-data:
    - `files`: one or more files
    - `productId`: product ID
- GET `/api/v1/images/image/download/{imageId}`
- PUT `/api/v1/images/image/{imageId}/update`
  - Multipart form-data:
    - `file`: image file
- DELETE `/api/v1/images/image/{imageId}/delete`

## Error handling
- 400 Bad Request: validation errors
- 401 Unauthorized: missing/invalid token
- 403 Forbidden: insufficient permissions
- 404 Not Found: resource not found
- 409 Conflict: already exists
- 500 Internal Server Error: server issue

## Security notes
- JWT tokens must be sent in `Authorization` header: `Bearer <token>`
- `/api/v1/carts/**` and `/api/v1/cartItems/**` require authentication
- Product create/update/delete endpoints require `ROLE_ADMIN`
