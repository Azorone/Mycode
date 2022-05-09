package sms.dao;

import sms.pojo.Clst;

import java.util.List;
import java.util.Map;

public interface ClstDao {
    //学生加入教室
    int addclast(Clst clst);
    //学生退出教室,或者老师移除学生
    int delClast(Clst clst);
    //老师解散教室
    int dissolveClass(int cid);
    //获取学生加入的教室id
    List<Integer> getCid(int sid);
    //获取加入教室的学生id
    List<Integer> getSid(int cid);
    //根据 cid 和 sid 获取记录 ，用于判断是否存在或者其它用途
    Clst getClst(Clst clst);
}
