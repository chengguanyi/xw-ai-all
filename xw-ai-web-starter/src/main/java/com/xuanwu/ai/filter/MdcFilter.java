package com.xuanwu.ai.filter;

import ch.qos.logback.classic.helpers.MDCInsertingServletFilter;
import com.xuanwu.ai.support.MyThreadContext;
import org.slf4j.MDC;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MdcFilter extends MDCInsertingServletFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
            MDC.put(MyThreadContext.MDC_LOG_LEVEL, (String) MyThreadContext.get(MyThreadContext.LOG_LEVEL));
            MDC.put(MyThreadContext.MDC_TRACE_ID, MyThreadContext.getTraceId());

            try {
                super.doFilter(request, response, chain);
            } finally {
                MDC.remove(MyThreadContext.MDC_TRACE_ID);
                MDC.remove(MyThreadContext.MDC_LOG_LEVEL);
            }
        } else {
            throw new ServletException("Only Http request supported.");
        }

    }
}
