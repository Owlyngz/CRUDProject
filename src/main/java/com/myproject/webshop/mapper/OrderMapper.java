package com.myproject.webshop.mapper;

import com.myproject.webshop.dto.OrderDTO;
import com.myproject.webshop.model.Order;
import com.myproject.webshop.model.Payment;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class OrderMapper {

    public OrderDTO toDto (Order order) {

        return new OrderDTO(order.getOrderId(), order.getOrdered(), order.getShipped(), order.getShipTo(), order.getOrderStatus());
    }


    public List<OrderDTO>toDtoList(List<Order> orders) {

        List<OrderDTO> orderDTOS = new ArrayList<>();

        for (Order order: orders) {
            orderDTOS.add((toDto(order)));
        }
        return orderDTOS;
    }

    public Order toEntity (OrderDTO orderDTO) {

        return new Order(orderDTO.getOrderId(), orderDTO.getOrdered(), orderDTO.getShipped(), orderDTO.getShipTo(), orderDTO.getOrderStatus());
    }

    public List<Order>toEntityList(List<OrderDTO> orderDTOList) {

        List<Order>orderEntityList = new ArrayList<>();

        for (OrderDTO orderDTO: orderDTOList) {
            orderEntityList.add((toEntity(orderDTO)));
        }

        return orderEntityList;
    }

    public Order updateOrder(OrderDTO orderDTO, Order order) {

        order.setShipTo(orderDTO.getShipTo());

        return order;

    }
}
