package WebServletp;

import Dao.ProductDao;
import MainClass.Product;
import Working.Trade;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletAPNews")
public class ServletAPNews extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String ID = null;
        Product product=null;
        ProductDao productDao = new ProductDao();
        for (Cookie cookie:cookies)
        {
            if (cookie.getName().equals("ID"))
            {
                ID = cookie.getValue();
            }
        }
        if (ID!=null){

           try {
             product = productDao.GetProduct(ID);
           }catch (Exception e){
               e.printStackTrace();
           }
        }
        else {
            PrintWriter out = response.getWriter();
            out.println("错误！");
        }
        if (product!=null)
        {
            String productClass = request.getParameter("productClass");
            String productName  = request.getParameter("productName");
            String productPrice = request.getParameter("productPrice");
            String productDescribe = request.getParameter("productDescribe");
            String adress          = request.getParameter("adress");
            String getProductTime  = request.getParameter("getProductTime");
            String phone           = request.getParameter("phone");
            product.setProductClass(productClass);
            product.setProductName(productName);

            product.setProductPrice(Double.valueOf(productPrice));
            product.setProductDescribe(productDescribe);
            product.setAdress(adress);
            product.setGetProductTime(getProductTime);
            product.setPhone(phone);
            product.toString();


            try {
              boolean KEY =  productDao.upProduct(product,product.getProductID());

              if (KEY){
                  Trade trade = new Trade();
                    trade.alterCart(product);
                    System.out.println(product.toString());
                    response.sendRedirect("sussesAlter.html");
              }
              else{
                  System.out.println("修改失败!");
                  response.sendRedirect("flase.html");
              }
            }catch (Exception E){
                E.printStackTrace();
            }



        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
