package Working;

import Dao.ProductDao;
import Dao.newsDao;
import MainClass.News;
import MainClass.Product;

import java.util.ArrayList;
import java.util.List;

public class NewsWoring {
    newsDao dao = new newsDao();
 public   boolean  alterNews(News news){



      try{

          boolean fl = dao.upNews(news);
          if (fl)
          {
              return  true;
          }

      }catch (Exception e){
          e.printStackTrace();
      }

      return false;

  }               //修改

   public boolean addNews(News news)                      //添加
    {
     try {
       boolean fl =   dao.addNews(news);
       if (fl){
           return  true;
       }
     }catch (Exception E){
         E.printStackTrace();
     }

         return  false;

    }

   public boolean Delect(String ID){

     try {
        boolean key = dao.DeletNews(ID);
        if (key){
            return true;
        }
     }catch (Exception e){
         e.printStackTrace();
     }
     return  false;

   }                   //删除信息

    public List<News> getNewstClass(String pclass){
        List<News> NewsP = new ArrayList<News>();

        System.out.println(pclass);
        try {
            if (pclass.equals("1"))
            {
            NewsP =  dao.getClassNews("失物招领");
            System.out.println("\"失物招领\"");
            System.out.println();
            }
            else  if (pclass.equals("2"))
            {
              NewsP=  dao.getClassNews("寻求帮助");
                System.out.println("\"寻求帮助\"");
            }
            else if (pclass.equals("3"))
            {
               NewsP = dao.getClassNews("留言");
                System.out.println("\"留言\"");
            }
            else if (pclass.equals("4"))
                NewsP= dao.getClassNews("其它");
            System.out.println("\"其它\"");

        }catch (Exception E){
            E.printStackTrace();
            return null;
        }
         System.out.println(NewsP);
        return NewsP;

    }    //分类获取

 public   News getANews(String ID){
            News news = null;

           try {
            news  = dao.GetANews(ID);
           }catch (Exception e){
               e.printStackTrace();
           }
            return news;
 }

public  List<News> getMYNews(String MYID){


     List<News> news = null;
     try {
         news = dao.getmyNews(MYID);
     }catch (Exception e){
         e.printStackTrace();
     }
     return news;
}                //获取我的商品

    public  List<News> serchN(String KEY)
    {

        List<News> newsList = new ArrayList<>();
        try {
            newsList = dao.serchNews(KEY);
        }catch (Exception e){
            e.printStackTrace();
        }

        return newsList;
    }


}
