package com.xuanwu.ai.tx;

import org.springframework.transaction.annotation.AnnotationTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionAttribute;

import java.lang.reflect.AnnotatedElement;

public class XuanwuAnnotationTransactionAttributeSource extends AnnotationTransactionAttributeSource {


    @Override
    protected TransactionAttribute determineTransactionAttribute(AnnotatedElement ae) {
        TransactionAttribute transactionAttribute = super.determineTransactionAttribute(ae);
        if(transactionAttribute != null){
            transactionAttribute = new XuanwuTransactionAttribute(transactionAttribute);
        }
        return transactionAttribute;
    }

}
