package MainClass;

public class Cart {
  private   String sellUid;      //售卖者ID
   private String buyUid;       //购买者ID
   private String Pid   ;       //商品ID
   private String Pmurl ;      //商品图片
   private String Psta  ;      //订单状态
    double Ppice ;     //商品价格
   private String Pname ;     //商品名字
   private String CartID;
   private String SellName;
   private String BuyName;
   private String adress;            //取货地址
   private String phone;             //联系电话
   private String getOrderName;      //取货码
   private String GetTime;           //取货时间
    public void setBuyUid(String buyUid) {
        this.buyUid = buyUid;
    }
    public void setPid(String pid) {
        Pid = pid;
    }
    public void setPmurl(String pmurl) {
        Pmurl = pmurl;
    }
    public void setPname(String pname) {
        Pname = pname;
    }
    public void setPpice(double ppice) {
        Ppice = ppice;
    }
    public void setPsta(String psta) {
        Psta = psta;
    }
    public void setSellUid(String sellUid) {
        this.sellUid = sellUid;
    }
    public String getBuyUid() {
        return buyUid;
    }
    public String getPid() {
        return Pid;
    }
    public String getPmurl() {
        return Pmurl;
    }
    public String getPname() {
        return Pname;
    }
    public double getPpice() {
        return Ppice;
    }
    public String getPsta() {
        return Psta;
    }
    public String getSellUid() {
        return sellUid;
    }
    public String getCartID() {
        return CartID;
    }
    public void setCartID(String cartID) {
        CartID = cartID;
    }
    public void setBuyName(String buysta) {
        BuyName= buysta;
    }
    public void setSellName(String sellsta) {
        SellName = sellsta;
    }
    public String getBuyName() {
        return BuyName;
    }
    public String getSellName() {
        return SellName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAdress() {
        return adress;
    }

    public String getGetOrderName() {
        return getOrderName;
    }

    public String getGetTime() {
        return GetTime;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setGetOrderName(String getOrderName) {
        this.getOrderName = getOrderName;
    }

    public void setGetTime(String getTime) {
        GetTime = getTime;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "sellUid='" + sellUid + '\'' +
                ", buyUid='" + buyUid + '\'' +
                ", Pid='" + Pid + '\'' +
                ", Pmurl='" + Pmurl + '\'' +
                ", Psta='" + Psta + '\'' +
                ", Ppice=" + Ppice +
                ", Pname='" + Pname + '\'' +
                ", CartID='" + CartID + '\'' +
                ", SellName='" + SellName + '\'' +
                ", BuyName='" + BuyName + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                ", getOrderName='" + getOrderName + '\'' +
                ", GetTime='" + GetTime + '\'' +
                '}';
    }
}

