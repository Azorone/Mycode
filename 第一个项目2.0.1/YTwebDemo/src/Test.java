import Dao.UserDao;
import MainClass.User;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        boolean key=false;
        User usertset = new User();
        usertset.setUserAdress("北京");
        usertset.setUserId("1234167");
        usertset.setUserPass("134569");
        usertset.setUserName("狗四");
        usertset.setUserMail ("yes");  //获取cook中的值相匹配，判断是否已经登录
        UserDao dao = new UserDao();

        User user   = new User();
        try {


           user = dao.getUser("1234167","134569");
            dao.addUser(usertset);

        } catch (SQLException e) {
            System.out.println("NO");
            e.printStackTrace();

        }
        try {
          key=  dao.isExist("1234167");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.print(user.toString()+key);
    }



}
