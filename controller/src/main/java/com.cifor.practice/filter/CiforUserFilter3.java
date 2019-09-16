package com.cifor.practice.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/cifor/*")
public class CiforUserFilter3 implements Filter {



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("================= "+filterConfig.getFilterName()+" ================");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("servletRequest: "+servletRequest.getLocalName());
        System.out.println("servletRequest: "+servletResponse.getLocale());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("3================= destroy ================");
    }

}
