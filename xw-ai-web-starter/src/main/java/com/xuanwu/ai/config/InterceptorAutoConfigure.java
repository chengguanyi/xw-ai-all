package com.xuanwu.ai.config;

import com.xuanwu.ai.Interceptor.PostHandleInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ConditionalOnClass(PostHandleInterceptor.class)
public class InterceptorAutoConfigure {

    @Configuration
    @ConditionalOnWebApplication
    @ConditionalOnClass(PostHandleInterceptor.class)
    @Order(0)
    protected static class PostHandlerInterceptorMvcConfigure implements WebMvcConfigurer {

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new PostHandleInterceptor());
        }
    }

}
