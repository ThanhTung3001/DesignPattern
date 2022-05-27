package com.example.springweb.Controller;

import com.example.springweb.Service.IUserService;
import com.example.springweb.dto.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/Admin/users"})
public class AdminUserController {
    @Autowired
    private IUserService service ;
    @GetMapping
    public String index(Model model){
        var users = service.findAll();
        model.addAttribute("Users",users);
        return "/Admin/User";
    }
    @GetMapping(value = "/Delete/{id}")
    public ModelAndView Delete(@PathVariable Long id){
        service.DeleteById(id);
        return new ModelAndView("redirect:/Admin/users");

    }

}
