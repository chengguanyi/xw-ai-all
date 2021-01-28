package com.xuanwu.ai.exception;


import com.xuanwu.ai.support.MyThreadContext;

public class ErrorResponse {

    private String code;
    private String message;
    private String traceId;
    private long timestamp = System.currentTimeMillis();

    public ErrorResponse() {}

    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTraceId() {
        traceId = MyThreadContext.getTraceId();
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}
