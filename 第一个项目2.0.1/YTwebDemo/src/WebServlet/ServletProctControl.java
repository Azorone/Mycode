package WebServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletProctControl")
public class ServletProctControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;");
        String s = request.getParameter("get");
       /* String URL = request.getRequestURI();
         System.out.println(URL);
        int i  = URL.lastIndexOf("/");
        String s = URL.substring(i+1);
        System.out.println(s);*/
        request.getRequestDispatcher(s).forward(request,response);
        System.out.println("进入结束");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
