package com.noor.zencommerce.service.cart;

import java.math.BigDecimal;

import com.noor.zencommerce.dto.CartDto;
import com.noor.zencommerce.model.Cart;
import com.noor.zencommerce.model.User;

public interface ICartService {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);

    Cart initializeNewCart(User user);

    Cart getCartByUserId(Long userId);

    CartDto convertToDto(Cart cart);
}
