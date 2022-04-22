package WebServlet;

import MainClass.User;
import Working.SLongin;

import javax.jms.Session;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

@javax.servlet.annotation.WebServlet(name = "ServletLogin")
public class ServletLogin extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
                                  String userID =  request.getParameter("userID");
                                  String userPass = request.getParameter("userPass");
                                  HttpSession session = request.getSession();
                                  SLongin sLongin = new SLongin();
                                  User user       = sLongin.setIsLogin(userID,userPass);

                                 if (user!=null)
                                 {   Cookie cookie = new Cookie("login","true");
                                     response.addCookie(cookie);
                                     session.setAttribute("user",user);
                                     session.setMaxInactiveInterval(30*60);      //设置session有效时间为30分钟
                                     request.getRequestDispatcher("MainPage.html").forward(request,response);
                                     System.out.println("登录成功");
                                 }
                                    else {
                                        response.sendRedirect("errorLogin1.html");
                                               System.out.println("登录失败,请检查账号和密码");

                                 }




    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            doPost(request,response);
    }
}
