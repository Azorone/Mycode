package sms.servlet.teacherServlet;

import sms.workdao.WorkTeacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDealNews")
public class ServletDealNews extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { WorkTeacher workTeacher = new WorkTeacher();




       String ID  =  request.getParameter("newsid");
       String STA = request.getParameter("sta");
       System.out.println("我是加入教室！");
        if (STA.equals("YES")){
            workTeacher.dealNews(ID,STA);
        }
        else if (STA.equals("NO")){
            workTeacher.dealNews(ID,STA);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
