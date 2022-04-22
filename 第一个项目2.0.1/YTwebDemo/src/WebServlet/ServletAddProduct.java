package WebServlet;

import Dao.ProductDao;
import MainClass.Product;
import MainClass.User;
import Tool.ChickString;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;
/***
 * 获取上传的商品并存储在
 *url:productUp
 *
 * */
@WebServlet(name = "ServletAddProduct")
public class ServletAddProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我被进入了！！我是商品上传");
        boolean key =false;
        User user   = null;
        user        = (User) request.getSession().getAttribute("user");

        if (user!=null){
            ProductDao productDao = new ProductDao();
            Product product       = new Product();
            String PATH      = null;
            String ProductID =null;
            Map<String,String> map = new HashMap<String, String>();
            String[] IsOk = {"BMP","bmp","png", "PNG","WEBP","webp","jpg","JPG"};

                      //获取商品上传人id
                if (user!=null)
                {
                    ProductID = user.getUserId();
                    product.setProductBelongID(user.getUserId());
                }
                else {
                    response.sendRedirect("Login.html");
                    return;
                }
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-ddhhmmss");
            System.out.println(dateFormat.format(date));
            ProductID = ProductID +"-"+dateFormat.format(date); //图片的名称
            /*System.out.println(ProductID);*/

            String savePeth =  this.getServletContext().getRealPath("/picture");

            File file = new File(savePeth);
            if (!file.exists() && !file.isDirectory())
            {
                System.out.println(savePeth+"不存在需要创建！");
                file.mkdir();
            }
            String messge = "p";
            try {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload    = new ServletFileUpload(factory);
                upload.setHeaderEncoding("UTF-8");
                if (!ServletFileUpload.isMultipartContent(request))
                {   System.out.println("我退出了");
                    return;
                }
                List<FileItem> list = upload.parseRequest(request);
                for (FileItem item : list){
                    if (item.isFormField())            //是普通的表单 input ！=file
                    {
                        String name = item.getFieldName();
                        String value = item.getString("UTF-8");

                        ChickString chickString = new ChickString();
                        if (chickString.chickOP(value)){
                            map.put(name,value);
                        }
                        else {
                            response.sendRedirect("alterEroor.html");
                            return;
                        }


                        System.out.println(name+"="+value);
                    }
                    else {                             //是文件上传的表单 input =file
                        System.out.println("进入文件上传表单");
                        String filename = item.getName();
                        System.out.println(filename);
                        if (filename==null || filename.trim().equals(""))
                        {
                            continue;
                        }
                        filename = filename.substring(filename.lastIndexOf(".")+1);
                        System.out.println(filename);
                        for (String str : IsOk)
                        {
                            if (str.equals(filename))
                            {
                                key =true;
                            }
                        }
                        if (key)
                        {
                             System.out.println("文件上传");
                            filename = ProductID+"."+filename;
                            PATH     = filename;
                            InputStream in = item.getInputStream();
                            FileOutputStream out = new FileOutputStream(savePeth+"\\"+filename);

                            byte buffer[] = new byte[1024];
                            int len = 0;
                            while ((len=in.read(buffer))>0)
                            {
                                out.write(buffer,0,len);
                            }
                            in.close();
                            out.close();
                            item.delete();
                            messge="文件上传成功";}
                        else {
                            response.sendRedirect("alterEroor.html");
                            System.out.println("文件不符合格式");
                            return;
                        }
                    }

                }
            }catch (Exception e)
            {
                messge="文件上传失败！";
                e.printStackTrace();
            }
            if (messge.equals("文件上传成功"))
            {   product.setProductID(ProductID);             //设置id，id是上传的时间
                product.setProductIMGurl("picture"+"/"+PATH);
                product.setProductClass(map.get("productClass"));
                product.setProductDescribe(map.get("productDescribe"));
                product.setProductPrice(Double.valueOf(map.get("productPrice")));
                product.setProductName(map.get("productName"));
                product.setProductDescribe(map.get("productDescribe"));
                product.setProductBelongName(user.getUseName());                       //保存到数据库
                product.setAdress(map.get("adress"));
                product.setGetProductTime(map.get("getProductTime"));
                product.setPhone(map.get("phone"));
                product.setProductquantity(map.get("Productquantity"));
                System.out.println("我是被进入了");
                System.out.println( product.toString());

            }
            try {
                productDao.addProduct(product);
            }catch (Exception E)
            {
                E.printStackTrace();
                System.out.println("在数数据库里面存储失败");
            }

            response.sendRedirect("susses.html");
            System.out.println(messge);
        }
      else {

          System.out.println("请登录！");
          response.sendRedirect("Login.html");
         return;

        }
        /*把商品存进数据库中*/


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
