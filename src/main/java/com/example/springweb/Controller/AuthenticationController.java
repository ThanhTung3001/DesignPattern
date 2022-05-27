package com.example.springweb.Controller;

import com.example.springweb.Reponsitory.IUserReponsitory;
import com.example.springweb.Service.IUserService;
import com.example.springweb.Service.imp.MailService;
import com.example.springweb.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = {"/authentication"})
public class AuthenticationController {
    @Autowired
    IUserService service;
    @Autowired
    MailService mailSender;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    IUserReponsitory userReponsitory;
    @GetMapping()
    public String ForgetPassword(){

        return "forgot";
    }
    @PostMapping(value = "/SendEmail")
    public String Send (@RequestParam String email, Model model){
        model.addAttribute("Message","Check your email");
        SimpleMailMessage message = new SimpleMailMessage();
        UserEntity user = service.findUserByEmail(email);
        if(user!=null){
            String htmlSend =String.format("<a href=\"http://localhost:8081/authentication/ChangePassword/%s\">Forgot password</a>", user.getToken());

            mailSender.Sendmail("Forgot password",email,htmlSend);
            System.out.println("Send mail success");
        }else{
            model.addAttribute("Message","Email not exits");
        }

        return "forgot";
    }
    @GetMapping(value = {"/ChangePassword/{token}"})
    public String ChangePassword(@PathVariable String token,Model model){
        model.addAttribute("Token",token);
        return "ChangePassword";
    }
    @PostMapping(value = {"/Change/{token}"})
    public ModelAndView ChangePasswordPost(@PathVariable String token, @RequestParam String password, Model model){
           UserEntity user = service.findUserByToken(token);
           if(user==null){
               model.addAttribute("Message","Change password fail");
               return new ModelAndView("redirect:/authentication");

           }else{
               user.setPassWord(passwordEncoder.encode(password));
               user.setToken(user.createToken());
               userReponsitory.save(user);
               model.addAttribute("Message","Change password Success");
               return new ModelAndView("redirect:/login");
           }

    }
}
