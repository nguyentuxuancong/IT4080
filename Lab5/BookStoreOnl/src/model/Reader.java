package model;

public class Reader {
    private String usr="";
    private String pwd="";
    private String fullName;

    public Reader(String usr, String pwd) {
        this(usr,pwd,null);
    }

    public Reader(String usr, String pwd, String fullName) {
        if(usr != null)
            this.usr = usr;
        if(pwd != null)
            this.pwd = pwd;
        this.fullName = fullName;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        Reader reader = (Reader)obj;
        return this.usr.equals(reader.getUsr());
    }

    @Override
    public String toString() {
        if(fullName == null)
            return usr;
        return this.usr + "(" + this.fullName + ")";
    }
}
