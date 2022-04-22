package Working;

import Dao.UserDao;
import MainClass.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class SLongin {
    User user = null;
    UserDao userDao = new UserDao();
    public User setIsLogin(String userId,String userPass) {             //判断账号和密码是否正确
        System.out.println("我被进入了！！！，我是longin");
        System.out.println("YES");
        try {
         user  = userDao.getUser(userId,userPass);
        } catch (SQLException e) {
            System.out.println("我出问题了");
            e.printStackTrace();
        }
        if (user!=null)
        {
            return user;
        }
        return null;
    }
    public Boolean setRegister(User user)                                //注册用户
    {
        UserDao userDao = new UserDao();
        try {
            userDao.addUser(user);                                       //把用户放进数据库中保存
        } catch (SQLException e) {
            System.out.println("用户没有被成功添加");
            e.printStackTrace();
            return false;
        }

          return true;
    }

    //检查用户的登录状态，true为登录过的用户，false为没有登录过的用户，通过验证用户cookie登录属性和user中的用户登录属性来判断是否已经登录过
    //cookies中会封装用户ID，和用户登录验证码，用登录时间为验证，V2.1会使用cm5加密
    public Boolean ChickSta(HttpSession session,String S){
                                  String PassFilter=null;
                           try{
                               PassFilter =  session.getAttribute("loginSta").toString();
                               if (PassFilter.equals(S))
                               {
                                   return true;
                               }

                           } catch (Exception e){
                               e.printStackTrace();
                           }
                                   return false;

    }
    //设置用户登录转态，登录后调用该方法，设置cookie和session和用户登录属性
    public Boolean setSta(){
                return false;
    }

}
