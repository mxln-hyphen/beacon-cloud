package com.mxln.beaconapi.filter.advice;


import com.mxln.beaconapi.filter.vo.R;
import com.mxln.beaconapi.filter.vo.ResultVO;
import com.mxln.beaconcommon.common.ApiException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResultVO apiException(ApiException ex){
        return R.error(ex);
    }
}
