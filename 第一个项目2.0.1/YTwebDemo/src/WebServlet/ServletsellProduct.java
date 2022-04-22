package WebServlet;

import Dao.ProductDao;
import MainClass.Product;
import MainClass.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * 获取出售列表
 *
 * **/
@WebServlet(name = "ServletsellProduct")
public class ServletsellProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Writer out = response.getWriter();
        String productBelongID=null;
        Gson json =new Gson();
        String Json =null;
        List<Product> productList =new ArrayList<Product>();
        ProductDao productDao =new ProductDao();
        HttpSession session = request.getSession();
        User user           =(User)session.getAttribute("user");
        if (user!=null){
            try {
                productList = productDao.GetBelongProduct(user.getUserId());

            } catch (SQLException e) {

                e.printStackTrace();
            }
            if (productList.isEmpty())
            {   System.out.println("没有上传商品");
                return;

            }
            else {
                System.out.println("有商品");
                Json = json.toJson(productList);
                out.write(Json);
                System.out.println(Json);
            }
        }
        else {
            request.getRequestDispatcher("Login.html").forward(request,response);
            System.out.println("请登录！" );
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request,response);
    }
}
