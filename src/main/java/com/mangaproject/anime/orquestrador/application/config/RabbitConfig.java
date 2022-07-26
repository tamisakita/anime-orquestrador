package com.mangaproject.anime.orquestrador.application.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

//    @Bean
//    public Queue animeQueue() {
//        return new Queue("anime-project", true);
//    }
//
//    @Bean
//    DirectExchange exchange() {
//        return new DirectExchange("animes");
//    }
//
//    @Bean
//    Binding animeBinding(Queue animeQueue, DirectExchange exchange) {
//        return BindingBuilder.bind(animeQueue).to(exchange).with("anime-routing-key");
//    }


}

//package com.mangaproject.anime.orquestrador.application.config;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
//import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
//import org.springframework.context.annotation.Bean;
//import org.springframework.messaging.converter.MappingJackson2MessageConverter;
//import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
//import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;
//
//public class RabbitConfig implements RabbitListenerConfigurer {
//
//    @Override
//    public void configureRabbitListeners(RabbitListenerEndpointRegistrar register) {
//        register.setMessageHandlerMethodFactory(register.getMessageHandlerMethodFactory());
//    }
//
//    @Bean
//    MessageHandlerMethodFactory messageHandlerMethodFactory() {
//        DefaultMessageHandlerMethodFactory messageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory();
//        messageHandlerMethodFactory.setMessageConverter(consumerJackson2MessageConverter());
//        return messageHandlerMethodFactory;
//    }
//
//    @Bean
//    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
//        return new MappingJackson2MessageConverter();
//    }
//}
