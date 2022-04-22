package WebServletNews;

import MainClass.News;
import MainClass.User;
import Working.NewsWoring;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * url deleNews;
 *
 * **/
@WebServlet(name = "ServletdeletNews")
public class ServletdeletNews extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String id = request.getParameter("NewsID");
        NewsWoring newsWoring = new NewsWoring();
        PrintWriter OUT = response.getWriter();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

           if (user!=null){
               boolean key = newsWoring.Delect(id);
               if (key)
               {
                   OUT.println("删除成功！");
               }
               else {
                   OUT.println("删除失败！");
               }
           }else {
               OUT.println("登录失效！");
           }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
