package com.supermarket.supermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
public class OrderDTO {

    private Long client_id;

    private Long product_id;

    private Integer quantity;

}
