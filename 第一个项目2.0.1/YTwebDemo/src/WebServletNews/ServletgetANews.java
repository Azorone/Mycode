package WebServletNews;

import MainClass.News;
import Working.NewsWoring;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletgetANews")
public class ServletgetANews extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String ID =null;
        NewsWoring newsWoring = new NewsWoring();
        News news = new News();
        for (Cookie cookie:cookies)
        {
            if (cookie.getName().equals("NewsID"))
            {
                ID = cookie.getValue();
            }
        }
        if (ID!=null){
              news = newsWoring.getANews(ID);
        }
        else {
            return;
        }

        Gson gson = new Gson();
        String JSON =gson.toJson(news);
        PrintWriter out = response.getWriter();
        out.println(JSON);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
