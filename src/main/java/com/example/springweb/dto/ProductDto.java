package com.example.springweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;

    private Long code_sell;

    private String name;

    private Long price;

    private int quantity;

    private String image;

    private  int timeInsurance;

    public String description;
   public List<SizeDto> sizes = new ArrayList<>();
   public List<ImageDto>imgs= new ArrayList<>();

}
