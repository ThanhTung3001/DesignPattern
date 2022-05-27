package com.example.springweb.Service.imp;

import com.example.springweb.ConvertDto.ConvertDto;
import com.example.springweb.Service.IShopingCartService;
import com.example.springweb.dto.CartItemDto;
import com.example.springweb.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShopingCart implements IShopingCartService {
    @Autowired
   private ConvertDto convertDto;
    Map<Integer,CartItemDto>maps =new HashMap<>();
    @Override
    public void addItem(ProductDto cartItemDto) {
        CartItemDto itemDto = maps.get(cartItemDto.getId().intValue());
        if(itemDto==null){
            CartItemDto dto = convertDto.toCartItemDto(cartItemDto);
            dto.setTotal(dto.getPrice());
            maps.put(dto.getId(),dto);
        }else {
            itemDto.setQuantity(itemDto.getQuantity()+1);
            itemDto.setTotal((long) (itemDto.getPrice()* itemDto.getQuantity()));
            maps.replace(itemDto.getId(),itemDto);
        }
    }
    @Override
    public void removeItemById(Long id) {
        CartItemDto item = maps.get(id.intValue());
        if(item.getQuantity()>1){
            item.setQuantity(item.getQuantity()-1);
            maps.replace(item.getId(),item);
        }else{
            removeItem((long)id.intValue());
        }
    }
    @Override
    public Collection<CartItemDto> showList() {
        return maps.values();
    }

    @Override
    public void removeItem(Long id) {
        maps.keySet().removeIf(key -> key == id.intValue());//java 8+
    }

    @Override
    public double total() {
        return maps.values().stream().mapToDouble(item->item.getQuantity()*item.getPrice()).sum();
    }

    @Override
    public void removeAllItems() {
        maps.clear();
    }
}
