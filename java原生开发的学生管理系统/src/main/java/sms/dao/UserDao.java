package sms.dao;

import sms.pojo.User;

import java.util.Map;

public interface UserDao {
     //获取用户
    User getUser(Map<String,Object> map);
    //获取用户权限等级
    int getUserPre(int key);
    //获取用户id 通过phone 和 pass
    int getUserId(Map<String,Object> map);
    //添加用户
    int addUser(User user);
    //删除用户
    int delUser(int id);
    //修改用户,传入ID,修改密码
    int updateUserPass(Map<String,Object> map);
    //检查是否被注册
   User chickExist(String account);

}
