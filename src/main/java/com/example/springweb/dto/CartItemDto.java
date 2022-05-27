package com.example.springweb.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {
    private Integer id;

    private String name;

    private Long price;

    private int quantity=1;

    private String image;

    private Long total;


}
