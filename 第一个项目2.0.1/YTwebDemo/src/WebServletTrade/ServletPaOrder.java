package WebServletTrade;

import Working.Trade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/***
 * 下单，该下单是在购物车中下单
 *
 * ***/
@WebServlet(name = "ServletPaOrder")
public class ServletPaOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                     String CardID = request.getParameter("cardID");
                     Trade trade = new Trade();
                    boolean key =  trade.PaOrder(CardID);
                     if (key)
                     {
                         System.out.println("下单成功");
                     }
                     else {
                         System.out.println("下单失败");
                     }
    }
}
