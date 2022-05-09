package sms.servlet.Tool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletControl")
public class ServletControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我被访问了");
        String kid = request.getParameter("kid");
        System.out.println(kid);
        if (kid.equals("doExam"))
        {
            String eid =request.getParameter("eid");
            String seid =request.getParameter("seid");
          response.sendRedirect("doExam.html?eid="+eid+"&seid="+seid);
        }
        else if (kid.equals("studentExam"))
        {
            String eid =request.getParameter("eid");
            String seid = request.getParameter("seid");
            response.sendRedirect("studentExam.html?eid="+eid+"&seid="+seid);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             doPost(request,response);
    }
}
