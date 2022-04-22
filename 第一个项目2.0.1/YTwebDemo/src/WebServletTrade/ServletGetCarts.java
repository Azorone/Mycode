package WebServletTrade;

import MainClass.Cart;
import MainClass.User;
import Working.Trade;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/****
 * 获取购物车里面的商品，
 * 获取的标志是 sellID  订单状态Psta = A
 *是否在xml注册
 * 注册路径 url = getCart
 * **/
@WebServlet(name = "ServletGetCarts")
public class ServletGetCarts extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我被进入了getCart");

        HttpSession session = request.getSession();
        User user           = (User)session.getAttribute("user");


        if (user!=null)
        {
            Trade trade = new Trade();

            List<Cart>  carts = trade.getBuyCart(user.getUserId());
            System.out.println(carts);
            if (!carts.isEmpty())
            {
                Gson gson = new Gson();
                String json = gson.toJson(carts);
                System.out.println(json);
                PrintWriter out = response.getWriter();
                out.println(json);

            }
            else
            {
                System.out.println("获取失败！");

            }
        }
        else {
            request.getRequestDispatcher("Login.html").forward(request,response);
            System.out.println("没有登录");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
