package com.sse.software_testing.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hq
 */

@WebFilter(urlPatterns = "/*",filterName = "CrossDomainFilter")
public class CrossDomainFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException {
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        //OPTION请求就直接返回
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (req.getMethod().equals("OPTIONS")) {
            resp.setStatus(200);
            resp.flushBuffer();
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
    @Override
    public void destroy() {}
}
