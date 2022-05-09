package sms.servlet.teacherServlet.ExamManger;

import com.google.gson.Gson;
import sms.pojo.User;
import sms.workdao.WorkQuestion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletremoveClass")
public class ServletremoveClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("我被进入了，我是ServletremoveClass");




        Cookie[] cookies = request.getCookies();
        for (Cookie c:cookies)
        {
            if (c.getName().equals("id"))
            {
                String id = c.getValue();
                HttpSession session = request.getSession();
                User user =(User) session.getAttribute(id);
                if (user!=null)
                {   int p = 0;
                    System.out.println(request.getParameter("list"));
                    String  list = request.getParameter("list");
                    String eid   = request.getParameter("eid");
                    Gson gson = new Gson();
                    List<String> temp = gson.fromJson(list,List.class);
                    if ( temp==null || temp.isEmpty())
                    {
                        System.out.println("需要移除的教室列表为空值！");
                    }
                    else {
                        WorkQuestion question = new WorkQuestion();
                        for (String S:temp)
                        {    System.out.println("教室id");
                            p= question.deleClassExamEid(eid,S);
                        }


                    }
                    if (p>0)
                    {
                        System.out.println("以删除");
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
