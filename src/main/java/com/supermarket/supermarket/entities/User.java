package com.supermarket.supermarket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
}
