package com.laity.provider.controller;

import com.laity.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @author D.F Douglas
 * @version 1.0.0
 * @ClassName TestController
 * @Description 服务提供者 Api 字段、实体类传输测试
 * @createTime 2019/11/16/11:06
 */
@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);


    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(@RequestParam(value = "e") String e, @RequestParam("count") int count) {
        logger.info("access @ provider 8000 as:" + count);
        return e + "provider";
    }
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String user(@RequestBody User user){
        return user.getUser()+user.getPwd()+"provider";
    }
}
