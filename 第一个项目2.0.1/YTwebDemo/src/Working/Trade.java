package Working;

import Dao.cartDAO;
import MainClass.Cart;
import MainClass.Product;
import Tool.DataSouurce;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/****
 * 交易类，该类分别用于增。删，改，查
 *
 * *******/
public class Trade {
           public boolean addCart(Product product,String buyID,String sta,String BuyName)
           {   cartDAO cartdao = new cartDAO();
               Cart cart = new Cart();


              String ID = creatID();
               cart.setCartID(ID);
               cart.setBuyUid(buyID);                             //购买人的id
               cart.setPid(product.getProductID());
               cart.setPmurl(product.getProductIMGurl());
               cart.setSellUid(product.getProductBelongID());
               cart.setPname(product.getProductName());
               cart.setSellName(product.getProductBelongName());
               cart.setBuyName(BuyName);
               cart.setAdress(product.getAdress());
               cart.setPhone(product.getPhone());
               cart.setGetTime(product.getGetProductTime());
               double price  = product.getProductPrice();
               cart.setPpice(price);
               cart.setPsta(sta);
               System.out.println(product.toString());
               try {
                   cartdao.addcart(cart);
                   System.out.println("添加成功能");
               }catch (Exception e)

               {    System.out.println(cart.toString());
                    System.out.println("订单添加失败");
                   e.printStackTrace();
                     return  false;
               }
                   return true;
           }
           public List<Cart> getBuyCart(String buyUid)              /*获取购物车中的商品*/
           {   String Psta = "A";
               List<Cart> carts = new ArrayList<Cart>();
                cartDAO cartDAO = new cartDAO();
                 System.out.println(buyUid);
                try {
                           carts = cartDAO.getBuyOrder2(buyUid,"A");
                           System.out.println(carts);
                           if (carts==null)
                           {
                               System.out.println("获取失败为空");
                           }
                }catch (Exception e)
                {    System.out.println("获取订单失败");
                    e.printStackTrace();
                    return null;
                }
               return carts;
           }
 public Boolean PaOrder(String CartID)        //下单，在购物车中下单
 {
      cartDAO cartdao = new cartDAO();
      try {
           boolean key =  cartdao.OrderProductcart(CartID);
           if (key)
           {
               System.out.println("修改成功");
               return true;
           }
           else
           {
               System.out.println("修改失败");
           }

      }catch (Exception e)
      {
          e.printStackTrace();
      }


     return false;
 }
        public boolean DelectOrder(String orderID){          //按照id删除

               cartDAO cartdAO = new cartDAO();

            try {
                if (cartdAO.Deletcart(orderID)){

                    return true;
                }
            }catch (Exception e){
                System.out.println("删除失败");
                e.printStackTrace();
            }

               return  false;
        }
        public List<Cart> getPAOrder(String buyUID)         /*获取我下单的商品**/
        {
            List<Cart> carts = new ArrayList<Cart>();
                 cartDAO dao = new cartDAO();
                 try {
                    carts = dao.getBuyOrder(buyUID,"B","C","D");
                 }catch (Exception e){
                     e.printStackTrace();
                 }

            return  carts;
        }
        public List<Cart> getSellOrder(String sellOrder){    /*获取我收到的订单,没被接受的订单*/
            List<Cart> carts = new ArrayList<Cart>();
            cartDAO dao = new cartDAO();
            try {
              carts =  dao.getSellOrder(sellOrder,"B");
            }catch (Exception exception){
                exception.printStackTrace();
            }
            return  carts;
        }
         public List<Cart> getNotsent(String sellOrder){                    /*获取待发货的订单*/

             List<Cart> carts = new ArrayList<Cart>();
             cartDAO dao = new cartDAO();
             try {
               carts =   dao.getSellOrder(sellOrder,"D");
             }catch (Exception e){
                 e.printStackTrace();
             }
             return  carts;

         }
         public List<Cart> getOrder(){
             List<Cart> carts = new ArrayList<Cart>();
             cartDAO dao = new cartDAO();
             return  carts;

         }
        public boolean UpOrderSta(String ID,String STA)       /*改变订单转态*/
         {

             cartDAO dao = new cartDAO();
            try {
                       boolean KEY =   dao.UpOrderSta(ID,STA);
                       if (KEY)
                       {
                           System.out.println("修改成功");
                           return true;
                       }
                       else {
                           System.out.println("修改失败！");
                       }

            }catch ( Exception E)
            {

                System.out.println("修改失败！异常错误！");
                E.printStackTrace();
            }
             return false;
                 }

         public boolean UpOrderNumber(String ID)
         {
             Random random = new Random();
             int Number    = random.nextInt(8999)+1000;
             int world     = random.nextInt(25);
             String[] words  = {"A","B","C","D","E","F","G","H","J","K","L","M","M","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
             String  NU   =String.valueOf(Number);
             String getNumber = words[world]+NU;
             cartDAO dao = new cartDAO();
                   try {


                    return   dao.UpOrderNumber(getNumber,ID);
                   }catch (Exception e){
                       e.printStackTrace();
                   }

                  return false;
         }


         public boolean alterCart(Product product)
         {

             cartDAO cartDAO = new cartDAO();

             try {
                boolean key = cartDAO.alterCartP(product);
                return key;
             }catch (Exception e){
                 e.printStackTrace();
             }




            return false;


         }


         private  synchronized String creatID()
         {
             Date date   = new Date();
             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyMMddhhmmss");
             return dateFormat.format(date);
         }
}
