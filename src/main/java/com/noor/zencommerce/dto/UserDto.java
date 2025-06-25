package com.noor.zencommerce.dto;

import lombok.Data;

import java.util.List;

import com.noor.zencommerce.model.Cart;
import com.noor.zencommerce.model.Order;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<OrderDto> orders;
    private CartDto cart;
}
