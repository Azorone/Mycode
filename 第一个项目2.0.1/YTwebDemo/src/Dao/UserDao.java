package Dao;

import MainClass.User;
import Tool.DataSouurce;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import java.sql.SQLException;
public class UserDao {
    public Boolean addUser(User user) throws SQLException                                                                                //注册新用户,返回真代表
    {
        QueryRunner runner = new QueryRunner(DataSouurce.getDataSource());
        String      SQL    = "insert into userdatas (userId,userName,userAdress,userPass,userMail) values(?,?,?,?,?);";
        int flage          = runner.update(SQL,user.getUserId(),user.getUseName(),user.getUserAdress(),user.getUserPass(),user.getUserMail ());
        return flage>0;
    }
    public User getUser(String userId,String userPass) throws SQLException{
        QueryRunner runner = new QueryRunner(DataSouurce.getDataSource());                                  //登录验证                    userSTM判断登录状态,
        String      SQL    = "select * from userdatas where userId=? and userPass=?";
        return           runner.query(SQL, new BeanHandler<>(User.class),userId,userPass);
    }
    public Boolean isExist(String userID) throws SQLException{                                                                //判断注册时候是否是唯一ID
        QueryRunner runner = new QueryRunner(DataSouurce.getDataSource());
        String SQL         = "select count(*) from userdatas where userId=?";
        long       query   = (long)runner.query(SQL,new ScalarHandler<>(),userID);

        return query>0;
    }
    public Boolean UpUserPass(User user) throws SQLException{                                                                //更新用户信息
        QueryRunner runner = new QueryRunner(DataSouurce.getDataSource());
        String SQL         = "update userdatas set userPass=?,userAdress=?where userID = ?";
        int flage          = runner.update(SQL,user.getUserPass(),user.getUserAdress(),user.getUserId());
        return flage>0;
    }


}
