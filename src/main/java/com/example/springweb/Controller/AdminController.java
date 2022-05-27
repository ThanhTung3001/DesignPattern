package com.example.springweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/Admin"})
public class AdminController {
    @GetMapping()
    public String Index(){
        return "Admin/Index";
    }
}
