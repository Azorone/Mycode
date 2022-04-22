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
/**
 * xml url: addNews
 *
 * **/
@WebServlet(name = "ServletaddNews")
public class ServletaddNews extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        News news = new News();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        NewsWoring newsWoring = new NewsWoring();
        if (user!=null)
        {
            news.setUserID(user.getUserId());
            news.setTxtAre(request.getParameter("TXTAre"));
            news.setTxtTile(request.getParameter("Title"));
            news.setTxtclass(request.getParameter("Txtclass"));
            news.setTxtTime(request.getParameter("TXTTime"));
            news.setUserName(user.getUseName());
            news.setPhon(request.getParameter("phone"));
            news.toString();
          boolean fl =  newsWoring.addNews(news);
            if (fl){
                response.sendRedirect("sussesN.html");
            }
            else {
                response.sendRedirect("flaseN.html");
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
