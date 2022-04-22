package WebServletTrade;

import MainClass.User;
import Tool.ChickString;
import Working.Trade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/******
 *
 * xml yes
 * */
@WebServlet(name = "ServletUpOrterSta")
public class ServletUpOrterSta extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChickString chickString = new ChickString();
        String OrderID   = request.getParameter("OrderID");

        if (chickString.chickABCD(OrderID)){
            System.out.println("非法行为！id");
            return;
        }
        if (!chickString.chick(OrderID))
        {
            System.out.println("非法行为！");
            return;
        }
        String OrderSta  = request.getParameter("OrderSta");
        System.out.println("YES!我是更新订单"+OrderID+" "+OrderSta);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user!=null)
        {
            Trade trade = new Trade();
            boolean   key = false;
            if (OrderSta.equals("D")){
                key =  trade.UpOrderSta(OrderID,OrderSta);

               if ( key ){
                 key = trade.UpOrderNumber(OrderID);
               }

                if (key){

                    System.out.println("修改成功！");
                }
                else
                {
                    System.out.println("修改失败！");
                }
            }
        else {
                   key =  trade.UpOrderSta(OrderID,OrderSta);
                if (key){

                    System.out.println("修改成功！");
                }
                else
                {
                    System.out.println("修改失败！");
                }
            }
        }
        else
        {
           response.sendRedirect("Login.html");
                 System.out.println("登录失效！");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
