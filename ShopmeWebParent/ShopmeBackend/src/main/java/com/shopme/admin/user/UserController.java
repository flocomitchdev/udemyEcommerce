package com.shopme.admin.user;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        //creating empty user object
        User userObject = new User();

        //A new User is enabled by default
        userObject.setEnabled(true);

        // fetching data from repos
        List<Role> userRoles = userService.listAllROles();

        //building the user model for frontend injection
        userModel.addAttribute("user",userObject);
        userModel.addAttribute("roles", userRoles);
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes redirectAttributes){
        //saving the user in db
        userService.save(user);

        //transmitting an object to the redirected page
        redirectAttributes.addFlashAttribute("message", "The user has been saved successfully");

        //indicating the template to th
        return "redirect:/users";
    }
}
