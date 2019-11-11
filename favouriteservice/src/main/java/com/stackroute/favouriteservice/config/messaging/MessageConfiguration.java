package com.stackroute.favouriteservice.config.messaging;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {

	private static final String exchangeName = "user_exchange";
	private static final String addUserQueue = "user_queue";
	private static final String addRecommendedCricMatchQueue = "add_recommended_cric_match_queue";
	private static final String deleteRecommendedCricMatchQueue = "delete_recommended_cric_match_queue";

	@Bean
	DirectExchange directExchange() {
		return new DirectExchange(exchangeName);
	}

	@Bean
	Queue queueAddUser() {
		return new Queue(addUserQueue, false);
	}

	@Bean
	Queue queueAddRecommendedCricMatch() {
		return new Queue(addRecommendedCricMatchQueue, false);
	}

	@Bean
	Queue queueDeleteRecommendedCricMatch() {
		return new Queue(deleteRecommendedCricMatchQueue, false);
	}

	@Bean
	Binding bindingUser(Queue queueAddUser, DirectExchange directExchange) {
		return BindingBuilder.bind(queueAddUser()).to(directExchange).with("user_route");
	}

	@Bean
	Binding bindingAddRecommendationMatch(Queue queueAddRecommendedCricMatch, DirectExchange directExchange) {
		return BindingBuilder.bind(queueAddRecommendedCricMatch()).to(directExchange)
				.with("add_recommendation_cric_match_route");
	}

	@Bean
	Binding bindingDeleteRecommendationMatch(Queue queueDeleteRecommendedCricMatch, DirectExchange directExchange) {
		return BindingBuilder.bind(queueDeleteRecommendedCricMatch()).to(directExchange)
				.with("delete_recommendation_cric_match_route");
	}

	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
		return rabbitTemplate;
	}
}
