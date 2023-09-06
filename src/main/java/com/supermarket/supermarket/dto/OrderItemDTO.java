package com.supermarket.supermarket.dto;

import com.supermarket.supermarket.entities.OrderItem;
import com.supermarket.supermarket.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
public class OrderItemDTO {

    private int quantity;

    private Product product_id;

}
