package MainClass;

public class User {
    private String userId ;
    private String userName = null;
    private String userAdress =null;
    private String userPass =null ;
    private String userMail  = null;

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserMail (String userMail ) {
        this.userMail  = userMail ;
    }

    public String getUserPass() {
        return userPass;
    }

    public String getUserAdress() {
        return userAdress;
    }

    public String getUseName() {
        return userName;
    }

    public String getUserMail () {
        return userMail ;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAdress='" + userAdress + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userMail='" + userMail  + '\'' +
                '}';
    }
}
