package MainClass;

import Dao.ProductDao;

import java.util.List;

public class Page {
   private int PageNumber=1;             //ҳ��
   private int limiits=12 ;             //ÿҳ��ȡ����Ʒ����
   private List<Product> productList =null; //��Ʒ�б�
   private String dataBases=null;                //���Ǹ����ݱ��ҳ
   private List<Cart> ListCarts = null;     //��ȡ���ﳵ
   private int toAll =0;                   //��Ʒ������
    ProductDao productDao = new ProductDao();
    public int getLimiits() {
        return limiits;
    }
    public int getPageNumber() {
        return PageNumber;
    }
    public List<Product> getProductList() {

        ProductDao productDao = new ProductDao();
       try {
           productList           = productDao.Productpage(PageNumber,limiits);
           if (productList.isEmpty())
           {
               System.out.println("��ҳʧ�ܣ�");
           }
       }catch (Exception e){
           System.out.println("��ҳʧ�ܣ�");
           e.printStackTrace();

       }


        return productList;
    }
    public List<Cart> getCartList(){


        return ListCarts;
    }

    public String getDataBases() {
        return dataBases;
    }

   public int  pageP(){
        try {
            toAll=productDao.getNumberP();
        }catch (Exception e){
            System.out.println("��ȡ�����쳣");
            e.printStackTrace();
        }


         return toAll;
   }
}
