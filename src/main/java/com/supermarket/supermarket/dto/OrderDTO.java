package com.supermarket.supermarket.dto;

import com.supermarket.supermarket.entities.OrderItem;
import com.supermarket.supermarket.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
public class OrderDTO {

    private User client;

    private Set<OrderItem> items;

}
