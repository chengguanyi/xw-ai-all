package com.xuanwu.ai.exception;


public class FastRuntimeException  extends BaseRuntimeException{

    private static final long serialVersionUID = -4954118251735823026L;

    public FastRuntimeException(String msg) {
        super(msg);
    }

    public FastRuntimeException(String code , Object[] args){
        super(code, "",args);
    }

    public FastRuntimeException(String code , String defaultMsg , Object[] args){
        super(code,defaultMsg,args);
    }

    public FastRuntimeException(String code, String msg) {
        super(code, msg, new Object[0]);
    }

    public FastRuntimeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public FastRuntimeException(String code, String msg, Throwable cause) {
        super(code, msg, cause, new Object[0]);
    }

    /**
     * 只要那个自定义异常类型是真的不需要stack trace的，我也会推荐覆写fillInStackTrace()为直接返回this。
     * @return
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
