package sms.servlet.teacherServlet.ExamManger;

import sms.dao.QuestionDao;
import sms.pojo.User;
import sms.pojo.qusetion.Exam;
import sms.workdao.WorkQuestion;
import sms.workdao.WorkTeacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

@WebServlet(name = "ServletCreatExam")
public class ServletCreatExam extends HttpServlet {
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
                {    System.out.println("存在！");
                    String ename = request.getParameter("ename");
                    System.out.println(ename);
                    WorkQuestion question = new WorkQuestion();
                    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd ");
                    Date date = new Date(System.currentTimeMillis());
                    String T = formatter.format(date);
                    Exam exam= new Exam();
                    exam.setEname(ename);
                    exam.setEtime(T);
                    exam.setTid(user.getId());
                    boolean p = question.creatExam(exam);
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
