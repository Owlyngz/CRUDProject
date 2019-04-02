package com.myproject.webshop.services;

import com.myproject.webshop.dto.OrderDTO;
import com.myproject.webshop.mapper.OrderMapper;
import com.myproject.webshop.model.Order;
import com.myproject.webshop.repositories.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Component
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public List<OrderDTO> getAllDtoOrders() {

        List<Order> foundOrders = orderRepository.findAllOrders();
        return orderMapper.toDtoList(foundOrders);
    }

    public List<OrderDTO> saveMethod(Order order) {

        orderRepository.save(order);
        return getAllDtoOrders();
    }

    public OrderDTO findOrderById(Long id) {

        OrderDTO orderDTO = orderMapper.toDto(orderRepository.findOrderById(id));
        return orderDTO;
    }

    public OrderDTO updateMethod(OrderDTO orderDTO, Long id) {

        Order foundOrder = orderRepository.findOrderById(id);

        orderMapper.updateOrder(orderDTO, foundOrder);

        saveMethod(foundOrder);

        return findOrderById(id);
    }

    public List<OrderDTO> deleteOrderById (Long id) {

        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.METHOD_NOT_ALLOWED);
        }
        if (id == 0) {
            throw new HttpClientErrorException(HttpStatus.I_AM_A_TEAPOT);
        }
        orderRepository.deleteById(id);
        return getAllDtoOrders();
    }


}
