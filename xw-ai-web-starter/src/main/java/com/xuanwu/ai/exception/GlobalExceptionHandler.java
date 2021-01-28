package com.xuanwu.ai.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    /**
     * 所有通用异常处理
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ErrorResponse defaultErrorHandler(HttpServletRequest request, Exception e) {
        log.error(e.getMessage(), e);
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.toString());
    }


    /**
     * 业务异常处理
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = FastRuntimeException.class)
    public ErrorResponse bizErrorHandler(HttpServletRequest request, FastRuntimeException e) {
        log.warn(e.getMessage(), e);
        return new ErrorResponse(e.getCode(), e.getMessage());
    }

    /**
     * 绑定参数错误处理
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    public ErrorResponse bindErrorHandler(HttpServletRequest request, BindException e) {
        log.warn(e.getMessage(), e);
        return new ErrorResponse(HttpStatus.BAD_REQUEST.toString(), e.getMessage());
    }

    /**
     * 处理请求对象属性不满足校验规则的异常信息
     *
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ErrorResponse exception(HttpServletRequest request, MethodArgumentNotValidException e) {
        log.warn(e.getMessage(), e);
        String message = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining("\n"));
        return new ErrorResponse(HttpStatus.BAD_REQUEST.toString(), message);
    }

    /**
     * 处理请求单个参数不满足校验规则的异常信息
     *
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = ValidationException.class)
    public ErrorResponse constraintViolationExceptionHandler(HttpServletRequest request, ValidationException e) {
        log.warn(e.getMessage(), e);
        return new ErrorResponse(HttpStatus.BAD_REQUEST.toString(), e.getMessage());
    }


}
