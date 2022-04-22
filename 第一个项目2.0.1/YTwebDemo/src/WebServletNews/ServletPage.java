package WebServletNews;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletPage")
public class ServletPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我被进入了，我是 +ServletPage");
        String NewsID;
        NewsID  = request.getParameter("NewsID");
        Cookie cookie = new Cookie("NewsID",NewsID);
        System.out.println(NewsID);
        response.addCookie(cookie);
        request.getRequestDispatcher("alterNews.html").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
