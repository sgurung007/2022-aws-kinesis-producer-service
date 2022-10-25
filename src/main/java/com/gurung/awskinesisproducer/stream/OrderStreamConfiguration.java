package com.gurung.awskinesisproducer.stream;

import com.gurung.awskinesisproducer.entity.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author bir birs sgrg007@gmail.com
 * @project bir-microservices
 * @since 3/21/2022
 */
@Component
@Slf4j
public class OrderStreamConfiguration {
    @Bean
    public Consumer<Message<?>> processOrder(){
        return event -> {
//            log.info("Order from the kinesis stream: {}",event.getPayload());
            log.info(event.getHeaders().toString());
            log.info(event.getPayload().toString());
        };
    }

    private BlockingQueue<Event> orderEvent=new LinkedBlockingDeque<>();

    public void sendOrder(Event event){
        event.setId(UUID.randomUUID());
        this.orderEvent.offer(event);
        log.info("Event sent: {}",event.getOrder().toString());
    }

    @Bean
    public Supplier<Event> produceOrderSecond(){
        return ()->this.orderEvent.poll();
    }

}
