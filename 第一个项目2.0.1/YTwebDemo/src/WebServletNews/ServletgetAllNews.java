package WebServletNews;

import MainClass.News;
import MainClass.User;
import Working.NewsWoring;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/******
 * getCLass
 * ***/
@WebServlet(name = "ServletgetAllNews")
public class ServletgetAllNews extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                         PrintWriter out = response.getWriter();

                          String PTA ;
                           PTA =request.getParameter("NCLASS");
                           Gson gson = new Gson();
                           System.out.println("NEWS:"+PTA);
                           HttpSession session = request.getSession();
            User user           =(User)session.getAttribute("user");
                NewsWoring woring = new NewsWoring();
        List<News> newsList = new ArrayList<>();
        if (PTA==null)
        {
            newsList = woring.getNewstClass("1");
            String json = gson.toJson(newsList);
            System.out.println("NEWS:json="+json);
            out.println(json);
            return;
        }

        else  if (PTA.equals("6")){
           if (user!=null){
               newsList = woring.getMYNews(user.getUserId());
               String json = gson.toJson(newsList);
               System.out.println("NEWS:json="+json);
               out.println(json);
               return;
           }else {
               System.out.println("没登录");
               return;
           }

        }
        else {

                newsList = woring.getNewstClass(PTA);
            String json = gson.toJson(newsList);
            System.out.println("NEWS:json="+json);
            out.println(json);
            return;

        }






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
