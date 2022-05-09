package sms.filter;

import sms.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "FilterGlobal")
public class FilterGlobal implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {


       String[] passServlet = {"sms-login","sms-register"};
        User user = null;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        System.out.println("我是登录过滤器！");
        Cookie[] cookies    = request.getCookies();
        HttpSession session = request.getSession();
        StringBuffer stringBuffer = request.getRequestURL();
        for (Cookie cookie:cookies)
        {
            if (cookie.getName().equals("id"))
            {
                user = (User)session.getAttribute(cookie.getValue());
            }

        }
        int i    =  stringBuffer.lastIndexOf(".");
        String P = stringBuffer.substring(i+1);
        String S = null;
        if (user==null){
            if (i==-1)
            {
                 boolean fl = false;
                 int key = stringBuffer.lastIndexOf("/");
                 String temp = stringBuffer.substring(key+1);
                 System.out.println(temp);
                for (String s:passServlet) {
                    if (temp.equals(s))
                    {
                        fl = true;
                        break;
                    }
                }

                if (fl)
                {
                    chain.doFilter(req, resp);
                }
                else {
                    response.sendRedirect("Login.html");
                }
            }
            else if (i!=-1){
                System.out.println("请求的是文件");
                String temp = stringBuffer.substring(i+1);
                System.out.println(temp);
                if(temp.equals("html")){
                    int key = stringBuffer.lastIndexOf("/");
                    String temp2 = stringBuffer.substring(key+1);
                    System.out.println(temp2);
                    System.out.println("请求的是html");
                    if (temp2.equals("Login.html"))
                    {
                        chain.doFilter(req, resp);
                    }
                    else {
                        response.sendRedirect("Login.html");
                    }
                }
                else {
                    chain.doFilter(req, resp);
                }

            }

        }else {
            chain.doFilter(req, resp);
        }



    }

    public void init(FilterConfig config) throws ServletException {

    }

}
