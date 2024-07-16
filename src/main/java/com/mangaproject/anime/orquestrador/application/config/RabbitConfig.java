package com.mangaproject.anime.orquestrador.application.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Value("${spring.rabbitmq.queue}")
    private String queueAnime;

//    @Value("${spring.rabbitmq.queue.list}")
//    private String queueAnimeList;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingKey}")
    private String routingKey;

//    @Value("${spring.rabbitmq.routingKeyList}")
//    private String routingKeyList;

    @Bean
    public Queue queue() {
        return new Queue(queueAnime, true);
    }

//    @Bean
//    public Queue animeListQueue() {
//        return new Queue(queueAnimeList, true);
//    }

    @Bean
    public DirectExchange exchangeDirect() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Binding bindingAnimeQueue(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

//    @Bean
//    public Binding bindingAnimeListQueue(Queue animeListQueue, DirectExchange exchange) {
//        return BindingBuilder.bind(animeListQueue).to(exchange).with(routingKeyList);
//    }
}
