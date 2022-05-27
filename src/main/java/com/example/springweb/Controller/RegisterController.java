package com.example.springweb.Controller;

import com.example.springweb.Reponsitory.IUserReponsitory;
import com.example.springweb.Reponsitory.RoleRepository;
import com.example.springweb.entity.RoleEntity;
import com.example.springweb.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class RegisterController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    IUserReponsitory iUserReponsitory;

    @Autowired
    RoleRepository roleRp;
   @GetMapping(value = "/register")
    public String createNewAccount(){

       return "regiter";
   }
   @PostMapping("/register")
    public ModelAndView newAccount(@RequestParam String email ,@RequestParam String fullName,@RequestParam String address,@RequestParam String phoneNumber,@RequestParam String userName,@RequestParam String passWord){
       UserEntity user =new UserEntity();
       user.setAddress(address);
       user.setPassWord(passwordEncoder.encode(passWord));
       user.setFullName(fullName);
       user.setPhoneNumber(phoneNumber);
       user.setEmail(email);
       user.setUserName(userName);
       Set<RoleEntity> roleEntities=new HashSet<>();
       List<RoleEntity> role =roleRp.findAllByName("ROLE_USER");
       roleEntities.add(role.get(0));
       user.setRoleEntities(roleEntities);
       iUserReponsitory.save(user);
       System.out.println(user.toString());
        return new ModelAndView("redirect:/login");
   }

}
