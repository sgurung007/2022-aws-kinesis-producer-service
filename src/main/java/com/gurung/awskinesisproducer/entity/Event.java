package com.gurung.awskinesisproducer.entity;


import java.util.UUID;

/**
 * @author bir birs sgrg007@gmail.com
 * @project bir-microservices
 * @since 3/21/2022
 */

public class Event {
    private UUID id;

    private Order order;

    private String type;

    private String originator;

    public Event() {
    }

    public Event(Order order, String type, String originator) {
        this.order = order;
        this.type = type;
        this.originator = originator;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", order=" + order +
                ", type='" + type + '\'' +
                ", originator='" + originator + '\'' +
                '}';
    }
}
