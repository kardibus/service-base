package com.example.serviceBase.Controller;

import com.example.serviceBase.Entity.Order;
import com.example.serviceBase.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/order")
    public String orderPage(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        Iterable<Order> message = orderRepository.findAll();
        model.addAttribute("message", message);
        return "order";

    }
}
