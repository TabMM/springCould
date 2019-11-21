package com.laity.consumer.controller;

import com.laity.consumer.service.TestFeignClient;
import com.laity.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author D.F Douglas
 * @version 1.0.0
 * @ClassName TestController
 * @Description 服务消费者 调用 提供者 模拟集群测试
 * @createTime 2019/11/16/11:02
 */
@Api(tags = "springcould")
@RestController
public class TestController {
    @Autowired
    private TestFeignClient client;
    @ApiOperation("String")
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String test(String e){
        //负载均衡测试
        for (int i = 0; i <10 ; i++) {
            client.test(e,i);
        }
        return "ok，负载";
    }
    @ApiOperation("Object")
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String user(User e){
        String s =client.user(e);
        return s;
    }
}
