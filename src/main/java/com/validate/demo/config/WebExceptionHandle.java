package com.validate.demo.config;

import com.baomidou.mybatisplus.extension.api.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * WebExceptionHandle.
 *
 * @author shitianyu 2021-09-08 18:01
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class WebExceptionHandle extends ResponseEntityExceptionHandler {

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers,
                                                               HttpStatus status, WebRequest request) {
        log.error("接口参数校验异常:", ex);
        BindingResult bindingResult = ex.getBindingResult();
        String expMsg = bindingResult.getAllErrors().get(0).getDefaultMessage();
        R<String> result = R.failed(expMsg);
        return new ResponseEntity<>(result, headers, HttpStatus.OK);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("接口参数校验异常:", ex);
        R<String> result = R.failed(ex.getMessage());
        return new ResponseEntity<>(result, headers, HttpStatus.OK);
    }

}
