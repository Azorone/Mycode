package sms.workdao;

import Util.mybatisUtil;
import org.apache.ibatis.session.SqlSession;
import sms.dao.McDao;
import sms.pojo.zl.material;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Workmaterial {
 public   int  addMc(String cid,String zid)
   {
       Map<String,Object> map = new HashMap<>();
       map.put("cid",cid);
       map.put("zid",zid);
       SqlSession session = mybatisUtil.getSqlSession();
       McDao mapper       = session.getMapper(McDao.class);
           int i =  mapper.addMc(map);
             session.commit();
             session.close();
             return i;
   }
 public   int addm(material m){


       SqlSession session = mybatisUtil.getSqlSession();
       McDao mapper       = session.getMapper(McDao.class);
       int i =  mapper.addm(m);
       session.commit();
       session.close();
       return i;
   }

  public int delm(String s){
       int k = Integer.valueOf(s);
       SqlSession session = mybatisUtil.getSqlSession();
       McDao mapper       = session.getMapper(McDao.class);
       int i =  mapper.delm(k);
       session.commit();
       session.close();
       return i;

   }
  public   int delmc(String s){
        int k = Integer.valueOf(s);
        SqlSession session = mybatisUtil.getSqlSession();
        McDao mapper       = session.getMapper(McDao.class);
        int i =  mapper.delmc(k);
        session.commit();
        session.close();
        return i;

    }

    List<material> getCidM(String id){
     int k =  Integer.valueOf(id);

        SqlSession session = mybatisUtil.getSqlSession();
        McDao mapper       = session.getMapper(McDao.class);



        List<material> list = mapper.getCidM(k);
        if (list==null || list.isEmpty())
        {
            return null;
        }
        session.close();
        return list;

    }

  public   List<material> getTidM(String id){

        int k =  Integer.valueOf(id);

        SqlSession session = mybatisUtil.getSqlSession();
        McDao mapper       = session.getMapper(McDao.class);



        List<material> list = mapper.getTidM(k);
        if (list==null || list.isEmpty())
        {
            return null;
        }
        session.close();
        return list;
    }
  public   material getm(String zid)
    {
        int id = Integer.valueOf(zid);

        SqlSession session = mybatisUtil.getSqlSession();
        McDao mapper       = session.getMapper(McDao.class);
        material m = mapper.getm(id);
     return m;
    }
}
