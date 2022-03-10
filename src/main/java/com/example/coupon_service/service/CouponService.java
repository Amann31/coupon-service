package com.example.coupon_service.service;

import com.example.coupon_service.model.Coupon;

import java.util.List;

public interface CouponService {

    public List<Coupon> getAllCoupons();

    public Coupon getCouponByCode(String code);

    public Coupon createCoupon(Coupon coupon);
}
