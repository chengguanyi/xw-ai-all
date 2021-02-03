package com.xuanwu.ai.views;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xuanwu.ai.support.MyThreadContext;
import org.springframework.http.HttpStatus;


public class ResponseVo<T> {

    private String code = String.valueOf(HttpStatus.OK.value());
    private String message = "success";
    private T data;
    private String traceId;
    private long timestamp = System.currentTimeMillis();

    public ResponseVo(){}

    public ResponseVo(T data){
        this.data = data;
    }

    public ResponseVo(T data, String message){
        this.data = data;
        this.message = message;
    }


    public static <T> ResponseVo<T> success(){
        return new ResponseVo<>();
    }

    public static <T> ResponseVo<T> success(T data){
        return new ResponseVo<>(data);
    }

    public static <T> ResponseVo<T> fail(String code) {
        ResponseVo<T> responseVo = new ResponseVo<>();
        responseVo.code = code;
        responseVo.message = "fail";
        return responseVo;
    }
    public static <T> ResponseVo<T> fail(String code, String message) {
        ResponseVo<T> responseVo = new ResponseVo<>();
        responseVo.code = code;
        responseVo.message = message;
        return responseVo;
    }
    public static <T> ResponseVo<T> fail(String code, T data, String message) {
        ResponseVo<T> responseVo = new ResponseVo<>(data, message);
        responseVo.code = code;
        return responseVo;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public String getTraceId() {
        traceId = MyThreadContext.getTraceId();
        return traceId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return null != this.getCode() && String.valueOf(HttpStatus.OK.value()).equals(this.getCode());
    }

}
