import Dao.ProductDao;
import MainClass.Product;
import com.google.gson.Gson;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.util.ArrayList;
import java.util.List;

public class testP {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        List<Product> products = new ArrayList<Product>();
        Gson gson              = new Gson();
       try {
           products = productDao.GetAllProduct() ;
       }catch (Exception e)
       {
           e.printStackTrace();
       }
          String json = gson.toJson(products);
       System.out.println(json);

    }
}
