package Working;

import Dao.ProductDao;
import MainClass.Product;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShowProduct {

    public List<Product> getProductClass(String pclass){
         List<Product> products = new ArrayList<Product>();
        ProductDao productDao   = new ProductDao();
         System.out.println(pclass);
     try {
         if (pclass.equals("1"))
         {System.out.println("a");
             products =productDao.GetClassProduct("衣服");
         }
         else  if (pclass.equals("2"))
         {
             products =productDao.GetClassProduct("文具");
         }
         else if (pclass.equals("3"))
         {
             products=productDao.GetClassProduct("电子产品");
         }
         else if (pclass.equals("4"))
         {
             products=productDao.GetClassProduct("书本");
         }
         else if (pclass.equals("5"))
         {
             products=productDao.GetClassProduct("宿舍神器");
         }
         else if (pclass.equals("6")){
             products=productDao.GetClassProduct("其它");
         }

     }catch (Exception E){
         E.printStackTrace();
         return null;
     }

        return products;

    }

    public List<Product>upsetProducts(List<Product> productList)
    {

       Product[] products= new Product[productList.size()];
        Random random = new Random();
        productList.toArray(products);
       int  key = productList.size();
        System.out.println(key);
        Product product;
        int i=0;
        int j = products.length-1;
          while(i<=j)
          {

              int p = random.nextInt(key);
                  if (p!=0)
                  {
                      p=p-1;
                  }
                  int c = random.nextInt(key);
              if (c!=0)
              {
                  c=c-1;
              }
              product = products[i] ;
             products[i] = products[p];
             products[p] = product;

              product = products[j] ;
              products[j] = products[c];
              products[c] = product;

                i++;
                j--;
          }
        List<Product> list = java.util.Arrays.asList(products);
         return list;
    }

    public  List<Product> searchProduct(String keyWord){
        List<Product> productList = new ArrayList<Product>();
        ProductDao productDao = new ProductDao();

             try {
                 productList = productDao.serchProduct(keyWord);
                 if (productList.isEmpty())
                 {
                     System.out.println("没有获取商品！");
                     return null;
                 }
             }catch (Exception e){

                 System.out.println("搜索功能错误！");
                 e.printStackTrace();
             }
            return productList;
    }



}
