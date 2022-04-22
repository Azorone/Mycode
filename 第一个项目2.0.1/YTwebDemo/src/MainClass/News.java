package MainClass;

public class News {
    String newsID;
    String userID;
    String txtAre;
    String txtTime;
    String txtclass;
   String txtTile;
   String phon;
   String userName;

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setNewsID(String newsID) {
        this.newsID = newsID;
    }

    public void setPhon(String phon) {
        this.phon = phon;
    }

    public void setTxtAre(String txtAre) {
        this.txtAre = txtAre;
    }

    public void setTxtclass(String txtclass) {
        this.txtclass = txtclass;
    }

    public void setTxtTile(String txtTile) {
        this.txtTile = txtTile;
    }

    public void setTxtTime(String txtTime) {
        this.txtTime = txtTime;
    }

    public String getNewsID() {
        return newsID;
    }

    public String getPhon() {
        return phon;
    }

    public String getTxtAre() {
        return txtAre;
    }

    public String getTxtclass() {
        return txtclass;
    }

    public String getTxtTile() {
        return txtTile;
    }

    public String getTxtTime() {
        return txtTime;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsID='" + newsID + '\'' +
                ", userID='" + userID + '\'' +
                ", txtAre='" + txtAre + '\'' +
                ", txtTime='" + txtTime + '\'' +
                ", txtclass='" + txtclass + '\'' +
                ", txtTile='" + txtTile + '\'' +
                ", phon='" + phon + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
