package fr.cda.librairie.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebFilter("/*")
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("\n--------->>> filtre LogFilter");

        ((HttpServletResponse) response).addHeader("header-special-cda", new Date().toString());

        chain.doFilter(request, response);


    }
}
