package sms.servlet;

import sms.pojo.User;
import sms.service.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String[]> map = new HashMap<>();

        map = request.getParameterMap();
        int l = map.size();
        Set<String> set = map.keySet();
        for (String set1:set){
            System.out.println(set1);
            String[] strings =  map.get(set1);
            System.out.println( strings[0]);
        }
        String account ;
        String pass ;
        account = request.getParameter("account");
        pass = request.getParameter("pass");

        Login login = new Login();
        if ( login.chickUser(account,pass))
        {
            User user = login.getUSER();
            HttpSession session = request.getSession();
            session.setAttribute(user.getId(),user);
            Cookie cookie = new Cookie("id",user.getId());
            response.addCookie(cookie);
            PrintWriter out = response.getWriter();
            if (user.getPer()==4)
            {
                out.println("1");
            }
           else {
               out.println("2");
            }
            return;
        }
        PrintWriter out = response.getWriter();
        out.println("-1");
        System.out.println("登录失败！");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
