package sms.service;

import Util.mybatisUtil;

import org.apache.ibatis.session.SqlSession;
import sms.dao.UserDao;
import sms.pojo.User;

import java.util.HashMap;
import java.util.Map;

public class Login {
    User USER = null;
   public boolean chickUser(String account,String pass){
        Map<String,Object> map = new HashMap<>();
        map.put("account",account);
        map.put("pass",pass);
        SqlSession sqlSession = mybatisUtil.getSqlSession();
        UserDao mapper         = sqlSession.getMapper(UserDao.class);
               USER = mapper.getUser(map);
              if (USER != null)
              {
                  System.out.println("用户存在！"+USER.toString());
                  return true;
              }
            return false;
    }
    public User getUSER() {
        return USER;
    }
}
