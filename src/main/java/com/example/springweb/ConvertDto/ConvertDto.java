package com.example.springweb.ConvertDto;


import com.example.springweb.dto.*;
import com.example.springweb.entity.CategoryEntity;
import com.example.springweb.entity.ProductEntity;
import com.example.springweb.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ConvertDto {
      public UserDto toUserDto(UserEntity user){
          UserDto userDto =new UserDto();
          userDto.setFullName(user.getFullName());
          userDto.setPhoneNumber(user.getPhoneNumber());
          userDto.setUserName(user.getUserName());
          userDto.setUserId(user.getUserId());
          userDto.setAddress(user.getAddress());
          userDto.setEmail(user.getEmail());
          userDto.setAvatar(user.getAvatar());
          return userDto;
      }
      public List<ProductDto>toListProductDTO(List<ProductEntity>listEmtity){
          List<ProductDto>list=new ArrayList<>();
          listEmtity.forEach(product->{
              ProductDto productDto =new ProductDto();
              productDto.setId(product.getId());
              productDto.setImage(product.getImage());
              productDto.setName(product.getName());
              productDto.setQuantity(product.getQuantity());
              productDto.setPrice(product.getPrice());
              productDto.setTimeInsurance(product.getTimeInsurance());
              productDto.setDescription(product.getDescription());
              list.add(productDto);
          });
        return list;
      }
      public List<CategoryDto>toCategoryEntities(List<CategoryEntity>categoryEntities){
           List<CategoryDto>list =new ArrayList<>();
           categoryEntities.forEach(category->{
              CategoryDto categoryDto =new CategoryDto();
              categoryDto.setId(category.getId());
              categoryDto.setName(category.getName());
              list.add(categoryDto);
           });
           return list;
      }
      public ProductDto toProductDto(ProductEntity productEntity){
          ProductDto productDto =new ProductDto();
          productDto.setId(productEntity.getId());
          productDto.setImage(productEntity.getImage());
          productDto.setName(productEntity.getName());
          productDto.setQuantity(productEntity.getQuantity());
          productDto.setPrice(productEntity.getPrice());
          productDto.setTimeInsurance(productEntity.getTimeInsurance());
          productDto.setDescription(productEntity.getDescription());
          productEntity.images.forEach(e->{
              productDto.imgs.add(new ImageDto(e.id, e.link));
          });
          productEntity.sizeEnities.forEach(e->{
               productDto.sizes.add(new SizeDto(e.id,e.size));
          });
      return productDto;
      }
      public CartItemDto toCartItemDto(ProductDto productDto){
          CartItemDto cartItemDto=new CartItemDto();
          cartItemDto.setId(productDto.getId().intValue());
          cartItemDto.setImage(productDto.getImage());
          cartItemDto.setName(productDto.getName());
          cartItemDto.setPrice(productDto.getPrice());
          return cartItemDto;
      }

}
