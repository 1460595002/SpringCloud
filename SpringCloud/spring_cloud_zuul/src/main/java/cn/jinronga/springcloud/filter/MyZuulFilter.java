package cn.jinronga.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName MyZuulFilter
 * @Author 郭金荣
 * @Date 2021/5/12 23:33
 * @Description MyZuulFilter
 * @Version 1.0
 */
public class MyZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        // 返回当前过滤器的类型，决定当前过滤器在什么时候执行
        // pre表示在目标微服务之前执行
        // 可选类型包括：pre、route、post、static
        String filterType = "pre";
        return filterType;
    }

    /**
     * shouldFilter： 应该过滤， 判断当前请求是否进行过滤
     * 要过滤:返回true，继续执行run方法
     * 不过滤：返回false 直接放行
     *
     * @return
     */
    @Override
    public int filterOrder() {
        // 过滤器执行顺序
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 1.获取当前RequestContext对象
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 2.获取当前请求对象
        HttpServletRequest request = currentContext.getRequest();
        // 3.获取当前请求要访问的目标地址
        String servletPath = request.getServletPath();
        // 4.打印
        System.out.println("servletPath = " + servletPath);
        // 5.当前方法返回值
        // true表示应该过滤，下面继续执行run方法
        // false表示不应该过滤，直接放行
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        // 执行具体过滤逻辑
        System.out.println("run()");
        // 官网文档说，当前实现会忽略这个返回值，所以直接返回null就行
        return null;
    }
}
