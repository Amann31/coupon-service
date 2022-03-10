package com.example.coupon_service;

import com.example.coupon_service.model.Coupon;
import com.example.coupon_service.model.CouponRepo;
import com.example.coupon_service.service.CouponService;
import com.example.coupon_service.ui.ErrorResponseModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CouponServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponServiceApplication.class, args);
    }

    @Bean
    public ErrorResponseModel errorResponseModel()
    {
        return new ErrorResponseModel();
    }
}
