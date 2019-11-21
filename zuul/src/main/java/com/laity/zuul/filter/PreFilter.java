package com.laity.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author D.F Douglas
 * @version 1.0.0
 * @ClassName PreFilter
 * @Description 网关拦截器
 * @createTime 2019/11/18/15:30
 */
@Component
@RefreshScope
public class PreFilter extends ZuulFilter {
    // 从远程仓库获取配置
    @Value("${token}")
    private boolean token;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
       /* RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String key = request.getParameter("key");
        System.out.println(key);
        if ("1".equals(key)) {
            context.setSendZuulResponse(false);
        }
        return null;*/

        /*RequestContext context =RequestContext.getCurrentContext();
        HttpServletRequest request=context.getRequest();
        String token =request.getHeader("token");
        if (null==token||"".equals(token)){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            context.setResponseBody("{\"msg\":\"401,access without permission,pls login first.\"}");
            return "request denied";
        }
        return "pass";*/
        System.out.println("token========="+token);
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        if (token) {
            String token = request.getHeader("token");
            if (null == token || token.equals("")) {
                context.setSendZuulResponse(false);
                context.setResponseStatusCode(401);
                context.setResponseBody("{\"msg\":\"401,access without permission,pls login first.\"}");
                return "request denied";
            }
        }
        return "pass";
    }
}
