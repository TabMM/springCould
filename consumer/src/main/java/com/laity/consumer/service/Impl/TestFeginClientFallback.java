package com.laity.consumer.service.Impl;

import com.laity.consumer.service.TestFeignClient;
import com.laity.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author D.F Douglas
 * @version 1.0.0
 * @ClassName TestFeginClientFallback
 * @Description Feign Api 调用 出错回调处理
 * @createTime 2019/11/16/16:24
 */
@Component
public class TestFeginClientFallback implements TestFeignClient {
    @Override
    public String test(String user,int count) {
        return "超时";
    }

    @Override
    public String user(User e) {
        return "超时";
    }
}
