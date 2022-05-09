package sms.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Filtercache")
public class Filtercache implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest  request  = (HttpServletRequest)  req;

        System.out.println(request.getRequestURL().toString());

        HttpServletResponse response = (HttpServletResponse) resp;

        response.setHeader("Cache-control", "no-cache");

        response.setHeader("pragma", "no-cache");

        response.setDateHeader("expires", -1);
        request.setCharacterEncoding("utf-8");


        chain.doFilter(req, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
