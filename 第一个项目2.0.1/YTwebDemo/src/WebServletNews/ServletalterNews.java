package WebServletNews;

import MainClass.News;
import MainClass.User;
import Working.NewsWoring;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
/**
 * 修改留言 alterNews
 * **/
@WebServlet(name = "ServletalterNews")
public class ServletalterNews extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        News news = new News();
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        String ID =null;
        for (Cookie cookie:cookies)
        {
            if (cookie.getName().equals("NewsID"))
            {
                ID = cookie.getValue();
            }
        }
        System.out.println(ID);
        User user = (User)session.getAttribute("user");
        NewsWoring newsWoring = new NewsWoring();
        if (user!=null)
        {  news.setNewsID(ID);
            news.setUserID(user.getUserId());
            news.setTxtAre(request.getParameter("TXTAre"));
            news.setTxtTile(request.getParameter("Title"));
            news.setTxtclass(request.getParameter("Txtclass"));
            news.setTxtTime(request.getParameter("TXTTime"));
            news.setPhon(request.getParameter("phone"));
            news.toString();
            boolean fl =  newsWoring.alterNews(news);
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
