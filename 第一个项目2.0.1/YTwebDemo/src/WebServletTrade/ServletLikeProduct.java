package WebServletTrade;

import Dao.ProductDao;
import MainClass.Product;
import MainClass.User;
import Working.Trade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/***
 * 这个类是用于添加商品到数据库的cart表中
 * 把
 *
 * */
@WebServlet(name = "ServletLikeProduct")
public class ServletLikeProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                               System.out.println("我被进入了，我是：ServletLikeProduct");
                               ProductDao productDao = new ProductDao();
                               String pid  = request.getParameter("pid");
                               String Psta = request.getParameter("Psta");
                               User user   = null;
                               HttpSession session = request.getSession();
                             user           =(User)session.getAttribute("user");

                             if (user==null)
                             {  PrintWriter out = response.getWriter();
                                out.println("请登录");
                             }
                             else {
                                 String buyID     = user.getUserId();
                                 String buyName   = user.getUseName();
                                 if (buyID==null)
                                 {

                                     return;
                                 }
                                 else
                                 {
                                     Trade trade = new Trade();
                                     Product product = null;
                                     try {
                                         product = productDao.GetProduct(pid);
                                     }catch (Exception e)
                                     {    System.out.println("获取商品失败");
                                         e.printStackTrace();
                                     }
                                     if (product!=null)
                                     {
                                         boolean key = trade.addCart(product,buyID,Psta,buyName);
                                         if (key)
                                         {
                                             PrintWriter out = response.getWriter();
                                             out.println("添加成功");
                                             System.out.println("添加成功！");
                                         }
                                         else{
                                             System.out.println("添加失败");
                                         }
                                     }
                                     else {
                                         return;
                                     }
                             }




                               }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                   doPost(request,response);
    }
}
