package com.example.springweb.Service;

import com.example.springweb.dto.ProductDto;
import com.example.springweb.entity.ProductEntity;

import java.util.List;

public interface IProductService {
    List<ProductDto>findAll();
    List<ProductDto>findAllByCategoryId(Long id);
    ProductDto findProductById(Long id);
    List<ProductDto>topThree();
    ProductEntity addProduct(ProductEntity product);

    ProductEntity findEntityById(Long id);

    void DeleteById(Long id);


}
