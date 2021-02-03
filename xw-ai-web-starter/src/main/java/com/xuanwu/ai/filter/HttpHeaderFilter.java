package com.xuanwu.ai.filter;

import com.xuanwu.ai.inter.WebConstants;
import com.xuanwu.ai.support.MyThreadContext;
import com.xuanwu.ai.util.UUIDShort;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpHeaderFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String traceId = request.getHeader(WebConstants.HEADER_FOR_TRACE_ID);
            if (StringUtils.isEmpty(traceId)) {
                traceId = UUIDShort.generate();
            }
            request.setAttribute(MyThreadContext.TRACE_ID, traceId);
            MyThreadContext.setTraceId(traceId);
            response.addHeader(WebConstants.HEADER_FOR_TRACE_ID, traceId);
            MyThreadContext.put(MyThreadContext.LOG_LEVEL, request.getHeader(WebConstants.HEADER_FOR_LOG_LEVEL));
            filterChain.doFilter(request, response);
        } finally {
            MyThreadContext.removeTraceId();
            MyThreadContext.remove(MyThreadContext.LOG_LEVEL);

        }

    }
}
