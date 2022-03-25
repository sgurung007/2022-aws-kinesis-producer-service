package com.gurung.awskinesisconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AwsKinesisConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsKinesisConsumerApplication.class, args);
	}


}
