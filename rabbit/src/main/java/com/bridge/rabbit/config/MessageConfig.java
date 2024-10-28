package com.bridge.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {
    public static final String QUEUE_NAME="rabbit";
    public static final String EXCHANGE_NAME="exchange";
    public static final String ROUTING_KEY="rotkey";

    @Bean
    public Queue queue(){
        return new Queue(QUEUE_NAME);
    }
    @Bean
    public TopicExchange topicExchange(){
         return new TopicExchange(EXCHANGE_NAME);

    }

    @Bean
    public Binding binding(Queue queue,TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with(ROUTING_KEY);

    }
   @Bean
    public MessageConverter messageConverter(){
        return  new Jackson2JsonMessageConverter();
    }

    public AmqpTemplate template(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());

        return  rabbitTemplate;

    }




}
