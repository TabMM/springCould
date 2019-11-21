package com.laity.eureka.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author D.F Douglas
 * @version 1.0.0
 * @ClassName WebSecurityConfig
 * @Description  引入下面依赖包（基于<spring-cloud.version>Hoxton.RC2</spring-cloud.version>版本）必须有以下配置，不然安全校验无效
 *  <dependency>
 *      <groupId>org.springframework.boot</groupId>
 *      <artifactId>spring-boot-starter-security</artifactId>
 *  </dependency>
 * @createTime 2019/04/16/10:21
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        super.configure(httpSecurity);
        httpSecurity.csrf().disable();
    }
}
