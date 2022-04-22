package MainClass;

import Dao.ProductDao;

import java.util.List;

public class Page {
   private int PageNumber=1;             //页码
   private int limiits=12 ;             //每页获取的商品数量
   private List<Product> productList =null; //商品列表
   private String dataBases=null;                //在那个数据表分页
   private List<Cart> ListCarts = null;     //获取购物车
   private int toAll =0;                   //商品总数量
    ProductDao productDao = new ProductDao();
    public int getLimiits() {
        return limiits;
    }
    public int getPageNumber() {
        return PageNumber;
    }
    public List<Product> getProductList() {

        ProductDao productDao = new ProductDao();
       try {
           productList           = productDao.Productpage(PageNumber,limiits);
           if (productList.isEmpty())
           {
               System.out.println("分页失败！");
           }
       }catch (Exception e){
           System.out.println("分页失败！");
           e.printStackTrace();

       }


        return productList;
    }
    public List<Cart> getCartList(){


        return ListCarts;
    }

    public String getDataBases() {
        return dataBases;
    }

   public int  pageP(){
        try {
            toAll=productDao.getNumberP();
        }catch (Exception e){
            System.out.println("获取数量异常");
            e.printStackTrace();
        }


         return toAll;
   }
}
