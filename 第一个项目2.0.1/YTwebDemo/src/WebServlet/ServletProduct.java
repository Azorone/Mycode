package WebServlet;

import Dao.ProductDao;
import MainClass.Product;
import Working.ShowProduct;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;
//页面加载，展示所有的商品
@WebServlet(name = "ServletProduct")
public class ServletProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ProductDao productDao = new ProductDao();
        Gson gson = new Gson();
        ShowProduct showProduct = new ShowProduct();
        String json = null;
        try {
            List<Product> productList = productDao.GetAllProduct();
           List<Product>products =  showProduct.upsetProducts(productList);   //打乱随机推送
            json = gson.toJson(products);
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println(json);
        System.out.println(json);
        System.out.println("你好");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doPost(request,response);
    }
}
