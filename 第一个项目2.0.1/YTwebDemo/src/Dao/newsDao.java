package Dao;

import MainClass.News;
import MainClass.Product;
import Tool.DataSouurce;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class newsDao {
 public   boolean addNews(News news) throws SQLException {
       QueryRunner queryRunner = new QueryRunner(DataSouurce.getDataSource());
       String SQL  = "insert into news (userID,txtAre,txtTime,txtclass,txtTile,phon,userName) values(?,?,?,?,?,?,?)";
       int flag    = queryRunner.update(SQL,news.getUserID(),
               news.getTxtAre(),news.getTxtTime(),news.getTxtclass(),news.getTxtTile(),news.getPhon(),news.getUserName());
       return  flag>0;
   }

    public List<News> GetAllNews() throws SQLException{
        QueryRunner runner = new QueryRunner(DataSouurce.getDataSource());
        String     SQL     = "select *from news";
        return runner.query(SQL, new BeanListHandler<News>(News.class));
    }

    public News GetANews(String ID) throws SQLException{
        QueryRunner runner = new QueryRunner(DataSouurce.getDataSource());
        String     SQL     = "select *from news where newsID=?";
        return runner.query(SQL,new BeanHandler<News>(News.class),ID);
    }


    public boolean DeletNews(String ID) throws  SQLException{
        QueryRunner runner =  new QueryRunner(DataSouurce.getDataSource());
        String      SQL    ="delete from news where newsID=?";
        int         flage  = runner.update(SQL,ID);
        return flage>0;
    }

    public boolean upNews(News news) throws SQLException{
        QueryRunner runner = new QueryRunner(DataSouurce.getDataSource());
        String      SQL    = "update news set txtAre=?,txtTime=?,txtclass=?,txtTile=?,phon=? where newsID=?";
        int key            = runner.update(SQL,news.getTxtAre(),news.getTxtTime(),news.getTxtclass(),news.getTxtTile(),news.getPhon(),news.getNewsID());


        return key>0;
    }

    public List<News> serchNews(String key) throws SQLException{
        String Key = "%"+key+"%";
        QueryRunner queryRunner = new QueryRunner(DataSouurce.getDataSource());
        String SQL = "SELECT * FROM news WHERE CONCAT(IFNULL(userID,''),IFNULL(txtAre,''),IFNULL(txtclass,''),IFNULL(txtTile,'')) LIKE ?";
        return queryRunner.query(SQL,new BeanListHandler<News>(News.class),Key);

    }
    public List<News> getClassNews(String NewsClass) throws SQLException{
        String     SQL     = "select *from news where txtclass=?";
        QueryRunner queryRunner = new QueryRunner(DataSouurce.getDataSource());
        return queryRunner.query(SQL,new BeanListHandler<News>(News.class),NewsClass);

    }
    public  List<News> getmyNews(String MYID) throws SQLException{
        QueryRunner runner = new QueryRunner(DataSouurce.getDataSource());
        String     SQL     = "select *from news where userID=?";
        return runner.query(SQL,new BeanListHandler<News>(News.class),MYID);
    }
}
