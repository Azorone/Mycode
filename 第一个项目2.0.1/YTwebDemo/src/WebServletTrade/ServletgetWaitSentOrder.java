package WebServletTrade;

import MainClass.Cart;
import MainClass.User;
import Working.Trade;
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
/**URL GETD
 * 获取状态为 D
 *xml yes
 * */
@WebServlet(name = "ServletgetWaitSentOrder")
public class ServletgetWaitSentOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我被进入了getD");
        HttpSession session = request.getSession();
        User user           = (User) session.getAttribute("user");
        List<Cart> carts    = new ArrayList<Cart>();
        PrintWriter out  = response.getWriter();
        Gson gson           = new Gson();
        if (user!=null)
        {
            Trade trade = new Trade();
            carts = trade. getNotsent(user.getUserId());
            if (carts.isEmpty())
            {
                System.out.println("暂无订单！");
            }
            else{

                String josn = gson.toJson(carts);
                System.out.println(josn);
                out.println(josn);

            }
        }
        else {
            request.getRequestDispatcher("Login.html").forward(request,response);
            System.out.println("请登录！");


        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
