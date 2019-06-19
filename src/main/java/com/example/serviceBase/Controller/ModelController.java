package com.example.serviceBase.Controller;

import com.example.serviceBase.Repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ModelController {
    @Autowired
    private ModelRepository modelRepository;

    @GetMapping("/model")
    public String modelPage(@RequestParam(name="name",required = false,defaultValue = "World")String name, Model model){
        Iterable<com.example.serviceBase.Entity.Model> message=modelRepository.findAll();
        model.addAttribute("message",message);
        return "model";
    }
}
