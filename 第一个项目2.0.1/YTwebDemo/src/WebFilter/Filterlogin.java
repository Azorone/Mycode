package WebFilter;

import MainClass.User;
import Working.SLongin;

import javax.naming.Name;
import javax.naming.ldap.Control;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "Filterlogin")
public class Filterlogin implements Filter {
    public void destroy() {
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
                HttpServletRequest request =(HttpServletRequest)req;
                HttpServletResponse response = (HttpServletResponse)resp;
                HttpSession session = request.getSession();
                User user  = (User) session.getAttribute("user");
                String userID = (String) session.getAttribute("userID");

                if(user!=null && userID!=null){

                    System.out.println(user.toString());
                    System.out.println(userID);

                }

                chain.doFilter(req,resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
