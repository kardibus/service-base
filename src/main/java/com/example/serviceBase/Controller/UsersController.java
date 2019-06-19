package com.example.serviceBase.Controller;

import com.example.serviceBase.Entity.Users;
import com.example.serviceBase.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String userPage(@RequestParam(name="name",required = false,defaultValue = "World")String name, Model model){
        Iterable<Users> message=userRepository.findAll();
        model.addAttribute("message",message);
        return "users";
    }
}
