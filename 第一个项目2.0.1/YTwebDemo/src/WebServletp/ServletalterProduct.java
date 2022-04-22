package WebServletp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 修改商品属性
 * url ：alterP
 *
 * **/
@WebServlet(name = "ServletalterProduct")
public class ServletalterProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我被进入了，我是alterProduct");
        String productID;
        productID  = request.getParameter("ID");
        Cookie cookie = new Cookie("ID",productID);
        System.out.println(productID);
        response.addCookie(cookie);
        request.getRequestDispatcher("alterProduct.html").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
