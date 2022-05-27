package com.example.springweb.Controller;

import com.example.springweb.Service.ICategoryService;
import com.example.springweb.Service.IProductService;
import com.example.springweb.dto.CategoryDto;
import com.example.springweb.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping(value = {"/home","","/"})
public class HomeController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IProductService productService;
       @GetMapping(value = {"","/"})
      public String HomePage(Model model){
        List<CategoryDto>list=categoryService.findAll();
        List<ProductDto>listProduct=productService.findAll();
        List<ProductDto>list1=productService.topThree();
           model.addAttribute("CategoryModel",list);
           model.addAttribute("ProductModel",listProduct);
           model.addAttribute("ProductList",list1);
           return "index";
       }
}