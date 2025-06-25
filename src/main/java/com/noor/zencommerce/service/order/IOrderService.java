package com.noor.zencommerce.service.order;

import org.springframework.transaction.annotation.Transactional;

import com.noor.zencommerce.dto.OrderDto;
import com.noor.zencommerce.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);
    List<OrderDto> getUserOrders(Long userId);

    OrderDto convertToDto(Order order);
}
