package WebServletNews;

import MainClass.News;
import Working.NewsWoring;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servletserch")
public class Servletserch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                      String key=  request.getParameter("NewsWord");
        Gson gson = new Gson();
        PrintWriter OUT  = response.getWriter();
        NewsWoring woring = new NewsWoring();
        List<News> newsList = new ArrayList<>();
        newsList = woring.serchN(key);
         System.out.println("HAHA");
        String json  = gson.toJson(newsList);
        OUT.println(json);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
