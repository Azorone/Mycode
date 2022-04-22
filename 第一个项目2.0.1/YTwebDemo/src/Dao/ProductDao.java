package Dao;

import MainClass.Product;
import Tool.DataSouurce;
import com.mysql.cj.Query;
import org.apache.commons.dbutils.BaseResultSetHandler;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.SQLException;
import java.util.List;
//添加商品
public class ProductDao {
    public  boolean addProduct(Product product ) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSouurce.getDataSource());
        String SQL         = "insert into productab (productName,productID,productPrice,productBelongName,productBelongID,productIMGurl,productDescribe,productClass,Productquantity,adress,phone,getProductTime) values(?,?,?,?,?,?,?,?,?,?,?,?);";
        int flage          = runner.update(SQL,
                product.getProductName(),
                product.getProductID(),
                product.getProductPrice(),
                product.getProductBelongName(),
                product.getProductBelongID(),
                product.getProductIMGurl(),
                product.getProductDescribe(),
                product.getProductClass() ,
                product.getProductquantity(),
                product.getAdress(),
                product.getPhone(),
                product.getGetProductTime());
         return flage>0;
    }
    //删除单件商品
    public boolean DeletProduct(String productID) throws  SQLException{
        QueryRunner runner =  new QueryRunner(DataSouurce.getDataSource());
        String      SQL    ="delete from productab where productID=?";
        int         flage  = runner.update(SQL,productID);
        return flage>0;
    }
    //获取所有商品
    public List<Product> GetAllProduct() throws SQLException{
        QueryRunner runner = new QueryRunner(DataSouurce.getDataSource());
        String     SQL     = "select *from productab";
        return runner.query(SQL, new BeanListHandler<Product>(Product.class));
    }
    //按种类获取商品
    public List<Product> GetClassProduct(String productClass) throws SQLException{
        QueryRunner runner = new QueryRunner(DataSouurce.getDataSource());
        String      SQL    ="select * from productab where productClass=?";
        return      runner.query(SQL,new BeanListHandler<Product>(Product.class),productClass);

    }
    //按照所有者id获取商品
    public List<Product> GetBelongProduct(String productBelongID) throws  SQLException{                 //获取用户上传的商品
        QueryRunner runner = new QueryRunner(DataSouurce.getDataSource());
        String      SQL    = "select *from productab where productBelongID=?;";

        return      runner.query(SQL,new BeanListHandler<Product>(Product.class),productBelongID);
    }
    //根据商品唯一ID获取商品信息


     public Product GetProduct(String productID) throws SQLException{
        QueryRunner runner = new QueryRunner(DataSouurce.getDataSource());
        String      SQL    = "select *from productab where productID=?";
        return      runner.query(SQL,new BeanHandler<Product>(Product.class),productID);
     }


     public   List<Product> Productpage(int PagNumber,int limit ) throws  SQLException{
         QueryRunner runner = new QueryRunner(DataSouurce.getDataSource());

         String      SQL    = "select * from productab  limit (?-1)*?,?";
         return          runner.query(SQL,new BeanListHandler<Product>(Product.class),PagNumber,limit,limit) ;
     }

     public boolean upProduct(Product product,String productID) throws SQLException{
          QueryRunner runner = new QueryRunner(DataSouurce.getDataSource());
          String      SQL    = "update productab set productName=?,productPrice=?,productDescribe=?,productClass=?,adress=?,phone=?,getProductTime=?where productID= ?";
          int key            = runner.update(SQL,product.getProductName(),product.getProductPrice(),product.getProductDescribe(),product.getProductClass(),product.getAdress(),product.getPhone(),product.getGetProductTime(),productID);


              return key>0;
     }

    public List<Product>serchProduct(String key) throws SQLException{
            String Key = "%"+key+"%";
        QueryRunner queryRunner = new QueryRunner(DataSouurce.getDataSource());
        String SQL = "SELECT * FROM productab WHERE CONCAT(IFNULL(productName,''),IFNULL(productDescribe,''),IFNULL(productClass,'')) LIKE ?";
        return queryRunner.query(SQL,new BeanListHandler<Product>(Product.class),Key);

    }
    public int getNumberP() throws SQLException{
           QueryRunner runner = new QueryRunner(DataSouurce.getDataSource());
           String SQL         = "SELECT COUNT(*) FROM productab";
           return runner.execute(SQL);
    }
}

