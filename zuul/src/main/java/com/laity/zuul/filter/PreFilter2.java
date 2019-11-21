package com.laity.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author D.F Douglas
 * @version 1.0.0
 * @ClassName PreFilter
 * @Description TODO
 * @createTime 2019/11/18/15:30
 */
@Component
public class PreFilter2 extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context =RequestContext.getCurrentContext();
        return context.sendZuulResponse();
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context =RequestContext.getCurrentContext();
        HttpServletRequest request=context.getRequest();
        String key =request.getParameter("key");
        System.out.println(key);
        if ("2".equals(key)){
            context.setSendZuulResponse(false);
        }
        return null;
    }
}
