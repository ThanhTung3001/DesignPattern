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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = {"/category"})
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IProductService productService;
    @GetMapping(value = {""})
     public String getCategory(Model model, @RequestParam Long id){
        List<CategoryDto> list=categoryService.findAll();
        List<ProductDto>listProduct=productService.findAllByCategoryId(id);
        model.addAttribute("CategoryModel",list);
        model.addAttribute("ProductModel",listProduct);
        return "index";
    }
}
