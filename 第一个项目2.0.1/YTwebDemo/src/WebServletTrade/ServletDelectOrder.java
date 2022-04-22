package WebServletTrade;

import MainClass.User;
import Working.Trade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/***
 * url：delect
 *
 * **/
@WebServlet(name = "ServletDelectOrder")
public class ServletDelectOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("我被进入了！delect");
            String cartID = request.getParameter("OrderID");
            Trade trade = new Trade();
        HttpSession session = request.getSession();
        User user           =(User)session.getAttribute("user");
                    if (user!=null)
                    {

                       boolean flage = trade.DelectOrder(cartID);
                             if (flage)
                             {
                                 System.out.println("删除成功！");
                             }
                             else {
                                 System.out.println("删除失败！");
                             }


                    }
                    else {
                        response.sendRedirect("Login.html");
                        System.out.println("请登录！");

                    }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
