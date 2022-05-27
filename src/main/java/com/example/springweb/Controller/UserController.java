package com.example.springweb.Controller;

import com.example.springweb.Reponsitory.IUserReponsitory;
import com.example.springweb.Service.IAttachmentService;
import com.example.springweb.Service.imp.UserService;
import com.example.springweb.dto.UserDto;
import com.example.springweb.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

      @Autowired
      UserService userService;

      @Autowired
    IAttachmentService iAttachmentService;

      @Autowired
      IUserReponsitory iUserReponsitory;

    @GetMapping(value = "/user")
    public String userInformation(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByName(auth.getName());
        UserEntity user = UserEntity.builder().userId(userDto.getUserId())
                        .userName(userDto.getUserName()).build();
        model.addAttribute("UserModel",user);
        return "User";
    }
    @PostMapping(value = "/user/upload")
    public ModelAndView UploadAvatar(@RequestParam("file") MultipartFile file){
      String path= iAttachmentService.storeFile(file);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = iUserReponsitory.findAllByUserName(auth.getName());
        user.setAvatar(path);
        iUserReponsitory.save(user);
        return new ModelAndView("redirect:/user");
    }
}
