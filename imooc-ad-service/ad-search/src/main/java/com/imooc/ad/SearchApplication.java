package com.imooc.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Qinyi.
 */
@EnableFeignClients //注册客户端存在
@EnableEurekaClient //客户端
@EnableHystrix  //断路器
@EnableCircuitBreaker //断路器
@EnableDiscoveryClient //发现
@EnableHystrixDashboard //熔断器的
@SpringBootApplication
public class SearchApplication {

    public static void main(String[] args) {

        SpringApplication.run(SearchApplication.class, args);
    }

    @Bean
    @LoadBalanced  //springCloud负载均衡注解
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
