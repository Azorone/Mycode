package sms.tool;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ToolPojo {

    public static void main(String[] args) {
        Test test = new Test();
       Class type = test.getClass();

       Method[] methods =  type.getMethods();
        Field[] fields  = type.getDeclaredFields();
       for (Field field:fields){
           field.setAccessible(true);
           try {
               field.set(test,"1");
           } catch (IllegalAccessException e) {
               e.printStackTrace();
           }

           if ((field.getName()).endsWith("String"))
           {
               System.out.println("YES");
           }


           System.out.println( field.getType()+":"+field.getName());
       }
        for (Method method:methods){
            try {
                if ((method.getName()).startsWith("set")){
                    method.invoke(test,"hhh");
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
      System.out.println(test.toString());
    }



}
class Test{
    private String ID;
    private String name;
    private String phone;
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "test{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
