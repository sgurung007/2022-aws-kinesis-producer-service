package com.gurung.awskinesisconsumer.stream;

import com.gurung.awskinesisconsumer.entity.Event;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @author bir birs sgrg007@gmail.com
 * @project bir-microservices
 * @since 3/21/2022
 */
@Component
public class OrderStreamConfiguration {
    @Bean
    public Consumer<Event> processOrder(){
        return event -> {
            System.out.println("Order from the kinesis stream:");
            System.out.println(event.getOrder().toString());
        };
    }
}
