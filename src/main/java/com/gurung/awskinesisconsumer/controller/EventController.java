package com.gurung.awskinesisconsumer.controller;


import com.gurung.awskinesisconsumer.entity.Event;
import com.gurung.awskinesisconsumer.entity.Order;
import com.gurung.awskinesisconsumer.stream.OrderStreamConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bir birs sgrg007@gmail.com
 * @project bir-microservices
 * @since 3/21/2022
 */
@RestController
@RequestMapping("/aws-kinesis-producer")
public class EventController {
    @Value("${originator}")
    private String originator;

    private final OrderStreamConfiguration awsKinesisProdcuer;

    public EventController(OrderStreamConfiguration awsKinesisProdcuer) {
        this.awsKinesisProdcuer = awsKinesisProdcuer;
    }

    @PostMapping("/send-event")
    public void sendEvent(@RequestBody Order order){
        awsKinesisProdcuer.sendOrder(new Event(order,"ORDER",originator));
    }
}
