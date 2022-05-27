package com.example.springweb.Controller;


import com.example.springweb.Service.IProductService;
import com.example.springweb.Service.IShopingCartService;
import com.example.springweb.dto.CartItemDto;
import com.example.springweb.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class CartController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IShopingCartService iShopingCartService;
    @GetMapping(value = {"/cart","/cart/"})
    public String showViews(Model model){
        Collection<CartItemDto>cartItemDtos = iShopingCartService.showList();
        model.addAttribute("Model_Item",cartItemDtos);
        model.addAttribute("total",iShopingCartService.total());
        return "cart";
    }
    @GetMapping(value = {"/home/add-cart/{id}"})
    public ModelAndView addCart(@PathVariable("id") Long id, Model model){
        ProductDto productDto =productService.findProductById(id);
        iShopingCartService.addItem(productDto);
        return new ModelAndView("redirect:/home");
    }
    @GetMapping(value = {"/cart/cart-add/{id}"})
    public ModelAndView addCarts(@PathVariable("id") Long id, Model model){
        ProductDto productDto =productService.findProductById(id);
        iShopingCartService.addItem(productDto);
        return new ModelAndView("redirect:/cart");
    }
    @GetMapping(value = {"/cart/cart-delete/{id}"})
    public ModelAndView deleteFromCart(@PathVariable("id") Long id, Model model){
        ProductDto productDto =productService.findProductById(id);
        iShopingCartService.removeItemById(id);
        return new ModelAndView("redirect:/cart/");
    }
    @GetMapping(value = {"/cart/delete"})
    public ModelAndView remove(@RequestParam("id") Long id, Model model){
        iShopingCartService.removeItem(id);
        return new ModelAndView("redirect:/cart");
    }

}
