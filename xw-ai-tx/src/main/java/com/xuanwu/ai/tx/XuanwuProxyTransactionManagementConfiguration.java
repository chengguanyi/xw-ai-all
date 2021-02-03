package com.xuanwu.ai.tx;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration;
import org.springframework.transaction.interceptor.TransactionAttributeSource;

@Configuration
public class XuanwuProxyTransactionManagementConfiguration extends ProxyTransactionManagementConfiguration {

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public TransactionAttributeSource transactionAttributeSource() {
        return new XuanwuAnnotationTransactionAttributeSource();
    }
}
