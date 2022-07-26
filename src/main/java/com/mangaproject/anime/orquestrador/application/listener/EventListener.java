package com.mangaproject.anime.orquestrador.application.listener;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class EventListener {

    public static final String EX_REGISTER_ANIME = "anime.save";
    public static final String ACTION_REGISTER_ANIME_RECORD = "send anime";

    //@RabbitListener(queues = EX_REGISTER_ANIME + "." + ACTION_REGISTER_ANIME_RECORD)
    public void listenerTest(String payLoad) {
        try {

        } catch (Throwable e) {
            log.error("Deu erro", e);
        }
    }
}
