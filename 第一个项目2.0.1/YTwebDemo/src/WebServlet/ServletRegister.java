package WebServlet;

import Dao.UserDao;
import MainClass.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
/**？
 * 用户登录Servlet
 *
 *
 * **/
@WebServlet(name = "ServletRegister")
public class ServletRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                    request.setCharacterEncoding("UTF-8");
                                    response.setHeader("content-type","text/html;charset=utf-8");
                                    System.out.println("我被进入了！");
                                    Writer out = response.getWriter();
                                    User user = new User();
                                    UserDao userDao = new UserDao();
                                    String UserID=    request.getParameter("userID");//用户id
                                    user.setUserMail (request.getParameter("userMail")); /*-获取用户邮箱*/
                                    user.setUserName(request.getParameter("userName")); /*--获取用户姓名--*/
                                    user.setUserPass(request.getParameter("userPass")); /*--获取用户密码--*/
                                    user.setUserId(UserID);
                                    user.setUserAdress(request.getParameter("userAdress"));  /*--获取用户地址--*/
                                       try { if (userDao.isExist(UserID)){

                                            out.write("false");
                                             return;
                                          }
                                          boolean key = userDao.addUser(user);
                                          if (key)
                                          {
                                              out.write("true");
                                              return;
                                          }


                                             }catch (SQLException e) {

                                           e.printStackTrace();
                                       }
                                       System.out.println(user.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
