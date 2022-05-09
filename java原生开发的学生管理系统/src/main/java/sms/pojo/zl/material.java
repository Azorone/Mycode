package sms.pojo.zl;

public class material {
    private String zname;
    private String zurl;
    private String zclass;

    public material(String zname, String zurl, String zclass) {
        this.zname = zname;
        this.zurl = zurl;
        this.zclass = zclass;
    }

    public material() {
    }

    public String getZname() {
        return zname;
    }

    public void setZname(String zname) {
        this.zname = zname;
    }

    public String getZurl() {
        return zurl;
    }

    public void setZurl(String zurl) {
        this.zurl = zurl;
    }

    public String getZclass() {
        return zclass;
    }

    public void setZclass(String zclass) {
        this.zclass = zclass;
    }

    @Override
    public String toString() {
        return "material{" +
                "zname='" + zname + '\'' +
                ", zurl='" + zurl + '\'' +
                ", zclass='" + zclass + '\'' +
                '}';
    }
}
