package com.example.springweb.Controller;

import com.example.springweb.ConvertDto.ConvertToEntity;
import com.example.springweb.Service.imp.InSuranceService;
import com.example.springweb.Service.imp.UserService;
import com.example.springweb.dto.UserDto;
import com.example.springweb.entity.InsuranceEntity;
import com.example.springweb.entity.ProductEntity;
import com.example.springweb.utilscheck.NumberCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(value = {"/insurance"})
public class InsuranceController {
    @Autowired
    NumberCheck number;
    @Autowired
    InSuranceService InSuranceService;
    @Autowired
    UserService userService;
    @Autowired
    ConvertToEntity convertToEntity;
    @GetMapping(value = {"/form","/",""})
    public String getForm(Model model){

        return "isn";
    }
    @GetMapping(value = {"/view-form"})
      public ModelAndView getViewForm(){

        return new ModelAndView("redirect:/insurance/form");
    }
    @PostMapping(value = {"/view-form"})
    public ModelAndView getView(@RequestParam String Bill_ID,
                                @RequestParam String Product_ID,
                                @RequestParam String psw_repeat,
                                Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto user =userService.findUserByName(auth.getName());
        boolean check = InSuranceService.checkInsurance(Long.valueOf(Product_ID),Long.valueOf(Bill_ID),Long.valueOf(user.getUserId()));
        ProductEntity productEntity =new ProductEntity();
        productEntity.setId(Long.valueOf(Product_ID));
        if(check==true){
            InsuranceEntity insuranceEntity =new InsuranceEntity();
            Set<ProductEntity> productE=new HashSet<>();
            insuranceEntity.setUserIS(convertToEntity.toUserEntity(user));
            insuranceEntity.setTimeInsuDate(new Date());
            insuranceEntity.setReason(psw_repeat);
            productE.add(productEntity);
            insuranceEntity.setProductE(productE);
            InSuranceService.save(insuranceEntity);
            model.addAttribute("Action","Request sent successfully ");
        }else {
            model.addAttribute("Action","Bill not exist or warranty period expired ");
        }
        return new ModelAndView("isn");
    }
}
