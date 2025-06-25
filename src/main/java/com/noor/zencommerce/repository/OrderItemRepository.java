package com.noor.zencommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noor.zencommerce.model.OrderItem;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
  List<OrderItem> findByProductId(Long id);
}
