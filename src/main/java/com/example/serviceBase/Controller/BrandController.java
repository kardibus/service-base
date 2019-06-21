package com.example.serviceBase.Controller;


import com.example.serviceBase.Entity.Brand;
import com.example.serviceBase.Repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class BrandController {
@Autowired
private BrandRepository brandRepository;

    @GetMapping("/brand")
    public String brandPage(Map<String,Object> model){
        Iterable<Brand> message=brandRepository.findAll();
        model.put("message",message);
        return "brand";
    }

    @PostMapping("/addBrand")
    public String addBrand(@RequestParam(name="brand") String brand, Map<String,Object> model){
        Brand brandData = new Brand(brand);
        brandRepository.save(brandData);
        Iterable<Brand>message=brandRepository.findAll();
        model.put("message",message);
        return "brand";
    }

    @PostMapping("/deleteBrand/{id}")
    public String deleteBrand(@PathVariable(value="id",required=false) Long id,Map<String,Object>model){
        brandRepository.deleteById(id);
        Iterable<Brand> message=brandRepository.findAll();
        model.put("message",message);
        return "brand";
    }

    @PostMapping("/updateBrand/{id}")
    public String updateBrand(@PathVariable(value = "id",required = false) Brand brandId,@RequestParam("brand") String brand, Map<String,Object>model){
        brandId.setBrand(brand);
        brandRepository.save(brandId);
        Iterable<Brand> message=brandRepository.findAll();
        model.put("message",message);
        return "brand";
    }
}
