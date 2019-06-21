package com.example.serviceBase.Controller;

import com.example.serviceBase.Entity.Brand;
import com.example.serviceBase.Entity.Model;
import com.example.serviceBase.Entity.Order;
import com.example.serviceBase.Entity.Users;
import com.example.serviceBase.Repository.OrderRepository;
import com.example.serviceBase.Repository.StatusOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/order")
    public String orderPage(Map<String,Object> model) {
        Iterable<Order> message = orderRepository.findAll();
        model.put("message", message);
        return "order";
    }

    @PostMapping("/addOrder")
    public String addUsers(@RequestParam(name="price") Set<StatusOrder> statusOrder,
                           @RequestParam(name="price") int price,
                           @RequestParam(name="serialnumber")String serialnumber,
                           @RequestParam(name="about_repair")String about_repair,
                           @RequestParam(name="defects")String defects,
                           @RequestParam(name="date_Open") LocalDateTime date_Open,
                           @RequestParam(name="date_Close")LocalDateTime date_Close,
                           @RequestParam(name="users_id")Users users_id,
                           @RequestParam(name="model_id") Model model_id,
                           @RequestParam(name="brand_id") Brand brand_id,
                           Map<String,Object> model){
        Order orderData = new Order(statusOrder,price,serialnumber,about_repair,defects,date_Open,date_Close,users_id,model_id,brand_id);
        orderRepository.save(orderData);
        Iterable<Order>message=orderRepository.findAll();
        model.put("message",message);
        return "order";
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
