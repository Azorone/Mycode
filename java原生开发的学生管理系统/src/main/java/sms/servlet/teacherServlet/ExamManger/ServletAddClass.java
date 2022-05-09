package sms.servlet.teacherServlet.ExamManger;

import com.google.gson.Gson;
import sms.pojo.User;
import sms.pojo.qusetion.ClassExam;
import sms.workdao.WorkQuestion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletAddClass")
public class ServletAddClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        ClassExam classExam;
        boolean p = false;
        for (Cookie c:cookies)
        {
            if (c.getName().equals("id"))
            {
                String id = c.getValue();
                HttpSession session = request.getSession();
                User user =(User) session.getAttribute(id);
                if (user!=null)
                {
                    System.out.println(request.getParameter("list"));
                    String  list = request.getParameter("list");
                    String eid   = request.getParameter("eid");
                    Gson gson = new Gson();
                    List<String> temp = gson.fromJson(list,List.class);
                    if ( temp==null || temp.isEmpty())
                    {
                        System.out.println("需要移除的题表为空值！");
                    }
                    else {
                        WorkQuestion question = new WorkQuestion();
                        for (String S:temp)
                        {    System.out.println("题id");
                           classExam = new ClassExam(S,eid,null);
                           p = question.addClassExam(classExam);
                        }
                    }
                    if (p)
                    {
                        System.out.println("以发布");
                        response.setCharacterEncoding("UTF-8");
                        PrintWriter out = response.getWriter();
                        out.println(1);
                        break;
                    }
                    else {
                        System.out.println("删除失败");
                        PrintWriter out = response.getWriter();
                        out.println(-1);
                        break;
                    }
                }else {
                    System.out.println("登录失效");
                    break;
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
