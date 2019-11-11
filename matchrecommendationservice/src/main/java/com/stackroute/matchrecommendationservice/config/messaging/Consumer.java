package com.stackroute.matchrecommendationservice.config.messaging;


import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stackroute.matchrecommendationservice.domain.dto.RecommendationDTO;
import com.stackroute.matchrecommendationservice.service.IRecommendationService;


@Component
public class Consumer {

    @Autowired
    private IRecommendationService recommendationService;
    
    @Autowired
    private AmqpAdmin amqpAdmin;
    
    public Consumer(IRecommendationService recommendationService, AmqpAdmin amqpAdmin) {
    	this.recommendationService = recommendationService;
    	this.amqpAdmin = amqpAdmin;
    }
    
    @PostConstruct
    public void createQueues() {
        amqpAdmin.declareQueue(new Queue("add_recommended_cric_match_queue", false));
        amqpAdmin.declareQueue(new Queue("delete_recommended_cric_match_queue", false));
    }
    

    @RabbitListener(queues = "add_recommended_cric_match_queue")
    public void addRecommendationMatch(RecommendationDTO recommendationDTO) {
    	recommendationService.addRecommendationMatch(recommendationDTO.getMatchId());
    }
    
    @RabbitListener(queues = "delete_recommended_cric_match_queue")
    public void updateRecommendationMatch(RecommendationDTO recommendationDTO) {
    	recommendationService.updateRecommendationMatch(recommendationDTO.getMatchId());
    }

}
