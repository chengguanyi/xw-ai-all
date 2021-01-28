package com.xuanwu.ai.views;

import com.xuanwu.ai.exception.RestException;
import org.springframework.util.Assert;

public class ResponseHelper {

    /**
     * ResponseVo 处理
     * @param responseVo
     * @param <T>
     * @return data
     * @throws NullPointerException
     */
    public static <T> T of(ResponseVo<T> responseVo) throws RestException, IllegalArgumentException {
        Assert.notNull(responseVo, "responseVo can not null");
        if (!responseVo.isSuccess()) {
            throw new RestException(responseVo.getCode(), responseVo.getMessage());
        }
        return responseVo.getData();
    }

}
