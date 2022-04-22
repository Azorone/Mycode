package WebServletp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletProductClassPage")
public class ServletProductClassPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我被进入了！");
        String CLASS = request.getParameter("PageClass");
        System.out.println(CLASS);
        Cookie cookie = new Cookie("Pclass",CLASS);
        response.addCookie(cookie);
        request.getRequestDispatcher("ProductClass.html").forward(request,response);
    }
}
