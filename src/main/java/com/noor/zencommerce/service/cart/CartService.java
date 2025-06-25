package com.noor.zencommerce.service.cart;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noor.zencommerce.dto.CartDto;
import com.noor.zencommerce.exceptions.ResourceNotFoundException;
import com.noor.zencommerce.model.Cart;
import com.noor.zencommerce.model.User;
import com.noor.zencommerce.repository.CartItemRepository;
import com.noor.zencommerce.repository.CartRepository;
import com.noor.zencommerce.repository.UserRepository;
import com.noor.zencommerce.service.product.IProductService;
import com.noor.zencommerce.service.user.IUserService;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService{
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ModelMapper modelMapper;
    private final IUserService userService;

    @Override
    public Cart getCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
        BigDecimal totalAmount = cart.getTotalAmount();
        cart.setTotalAmount(totalAmount);
        return cartRepository.save(cart);
    }


    /*    @Override
    public Cart getCart(Long userId) {
        return Optional.ofNullable(getCartByUserId(userId))
                .map(cart -> {
                    // If the cart exists, return it
                    BigDecimal totalAmount = cart.getTotalAmount();
                    cart.setTotalAmount(totalAmount);
                    return cartRepository.save(cart);
                })
                .orElseGet(() -> {
                    // If the cart does not exist, initialize a new cart
                    User user = Optional.ofNullable(userService.getUserById(userId))
                            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
                    return initializeNewCart(user);
                });
    }*/

    @Transactional
    @Override
    public void clearCart(Long id) {
        Cart cart = getCart(id);
        cartItemRepository.deleteAllByCartId(id);
        cart.clearCart();
        cartRepository.deleteById(id);
    }

    @Override
    public BigDecimal getTotalPrice(Long id) {
        Cart cart = getCart(id);
        return cart.getTotalAmount();
    }


    @Override
    public Cart initializeNewCart(User user) {
        return Optional.ofNullable(getCartByUserId(user.getId()))
                .orElseGet(() -> {
                    Cart cart = new Cart();
                    cart.setUser(user);
                    return cartRepository.save(cart);
                });
    }

  @Override
    public Cart getCartByUserId(Long userId) {
       return cartRepository.findByUserId(userId);
    }

    @Override
    public CartDto convertToDto(Cart cart){
        return modelMapper.map(cart, CartDto.class);
    }
}
