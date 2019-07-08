package com.example.serviceBase.Controller;

import com.example.serviceBase.Entity.Brand;
import com.example.serviceBase.Entity.Model;
import com.example.serviceBase.Entity.Order;
import com.example.serviceBase.Entity.Users;
import com.example.serviceBase.Repository.BrandRepository;
import com.example.serviceBase.Repository.ModelRepository;
import com.example.serviceBase.Repository.OrderRepository;
import com.example.serviceBase.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private BrandRepository brandRepository;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @GetMapping("/order")
    public String orderPage(Map<String,Object> model) {

        Iterable<Order> message = orderRepository.findAll();
        Iterable<Users> messageUsers =userRepository.findAll();
        Iterable<Model> messageModel =modelRepository.findAll();
        Iterable<Brand> messageBrand =brandRepository.findAll();

        model.put("messageBrand",messageBrand);
        model.put("messageModel",messageModel);
        model.put("messageUsers",messageUsers);
        model.put("message", message);

        return "order";
    }

    @PostMapping("/addOrder")
    public String addOrder(@RequestParam int price,
                           @RequestParam String serialnumber,
                           @RequestParam String about_repair,
                           @RequestParam String defects,
                           @RequestParam ("date_Open") String date_Open,
                           @RequestParam ("date_Close") String date_Close,
                           @RequestParam(name="users_id") Users users_id,
                           @RequestParam(name="model_id")Model model_id,
                           @RequestParam(name="brand_id") Brand brand_id,
                           @RequestParam String statusOrder,
                           Map<String,Object> model){


        Timestamp dateOpen= Timestamp.valueOf(date_Open);
        Timestamp dateClose= Timestamp.valueOf(date_Close);

        Order orderData = new Order(statusOrder,price,serialnumber,about_repair,defects, dateOpen,dateClose,users_id,model_id,brand_id);
        orderRepository.save(orderData);

        Iterable<Order>message=orderRepository.findAll();
        Iterable<Users> messageUsers =userRepository.findAll();
        Iterable<Model> messageModel =modelRepository.findAll();
        Iterable<Brand> messageBrand =brandRepository.findAll();
        model.put("messageBrand",messageBrand);
        model.put("messageModel",messageModel);
        model.put("messageUsers",messageUsers);
        model.put("message",message);
        return "order";
    }

    @PostMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable(value="id",required=false) Long id, Map<String,Object>model){
        orderRepository.deleteById(id);

        Iterable<Order> message=orderRepository.findAll();
        Iterable<Users> messageUsers =userRepository.findAll();
        Iterable<Model> messageModel =modelRepository.findAll();
        Iterable<Brand> messageBrand =brandRepository.findAll();

        model.put("messageBrand",messageBrand);
        model.put("messageModel",messageModel);
        model.put("messageUsers",messageUsers);
        model.put("message",message);

        return "order";
    }

    @PostMapping("/updateOrder/{id}")
    public String updateOrder(@PathVariable(value = "id",required = false)  Order orderId,
                              @RequestParam int price,
                              @RequestParam String serialnumber,
                              @RequestParam String about_repair,
                              @RequestParam(name="defects")String defects,
                              @RequestParam ("date_Open") String date_Open,
                              @RequestParam ("date_Close") String date_Close,
                              @RequestParam(name="users_id")Users users_id,
                              @RequestParam(name="model_id")Model model_id,
                              @RequestParam(name="brand_id")Brand brand_id,
                              @RequestParam (name = "statusOrder") String statusOrders,
                              Map<String,Object>model){


        Timestamp dateOpen= Timestamp.valueOf(date_Open);
        Timestamp dateClose= Timestamp.valueOf(date_Close);

        orderId.setPrice(price);
        orderId.setSerialnumber(serialnumber);
        orderId.setAbout_repair(about_repair);
        orderId.setDefects(defects);
        orderId.setDate_Open(dateOpen);
        orderId.setDate_Close(dateClose);
        orderId.setUsers_id(users_id);
        orderId.setModel_id(model_id);
        orderId.setBrand_id(brand_id);
        orderId.setStatusOrder(statusOrders);
        orderRepository.save(orderId);

        Iterable<Order> message=orderRepository.findAll();
        Iterable<Users> messageUsers =userRepository.findAll();
        Iterable<Model> messageModel =modelRepository.findAll();
        Iterable<Brand> messageBrand =brandRepository.findAll();

        model.put("messageBrand",messageBrand);
        model.put("messageModel",messageModel);
        model.put("messageUsers",messageUsers);
        model.put("message",message);

        return "order";
    }
}
