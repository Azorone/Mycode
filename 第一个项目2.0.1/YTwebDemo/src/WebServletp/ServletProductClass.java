package WebServletp;

import MainClass.Product;
import Working.ShowProduct;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletProductClass")
public class ServletProductClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          System.out.println("我被进入了我师class");
        List<Product> products = new ArrayList<>();
                  String Number =request.getParameter("Pclass");
                  String KEY    = request.getParameter("keyWorld");
                  System.out.println(Number);
                  System.out.println(KEY);
        ShowProduct showProduct = new ShowProduct();
        HttpSession session = request.getSession();
        String Keyworld = (String) session.getAttribute("keyWorld");

               if (Keyworld==null)
               {
                  System.out.println("搜索为空！");
                   if (KEY==null){

                       if (Number!=null){

                           System.out.println(Number+"分类获取");
                           products= showProduct.getProductClass(Number);

                       }
                       else{

                           Cookie[] cookies =request.getCookies();
                           for (Cookie cookie :cookies){
                               if (cookie.getName().equals("Pclass"))
                               {
                                   Number = cookie.getValue();
                                   cookie.setMaxAge(0);

                               }

                           }

                           if (Number!=null){

                               products= showProduct.getProductClass(Number);
                           }
                           else {
                               products= showProduct.getProductClass("1");
                           }
                       }


                       if (products.isEmpty()){
                           System.out.println("11");
                           return;
                       }
                       else {

                           Gson gson = new Gson();
                           String json = gson.toJson(products);
                           PrintWriter out = response.getWriter();
                           out.println(json);
                       }
                   }
                   else {

                       /*****搜索******/

                       products = showProduct.searchProduct(KEY);
                       Gson gson = new Gson();
                       String Json = gson.toJson(products);
                       PrintWriter out = response.getWriter();
                       out.println(Json);
                       System.out.println(Json);
                   }

               }
               else {

                   /****搜索*****/
               session.removeAttribute("keyWorld");
               products = showProduct.searchProduct(Keyworld);
               Gson gson = new Gson();
                     String Json = gson.toJson(products);
                   PrintWriter out = response.getWriter();
                   out.println(Json);
                     System.out.println(Json);


               }





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
