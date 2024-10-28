package com.bridge.rabbit.publisher;


import com.bridge.rabbit.config.MessageConfig;
import com.bridge.rabbit.model.Order;
import com.bridge.rabbit.model.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
     private RabbitTemplate rabbitTemplate;

    @PostMapping("/{resturantname}")
    public String bookOder(@RequestBody Order order, @PathVariable String resturantname){
        order.setOrderId(UUID.randomUUID().toString());
        //resturantService
        //paymentService

        OrderStatus orderStatus=new OrderStatus(order,"progress","oder placed successsfully in"+resturantname);
        rabbitTemplate.convertAndSend(MessageConfig.EXCHANGE_NAME,MessageConfig.ROUTING_KEY,orderStatus);
        return "sucess";
    }

}
