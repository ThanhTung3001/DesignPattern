package com.example.springweb.Controller;

import com.example.springweb.Service.IBillService;
import com.example.springweb.entity.BillEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/Admin/order"})
public class ApiOrderController {
    @Autowired
    IBillService billService;

    @GetMapping(value = {"","/"})
    public String Index(Model model){
        model.addAttribute("Orders",billService.getAll());
         return "/Admin/bill";
    }

    @GetMapping(value = {"/Update/{id}"})
    public ModelAndView Update(@PathVariable  Long id,@RequestParam(name = "status")String status){
        BillEntity billEntity = billService.findByIdBill(id);
        billEntity.setStatusDelivery(!billEntity.isStatusDelivery());
        billEntity.setStatus(status);
        billService.save(billEntity);
        return new ModelAndView("redirect:/Admin/order");
    }
}
