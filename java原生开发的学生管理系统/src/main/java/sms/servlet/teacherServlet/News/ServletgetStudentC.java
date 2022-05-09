package sms.servlet.teacherServlet.News;

import com.google.gson.Gson;
import sms.pojo.Student;
import sms.pojo.Studentm;
import sms.pojo.User;
import sms.workdao.WorkTeacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletgetStudentC")
public class ServletgetStudentC extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String cid = request.getParameter("cid");
        System.out.println(cid);
        if (cid!=null)
        {
            Cookie[] cookies = request.getCookies();
            for (Cookie c:cookies)
            {
                if (c.getName().equals("id"))
                {
                    String id = c.getValue();
                    HttpSession session = request.getSession();
                    User user =(User) session.getAttribute(id);
                    if (user!=null)
                    {    System.out.println("存在！");
                        WorkTeacher workTeacher = new WorkTeacher();
                        List<Studentm> joinnewsList = workTeacher.getStudents(cid);
                        int p ;
                        if (joinnewsList == null || joinnewsList.isEmpty())
                        {
                            System.out.println("没有学生");
                            response.setCharacterEncoding("UTF-8");
                            PrintWriter out = response.getWriter();
                            out.println(-1);
                            break;

                        }
                        else {
                            System.out.println("有学生！");
                            Gson gson = new Gson();
                            String json = gson.toJson(joinnewsList);
                            System.out.println(json);
                            response.setCharacterEncoding("UTF-8");
                            PrintWriter out = response.getWriter();
                            out.println(json);
                            break;
                        }

                    }else {
                        System.out.println("登录失效");
                        break;
                    }
                }
            }
        }
        else {
            System.out.println("错误！");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
