package sms.servlet;

import com.sun.prism.null3d.NULL3DPipeline;
import sms.pojo.qusetion.Setable;
import sms.pojo.qusetion.Test;
import sms.pojo.qusetion.seletq;
import sms.workdao.Question;
import sms.workdao.WorkQuestion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletTestScore")
public class ServletTestScore extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                 String eid= request.getParameter("eid");
                 System.out.println(eid);
                 String seid = request.getParameter("seid");
        WorkQuestion question = new WorkQuestion();
         String ANS= null;
        Test test =  question.getEidTest(eid);
        List<seletq>  seletqs = test.getSeletqList();
        int size = seletqs.size();
        int ok=0;

        for (seletq s: seletqs)
        {
              ANS =  request.getParameter(s.getQid()) ;
              System.out.println(ANS);
              if (s.getAns().equals(ANS))
              {
                  ok++;
              }
        }
        double temp =(ok/size)*100;
        String score = String.format("%.2f", temp);
        response.setCharacterEncoding("utf-8");
        PrintWriter out= response.getWriter();
        out.println(score);
         question.addSetableScore(seid,score);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
