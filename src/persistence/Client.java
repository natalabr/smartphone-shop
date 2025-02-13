package persistence;

import java.time.LocalDate;
import java.util.ArrayList;

public class Client {

    public int id;
    public String salutation;
    public String firstname;
    public String lastname;
    public String privatePhoneNumber;
    public String mobilePhoneNumber;
    public String emailAdress;
    public LocalDate dateOfBirth;
    public String username;
    public String password;
    public ArrayList<Adress> adresses;

    public String toString() {
        return salutation + " " + lastname + " " + firstname;
    }
}
