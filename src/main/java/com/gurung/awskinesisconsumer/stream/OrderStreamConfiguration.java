package com.gurung.awskinesisconsumer.stream;

import com.gurung.awskinesisconsumer.entity.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @author bir birs sgrg007@gmail.com
 * @project bir-microservices
 * @since 3/21/2022
 */
@Component
@Slf4j
public class OrderStreamConfiguration {
    @Bean
    public Consumer<Event> processOrder(){
        return event -> {
            log.info("Order from the kinesis stream:");
            log.info(event.getOrder().toString());
        };
    }
}
