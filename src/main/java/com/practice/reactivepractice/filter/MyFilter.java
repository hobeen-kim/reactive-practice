package com.practice.reactivepractice.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter implements Filter {

    private EventNotify eventNotify;

    public MyFilter(EventNotify eventNotify) {
        this.eventNotify = eventNotify;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("*** MyFilter.doFilter() is called ***");

        HttpServletResponse servletResponse = (HttpServletResponse) response;

        servletResponse.setContentType("text/event-stream; charset=utf-8");

        PrintWriter out = servletResponse.getWriter();

        for (int i = 0; i < 5; i++) {
            out.print("응답 : " + i + "\n");
            out.flush();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        while(true) {
            try {
                if(eventNotify.getChange()) {
                    int lastIdx = eventNotify.getEvents().size() - 1;
                    out.print("응답 : " + eventNotify.getEvents().get(lastIdx) + "\n");
                    out.flush();
                }
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
