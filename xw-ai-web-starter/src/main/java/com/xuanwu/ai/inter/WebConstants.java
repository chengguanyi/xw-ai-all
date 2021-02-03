package com.xuanwu.ai.inter;

public interface WebConstants {

    String HEADER_FOR_TRACE_ID = "X-TRACE-ID";

    String HEADER_FOR_USER_TOKEN = "X-USER-TOKEN";
    /**
     * 请求调用方应用名
     */
    String HEADER_FOR_REQ_NAME = "X-REQ-NAME";

    /**
     * 用户id
     */
    String HEADER_FOR_USER_ID = "X-USER-ID";
    /**
     * 用户名
     */
    String HEADER_FOR_USER_NAME = "X-USER-NAME";
    /**
     * 用户电话
     */
    String HEADER_FOR_USER_MOBILE = "X-USER-MOBILE";
    /**
     * 日志级别
     */
    String HEADER_FOR_LOG_LEVEL = "X-LOG-LEVEL";

    String HEADER_FOR_SYSTEM_TYPE = "X-SYSTEM-TYPE";

    /**
     *  保存subject到request  attribute中
     */
    String REQUEST_ATTR_FOR_SUBJECT = "REQ-ATTR-FOR-SUBJECT";


}
