package com.imooc.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by Qinyi.
 */
@EnableFeignClients     //
@EnableCircuitBreaker //
@EnableEurekaClient  //便于检测
@SpringBootApplication
public class SponsorApplication {

    public static void main(String[] args) {

        SpringApplication.run(SponsorApplication.class, args);
    }
}
