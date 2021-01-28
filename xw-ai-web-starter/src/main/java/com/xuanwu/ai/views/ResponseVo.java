package com.xuanwu.ai.views;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public class ResponseVo<T> {

    private Integer code = HttpStatus.OK.value();
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

    public static <T> ResponseVo<T> fail(Integer code) {
        ResponseVo<T> responseVo = new ResponseVo<>();
        responseVo.code = code;
        responseVo.message = "fail";
        return responseVo;
    }
    public static <T> ResponseVo<T> fail(Integer code, String message) {
        ResponseVo<T> responseVo = new ResponseVo<>();
        responseVo.code = code;
        responseVo.message = message;
        return responseVo;
    }
    public static <T> ResponseVo<T> fail(Integer code, T data, String message) {
        ResponseVo<T> responseVo = new ResponseVo<>(data, message);
        responseVo.code = code;
        return responseVo;
    }

    public static void main(String[] args) {
        System.out.println(new ResponseVo<>());
    }

}
