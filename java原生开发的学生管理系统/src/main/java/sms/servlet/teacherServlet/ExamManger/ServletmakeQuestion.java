package sms.servlet.teacherServlet.ExamManger;

import sms.pojo.User;
import sms.pojo.qusetion.Exam;
import sms.pojo.qusetion.seletq;
import sms.workdao.Question;
import sms.workdao.WorkQuestion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

@WebServlet(name = "ServletmakeQuestion")
public class ServletmakeQuestion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我是创建Exam");
        Cookie[] cookies = request.getCookies();
        for (Cookie c:cookies)
        {
            if (c.getName().equals("id"))
            {
                String id = c.getValue();
                HttpSession session = request.getSession();
                User user =(User) session.getAttribute(id);
                if (user!=null)
                {
                    WorkQuestion question = new WorkQuestion();
                   String qclass = request.getParameter("qclass");
                   String qtitle = request.getParameter("qtitle");
                   String ansA  = request.getParameter("ansA");
                    String ansB  = request.getParameter("ansB");
                    String ansC  = request.getParameter("ansC");
                    String ansD  = request.getParameter("ansD");
                    String ans  = request.getParameter("ans");
                   seletq s = new seletq(null,qclass,ansA,ansB,ansC,ansD,ans,null,qtitle, user.getId());
                   s.setTid(user.getId());
                    boolean p = question.addSeletq(s);
                    if (p)
                    {
                        System.out.println("以创建");
                        response.setCharacterEncoding("UTF-8");
                        PrintWriter out = response.getWriter();
                        out.println(1);
                        break;
                    }
                    else {
                        System.out.println("创建失败");
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
