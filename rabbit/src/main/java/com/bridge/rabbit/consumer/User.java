package com.bridge.rabbit.consumer;

import com.bridge.rabbit.config.MessageConfig;
import com.bridge.rabbit.model.Order;
import com.bridge.rabbit.model.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {

    @RabbitListener(queues = MessageConfig.QUEUE_NAME)
    public void consumeMessage(OrderStatus orderStatus) {
        System.out.println("Message recived from queue" + orderStatus);
    }
}
