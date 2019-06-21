package com.example.serviceBase.Controller;

import com.example.serviceBase.Entity.Users;
import com.example.serviceBase.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class UsersController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String usersPage(Map<String,Object> model){
        Iterable<Users> message=userRepository.findAll();
        model.put("message",message);
        return "users";
    }

    @PostMapping("/addUsers")
    public String addUsers(@RequestParam(name="name") String name,
                           @RequestParam(name="surname")String surname,
                           @RequestParam(name="patronymic")String patronymic,
                           @RequestParam(name="numberOne")String numberOne,
                           @RequestParam(name="numberTwo")String numberTwo,
                           @RequestParam(name="numberThree")String numberThree,
                           Map<String,Object> model){
        Users usersData = new Users(name,surname,patronymic,numberOne,numberTwo,numberThree);
        userRepository.save(usersData);
        Iterable<Users>message=userRepository.findAll();
        model.put("message",message);
        return "users";
    }

    @PostMapping("/deleteUsers/{id}")
    public String deleteBrand(@PathVariable(value="id",required=false) Long id, Map<String,Object>model){
        userRepository.deleteById(id);
        Iterable<Users> message=userRepository.findAll();
        model.put("message",message);
        return "users";
    }

    @PostMapping("/updateUsers/{id}")
    public String updateBrand(@PathVariable(value = "id",required = false) Users usersId,
                              @RequestParam(name="name") String name,
                              @RequestParam(name="surname")String surname,
                              @RequestParam(name="patronymic")String patronymic,
                              @RequestParam(name="numberOne")String numberOne,
                              @RequestParam(name="numberTwo")String numberTwo,
                              @RequestParam(name="numberThree")String numberThree,
                              Map<String,Object>model){
        usersId.setName(name);
        usersId.setSurname(surname);
        usersId.setPatronymic(patronymic);
        usersId.setNumberOne(numberOne);
        usersId.setNumberTwo(numberTwo);
        usersId.setNumberThree(numberThree);
        userRepository.save(usersId);
        Iterable<Users> message=userRepository.findAll();
        model.put("message",message);
        return "users";
    }
}
