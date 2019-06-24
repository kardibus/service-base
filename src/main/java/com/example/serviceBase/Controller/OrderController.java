package com.example.serviceBase.Controller;

import com.example.serviceBase.Entity.Brand;
import com.example.serviceBase.Entity.Model;
import com.example.serviceBase.Entity.Order;
import com.example.serviceBase.Entity.Users;
import com.example.serviceBase.Repository.OrderRepository;
import com.example.serviceBase.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/order")
    public String orderPage(Map<String,Object> model) {
        Iterable<Order> message = orderRepository.findAll();
        Iterable<Users> messageUsers =userRepository.findAll();
        model.put("messageUsers",messageUsers);
        model.put("message", message);
        return "order";
    }

    @PostMapping("/addOrder")
    public String addOrder(@RequestParam(name="statusorder") String statusOrder,
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
        Iterable<Users> messageUsers =userRepository.findAll();
        model.put("messageUsers",messageUsers);
        model.put("message",message);
        return "order";
    }

    @PostMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable(value="id",required=false) Long id, Map<String,Object>model){
        orderRepository.deleteById(id);
        Iterable<Order> message=orderRepository.findAll();
        Iterable<Users> messageUsers =userRepository.findAll();
        model.put("messageUsers",messageUsers);
        model.put("message",message);
        return "order";
    }

    @PostMapping("/updateOrder/{id}")
    public String updateOrder(@PathVariable(value = "id",required = false)  Order orderId,
                              @RequestParam(name="price") int price,
                              @RequestParam(name="serialnumber")String serialnumber,
                              @RequestParam(name="about_repair")String about_repair,
                              @RequestParam(name="defects")String defects,
                              @RequestParam(name="date_Open")LocalDateTime date_Open,
                              @RequestParam(name="date_Close")LocalDateTime date_Close,
                              @RequestParam(name="users_id")Users users_id,
                              @RequestParam(name="model_id")Model model_id,
                              @RequestParam(name="brand_id")Brand brand_id,
                              @RequestParam(name="statusorder")String statusOrders,
                              Map<String,Object>model){
        orderId.setPrice(price);
        orderId.setSerialnumber(serialnumber);
        orderId.setAbout_repair(about_repair);
        orderId.setDefects(defects);
        orderId.setDate_Open(date_Open);
        orderId.setDate_Close(date_Close);
        orderId.setUsers_id(users_id);
        orderId.setModel_id(model_id);
        orderId.setBrand_id(brand_id);
        orderId.setStatusOrder(statusOrders);
        orderRepository.save(orderId);
        Iterable<Order> message=orderRepository.findAll();
        Iterable<Users> messageUsers =userRepository.findAll();
        model.put("messageUsers",messageUsers);
        model.put("message",message);
        return "order";
    }
}
