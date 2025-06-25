package com.noor.zencommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noor.zencommerce.model.CartItem;
import com.noor.zencommerce.model.Product;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    void deleteAllByCartId(Long id);
    List<CartItem> findByProductId(Long productId);
}
