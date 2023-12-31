package com.practice.reactivepractice.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter2 implements Filter {

    private EventNotify eventNotify;

    public MyFilter2(EventNotify eventNotify) {
        this.eventNotify = eventNotify;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("*** MyFilter2.doFilter() is called ***");

        //데이터를 하나 발생시켜서
        eventNotify.add("새로운 데이터");

    }
}
