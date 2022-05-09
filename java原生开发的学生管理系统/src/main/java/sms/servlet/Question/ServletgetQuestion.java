package sms.servlet.Question;

import com.google.gson.Gson;
import sms.dao.QuestionDao;
import sms.pojo.Classber;
import sms.pojo.User;
import sms.pojo.qusetion.TestName;
import sms.workdao.WorkQuestion;
import sms.workdao.WorkStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletgetQuestion")
public class ServletgetQuestion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=null ;
        String cid = request.getParameter("cid");
        System.out.println(cid);
        Cookie[] cookie = request.getCookies();
        for (Cookie cookie1:cookie)
        {
            if (cookie1.getName().equals("id"))
            {


                id = cookie1.getValue();
                WorkQuestion workQuestion = new WorkQuestion();
              List<TestName> testNameList= workQuestion.getStudentQ(cid,id);

                if (testNameList==null)
                {
                    PrintWriter out = response.getWriter();
                    System.out.println("没有加入教室！");
                    out.println("没有加入任何教室！");

                }
                else {
                    response.setCharacterEncoding("utf-8");
                    Gson gson =new Gson();
                    String json = gson.toJson(testNameList);
                    System.out.println(json);
                    PrintWriter out = response.getWriter();

                    out.println(json);
                    break;
                }
                break;
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
