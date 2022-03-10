package com.example.coupon_service.exception;


import com.example.coupon_service.ui.ErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CouponControllerExceptionHandler {
    private final ErrorResponseModel errorResponseModel;

    @Autowired
    public CouponControllerExceptionHandler(ErrorResponseModel errorResponseModel) {
        this.errorResponseModel = errorResponseModel;
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseModel> handleUserNotFoundException(CouponNotFoundException e) {
        errorResponseModel.setErrorMessage(e.getMessage());
        errorResponseModel.setErrorTime(System.currentTimeMillis());
        errorResponseModel.setErrorCode(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseModel);
    }

}
