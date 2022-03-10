package com.example.coupon_service.exception;

public class CouponNotFoundException extends RuntimeException {
    private String message;

    public CouponNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
