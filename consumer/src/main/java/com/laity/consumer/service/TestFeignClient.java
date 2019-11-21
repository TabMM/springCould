package com.laity.consumer.service;

import com.laity.consumer.service.Impl.TestFeginClientFallback;
import com.laity.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author D.F Douglas
 * @version 1.0.0
 * @ClassName TestFeignClient
 * @Description @FeignClient(name = "provider",fallback = TestFeginClientFallback.class)
 * 上面注解 是用于指定服务提供者（如"provider"），fallback 为调用服务故障，捕获并处理
 * @createTime 2019/11/16/16:24
 */
@FeignClient(name = "provider",fallback = TestFeginClientFallback.class)
public interface TestFeignClient {
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    String test(@RequestParam(value = "e") String user,@RequestParam("count") int count);

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    String user(@RequestBody User e);
}
