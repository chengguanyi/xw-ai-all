package com.xuanwu.ai.filter;

import org.springframework.core.Ordered;

public class OrderedHttpHeaderFilter extends HttpHeaderFilter implements Ordered {


    /**
     * 此filter必须在MdcFilter之前运行
     * @see
     */
    private int order = Ordered.HIGHEST_PRECEDENCE + 100;

    @Override
    public int getOrder() {
        return this.order;
    }

    /**
     * Set the order for this filter.
     * @param order the order to set
     */
    public void setOrder(int order) {
        this.order = order;
    }
}
