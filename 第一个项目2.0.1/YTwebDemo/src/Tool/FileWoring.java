package Tool;

import Dao.ProductDao;
import MainClass.Product;

import java.io.File;

public class FileWoring {
 public  static   boolean delectPict(String PATH) {

       System.out.println(PATH);
       File file = new File(PATH);
       if (!file.exists()) {
           System.out.println("文件不存在！");
           return false;
       } else {
           file.delete();
           if (!file.exists()) {
              return true;
           }
       }

          return  false;
   }}