package com.example.springweb.Service;


import com.example.springweb.dto.CartItemDto;
import com.example.springweb.dto.ProductDto;

import java.util.Collection;

public interface IShopingCartService {
   public void addItem(ProductDto cartItemDto);
   public void removeItemById(Long id);
   public Collection<CartItemDto>showList();
   public void removeItem(Long id);
   public double total();
   public void removeAllItems();
}
