package com.example.coupon_service.controller;


import com.example.coupon_service.exception.CouponNotFoundException;
import com.example.coupon_service.model.Coupon;
import com.example.coupon_service.proxy.CouponGeneratorProxy;
import com.example.coupon_service.proxy.Generator;
import com.example.coupon_service.service.CouponService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
public class CouponController {

    private final CouponService couponService;
    private final Environment environment;
    private final CouponGeneratorProxy couponGeneratorProxy;

    public CouponController(CouponService couponService, Environment environment, CouponGeneratorProxy couponGeneratorProxy) {
        this.couponService = couponService;
        this.environment = environment;
        this.couponGeneratorProxy = couponGeneratorProxy;
    }


    @GetMapping("/status")
    public String getStatus() {
        return "coupon service is up and running on port " + environment.getProperty("local.server.port");
    }

    @GetMapping("/coupons/{code}")
    public Coupon findByCouponCode(@PathVariable("code") String code) {
        return couponService.getCouponByCode(code);
    }
    @PostMapping("/coupons")
    public Coupon createCoupon(@RequestBody Coupon coupon)
    {
        Generator generator=couponGeneratorProxy.generateCoupon();
        coupon.setCode(generator.getCouponCode());
        coupon.setDiscount(generator.getDiscount());
        return couponService.createCoupon(coupon);
    }
}
