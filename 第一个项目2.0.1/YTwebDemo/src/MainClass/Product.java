package MainClass;

public class Product {
    private String productName ;
    private String productID;
    private double productPrice;
    private String productBelongName;      //该件产品的上传人姓名
    private String productBelongID;        //该件产品的上传人ID
    private String productIMGurl;          //该件产的图片地址
    private String productDescribe;        //该件产品的描述
    private String productClass;           //该件产品的种类
    private String Productquantity;        //该产品的数量
    private String adress;                 //取货地址
    private String phone;                  //联系方式
    private String getProductTime;         //取回时间
    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
    }

    public void setProductBelongID(String productBelongID) {
        this.productBelongID = productBelongID;
    }

    public void setProductBelongName(String productBelongName) {
        this.productBelongName = productBelongName;
    }

    public void setProductIMGurl(String productIMGurl) {
        this.productIMGurl = productIMGurl;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setGetProductTime(String getProductTime) {
        this.getProductTime = getProductTime;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProductquantity(String productquantity) {
        Productquantity = productquantity;
    }

    public String getProductClass() {
        return productClass;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductDescribe() {
        return productDescribe;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductBelongID() {
        return productBelongID;
    }

    public String getProductBelongName() {
        return productBelongName;
    }

    public String getProductIMGurl() {
        return productIMGurl;
    }

    public String getAdress() {
        return adress;
    }

    public String getGetProductTime() {
        return getProductTime;
    }

    public String getPhone() {
        return phone;
    }

    public String getProductquantity() {
        return Productquantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productID='" + productID + '\'' +
                ", productPrice=" + productPrice +
                ", productBelongName='" + productBelongName + '\'' +
                ", productBelongID='" + productBelongID + '\'' +
                ", productIMGurl='" + productIMGurl + '\'' +
                ", productDescribe='" + productDescribe + '\'' +
                ", productClass='" + productClass + '\'' +
                ", Productquantity='" + Productquantity + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                ", getProductTime='" + getProductTime + '\'' +
                '}';
    }
}
