package com.example.springweb.ConvertDto;

import com.example.springweb.dto.CartItemDto;
import com.example.springweb.dto.UserDto;
import com.example.springweb.entity.ProductEntity;
import com.example.springweb.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class ConvertToEntity {
      public ProductEntity toEntityProduct(CartItemDto cartItemDto){
            ProductEntity productEntity =new ProductEntity();
            productEntity.setId((long)cartItemDto.getId());
            productEntity.setName(cartItemDto.getName());
            productEntity.setImage(cartItemDto.getImage());
            productEntity.setPrice(cartItemDto.getPrice());
            productEntity.setQuantity(cartItemDto.getQuantity());
          return productEntity;
      }
      public UserEntity toUserEntity(UserDto userDto){
            UserEntity user =new UserEntity();
            user.setFullName(userDto.getFullName());
            user.setUserId(userDto.getUserId());
            user.setPhoneNumber(userDto.getPhoneNumber());
            user.setAvatar(userDto.getAvatar());
            return user;
      }
      public Collection<ProductEntity> toListProductEntity(Collection<CartItemDto> cartItemDtos){
            Collection<ProductEntity>list = new ArrayList<>();
            cartItemDtos.forEach(cartItemDto -> {
                  ProductEntity productEntity =new ProductEntity();
                  productEntity.setId((long)cartItemDto.getId());
                  list.add(productEntity);
            });
            return list;
      }
}
