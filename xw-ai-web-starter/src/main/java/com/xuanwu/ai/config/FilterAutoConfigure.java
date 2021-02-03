package com.xuanwu.ai.config;

import com.xuanwu.ai.properties.CorsProperties;
import com.xuanwu.ai.filter.HttpHeaderFilter;
import com.xuanwu.ai.filter.MdcFilter;
import com.xuanwu.ai.filter.OrderedHttpHeaderFilter;
import com.xuanwu.ai.filter.OrderedMdcFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
@ConditionalOnClass({HttpHeaderFilter.class, MdcFilter.class})
@EnableConfigurationProperties({CorsProperties.class})
public class FilterAutoConfigure {

    @Bean
    @ConditionalOnMissingBean(HttpHeaderFilter.class)
    public OrderedHttpHeaderFilter traceIdFilter() {
        return new OrderedHttpHeaderFilter();
    }

    @Bean
    @ConditionalOnMissingBean(MdcFilter.class)
    public OrderedMdcFilter mdcFilter() {
        return new OrderedMdcFilter();
    }

//    @Bean
//    @ConditionalOnMissingBean(UserContextFilter.class)
//    public OrderedUserContextFilter userContextFilter(){
//        return new OrderedUserContextFilter();
//    }


    /**
     * example for init by FilterResgitrationBean
     * @param servletContext
     * @return
     * @throws ServletException
     */
    public FilterRegistrationBean filterRegistrationBean(ServletContext servletContext) throws ServletException {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.onStartup(servletContext);
        return registrationBean;
    }

    /**
     * example for init by ServletRegistrationBean
     * @return
     */
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        return servletRegistrationBean;
    }


}
