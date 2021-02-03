package com.xuanwu.ai.filter;

import org.springframework.core.Ordered;

public class OrderedMdcFilter extends MdcFilter implements Ordered {

    private int order = Ordered.HIGHEST_PRECEDENCE + 200;

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
