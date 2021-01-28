package com.xuanwu.ai.exception;


/**
 * 远程调用异常
 */
public class RestException extends FastRuntimeException {

    public RestException(String code, String msg) {
        super(code, msg);
    }
}
