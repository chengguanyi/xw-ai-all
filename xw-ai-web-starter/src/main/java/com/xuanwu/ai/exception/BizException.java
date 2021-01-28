package com.xuanwu.ai.exception;

public class BizException extends FastRuntimeException {

    public BizException(String msg) {
        super(msg);
    }

    public BizException(String code, String msg) {
        super(code, msg);
    }

    public BizException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BizException(String code, String msg, Throwable cause) {
        super(code, msg, cause);
    }

}
