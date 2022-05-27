package com.example.springweb.Controller;

import com.example.springweb.Service.ICategoryService;
import com.example.springweb.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/Admin/category"})
public class AdminCategoryController {

    @Autowired
    ICategoryService categoryService;

    @GetMapping(value = {"/",""})
    public String Index (Model model){
        model.addAttribute("Catgory_List",categoryService.findAll());
        return "/Admin/Category";
    }
    @PostMapping(value = {"/Add"})
    public ModelAndView Add(@RequestParam String categoryName){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(categoryName);
        categoryService.Add(categoryEntity);
        return new ModelAndView("redirect:/Admin/category");
    }
    @GetMapping(value = {"/Delete/{id}"})
    public ModelAndView Delete(@PathVariable Long id){
        categoryService.DeleteById(id);
        return new ModelAndView("redirect:/Admin/category");

    }
}
