package com.xuanwu.ai.exception;



import com.xuanwu.ai.util.ExceptionUtils;
import org.springframework.core.NestedRuntimeException;

import java.util.Date;

public class BaseRuntimeException extends NestedRuntimeException {

    private static final long serialVersionUID = -5889040288739122793L;

    private String code;
    private Date time;
    private String[] args;
    private String className;
    private String methodName;
    private String[] parameters;
    private boolean handled;
    private String i18nMessage;

    public BaseRuntimeException(String code, String defaultMessage, Object[] args) {
        super(defaultMessage);
        this.code = code;
        this.args = ExceptionUtils.convertArgsToString(args);
    }

    public BaseRuntimeException(String code, String defaultMessage, Throwable cause, Object[] args) {
        super(defaultMessage, cause);
        this.code = code;
        this.args = ExceptionUtils.convertArgsToString(args);
    }

    public BaseRuntimeException(String defaultMessage) {
        super(defaultMessage);
    }

    public BaseRuntimeException(String defaultMessage, Throwable cause) {
        super(defaultMessage, cause);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String[] getParameters() {
        return parameters;
    }

    public void setParameters(String[] parameters) {
        this.parameters = parameters;
    }

    public boolean isHandled() {
        return handled;
    }

    public void setHandled(boolean handled) {
        this.handled = handled;
    }

    public String getI18nMessage() {
        return i18nMessage;
    }

    public void setI18nMessage(String i18nMessage) {
        this.i18nMessage = i18nMessage;
    }
}
