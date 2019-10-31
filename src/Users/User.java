package Users;

import java.util.Date;

public class User {
    private String username;
    private String password;
    private String Fname;
    private String LName;
    private Date brithday;
    private int SIN;
    private String adress;
    private int ID;
    private int phoneNumber;

    public User(String username, String password, String Fname, String LName, Date brithday, int SIN, String adress, int ID, int phoneNumber) {

        this.username = username;
        this.password = password;
        this.Fname = Fname;
        this.LName = LName;
        this.brithday = brithday;
        this.SIN = SIN;
        this.adress = adress;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public int getSIN() {
        return SIN;
    }

    public void setSIN(int SIN) {
        this.SIN = SIN;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean comparePassword(String password) {
        if(this.password == password) {
            return true;
        }
        else {
            return false;
        }
    }
}
