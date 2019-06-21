package com.example.serviceBase.Controller;

import com.example.serviceBase.Entity.Model;
import com.example.serviceBase.Repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class ModelController {
    @Autowired
    private ModelRepository modelRepository;

    @GetMapping("/model")
    public String modelPage(Map<String,Object>model){
        Iterable<Model> message=modelRepository.findAll();
        model.put("message",message);
        return "model";
    }

    @PostMapping("/addModel")
    public String addModel(@RequestParam String modelApp, Map<String,Object> model){
        Model modelData = new Model(modelApp);
        modelRepository.save(modelData);
        Iterable<Model>message=modelRepository.findAll();
        model.put("message",message);
        return "model";
    }

    @PostMapping("/deleteModel/{id}")
    public String deleteModel(@PathVariable(value="id",required=false) Long id, Map<String,Object>model){
        modelRepository.deleteById(id);
        Iterable<Model> message=modelRepository.findAll();
        model.put("message",message);
        return "model";
    }

    @PostMapping("/updateModel/{id}")
    public String updateModel(@PathVariable(value = "id",required = false) Model modelId, @RequestParam("model") String modelApp, Map<String,Object>model){
        modelId.setModel(modelApp);
        modelRepository.save(modelId);
        Iterable<Model> message=modelRepository.findAll();
        model.put("message",message);
        return "model";
    }
}
