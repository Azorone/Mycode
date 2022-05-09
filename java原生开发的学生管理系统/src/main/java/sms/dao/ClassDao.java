package sms.dao;
import sms.pojo.Classber;
import sms.pojo.Joinnews;

import java.util.List;
import java.util.Map;

public interface ClassDao {
    //添加教室
    int addClass(Classber classber);
    //删除教室
    int delClass(int cid);
    //修改教室
    int updateClass(Classber classber);
    //查找单独的教室
    Classber getClassber(int cid);
    //获取所有的教室,老师
    List<Classber> getClassbersT(int tid);
    //判断是否以经加入教室
    Classber isExist(int sid,int cid);


    //判断申请是否存在
    Joinnews isExistNews(Map<String,Object> map);
    //删除申请
    int delJoinNews(int newsid);
    //添加申请
    int addJoinNews(Joinnews joinnews);
    //获取一个申请
    Joinnews getJoinNews(int newsid);
    List<Joinnews> getClassAllNews(int cid);

}
