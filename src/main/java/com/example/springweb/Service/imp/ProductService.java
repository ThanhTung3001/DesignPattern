package com.example.springweb.Service.imp;

import com.example.springweb.ConvertDto.ConvertDto;
import com.example.springweb.Reponsitory.IProductReponsitory;
import com.example.springweb.Service.IProductService;
import com.example.springweb.dto.ProductDto;
import com.example.springweb.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductReponsitory iProductReponsitory;
    @Autowired
    private ConvertDto convertDto;
    @Override
    public List<ProductDto> findAll() {
         List<ProductEntity>list= iProductReponsitory.findAll();
        return convertDto.toListProductDTO(list);
    }
    @Override
    public List<ProductDto> findAllByCategoryId(Long id) {
        List<ProductEntity>list =iProductReponsitory.findAllByIdCategory(id);
        return convertDto.toListProductDTO(list);
    }
    @Override
    public ProductDto findProductById(Long id) {
        ProductDto productDto = convertDto.toProductDto(iProductReponsitory.findAllById(id));
        return productDto;
    }

    @Override
    public List<ProductDto> topThree() {
            List<ProductEntity> list =iProductReponsitory.findAll();
            List<ProductEntity>list1 =new ArrayList<>();
        for(int i=list.size()-1;i>=list.size()-3&&i>=0;i--){
            list1.add(list.get(i));
        }
        return convertDto.toListProductDTO(list1);
    }

    @Override
    public ProductEntity addProduct(ProductEntity product) {
        iProductReponsitory.save(product);
        return iProductReponsitory.save(product);
    }

    @Override
    public ProductEntity findEntityById(Long id) {
        return iProductReponsitory.findAllById(id);
    }

    @Override
    public void DeleteById(Long id) {
        iProductReponsitory.deleteById(id);
    }
}
