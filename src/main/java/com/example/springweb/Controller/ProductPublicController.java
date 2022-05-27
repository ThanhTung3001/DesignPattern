package com.example.springweb.Controller;

import com.example.springweb.Service.imp.ProductService;
import com.example.springweb.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/Shop/product")
public class ProductPublicController {

    @Autowired
    public ProductService productService;
    @GetMapping
    public String getById(@RequestParam Long id, Model model){
        ProductDto product=productService.findProductById(id);
        model.addAttribute("product",product);
        return "product";
    }
}
