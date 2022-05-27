package com.example.springweb.Controller;

import com.example.springweb.Service.IPromotionService;
import com.example.springweb.entity.PromotionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Date;

@Controller
@RequestMapping(value = {"/Admin/promotion"})
public class AdminPromotionController {
  @Autowired
  private IPromotionService iPromotionService;
    @GetMapping()
    public String Index(Model model){
        var promotions= iPromotionService.getAll();
        model.addAttribute("Promotions",promotions);
        return "Admin/Promotion";
    }
    @PostMapping(value = "/Add")
    public ModelAndView Update(
            @RequestParam(name = "code")String code,
            @RequestParam(name = "value")Long value,
            @RequestParam(name = "amount") int amount,
            @RequestParam(name = "end") String end
    ) throws ParseException {

        Date date =new SimpleDateFormat("yyyy-MM-dd").parse(end);
        PromotionEntity  promotionEntity = new PromotionEntity();
        promotionEntity.setAmount(amount);
        promotionEntity.setCode(code);
        promotionEntity.setEnd(date);
        promotionEntity.setValue(value);
        iPromotionService.Add(promotionEntity);
      return new ModelAndView("redirect:/Admin/promotion");
    }
    @GetMapping(value = {"/Delete/{id}"})
    public ModelAndView Delete(@PathVariable Long id){
        iPromotionService.Delete(id);
        return new ModelAndView("redirect:/Admin/promotion");
    }
}
