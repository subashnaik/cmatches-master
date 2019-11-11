package com.stackroute.favouriteservice.config.messaging;


import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stackroute.favouriteservice.domain.dto.RecommendationDTO;
import com.stackroute.favouriteservice.domain.dto.UserDTO;

@Component
public class Producer {

    private RabbitTemplate rabbitTemplate;
    private DirectExchange exchange;

    @Autowired
    public Producer(RabbitTemplate rabbitTemplate, DirectExchange exchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
    }
    
    public void registerUser(UserDTO userDTO){
        rabbitTemplate.convertAndSend(exchange.getName(), "user_route", userDTO);
    }

    public void addRecommendationMatch(RecommendationDTO recommendationDTO){
        rabbitTemplate.convertAndSend(exchange.getName(), "add_recommendation_cric_match_route", recommendationDTO);
    }
    
    public void updateRecommendationMatch(RecommendationDTO recommendationDTO){
        rabbitTemplate.convertAndSend(exchange.getName(), "delete_recommendation_cric_match_route", recommendationDTO);
    }
}
