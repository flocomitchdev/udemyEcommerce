package com.shopme.admin.user;

import com.shopme.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String showListUsers(Model userModel){
        List<User> listUsers = userService.listAllUsers();
        userModel.addAttribute("listUsers", listUsers);
        return "users";
    }

    @GetMapping("/users/new")
    public String addUserTest(Model userModel){
        User user = new User();
        userModel.addAttribute("user",user);
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user){
        System.out.println(user.toString());
        userService.save(user);
        return "redirect:/users";
    }
}
