package Dao;

import MainClass.Cart;
import MainClass.Product;
import Tool.DataSouurce;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class cartDAO {
    public boolean addcart(Cart cart) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSouurce.getDataSource());
                    String SQL  = "insert into cart (sellUid,buyUid,Pid,Pmurl,Psta,Ppice,Pname,CartID,SellName,BuyName,adress,phone,getOrderName,GetTime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    int flag    = queryRunner.update(SQL,cart.getSellUid(),
                            cart.getBuyUid(),
                            cart.getPid(),
                            cart.getPmurl(),
                            cart.getPsta(),
                            cart.getPpice(),
                            cart.getPname(),
                            cart.getCartID(),
                            cart.getSellName(),
                            cart.getBuyName() ,
                            cart.getAdress(),
                            cart.getPhone(),
                            cart.getGetOrderName(),
                            cart.getGetTime());

        return  flag>0;
    }
    public boolean Deletcart(String cartID) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSouurce.getDataSource());
                    String SQL  = "delete from cart where cartID=?";
                    int flag    = queryRunner.update(SQL,cartID);

                    return flag>0;
    }
    public boolean OrderProductcart(String cartID)throws  SQLException{                                 //下了单，sell是下单状态,在购物车里面下单
        QueryRunner queryRunner = new QueryRunner(DataSouurce.getDataSource());
                    String SQL  ="update cart set Psta=?where cartID=?";
                    int flag    = queryRunner.update(SQL,'B',cartID);
                    return flag>0;
    }



    public List<Cart> getBuyOrder(String buyID,String OrderSta1,String OrderSta2,String OrderSta3) throws SQLException{                                                                             //或取buy的订单
        QueryRunner queryRunner = new QueryRunner(DataSouurce.getDataSource());
        String SQL              = "SELECT *from cart where buyUid=? and  (Psta=? or Psta=? or Psta=?)";
        return queryRunner.query(SQL,new BeanListHandler<Cart>(Cart.class),buyID,OrderSta1,OrderSta2,OrderSta3);

    }
    public List<Cart> getBuyOrder2(String buyID,String OrderSta1) throws SQLException{                                                                             //或取buy的订单
        QueryRunner queryRunner = new QueryRunner(DataSouurce.getDataSource());
        String SQL              = "SELECT *from cart where buyUid=? and  Psta=? ";
        return queryRunner.query(SQL,new BeanListHandler<Cart>(Cart.class),buyID,OrderSta1);

    }


    //获取sell的订单，我所出售的商品形成的订单，我作为哦商家接受的订单
    public List<Cart> getSellOrder(String sellID,String OrderSta) throws SQLException{

        QueryRunner queryRunner = new QueryRunner(DataSouurce.getDataSource());
        String SQL              = "SELECT *from cart where sellUid=? and  Psta=?";
        return queryRunner.query(SQL,new BeanListHandler<Cart>(Cart.class),sellID,OrderSta);

    }

     public boolean UpOrderSta(String OrderID,String OrderSta) throws SQLException              //修改订单状态
     {   String SQL1         = "select Psta from cart where cartID=? for update ";
          String SQL         = "update cart set Psta=?where cartID=?" ;
          int flag=0;
         QueryRunner queryRunner = new QueryRunner(DataSouurce.getDataSource());

                      DataSouurce.startTransaction();


         System.out.println("我是 orderSTA "+OrderSta);
        String  OrderS = OrderSta;

          if (OrderS.equals("D") || OrderS.equals("C") ) {
              String PST    = queryRunner.query(SQL1, rs -> {
                  String P=null;
                  if (rs.next())
                  {
                      P=(String) rs.getObject(1);
                  }
                  return P;
              },OrderID);

              if (PST.equals("B"))
              {
                  flag = queryRunner.update(SQL,OrderSta,OrderID);
                  DataSouurce.commitAndRelease();
              }
              else {
                  DataSouurce.rollback();
                  DataSouurce.closeConnection();
                  return false;
              }
          }
            else if (OrderS.equals("A")) {
              String PST    = queryRunner.query(SQL1, rs -> {
                  String P=null;
                  if (rs.next())
                  {
                      P=(String) rs.getObject(1);
                  }
                  return P;
              },OrderID);
              System.out.println("我是 PST2"+PST);
              if (PST.equals("C") || PST.equals("B"))
              {
                  flag = queryRunner.update(SQL,OrderSta,OrderID);
                  DataSouurce.commitAndRelease();
              }
              else {
                  DataSouurce.rollback();
                  DataSouurce.closeConnection();
                  return false;
              }

          }
           else   if (OrderS.equals("B")){
                           System.out.println("1");
              String PST    = queryRunner.query(SQL1, new ResultSetHandler<String>() {
                  @Override
                  public String handle(ResultSet rs) throws SQLException {
                                  String P=null;
                                   if (rs.next())
                                   {
                                       P=(String) rs.getObject(1);
                                   }
                             return P;
                  }
              },OrderID);
              System.out.println("我是 PST3"+PST);
              if (PST.equals("A"))
              {
                  flag = queryRunner.update(SQL,OrderSta,OrderID);
                  DataSouurce.commitAndRelease();
              }
              else {
                  DataSouurce.rollback();
                  DataSouurce.closeConnection();
                  return false;
              }


          }

       return flag>0;

     }
    public boolean UpOrderNumber(String getOrderName,String OrderID) throws SQLException
    {
        QueryRunner queryRunner = new QueryRunner(DataSouurce.getDataSource());

        String SQL              = "update cart set getOrderName=?where cartID=?";
        int flag                = queryRunner.update(SQL,getOrderName,OrderID);
        return flag>0;
    }
    public boolean DeletPcart(String PID) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSouurce.getDataSource());
        String SQL  = "delete from cart where pid=?";
        int flag    = queryRunner.update(SQL,PID);

        return flag>0;
    }

    public boolean alterCartP(Product product) throws  Exception{

        QueryRunner queryRunner = new QueryRunner(DataSouurce.getDataSource());
        String SQL = "update cart set Ppice=?,Pname=?,adress=?,phone=?,GetTime=? where Pid=?";
        int key    = queryRunner.update(SQL,product.getProductPrice(),
                product.getProductName(),
                product.getAdress(),
                product.getPhone(),
                product.getGetProductTime(),
                product.getProductID());
        return key>0;


    }


}
