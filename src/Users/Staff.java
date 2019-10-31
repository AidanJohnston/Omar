package Users;

import java.util.Date;

public class Staff extends User{
    public Staff(
            String username,
            String password,
            String Fname,
            String LName,
            Date brithday,
            int SIN,
            String adress,
            int ID,
            int phoneNumber) {
        super(username, password, Fname, LName, brithday, SIN, adress, ID, phoneNumber);
    }
}
