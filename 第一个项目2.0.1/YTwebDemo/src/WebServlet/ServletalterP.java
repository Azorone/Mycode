package WebServlet;

import Dao.ProductDao;
import MainClass.Product;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletalterP")
public class ServletalterP extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        boolean key=false;
        Cookie[] cookies = request.getCookies();
        ProductDao productDao = new ProductDao();
        Product product    = new Product();
        Gson gson            = new Gson();
        String pid ;
        for (Cookie cookie:cookies)
        {
            if (cookie.getName().equals("ID"))
            {
                pid = cookie.getValue();
                try {
                    product = productDao.GetProduct(pid);
                    key     = true;
                }catch (Exception e)
                {
                    System.out.println("从数据库获取商品错误");
                    e.printStackTrace();
                }
            }
        }
        if (key)
        {
            String JSON = gson.toJson(product);
            out.println(JSON);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
