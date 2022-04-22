package WebServletUser;

import MainClass.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
/***
 * 获取用户信息，并以标准的json格式返回到前端
 * url：user
 * web.xml是否注册：yes
 * ***/
@WebServlet(name = "ServletgetUser")
public class ServletgetUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我被进入拉！！");
        HttpSession session = request.getSession();
        User user           =(User)session.getAttribute("user");
        if (user!=null)
        {
            PrintWriter out = response.getWriter();
            Gson gson   = new Gson();
            String json = gson.toJson(user);
            System.out.println("hhh"+user.toString());
            out.println(json);
        }
        else {

            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doPost(request,response);
    }
}
