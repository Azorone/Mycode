package sms.workdao;

import sms.pojo.qusetion.Lunq;
import sms.pojo.qusetion.Exam;
import sms.pojo.qusetion.seletq;

public interface TestWord {

    //创建选择题
    boolean addQuestionSelect(seletq q);
    //创建论述题
    boolean addQuestionSelect(Lunq q);
    //创建试卷
    boolean addExam(Exam e);
    //发布试卷 试卷id 教室id
    boolean releaseExam();
    //创建试卷-题对应
    boolean addEqtable(String eid,String qid);
    //获取试卷的题
    boolean getQuestion();
}
