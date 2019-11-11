package com.stackroute.userservice.messaging;


import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stackroute.userservice.domain.dto.UserDTO;
import com.stackroute.userservice.domain.model.User;
import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.service.IUserService;


@Component
public class Consumer {

    @Autowired
    private IUserService userService;
    
    @Autowired
    private AmqpAdmin amqpAdmin;
    
    public Consumer(IUserService userService, AmqpAdmin amqpAdmin) {
    	this.userService = userService;
    	this.amqpAdmin = amqpAdmin;
    }
    
    @PostConstruct
    public void createQueues() {
    	amqpAdmin.declareQueue(new Queue("user_queue", false));
    }

    @RabbitListener(queues = "user_queue")
    public void registerUser(UserDTO userDTO) throws UserAlreadyExistsException {
    	User user = new User();
        BeanUtils.copyProperties(userDTO, user);
    	userService.saveUser(user);
    }
}
