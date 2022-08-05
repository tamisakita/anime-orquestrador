package com.mangaproject.anime.orquestrador.application.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMqListener {

    @RabbitListener(queues = {"anime.out"})
    public void returnMessage(@Payload String message) {
        try {
            System.out.println(message);
        } catch (Throwable e) {
            log.error("Could not receive the message", e);
        }
    }

}
