package com.example.coupon_service.service;

import com.example.coupon_service.exception.CouponNotFoundException;
import com.example.coupon_service.model.Coupon;
import com.example.coupon_service.model.CouponRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService{
    private final CouponRepo couponRepo;

    public CouponServiceImpl(CouponRepo couponRepo) {
        this.couponRepo = couponRepo;
    }


    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepo.findAll();
    }

    @Override
    public Coupon getCouponByCode(String code) {
        Coupon coupon = couponRepo.findByCode(code);
        if(coupon == null)
        {
            throw new CouponNotFoundException("Coupon:" + code + " not found");
        }
            return coupon;
    }

    @Override
    public Coupon createCoupon(Coupon coupon) {
        return couponRepo.save(coupon);
    }
}
