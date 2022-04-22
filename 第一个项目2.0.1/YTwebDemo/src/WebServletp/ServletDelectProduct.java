package WebServletp;

import Dao.ProductDao;
import Dao.cartDAO;
import MainClass.Cart;
import MainClass.Product;
import Tool.DataSouurce;
import Tool.FileWoring;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/****
 * 删除
 * 删除图片
 * 删除订单
 * 删除产品
 * ****/
@WebServlet(name = "ServletDelectProduct")
public class ServletDelectProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("我是DelectP");
            String PATH = this.getServletContext().getContextPath();
              String ID = request.getParameter("ID");
        ProductDao productDao = new ProductDao();
        cartDAO dao =  new cartDAO();

        Product product = null;
        try {
                 product = productDao.GetProduct(ID);
        }catch (Exception e){
            e.printStackTrace();
        }

        if (product!=null)
        {
            boolean key =false;
            try {



                key =  productDao.DeletProduct(ID);
            }catch (Exception e){
                e.printStackTrace();
            }
            if (key){




                try {

                    PrintWriter out = response.getWriter();

                   boolean fl= dao.DeletPcart(ID);

                    if (fl){
                        boolean key1=  FileWoring.delectPict(PATH+product.getProductIMGurl());
                        if(key1){
                            out.println("删除成功！");
                        }
                    }else {
                        System.out.println("失败");
                        return;
                    }


                }catch (Exception e){
                    try {
                        DataSouurce.rollback();
                    } catch (SQLException A) {
                        A.printStackTrace();
                    }
                    e.printStackTrace();
                }

            }
            else
            {
                PrintWriter out = response.getWriter();
                out.println("删除失败！");
                try {
                    DataSouurce.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return;
            }

        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
