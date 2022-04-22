package WebServletp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/*ËÑË÷Ò³Ãæ×ª·¢
*
* xml:
* url:searchPage
*
* */
@WebServlet(name = "ServletserchPage")
public class ServletserchPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


                    String  world = request.getParameter("keyWorld");
                    System.out.println(world);

                    HttpSession session = request.getSession();
                    session.setAttribute("keyWorld",world);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
