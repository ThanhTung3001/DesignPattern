package com.example.springweb.Controller;

import com.example.springweb.ConvertDto.ConvertToEntity;
import com.example.springweb.Service.IBillService;
import com.example.springweb.Service.IShopingCartService;
import com.example.springweb.Service.IUserService;
import com.example.springweb.Service.imp.BillService;
import com.example.springweb.dto.CartItemDto;
import com.example.springweb.dto.UserDto;
import com.example.springweb.entity.BillEntity;
import com.example.springweb.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(value = {"/check-out"})
public class CheckOutController {
    @Autowired
    private IShopingCartService iShopingCartService;
    @Autowired
    private IBillService iBillService;
    @Autowired
    private IUserService userService;
    @Autowired
    private ConvertToEntity convertToEntity;
    @Autowired
    private BillService billService;
    @GetMapping(value = {"","/"})
    public String checkout(Model model){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto =userService.findUserByName(auth.getName());
         BillEntity billEntity =new BillEntity();
         billEntity.setTotal((long)iShopingCartService.total());
         billEntity.setTimeSell(sqlDate);
         billEntity.setUser(convertToEntity.toUserEntity(userDto));
         Set<ProductEntity>productEntities =new HashSet<>();
         Collection<CartItemDto>list=iShopingCartService.showList();
        ProductEntity productEntity =new ProductEntity();
         list.forEach(cartItemDto -> {

             productEntity.setId(Long.valueOf(cartItemDto.getId()));
             productEntities.add(productEntity);
         });
         billEntity.setProductEntities(productEntities);
        iBillService.save(billEntity);
        iShopingCartService.removeAllItems();
        Integer integer =billService.findBillId(userDto.getUserId(),productEntity.getId());
        Collection<CartItemDto>cartItemDtos = iShopingCartService.showList();
        model.addAttribute("Model_Item",cartItemDtos);
        model.addAttribute("total",iShopingCartService.total());
        String action="Buy Success your bill id: "+ integer;
        model.addAttribute("ActionModel",action);
        System.out.println(action);
        return "cart";
    }


}
