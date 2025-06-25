package com.noor.zencommerce.dto;

import lombok.Data;

import java.math.BigDecimal;

import com.noor.zencommerce.model.Product;
@Data
public class CartItemDto {
    private Long itemId;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
    private ProductDto product;
}
