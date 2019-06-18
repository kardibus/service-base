package com.example.serviceBase.Controller;


import com.example.serviceBase.Entity.Brand;
import com.example.serviceBase.Repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class BrandController {
@Autowired
private BrandRepository brandRepository;

    @GetMapping("/")
    public String brandpage(@RequestParam(name="name",required = false,defaultValue = "World")String name, Model model){
        Iterable<Brand> message=brandRepository.findAll();
       // String brand="Nokia";
       // Brand brand1=new Brand(brand);
      //  brandRepository.save(brand1);
        model.addAttribute("message",message);
        return "brand";
    }

}
