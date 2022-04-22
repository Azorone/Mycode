package WebServletp;

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

/**
 *
 * 按照单件商品的id获取商品，
 * url:
 *
 * */

@WebServlet(name = "ServletgetProduct")
public class ServletgetProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我被进入了，我是ServletgetProduct");
        String productID;
        productID  = request.getParameter("pid");
        Cookie cookie = new Cookie("pid",productID);
        response.addCookie(cookie);
            request.getRequestDispatcher("productNews.html").forward(request,response);




    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    doPost(request,response);
    }
}
