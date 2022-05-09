package sms.dao;

import sms.pojo.Classber;
import sms.pojo.qusetion.*;

import java.util.List;
import java.util.Map;

public interface QuestionDao {
    //添加一道选择题
    int  addseletq(seletq s);
    //添加一道论述题
    int  addLunq(Lunq lunq);
    //删除一道选择题
    int delSeletq(int qid);
    //删除一道论述题
    int delLunq(int wqid);
    //添加一份试卷
    int addExam(Exam e);
    //删除一份试卷
    int delExam(int eid);
    //添加试卷试题关系表
    int addEqtable(Eqtable eqtable);
    //删除试卷关系表
    int delEqtable(int eqid);
    //查询教
    List<Exam> getTeacherExam(int tid);
   //删除一张试卷的所有E-Q关系
    int delEQEid(int eid);


    int delEqtableEid(int eid);
    //用于试卷的合成
    //查询一张试卷
    Exam getexam(int eid);
    //查询试卷的选择题
    List<seletq> getSeletqs( int eid);
    //查询试卷的论述题
    List<Lunq> getLunqs(int eid);

    //添加一张试卷到教室

    //添加试卷教室关系表
    int addClassExam(ClassExam classExam);
    //删除试卷教室关系表
    int delClassExam(int ecid);
    //查找教室所有的试卷
    List<Exam> getClassExamcid(int cid);
    //查询试卷被所有的所有教室
    List<Classber> getClassExameid(int eid);

    int addsetable(Setable setable);
    //检查试卷是否被发布
    ClassExam isExisetCE(Map<String,Object> map);
    //获得这个老师创建的选择题
    List<seletq> getSeletqTid(int tid);
    //获得这个老师创建的论述题
    List<Lunq> getLunqTid(int tid);
    //删除学生-考试表
    int deleSetable(int ecid);
    //根据试卷获得教室作业表
    List<ClassExam> getClassExamEid(int eid);


    //获得某个学生的某次考试成绩，cid+eid     ecid+sid
     Setable getASetable(Map<String,Object> map);
    //获得学生在cid的所有考试情况  根据cid 获得 ecid 根据ecid 和 sid 在setable 中查找 成绩
    List<Setable> getSetableCid(Map<String,Object> map);

    //获取不在试卷中 tid 所创建的选择题
    List<seletq> getNoEidSq(Map<String,Object> map);
    //获取不在试卷中 tid 所创建的论述题目
    List<Lunq>   getNoEidLq(Map<String,Object> map);
     //获取试卷不在的教室
    List<Classber> getNoClass(Map<String,Object> map);
    //删除试卷中的某个题
    int delExamQusetion(Map<String,Object> map);

    //添加学生成绩
    int updateStudent(Map<String,Object> map);

}
